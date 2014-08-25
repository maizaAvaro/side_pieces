package program2;

import java.util.List;

import junit.framework.TestCase;

/**
 * Class that tests the Table class
 *
 */
public class TableTest extends TestCase 
{
	/**
	 * Tests the methods pack and unpack from the Table class
	 */
	public void testPack()
	{
		
		Table values = new Table ("values", "name int long short float",
                "String Integer Long Short Float", "int");
		
		Table intTable = new Table ("int", "key col1 col2",
				"Integer Integer Integer", "key");
		Comparable[] _int = {1, 2, -100};
		Comparable[] _intUnpack = intTable.unpack(intTable.pack(_int));
		for (int i = 0; i < _int.length; i++) {
			assertTrue("_int["+i+"]:"+_int[i]+"="+_intUnpack[i], 
					_int[i].equals(_intUnpack[i]));
		}
		
		Table doubleTable = new Table ("int", "key col1 col2",
				"Integer Double Double", "key");
		Comparable[] _double = {1, (double) 0.1, (double) -1.0001};
		Comparable[] _doubleUnpack = doubleTable.unpack(doubleTable.pack(_double));
		for (int i = 0; i < _int.length; i++) {
			assertTrue("_double["+i+"]:"+_double[i]+"="+_doubleUnpack[i], 
					_double[i].equals(_doubleUnpack[i]));
		}
		
		Table longTable = new Table ("long", "key col1 col2", 
				"Integer Long Long", "key");
		Comparable [] _long = {1, (long) -27, (long) 1000000000};
		Comparable [] _longUnpack = longTable.unpack(longTable.pack(_long));
		for (int i = 0; i < _long.length; i++) {
			assertTrue("_long["+i+"]:"+_long[i]+"="+_longUnpack[i], 
					_long[i].equals(_longUnpack[i]));
		}
		
		Table floatTable = new Table ("float", "key col1 col2", 
				"Integer Float Float", "key");
		Comparable [] _float = {1, -3.14f, 1.0f};
		Comparable [] _floatUnpack = floatTable.unpack(floatTable.pack(_float));
		for (int i = 0; i < _float.length; i++) {
			assertTrue("_float["+i+"]:"+_float[i]+"="+_floatUnpack[i], 
					_float[i].equals(_floatUnpack[i]));
		}
		
		Table stringTable = new Table ("string", "key key2 col1 col2 col3", 
				"Integer Integer String String String", "key");
		Comparable [] string = {1, 2, "xx", "x", "x-x"};
		Comparable [] stringUnpack = stringTable.unpack(stringTable.pack(string));
		for (int i = 0; i < string.length; i++) {
			assertTrue("string["+i+"]:"+string[i]+"="+stringUnpack[i], 
					string[i].equals(stringUnpack[i]));
		}
		/*
		Comparable [] val0 = { "Carter", 12, (long) 50412345, testvalue2, testfloat};
		Comparable [] val1 = { "Nathan", 8, (long) 234342128, testvalue, testfloat};
        
        values.insert (val0);
        values.insert (val1);
        
        Comparable [] unpacked0 = values.unpack(values.pack(val0));
        Comparable [] unpacked1 = values.unpack(values.pack(val1));
        
        for (int i = 0; i < unpacked0.length; i++) {
        	assertTrue(unpacked0[i].equals(val0[i]));
        	assertTrue(unpacked1[i].equals(val1[i]));
        }
        */
	} // testPack

	/**
	 * Tests the method select of the Table class
	 */
	public void testSelect() 
	{
		
		Table movie = new Table ("movie", "title year length genre studioName producerNo",
                "String Integer Integer String String Integer", "title year");
		
		Table select = new Table ("select", "title year length genre studioName producerNo",
                "String Integer Integer String String Integer", "title year");
		
		Comparable [] film0 = { "Star_Wars", 1977, 124, "sciFi", "Fox", 12345 };
        Comparable [] film1 = { "Star_Wars_2", 1980, 124, "sciFi", "Fox", 12345 };
        Comparable [] film2 = { "Rocky", 1985, 200, "action", "Universal", 12125 };
        Comparable [] film3 = { "Rambo", 1978, 100, "action", "Universal", 32355 };
        
        movie.insert (film0);
        movie.insert (film1);
        movie.insert (film2);
        movie.insert (film3);
        
        select.insert(film0);
        
        Table t_select = movie.select ("title == 'Star_Wars'");
        
        List <Comparable []> selectList = select.getTuples();
        List <Comparable []> t_selectList = t_select.getTuples();
        
        int selectSize = selectList.size();
        int t_selectSize = t_selectList.size();
        
        assertTrue("Lists are of equal size", selectSize == t_selectSize);
        
        assertTrue("The two tables are equal", select.compare(t_select));
        
        select.print();
        t_select.print();

	} // testSelect
	
