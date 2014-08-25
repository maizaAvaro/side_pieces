package program3;

/*******************************************************************************
 * @file LinHash.java
 */

import java.io.*;
import java.lang.reflect.Array;
import static java.lang.System.out;
import java.util.*;
import java.util.Map.Entry;

/*******************************************************************************
 * This class provides hash maps that use the Linear Hashing algorithm.
 * A hash table is created that is an array of buckets.
 */
public class LinHash <K extends Comparable <K>, V>
       extends AbstractMap <K, V>
       implements Serializable, Cloneable, Map <K, V>
{
    /** The number of slots (for key-value pairs) per bucket.
     */
    private static final int SLOTS = 4;

    /** The class for type K.
     */
    private final Class <K> classK;

    /** The class for type V.
     */
    private final Class <V> classV;

    /***************************************************************************
     * This inner class defines buckets that are stored in the hash table.
     */
    private class Bucket
    {
        int    nKeys;
        ArrayList<Map.Entry<K, V>> storage;
        
        @SuppressWarnings("unchecked")
        Bucket (Bucket n)
        {     
            storage = new ArrayList<>();
        } // constructor
        
        /**
         * Method that determines whether or not a bucket is full
         * @return true or false
         */
        public boolean isFull() 
        {
			return (nKeys > SLOTS);
		} // isFull
        
        /**
         * Gets the key value in the map
         * @param _key
         * @return
         */
        public V get(K _key)
        {
        	count++;
        	for (Entry<K,V> en : storage) {
        		if (en.getKey().hashCode() == _key.hashCode()) {
        			return en.getValue();
        		}
        	}
        	return null;
        } // get
        
        /**
         * Puts the key and value into the map
         * @param _key
         * @param _value
         * @return true or false
         */
        public boolean put(K _key, V _value)
        {
        	if (get(_key) == null) {
        		storage.add(new AbstractMap.SimpleEntry(_key, _value));
        		nKeys++;
        	}
        	return this.isFull();
        } // put
        
        public Set <Map.Entry <K, V>> entrySet () {
        	Set <Map.Entry <K, V>> toReturn = new HashSet<>();
        	for (Map.Entry<K, V> en : storage) {
        		toReturn.add(en);
        	}
        	return toReturn;
        }
        
    } // Bucket inner class

    /** The list of buckets making up the hash table.
     */
    private final List <Bucket> hTable;

    /** The modulus for low resolution hashing
     */
    private int mod1;

    /** The modulus for high resolution hashing
     */
    private int mod2;

    /** Counter for the number buckets accessed (for performance testing).
     */
    private int count = 0;

    /** The index of the next bucket to split.
     */
    private int split = 0;

    /***************************************************************************
     * Construct a hash table that uses Linear Hashing.
     * @param classK    the class for keys (K)
     * @param classV    the class for keys (V)
     * @param initSize  the initial number of home buckets (a power of 2, e.g., 4)
     */
    public LinHash (Class <K> _classK, Class <V> _classV, int initSize)
    {
        classK = _classK;
        classV = _classV;
        hTable = new ArrayList <Bucket> ();
        mod1   = initSize;
        mod2   = 2 * mod1;
        
        for(int i = 0; i < mod1; ++i)
        {
        	hTable.add(new Bucket(null));
        } // for
    } // LinHash

    /***************************************************************************
     * Return a set containing all the entries as pairs of keys and values.
     * @return  the set view of the map
     */
    public Set <Map.Entry <K, V>> entrySet ()
    {
        Set <Map.Entry <K,V>> enSet = new HashSet <> ();

             for(int i = 0; i < hTable.size(); ++i)
             {
            	enSet.addAll(hTable.get(i).entrySet());
             }
        return enSet;
    } // entrySet

    /***************************************************************************
     * Given the key, look up the value in the hash table.
     * @param key  the key used for look up
     * @return  the value associated with the key
     */
    public V get (Object key)
    {
    	int lowRes = h(key);
        int highRes = h2(key);
        
        int index = highRes;
        
        if(lowRes >= split)
        {
        	
        	 index = lowRes;
        	
        }

       return hTable.get(index).get((K)key);
       
    } // get

    /***************************************************************************
     * Put the key-value pair in the hash table.
     * @param key    the key to insert
     * @param value  the value to insert
     * @return  null (not the previous value)
     */
    public V put (K key, V value)
    {
        
    	int lowRes = h(key);
        int highRes = h2(key);
        
        int index = highRes;
        
        if(lowRes >= split)
        {
        	 index = lowRes;
        } // if
        boolean toSplit = hTable.get(index).put(key, value);
        
        if(toSplit)
        {
        	split();
        } // if
        
        return null;
        
    } // put
    
    /***************************************************************************
     * Splits the bucket pointed to by the hash pointer
     */
    public void split()
    {
    	Bucket toSplit = hTable.get(split);
    	Bucket a = new Bucket(null);
    	Bucket b = new Bucket(null);
    	Iterator <Map.Entry<K, V>> it = toSplit.entrySet().iterator();
    	
    	while(it.hasNext())
    	{
    		Map.Entry<K, V> en = it.next();
    		K key = en.getKey();
    		V val = en.getValue();
    		
    		if(h(key) == h2(key))
    		{
    			a.put(key, val);
    			a.nKeys++;
    		}else
    		{
    			b.put(key, val);
    			b.nKeys++;
    		} // if-else
    	} // while
    	
    	hTable.set(split, a);
    	hTable.add(b);
    	split++;
    	
    	if(split >= mod1)
    	{
    		split = 0;
    		mod1 = mod2;
    		mod2 = mod2 * 2;
    	} // if
    	
    } // split

    /***************************************************************************
     * Return the size (SLOTS * number of home buckets) of the hash table. 
     * @return  the size of the hash table
     */
    public int size ()
    {
        return SLOTS * (mod1 + split);
    } // size

    /***************************************************************************
     * Print the hash table.
     */
    public void print ()
    {
       
    	 System.out.println ("Hash Table (Linear Hashing)");
         System.out.println ("-------------------------------------------");

         System.out.println("Mod1: " + mod1 + " ::: " + "Mod2: " + mod2 + " ::: " + "Split: " + split);
         for (int i = 0; i < hTable.size(); ++i)
         {
        	 Bucket b = hTable.get(i);
        	 Set<Entry<K, V>> enSet = b.entrySet();
        	 System.out.print("[Bucket #" + i + ": ");
        	 boolean first = true;
        	 for (Entry<K,V> ent : enSet) 
        	 {
        		 if (!first) 
        		 {
        			 System.out.print(" ---> ");
        		 } // if
        		 System.out.print(ent.getKey() + ":" + ent.getKey().hashCode() % mod2 + ":" + ent.getValue());
        		 first = false;
   
        	 } // inner for
        	 System.out.print(" ]\n");
       
         } // for
     
        System.out.println ("-------------------------------------------");
    	
    } // print

    /***************************************************************************
     * Hash the key using the low resolution hash function.
     * @param key  the key to hash
     * @return  the location of the bucket chain containing the key-value pair
     */
    private int h (Object key)
    {
        return Math.abs(key.hashCode () % mod1);
    } // h

    /***************************************************************************
     * Hash the key using the high resolution hash function.
     * @param key  the key to hash
     * @return  the location of the bucket chain containing the key-value pair
     */
    private int h2 (Object key)
    {
        return Math.abs(key.hashCode () % mod2);
    } // h2

    /***************************************************************************
     * The main method used for testing.
     * @param  the command-line arguments (args [0] gives number of keys to insert)
     */
    public static void main (String [] args)
    {
        LinHash <Integer, Integer> ht = new LinHash <> (Integer.class, Integer.class, 11);
        int nKeys = 30;
        if (args.length == 1) nKeys = Integer.valueOf (args [0]);
        for (int i = 1; i < nKeys; i += 2) ht.put (i, i * i);
        ht.print ();
        for (int i = 0; i < nKeys; i++) {
            out.println ("key = " + i + " value = " + ht.get (i));
        } // for
        out.println ("-------------------------------------------");
        out.println ("Average number of buckets accessed = " + ht.count / (double) nKeys);
    } // main

} // LinHash class

