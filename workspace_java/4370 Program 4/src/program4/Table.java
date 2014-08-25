package program4;

/**
 * @file  Table.java
 */

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;

import static java.lang.Boolean.*;
import java.lang.*;
import static java.lang.System.out;
import java.util.*;
import java.nio.ByteBuffer;

import program4.KeyType;

/*******************************************************************************
 * This class implements relational database tables (including attribute names,
 * domains and a list of tuples.  Five basic relational algebra operators are
 * provided: project, select, union, minus and join.  The insert data manipulation
 * operator is also provided.  Missing are update and delete data manipulation
 * operators.
 */
public class Table
implements Serializable, Cloneable
{
	
	private String graphFileName;
	/**
	 * Default serializable type
	 */
	private static final long serialVersionUID = 1L;

	/** Debug flag, turn off once implemented
	 */
	private static final boolean DEBUG = true;

	/** Counter for naming temporary tables.
	 */
	private static int count = 0;

	/** Table name.
	 */
	private final String name;

	/** Array of attribute names.
	 */
	private final String [] attribute;

	/** Array of attribute domains: a domain may be
	 *  integer types: Long, Integer, Short, Byte
	 *  real types: Double, Float
	 *  string types: Character, String
	 */
	private final Class [] domain;

	/** Collection of tuples (data storage).
	 */
	private final List <Comparable []> tuples;

	/** Primary key. 
	 */
	private final String [] key;

	/**
	 * Index into tuples (maps key to tuple)
	 */
	private final Map <KeyType, Integer> index;
	
	/**
	 * Represents the timeElapsed in a method call
	 */
	private long timeElapsed;
	
	/**
	 * Sets the elapsedTime of a method
	 * @param elapsedTime
	 */
	public void setTimeElapsed(long elapsedTime)
	{
		
		timeElapsed = elapsedTime;
		
	} // setTimeElapsed
	
	/**
	 * Gets the time elapsed in a method call
	 * @return
	 */
	public long getTimeElapsed()
	{
		
		return timeElapsed;
		
	} // getTimeElapsed
	
	public void setFileName(String fileName)
	{
		
		graphFileName = fileName;
		
	} // setFileName
	
	public String getFileName()
	{
		
		return graphFileName;
		
	} // getFileName

	/***************************************************************************
	 * Construct an empty table from the meta-data specifications.
	 * @param _name       the name of the relation
	 * @param _attribute  the string containing attributes names
	 * @param _domain     the string containing attribute domains (data types)
	 * @param _key        the primary key
	 */  
	public Table (String _name, String [] _attribute, Class [] _domain, String [] _key)
	{
		graphFileName = "src/test.csv";
		timeElapsed = 0;
		name      = _name;
		attribute = _attribute;
		domain    = _domain;
		key       = _key;
		tuples    = new ArrayList <> ();                
		//tuples    = new FileList (this, tupleSize ());
		//index     = new TreeMap <> ();                  
		//index = new ExtHash <> (KeyType.class, Integer.class, 11);
		//index = new LinHash <> (KeyType.class, Integer.class, 11);
		index = new BpTree <> (KeyType.class, Integer.class);
	} // Table

	/***************************************************************************
	 * Construct an empty table from the raw string specifications.
	 * @param name        the name of the relation
	 * @param attributes  the string containing attributes names
	 * @param domains     the string containing attribute domains (data types)
	 */
	public Table (String name, String attributes, String domains, String _key)
	{
		this (name, attributes.split (" "), findClass (domains.split (" ")), _key.split(" "));
	} // Table

	/***************************************************************************
	 * Construct an empty table using the meta-data of an existing table.
	 * @param tab     the table supplying the meta-data
	 * @param suffix  the suffix appended to create new table name
	 */
	public Table (Table tab, String suffix)
	{
		this (tab.name + suffix, tab.attribute, tab.domain, tab.key);
	} // Table

	/****************************************************************************
	 * Gets the tuples in a Table - used for testing purposes only
	 * @return a List of Comparable tuples
	 */
	public List <Comparable []> getTuples()
	{
		return tuples;
		/*
		Collection <Comparable []> c = index.values();
		if (c instanceof List) {
			return (List <Comparable[]>) c;
		}
		else {
			return new ArrayList <Comparable[]> (c);
		}
		 */
	}

	/***************************************************************************
	 * Project the tuples onto a lower dimension by keeping only the given attributes.
	 * Check whether the original key is included in the projection.
	 * #usage movie.project ("title year studioNo")
	 * @param attributeList  the attributes to project onto
	 * @return  the table consisting of projected tuples
	 */
	public Table project (String attributeList)
	{
		String [] pAttribute = attributeList.split (" ");
		int []    colPos     = match (pAttribute);
		Class []  colDomain  = extractDom (domain, colPos);
		String [] newKey     = null;    // FIX: original key if included, otherwise all attributes
		ArrayList<String> tempKeys = new ArrayList<String>();
		for(int i=0; i<key.length; ++i)
		{
			for(int j=0; j<pAttribute.length; ++j)
			{
				if(pAttribute[j].equals(key[i]))
					tempKeys.add(key[i]);
			}
		}
		if(tempKeys.isEmpty())
		{
			newKey = pAttribute;
		}
		else
		{
			newKey = new String[tempKeys.size()];
			for(int i=0; i<tempKeys.size(); ++i)
			{
				newKey[i] = (String) tempKeys.get(i);
			}
		}
		Table result = new Table (name + count++, pAttribute, colDomain, newKey);

		for (Comparable [] tup : this.getTuples()) {
			result.insert(extractTup (tup, colPos));
		} // for

		return result;
	} // project

	/***************************************************************************
	 * Select the tuples satisfying the given condition.
	 * A condition is written as infix expression consists of 
	 *   6 comparison operators: "==", "!=", "<", "<=", ">", ">="
	 *   2 Boolean operators:    "&", "|"  (from high to low precedence)
	 * #usage movie.select ("1979 < year & year < 1990")
	 * @param condition  the check condition for tuples
	 * @return  the table consisting of tuples satisfying the condition
	 * @throws UnsupportedEncodingException 
	 * @throws FileNotFoundException 
	 */
	public Table select (String condition)
	{
		
		String [] postfix = infix2postfix (condition);

		Table result  = new Table (name + count++, attribute, domain, key);
		
		for (Comparable [] tup : this.getTuples()) {
			if (evalTup (postfix, tup))
			{
				result.insert(tup);
			}
			
		} // for
		
		return result;
	} // select

	/***************************************************************************
	 * Union this table and table2.  Check that the two tables are compatible.
	 * #usage movie.union (show)
	 * @param table2  the rhs table in the union operation
	 * @return  the table representing the union (this U table2)
	 */
	public Table union (Table table2)
	{
		Table result = new Table (name + count++, attribute, domain, key); 

		if(compatible(table2))
		{

			for(Comparable [] tup: tuples)
			{
				result.insert(tup);
			}

			for(Comparable [] tup: table2.tuples)
			{
				result.insert(tup);
			}
		}else
		{

			System.out.println("Tables are not Compatible");

		}

		return result;

	} // union

	/***************************************************************************
	 * Take the difference of this table and table2.  Check that the two tables
	 * are compatible.
	 * #usage movie.minus (show)
	 * @param table2  the rhs table in the minus operation
	 * @return  the table representing the difference (this - table2)
	 */
	public Table minus (Table table2)
	{
		Table result = new Table (name + count++, attribute, domain, key);



		if(compatible(table2))
		{

			// Check table 1 for tuples that are not in table 2
			for(Comparable [] tup: tuples)
			{

				Boolean addThis = true;
				for(Comparable [] tup2: table2.tuples)
				{
					for(int i=0; i<tup.length; ++i)
					{
						if(tup[i].equals(tup2[i]))
							addThis = false;
					}
				}

				if(addThis)
					result.insert(tup);
			}
		}else
		{

			System.out.println("Tables are not Compatible");

		}

		return result;
	} // minus

	/***************************************************************************
	 * Join this table and table2.  If an attribute name appears in both tables,
	 * assume it is from the first table unless it is qualified with the first
	 * letter of the second table's name (e.g., "s.").
	 * In the result, disambiguate the attribute names in a similar way
	 * (e.g., prefix the second occurrence with "s_").
	 * Caveat: the key parameter assumes joining the table with the foreign key
	 * (this) to the table containing the primary key (table2).
	 * #usage movie.join ("studioNo == name", studio);
	 * #usage movieStar.join ("name == s.name", starsIn);
	 * @param condition  the join condition for tuples
	 * @param table2     the rhs table in the join operation
	 * @return  the table representing the join (this |><| table2)
	 * @throws UnsupportedEncodingException 
	 * @throws FileNotFoundException 
	 */
	public Table join (String condition, Table table2)
	{
		
		Table result = new Table (name + count++, new String [0], new Class [0], key);

		// Arrays to Contain Table1 and Table 2 attributes/Domains (Joined)
		String[] joinAttr;
		Class[] joinDomain;

		// Joins Attributes from Table 1 and Table2 into joinAttr Array
		List jAttr = new ArrayList (Arrays.asList(attribute));
		String [] attr2 = table2.attribute;
		for(int q=0; q<attr2.length; ++q)
		{
			for(int r=0; r<attribute.length; ++r)
			{
				if(attr2[q].equals(attribute[r]))
				{
					//replace attr2's value
					attr2[q] = (table2.getName()).charAt(0)+"."+attr2[q];
				}
			}
		}
		jAttr.addAll(Arrays.asList(attr2));
		Object[] oAttr = jAttr.toArray();
		Arrays.asList(oAttr).toArray(joinAttr = new String[oAttr.length]);

		// Joins Domain from Table1 and Table2 into joinDomain Array
		List jDomain = new ArrayList(Arrays.asList(domain));
		jDomain.addAll(Arrays.asList(table2.domain));
		Object[] oDomain = jDomain.toArray();
		Arrays.asList(oDomain).toArray(joinDomain = new Class[oDomain.length]);

		// Creates Result Table
		result = new Table (name + count++, joinAttr, joinDomain, key);

		/*
       // Splits condition statement placing it into conArray
       String[] condArray= infix2postfix(condition);

       // Retrieves the Positions in which the join condition performs comparisons
      int tupPos = Arrays.asList(attribute).indexOf(condArray[0]);
      int tup2Pos = Arrays.asList(table2.attribute).indexOf(condArray[1]);
		 */
		
		// Join w/ Condition
		/* For loops access the tuples of table1 and table2
		 * The if statement performs a comparison at each tuple w/ the Join condition
		 * Note: The tup[] and tup2[] take in position values which came from identifying their position
		 * this was done for flexibility in new iterations of the project. 
		 */
		for(Comparable[] tup: tuples){
			for(Comparable[] tup2: table2.tuples){

				Comparable[] joinTuples = new Comparable[attribute.length + table2.attribute.length];
				System.arraycopy(tup, 0, joinTuples, 0, tup.length);
				System.arraycopy(tup2, 0, joinTuples, attribute.length, tup2.length);

				if(result.evalJoinTup(infix2postfix(condition), joinTuples, true))
				{
					result.tuples.add(joinTuples);
					
				} 
				
			} 
			
		}
		
		return result;
	} // join

	public KeyType genKey(Comparable[] tup) {
		int []        cols   = match (key);
		Comparable [] keyVal = new Comparable [key.length];
		for (int j = 0; j < keyVal.length; j++) keyVal [j] = tup[cols [j]];
		KeyType kt = new KeyType(keyVal);
		return kt;
	}
	
	/***************************************************************************
	 * Insert a tuple to the table.
	 * #usage movie.insert ("'Star_Wars'", 1977, 124, "T", "Fox", 12345)
	 * @param tup  the array of attribute values forming the tuple
	 * @return  whether insertion was successful
	 */
	public boolean insert (Comparable [] tup)
	{
		if (typeCheck (tup, domain)) {
			
				// Comparable [] keyVal = new Comparable [key.length];
				// int []        cols   = match (key);
				// for (int j = 0; j < keyVal.length; j++) keyVal [j] = tup [cols [j]];
				// KeyType kt = new KeyType(keyVal);
				KeyType kt = genKey(tup);
				//out.println(kt + ":" + kt.hashCode());
				//out.println("containsKey: " + index.containsKey(kt) + " get: " + index.get(kt));
				if (index.put(kt, 1) == null) {
					tuples.add (tup);
					return true;
				}
			}
		return false;
	} // insert

	/***************************************************************************
	 * Get the name of the table.
	 * @return  the table's name
	 */
	public String getName ()
	{
		return name;
	} // getName

	/***************************************************************************
	 * Print the table.
	 */
	public void print ()
	{
		out.println ("\n Table " + name);

		out.print ("|-");
		for (int i = 0; i < attribute.length; i++) out.print ("---------------");
		out.println ("-|");
		out.print ("| ");
		for (String a : attribute) out.printf ("%15s", a);
		out.println (" |");

		if (DEBUG) {
			out.print ("|-");
			for (int i = 0; i < domain.length; i++) out.print ("---------------");
			out.println ("-|");
			out.print ("| ");
			for (Class d : domain) out.printf ("%15s", d.getSimpleName ());
			out.println (" |");
		} // if

		out.print ("|-");
		for (int i = 0; i < attribute.length; i++) out.print ("---------------");
		out.println ("-|");
		for (Comparable [] tup : tuples) {
			out.print ("| ");
			for (Comparable attr : tup) out.printf ("%15s", attr);
			out.println (" |");
		} // for
		out.print ("|-");
		for (int i = 0; i < attribute.length; i++) out.print ("---------------");
		out.println ("-|");
	} // print

	/***************************************************************************
	 * Determine whether the two tables (this and table2) are compatible, i.e.,
	 * have the same number of attributes each with the same corresponding domain.
	 * @param table2  the rhs table
	 * @return  whether the two tables are compatible
	 */
	private boolean compatible (Table table2)
	{
		int attrTb, attrTb2;

		attrTb = domain.length;  
		attrTb2 = table2.domain.length;


		if(Arrays.equals(attribute, table2.attribute) && attrTb == attrTb2)
		{

			return true;

		}else
		{

			return false;

		}

	} // compatible

	/***************************************************************************
	 * Return the column position for the given column/attribute name.
	 * @param column  the given column/attribute name
	 * @return  the column index position
	 */
	private int columnPos (String column)
	{
		for (int j = 0; j < attribute.length; j++) {
			if (column.equals (attribute [j])) return j;
		} // for

		out.println ("columnPos: error - " + column + " not found");
		return -1;  // column name not found in this table
	} // columnPos

	/***************************************************************************
	 * Return all the column positions for the given column/attribute names.
	 * @param columns  the array of column/attribute names
	 * @return  the array of column index positions
	 */
	private int [] match (String [] columns)
	{
		int [] colPos = new int [columns.length];

		for (int i = 0; i < columns.length; i++) {
			colPos [i] = columnPos (columns [i]);
		} // for

		return colPos;
	} // match

	/***************************************************************************
	 * Check whether the tuple satisfies the condition.  Use a stack-based postfix
	 * expression evaluation algorithm.
	 * @param postfix  the postfix expression for the condition
	 * @param tup      the tuple to check
	 * @return  whether to keep the tuple
	 */
	@SuppressWarnings("unchecked")
	private boolean evalTup (String [] postfix, Comparable [] tup)
	{
		return evalJoinTup(postfix, tup, false);   
	} // evalTup

	private boolean evalJoinTup(String [] postfix, Comparable [] tup, boolean isJoin)
	{
		if (postfix == null) return true;
		Stack <Comparable <?>> s = new Stack <> ();

		for (String token : postfix) 
		{

			if(precedence(token) == -1)
			{

				s.push(token);

			}else if(precedence(token) != -1)
			{

				//pop two things off stack
				Comparable temp1 = s.pop(); //We have some value (a name, a phone number, etc.)
				Comparable tempTwo = s.pop();
				Comparable temp2;

				if(tempTwo.getClass().getName() != "java.lang.Boolean")
				{
					temp2 = tup[columnPos((String) tempTwo)]; //We have a column name referring to an element in tup[]
				}
				else
					temp2 = tempTwo;

				if(isJoin && temp1.getClass().getName() != "java.lang.Boolean" && !((String)temp1).matches("\\d*") && !((String)temp1).matches("['\"](.)*['\"]"))
				{
					temp1 = tup[columnPos((String) temp1)]; //We have a column name referring to an element in tup[]
				}

				if(temp1.getClass().getName() == "java.lang.String")
				{
					String tempVal = (String) temp1;
					tempVal = tempVal.replace("'","");
					tempVal = tempVal.replace("\"","");
					temp1 = tempVal;
					//System.out.println(tempVal);
				}

				//System.out.println("\t\t"+temp2+" "+token+" "+temp1);

				int compareValue = (temp2.toString()).compareTo(temp1.toString());

				//System.out.println("\t\t\t"+compareValue);

				if(compareValue < 0)
				{
					if(token.equals("<") || token.equals("!=") || token.equals("<=") || token.equals("|") || token.equals("||"))
						s.push(true);
					else
						s.push(false);
				}
				else if(compareValue == 0)
				{
					if(token.equals("=")||token.equals("==") || token.equals("<=") || token.equals(">="))
						s.push(true);
					else if(token.equals("|") || token.equals("||") || token.equals("&") || token.equals("&&"))
						s.push(temp1);
					else
						s.push(false);
				}
				else if(compareValue > 0)
				{
					if(token.equals(">") || token.equals("!=") || token.equals(">=") || token.equals("|") || token.equals("||"))
						s.push(true);
					else
						s.push(false);
				}
			}

		} // for

		return (Boolean) s.pop ();  
	}

	/***************************************************************************
	 * Pack tuple tup into a record/byte-buffer (array of bytes).
	 * @param tup  the array of attribute values forming the tuple
	 * @return  a tuple packed into a record/byte-buffer
	 */
	byte [] pack (Comparable [] tup)
	{
		byte [] record = new byte [tupleSize ()];
		byte [] b      = null;
		int     s      = 0;
		int     i      = 0;

		try{
			for (int j = 0; j < domain.length; j++) {
				switch (domain [j].getName ()) {
				case "java.lang.Integer":
					//System.out.print("int...");
					b = Conversions.int2ByteArray ((Integer) tup [j]);
					s = 4;
					break;
				case "java.lang.Short":
					//System.out.println("short...");
					b = Conversions.short2ByteArray ((Short) tup [j]);
					s = 2;
					break;
				case "java.lang.Character":
					//System.out.print("string("+(tup[j])+")...");
					b = Conversions.char2ByteArray ((Character) tup [j]);
					s = 2;
					break;
				case "java.lang.String":
					//System.out.print("string("+(tup[j])+")...");
					b = ((String) tup [j]).getBytes ();
					s = 64;
					break;
				case "java.lang.Double":
					//System.out.println("double...");
					b = Conversions.double2ByteArray ((Double) tup [j]);
					s = 8;
					break;
				case "java.lang.Long":
					//System.out.println("long...");
					b = Conversions.long2ByteArray ((Long) tup [j]);
					s = 8;
					break;
				case "java.lang.Float":
					//System.out.println("float...");
					b = Conversions.float2ByteArray ((Float) tup [j]);
					s = 4;
					break;

				} // switch
				if (b == null) {
					out.println ("Table.pack: byte array b is null");
					return null;
				} // if
				for (int k = 0; k < s; k++) {
					if(k<(s-b.length))
						record[i++]=0;
					else
					{
						//System.out.println(tup[j]+": "+record.length+" ::: "+i);
						record [i++] = b [k-(s-b.length)];
					}
				}
			} // for
		} catch (Exception e)
		{
			System.out.println ("Caught exception: " );
			e.printStackTrace();
		}
		return record;
	} // pack


	/***************************************************************************
	 * Unpack the record/byte-buffer (array of bytes) to reconstruct a tuple.
	 * @param record  the byte-buffer in which the tuple is packed
	 * @return  an unpacked tuple
	 */
	Comparable [] unpack (byte [] record)
	{
		Comparable[] toReturn = new Comparable[domain.length];

		int s=0;
		int i=0;

		try{
			for (int j = 0; j < domain.length; j++) {
				switch (domain [j].getName ()) {
				case "java.lang.Integer":
					s=4;
					break;
				case "java.lang.Short":
					s=2;
					break;
				case "java.lang.String":
					s=64;
					break;
				case "java.lang.Character":
					s=2;
					break;
				case "java.lang.Double":
					s=8;
					break;
				case "java.lang.Long":
					s=8;
					break;
				case "java.lang.Float":
					s=4;
					break;
				} // switch

				int previ = i;
				i += s;

				byte [] thisRecord = Arrays.copyOfRange(record, previ, i);

				switch (domain [j].getName ()) {
				case "java.lang.Integer":
					toReturn[j] = Conversions.byteArray2Int(thisRecord);
					break;
				case "java.lang.Character":
					toReturn[j] = Conversions.byteArray2Char(thisRecord);
					break;
				case "java.lang.String":
					String newEntry = new String(thisRecord);
					newEntry = newEntry.trim();
					toReturn[j] = newEntry;
					break;
				case "java.lang.Double":
					toReturn[j] = Conversions.byteArray2Double(thisRecord);
					break;
				case "java.lang.Long":
					toReturn[j] = Conversions.byteArray2Long(thisRecord);
					break;
				case "java.lang.Float":
					toReturn[j] = Conversions.byteArray2Float(thisRecord);
					break;
				case "java.lang.Short":
					toReturn[j] = Conversions.byteArray2Short(thisRecord);
					break;

				} // switch

			} // for
		} catch (Exception e) {
			e.printStackTrace();
		}
		return toReturn;
	} // unpack


	/***************************************************************************
	 * Determine the size of tuples in this table in terms of the number of bytes
	 * required to store it in a record/byte-buffer.
	 * @return  the size of packed-tuples in bytes
	 */
	private int tupleSize ()
	{
		int s = 0;

		for (int j = 0; j < domain.length; j++) {
			switch (domain [j].getName ()) {
			case "java.lang.Integer": s += 4;  break;
			case "java.lang.String":  s += 64; break;
			case "java.lang.Character":  s += 2; break;
			case "java.lang.Long":  s += 8; break;
			case "java.lang.Double":  s += 8; break;
			case "java.lang.Float":  s += 4; break;
			case "java.lang.Short":  s += 2; break;
			} // if
		} // for

		return s;
	} // tupleSize


	//------------------------ Static Utility Methods --------------------------

	/***************************************************************************
	 * Check the size of the tuple (number of elements in list) as well as the
	 * type of each value to ensure it is from the right domain. 
	 * @param tup  the tuple as a list of attribute values
	 * @param dom  the domains (attribute types)
	 * @return  whether the tuple has the right size and values that comply
	 *          with the given domains
	 */
	private static boolean typeCheck (Comparable [] tup, Class [] dom)
	{

		Boolean toReturn = true;

		if(tup.length != dom.length)
			return false;

		for(int i=0; i<tup.length; ++i)
		{
			if (tup[i].getClass() != dom[i])
				toReturn = false;
		}

		return toReturn;
	} // typeCheck

	/***************************************************************************
	 * Determine if the token/op is a comparison operator.
	 * @param op  the token/op to check
	 * @return  whether it a comparison operator
	 */
	private static boolean isComparison (String op)
	{
		return op.equals ("==") || op.equals ("!=") ||
				op.equals ("<")  || op.equals ("<=") ||
				op.equals (">")  || op.equals (">=");
	} // isComparison

	/***************************************************************************
	 * Compare values x and y according to the comparison operator.
	 * @param   x   the first operand
	 * @param   op  the comparison operator
	 * @param   y   the second operand
	 * @return  whether the comparison evaluates to true or false
	 */
	@SuppressWarnings("unchecked")
	private static boolean compare (Comparable x, String op , Comparable y)
	{
		switch (op) {
		case "==": return x.compareTo (y) == 0;
		case "!=": return x.compareTo (y) != 0;
		case "<":  return x.compareTo (y) <  0;
		case "<=": return x.compareTo (y) <= 0;
		case ">":  return x.compareTo (y) >  0;
		case ">=": return x.compareTo (y) >= 0;
		default: { out.println ("compare: error - unexpected op"); return false; }
		} // switch
	} // compare

	/********************************************************************************
	 * Method to compare the equality of two table's data - used only for testing purposes
	 * @param t - the table with which to compare this table
	 * @return boolean value as to whether or not the two tables match
	 */
	public boolean compare(Table t)
	{
		for(Comparable [] tup : tuples)
		{

			Boolean hasMember = false;
			for(Comparable [] tup2 : t.tuples)
			{

				if(tup.length != tup2.length)
				{
					return false;
				}

				Boolean isSame = true;
				for(int i=0; i<tup2.length; ++i)
				{
					if(tup[i].compareTo(tup2[i])!=0)
					{
						isSame = false;
					}
				}

				if(isSame)
				{
					hasMember=true;
					break;
				}
			}

			if(!hasMember)
			{
				return false;
			}
		}	
		return true;
	}	// compare

	/***************************************************************************
	 * Convert an untokenized infix expression to a tokenized postfix expression.
	 * This implementation does not handle parentheses ( ).
	 * Ex: "1979 < year & year < 1990" --> { "1979", "year", "<", "year", "1990", "<", "&" } 
	 * @param condition  the untokenized infix condition
	 * @return  resultant tokenized postfix expression
	 */
	private static String [] infix2postfix (String condition)
	{
		if (condition == null || condition.trim () == "") return null;
		String [] infix   = condition.split (" ");        // tokenize the infix
		String [] postfix = new String [infix.length];    // same size, since no ( ) 

		Stack<String> operatorStack = new Stack<String>();

		int counter = 0;

		for(int i = 0; i < infix.length; i++)
		{
			String eval = infix[i];

			if(precedence(eval)==-1)
			{
				postfix[counter] = eval;
				counter++;
			}
			if(precedence(eval)!=-1)
			{

				while(!operatorStack.isEmpty() && precedence(operatorStack.peek()) < precedence(eval))
				{

					postfix[counter] = operatorStack.pop();
					counter++;

				}	// while

				operatorStack.push(eval);

			}	// if

		}	// for

		while(!operatorStack.isEmpty())
		{
			postfix[counter] = operatorStack.pop();
			counter++;
		}

		return postfix;
	} // infix2postfix

	/***************************************************************************
	 * Finds the precedence of the operator passed as the argument
	 * @param operator  the String operator evaluated from the condition
	 * @return  the int value of precedence of the operator passed
	 */
	private static int precedence(String operator)
	{

		if(operator.equals("+") || operator.equals("-") || operator.equals("/") || operator.equals("*") || operator.equals("<") || operator.equals(">") || operator.equals("<=") || operator.equals(">="))
		{

			return 1;

		}else if(operator.equals("=") || operator.equals("!=") || operator.equals("=="))
		{

			return 2;

		}else if(operator.equals("^") || operator.equals("|") || operator.equals("&&") || operator.equals("||") || operator.equalsIgnoreCase("and") || operator.equalsIgnoreCase("or"))
		{

			return 3;

		}else
		{

			return -1;

		}

	}	// precedence

	/***************************************************************************
	 * Find the classes in the "java.lang" package with given names.
	 * @param className  the array of class name (e.g., {"Integer", "String"})
	 * @return  the array of Java classes for the corresponding names
	 */
	private static Class [] findClass (String [] className)
	{
		Class [] classArray = new Class [className.length];

		for (int i = 0; i < className.length; i++) {
			try {
				classArray [i] = Class.forName ("java.lang." + className [i]);
			} catch (ClassNotFoundException ex) {
				out.println ("findClass: " + ex);
			} // try
		} // for

		return classArray;
	} // findClass

	/***************************************************************************
	 * Extract the corresponding domains from the group.
	 * @param group   where to extract from
	 * @param colPos  the column positions to extract
	 * @return  the extracted domains
	 */
	private static Class [] extractDom (Class [] group, int [] colPos)
	{
		Class [] dom = new Class [colPos.length];

		for (int j = 0; j < colPos.length; j++) {
			dom [j] = group [colPos [j]];
		} // for

		return dom;
	} // extractDom

	/***************************************************************************
	 * Extract the corresponding attribute values from the group.
	 * @param group   where to extract from
	 * @param colPos  the column positions to extract
	 * @return  the extracted attribute values
	 */
	private static Comparable [] extractTup (Comparable [] group, int [] colPos)
	{
		Comparable [] tup = new Comparable [colPos.length];

		for(int i=0; i<tup.length; ++i)
		{
			tup[i] = group[colPos[i]];
		}

		return tup;
	} // extractTup

} // Table class