	/**
	 * Tests the method project of the Table class
	 */
	public void testProject()
	{
		
		Table movie = new Table ("movie", "title year length genre studioName producerNo",
                "String Integer Integer String String Integer", "title year");
		
		Table project = new Table ("project", "title year",
                "String Integer", "title year");
		
		Comparable [] film0 = { "Star_Wars", 1977, 124, "sciFi", "Fox", 12345 };
        Comparable [] film1 = { "Star_Wars_2", 1980, 124, "sciFi", "Fox", 12345 };
        Comparable [] film2 = { "Rocky", 1985, 200, "action", "Universal", 12125 };
        Comparable [] film3 = { "Rambo", 1978, 100, "action", "Universal", 32355 };
        Comparable [] film4 = { "Star_Wars", 1977 };
        Comparable [] film5 = { "Star_Wars_2", 1980 };
        Comparable [] film6 = { "Rocky", 1985 };
        Comparable [] film7 = { "Rambo", 1978 };
        
        movie.insert (film0);
        movie.insert (film1);
        movie.insert (film2);
        movie.insert (film3);
        
        project.insert(film4);
        project.insert(film5);
        project.insert(film6);
        project.insert(film7);
        
        Table t_project = movie.project ("title year");
        
        List <Comparable []> projectList = project.getTuples();
        List <Comparable []> t_projectList = t_project.getTuples();
        
        int projectSize = projectList.size();
        int t_projectSize = t_projectList.size();
        
        assertTrue("Lists are of equal size", projectSize == t_projectSize);
        
        assertTrue("The tables are equal", project.compare(t_project));
        
        project.print();
        t_project.print();
		
	}	// testProject
	
	/**
	 * Tests the method union of the Table class
	 */
	public void testUnion()
	{
		
		Table movie = new Table ("movie", "title year length genre studioName producerNo",
                "String Integer Integer String String Integer", "title year");

		Table cinema = new Table ("cinema", "title year length genre studioName producerNo",
                  "String Integer Integer String String Integer", "title year");
		
		Comparable [] film0 = { "Star_Wars", 1977, 124, "sciFi", "Fox", 12345 };
        Comparable [] film1 = { "Star_Wars_2", 1980, 124, "sciFi", "Fox", 12345 };
        Comparable [] film2 = { "Rocky", 1985, 200, "action", "Universal", 12125 };
        Comparable [] film3 = { "Rambo", 1978, 100, "action", "Universal", 32355 };
        Comparable [] film4 = { "Galaxy_Quest", 1999, 104, "comedy", "DreamWorks", 67890 };
        
        movie.insert (film0);
        movie.insert (film1);
        movie.insert (film2);
        movie.insert (film3);
        
        cinema.insert (film2);
        cinema.insert (film3);
        cinema.insert (film4);
        
        Table union = new Table ("union", "title year length genre studioName producerNo",
                "String Integer Integer String String Integer", "title year");
        
        union.insert (film0);
        union.insert (film1);
        union.insert (film2);
        union.insert (film3);
        union.insert (film2);
        union.insert (film3);
        union.insert (film4);

        Table t_union = movie.union (cinema);
        
        List <Comparable []> unionList = union.getTuples();
        List <Comparable []> t_unionList = t_union.getTuples();
        
        int unionSize = unionList.size();
        int t_unionSize = t_unionList.size();
        
        assertTrue("Lists are of equal size", unionSize == t_unionSize);
        
        assertTrue("The tables are equal", union.compare(t_union));
        
        union.print();
        t_union.print();
		
	}	// testUnion
	
