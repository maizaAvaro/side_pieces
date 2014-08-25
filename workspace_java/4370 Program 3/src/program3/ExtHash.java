package program3;

import java.io.*;
import java.lang.reflect.Array;
import static java.lang.System.out;
import java.util.*;



/**
 * Class ExtHash.java
 * @param <K>
 * @param <V>
 */
public class ExtHash<K, V> 
	extends AbstractMap<K, V>		
	implements Map<K, V> {
	
	/** The number of slots (for key-value pairs) per bucket.
     */
	
	static int slots = 4;
	/**
	 * Initial Size of the HashTable
	 */
	
	public int initSize;
	
	  /** The class for type K.
     */
    private final Class <K> classK;

    /** The class for type V.
     */
    private final Class <V> classV;
	
	
    private class Bucket<K, V> {
		
		
		public int lD = 0;
		
		/**
		 * Number of Current keys in the Bucket
		 */
		int nKeys = 0;
		
		/**
		 * Directory for Map slots within the bucket
		 */
		
		public Map<K, V> dir = new HashMap<K, V>(slots);
	
		/**
		 * Checks if the bucket is Full
		 * @return
		 */
		
		public boolean isFull() {
			return (nKeys > slots);
		}
		
		/**
		 * Get ths key value from directory
		 * @param key
		 * @return
		 */
		
		public V get(K key) {
			return this.dir.get(key);
		}
		/**
		 * returns the number of buckets
		 * @return
		 */
		
		public int bucketSize() {
			return this.dir.size();
		}
		
		/**
		 * Put key and value into slots in the bucket
		 * @param key
		 * @param value
		 */
		
		public void put(K key, V value) {
			nKeys++;
			this.dir.put(key, value);
		}
		
	}//End of Class Bucket
	
	
	/**
	 * Global Depth Value
	 */
	private int gD = 0;
	
	/**
	 * The hashtable containing Directory and buckets
	 */
	
	private List<Bucket<K, V>> hTable = new ArrayList<Bucket<K, V>>();
	
	/**
	 * Number of Bucket Accesses for Performance
	 */
	int count = 0;
	
	/**
	 * The mod for Hash Table;
	 */
	private int mod;
	
	/**
	 * ExtHash Constructor
	 * @param _classK
	 * @param _classV
	 * @param hashSize
	 */
	public ExtHash(Class <K> _classK, Class <V> _classV, int hashSize) {
		
		//Takes in class values, sets modulus, hashTable size equal to each other
		classK = _classK;
        classV = _classV;
		mod = initSize = hashSize;
		
		//Creates Tables with Buckets
		for(int i = 0; i < initSize; i++){
			this.hTable.add(new Bucket<K, V>());
		}
	}
	
	/***************************************************************************
     * Return a set containing all the entries as pairs of keys and values.
     * @return  the set view of the map
     */
	public Set<Entry<K, V>> entrySet() {
		Set<Entry<K, V>> set = new HashSet<Entry<K, V>>();
		for (Bucket<K, V> b : this.hTable) {
			set.addAll(b.dir.entrySet());
		}
		return set;
	}

	/**
	 * Get Methods
	 * retrieves the bucket hash value
	 * @param k
	 * @return
	 */
	private Bucket<K, V> getBucket(K k) {
		count++;
		int hashCode = Math.abs(k.hashCode ()) % initSize;
		return hTable.get(hashCode);
	}
	
	/**
	 * Retirieves the bucket fom getBucket HashCode value return
	 */
	public V get(Object key) {
		return getBucket((K) key).get((K) key);
	}

	public boolean containsKey(Object key) {
		return get(key) != null;
	}

	/**
	 * Put Method that performs the follwing extendible hashing conditions
	 * 
	 */
	public V put(K key, V value) {
		if (containsKey(key)) return null;
		//Gets the bucket
		Bucket<K, V> b = getBucket(key);
		
		
		/**
		 * First Condition: Checks if Bucket is Full and globalDepth and LocalDepth are equal(Split Method)
		 * Second Condition: Check if Bucket is Full and LocalDepth less than Global Depth(Split Method)
		 * Third Condition: Place the Key, Value into table(Normal Case)
		 */
		if (b.isFull() && b.lD == this.gD) {
			
			//Makes a new bucket and places the new buckets into the hashtable
			List<Bucket<K, V>> buckets2 = new ArrayList<Bucket<K, V>>(this.hTable);
			this.hTable.addAll(buckets2);
			this.gD++;
		
		} else if (b.isFull() && b.lD < this.gD) {
			
			/**Creates two sepertate new buckets, and rehashes the 
			* values between the two buckets
			*/
			b.put(key, value);
			Bucket<K, V> bucket1 = new Bucket<K, V>();
			Bucket<K, V> bucket2 = new Bucket<K, V>();
		
			for (Entry<K, V> entry : b.dir.entrySet()) {
				K kVal = entry.getKey();
				V vVal = entry.getValue();
				
				int hashCode = Math.abs(b.hashCode()) & ((1 << this.gD) - 1);
				
				
				if (((hashCode >> b.lD) & 1) == 1) {
					bucket2.put(kVal, vVal);
				} else {
					bucket1.put(kVal, vVal);
				}
				
			}
			
			for (int i = 0; i < this.hTable.size(); ++i) {
				if (this.hTable.get(i) == b) {
					if (((i >> b.lD) & 1) == 1) {
						this.hTable.set(i, bucket2);
					} else {
						this.hTable.set(i, bucket1);
					}
				}
			}
			
			//Resets local depths of of two buckets
			bucket2.lD= b.lD + 1;
			bucket1.lD = b.lD + 1;
			
		} else {
			b.put(key, value);
		}
		
		return value;
	}

/**
 * The size of the hashTable
 */
	public int hSize() {
		int sum = 0;
		for (Bucket<K, V> bucket : this.hTable) {
			sum =+ slots;
		}
		
		sum = sum * initSize;
		return sum;
		
	}

	/**
	 * Print method that prints the hash table
	 */
	private void print ()
    {
        System.out.println ("Hash Table (Extendable Hashing)");
        System.out.println ("-------------------------------------------");

        int bNum = 0;
        for (Bucket<K, V> b : hTable) {
        Set<Entry<K, V>> enSet = b.dir.entrySet();
        System.out.print("[Bucket #" + bNum + ": ");
        boolean first = true;
        for (Entry<K,V> ent : enSet) {
        	if (!first) {
        		System.out.print(" ---> ");
        	}
        	System.out.print(ent.getKey() + ":" + ent.getValue());
        	first = false;
  
        }
       System.out.print(" ]\n");
       bNum++; 
      
        } // for
    
       System.out.println ("-------------------------------------------");
    } // print
	
	/**
	 * Main method used for testing purposes
	 * @param args
	 */
	public static void main(String[] args) {

		
		ExtHash <Integer, Integer> ht = new ExtHash <> (Integer.class, Integer.class, 11);
        int nKeys = 30;
        if (args.length == 1) nKeys = Integer.valueOf (args [0]);
        for (int i = 1; i < nKeys; i += 2) ht.put (i, i * i);
        ht.print ();
        for (int i = 0; i < nKeys; i++) {
            out.println ("key = " + i + " value = " + ht.get (i));
        } // for
        out.println ("-------------------------------------------");
        out.println ("Average number of buckets accessed = " + ht.count / (double) nKeys);
        out.println("HashTable size: " + ht.hSize());
	
	} // main
		
}