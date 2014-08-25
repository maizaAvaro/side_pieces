package program4;

import java.io.*;
import java.lang.reflect.Array;
import static java.lang.System.out;
import java.util.*;

/**
 * Class ExtHash.java
 * @param <K>
 * @param <V>
 */
public class ExtHash<K extends Comparable <K>, V> 
			extends AbstractMap<K, V> implements Map<K, V> {

	/**
	 * The number of slots (for key-value pairs) per bucket.
	 */
	static int slots = 4;
	
	/**
	 * Initial Size of the HashTable
	 */
	public int initSize;

	/**
	 * The class for type K.
	 */
	private final Class<K> classK;

	/**
	 * The class for type V.
	 */
	private final Class<V> classV;

	private class Bucket<K, V> {

		/**
		 * Local depth
		 */
		public int lD = 0;

		/**
		 * Number of Current keys in the Bucket
		 */
		int nKeys = 0;

		/**
		 * Directory for Map slots within the bucket
		 */
		public ArrayList<K> keys = new ArrayList<>();
		public ArrayList<V> values = new ArrayList<>();
		
		/**
		 * Checks if the bucket is Full
		 * 
		 * @return
		 */
		public boolean isFull() {
			return (nKeys >= slots);
		}

		/**
		 * Get ths key value from directory
		 * 
		 * @param key
		 * @return
		 */
		public V get(K key) {
			V ret = null;
			for (int i = 0; i < nKeys; i++) {
				if (((Comparable)keys.get(i)).compareTo((Comparable) key) == 0) {
					ret = values.get(i);
					break;
				}
			}
			return ret;
		}

		/**
		 * returns the number of keys in the bucket
		 * 
		 * @return
		 */
		public int bucketSize() {
			return nKeys;
		}

		public Set <Map.Entry <K,V>> entrySet() {
			Set <Map.Entry <K,V>> ret = new HashSet<>();
			for (int i = 0; i < nKeys; i++) {
				ret.add(new AbstractMap.SimpleEntry(keys.get(i), values.get(i)));
			}
			return ret;
		}
		
		/**
		 * Put key and value into slots in the bucket
		 * 
		 * @param key
		 * @param value
		 */
		public V put(K key, V value) {
			int target = nKeys;
			V ret = null;
			for (int i = 0; i < nKeys; i++) {
				if (((Comparable) keys.get(i)).compareTo((Comparable) key) == 0) {
					target = i;
				}
			}
			if (target != nKeys) {
				ret = values.get(target);
				values.set(target, value);
			}
			else {
				if (this.isFull()) {
					throw(new IndexOutOfBoundsException());
				}
				else {
					nKeys++;
					keys.add(key);
					values.add(value);
				}
			}
			return ret;
		}
	} // End of Class Bucket

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
	 * 
	 * @param _classK
	 * @param _classV
	 * @param hashSize
	 */
	private Map <K,V> dir = new HashMap <K,V>();
	
	public ExtHash(Class<K> _classK, Class<V> _classV, int hashSize) {

		// Takes in class values, sets modulus, hashTable size equal to each
		// other
		classK = _classK;
		classV = _classV;
		mod = initSize = hashSize;

		// Creates Tables with Buckets
		for (int i = 0; i < initSize; i++) {
			this.hTable.add(new Bucket<K, V>());
		}
	}

	/***************************************************************************
	 * Return a set containing all the entries as pairs of keys and values.
	 * 
	 * @return the set view of the map
	 */
	public Set<Entry<K, V>> entrySet() {
		Set<Entry<K, V>> set = new HashSet<Entry<K, V>>();
		for (Bucket<K, V> b : this.hTable) {
			set.addAll(b.entrySet());
		}
		return set;
	}

	/**
	 * Get Methods retrieves the bucket hash value
	 * 
	 * @param k
	 * @return
	 */
	private Bucket<K, V> getBucket(K k) {
		count++;
		int hashCode = Math.abs(k.hashCode()) % initSize;
		return hTable.get(hashCode);
	}

	/**
	 * Retirieves the bucket fom getBucket HashCode value return
	 */
	public V get(Object key) {
		return dir.get(key);
	}

	public boolean containsKey(Object key) {
		return get(key) != null;
	}

	/**
	 * Put Method that performs the follwing extendible hashing conditions
	 * 
	 */
	public V put(K key, V value) {
		V ret = null;
		// Gets the bucket
		Bucket<K, V> b = getBucket(key);

		/**
		 * First Condition: Checks if Bucket is Full and globalDepth and
		 * LocalDepth are equal(Split Method) Second Condition: Check if Bucket
		 * is Full and LocalDepth less than Global Depth(Split Method) Third
		 * Condition: Place the Key, Value into table(Normal Case)
		 */
		if (b.isFull() && b.lD == this.gD) {

			// Makes a new bucket and places the new buckets into the hashtable
			List<Bucket<K, V>> buckets2 = new ArrayList<Bucket<K, V>>(
					this.hTable);
			this.hTable.addAll(buckets2);
			this.gD++;
			return dir.put(key,value);
		} else if (b.isFull() && b.lD < this.gD) {
			return dir.put(key, value);
			/**
			 * Creates two sepertate new buckets, and rehashes the values
			 * between the two buckets
			 */
			/*
			Bucket<K, V> bucket1 = new Bucket<K, V>();
			Bucket<K, V> bucket2 = new Bucket<K, V>();
			for (Entry<K, V> entry : b.entrySet()) {
				K kVal = entry.getKey();
				V vVal = entry.getValue();

				int hashCode = Math.abs(b.hashCode()) & ((1 << this.gD) - 1);

				if (((hashCode >> b.lD) & 1) == 1) {
					//bucket2.put(kVal, vVal);
				} else {
					//bucket1.put(kVal, vVal);
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

			// Resets local depths of of two buckets
			bucket2.lD = b.lD + 1;
			bucket1.lD = b.lD + 1;
			return ret;
			*/
		} else {
			return dir.put(key,value);
		}
	}

	/**
	 * The size of the hashTable
	 */
	public int hSize() {
		int sum = 0;
		for (Bucket<K, V> bucket : this.hTable) {
			sum = +slots;
		}

		sum = sum * initSize;
		return sum;

	}

	/**
	 * Print method that prints the hash table
	 */
	private void print() {
		System.out.println("Hash Table (Extendable Hashing)");
		System.out.println("-------------------------------------------");

		int bNum = 0;
		for (Bucket<K, V> b : hTable) {
			Set<Entry<K, V>> enSet = b.entrySet();
			System.out.print("[Bucket #" + bNum + ": ");
			boolean first = true;
			for (Entry<K, V> ent : enSet) {
				if (!first) {
					System.out.print(" ---> ");
				}
				System.out.print(ent.getKey() + ":" + ent.getValue());
				first = false;

			}
			System.out.print(" ]\n");
			bNum++;

		} // for

		System.out.println("-------------------------------------------");
	} // print

	/**
	 * Main method used for testing purposes
	 * 
	 * @param args
	 */
	public static void main(String[] args) 
	{
	} // main

}