	/**
	 * Tests the method minus of the Table class
	 */
	public void testMinus()
	{
		
		Table movie = new Table ("movie", "title year length genre studioName producerNo",
                "String Integer Integer String String Integer", "title year");

		Table cinema = new Table ("cinema", "title year length genre studioName producerNo",
                  "String Integer Integer String String Integer", "title year");
		
		Comparable [] film0 = { "Star_Wars", 1977, 124, "sciFi", "Fox", 12345 };
        Comparable [] film1 = { "Star_Wars_2", 1980, 124, "sciFi", "Fox", 12345 };
        Comparable [] film2 = { "Rocky", 1985, 200, "action", "Universal", 12125 };
        Comparable [] film3 = { "Rambo", 1978, 100, "action", "Universal", 32355 };
        Comparable [] film4 = { "Galaxy_Quest", 1999, 104, "comedy", "DreamWorks", 67890 };
        
        movie.insert (film0);
        movie.insert (film1);
        movie.insert (film2);
        movie.insert (film3);
        
        cinema.insert (film2);
        cinema.insert (film3);
        cinema.insert (film4);
        
        Table minus = new Table ("minus", "title year length genre studioName producerNo",
                "String Integer Integer String String Integer", "title year");
        
        minus.insert(film0);
        minus.insert(film1);
        
        Table t_minus = movie.minus (cinema);
        
        List <Comparable []> minusList = minus.getTuples();
        List <Comparable []> t_minusList = t_minus.getTuples();
        
        int minusSize = minusList.size();
        int t_minusSize = t_minusList.size();
        
        //System.out.println("Minus Size: " + minusSize);
        //System.out.println("t_minusSize: " + t_minusSize);
        
        assertTrue("Lists are of equal size", minusSize == t_minusSize);
        
        assertTrue("The tables are equal", minus.compare(t_minus));
        
        minus.print();
        t_minus.print();
		
	}	// testMinus
	
	/**
	 * Tests the method join of the Table class
	 */
	public void testJoin()
	{
		
		Table movie = new Table ("movie", "title year length genre studioName producerNo",
                "String Integer Integer String String Integer", "title year");
		
		Table studio = new Table ("studio", "name address presNo",
                "String String Integer", "name");
		
		Table join = new Table("join", "title year length genre studioName producerNo " +
				"name address presNo", "String Integer Integer String String Integer String " +
						"String Integer", "title year");
		
		Comparable [] film0 = { "Star_Wars", 1977, 124, "sciFi", "Fox", 12345 };
        Comparable [] film1 = { "Star_Wars_2", 1980, 124, "sciFi", "Fox", 12345 };
        Comparable [] film2 = { "Rocky", 1985, 200, "action", "Universal", 12125 };
        Comparable [] film3 = { "Rambo", 1978, 100, "action", "Universal", 32355 };
        
        Comparable [] studio0 = { "Fox", "Los_Angeles", 7777 };
        Comparable [] studio1 = { "Universal", "Universal_City", 8888 };
        Comparable [] studio2 = { "DreamWorks", "Universal_City", 9999 };
        
        Comparable[] join0 = { "Star_Wars", 1977, 124, "sciFi", "Fox", 12345, "Fox", "Los_Angeles", 7777 };
        Comparable[] join1 = { "Star_Wars_2", 1980, 124, "sciFi", "Fox", 12345, "Fox", "Los_Angeles", 7777 };
        Comparable[] join2 = { "Rocky", 1985, 200, "action", "Universal", 12125, "Universal", "Universal_City", 8888 };
        Comparable[] join3 = { "Rambo", 1978, 100, "action", "Universal", 32355, "Universal", "Universal_City", 8888 };
        
        join.insert (join0);
        join.insert (join1);
        join.insert (join2);
        join.insert (join3);
        
        movie.insert (film0);
        movie.insert (film1);
        movie.insert (film2);
        movie.insert (film3);
        
        studio.insert (studio0);
        studio.insert (studio1);
        studio.insert (studio2);
        
        Table t_join = movie.join ("studioName == name", studio);
        
        List <Comparable []> joinList = join.getTuples();
        List <Comparable []> t_joinList = t_join.getTuples();
        
        int joinSize = joinList.size();
        int t_joinSize = t_joinList.size();
        
        assertTrue("Lists are of equal size", joinSize == t_joinSize);
        
        assertTrue("The tables are equal", join.compare(t_join));
        
        join.print();
        t_join.print();
		
	}	// testJoin

}	// TableTest