package program4;

/*******************************************************************************
 * @file BpTree.java
 */

import java.io.*;
import java.lang.reflect.Array;
import static java.lang.System.out;
import java.util.*;


/*******************************************************************************
 * This class provides B+Tree maps.  B+Trees are used as multi-level index structures
 * that provide efficient access for both point queries and range queries.
 */
public class BpTree <K extends Comparable <K>, V>
       extends AbstractMap <K, V>
       implements Serializable, Cloneable, SortedMap <K, V>
{
    /** The maximum fanout for a B+Tree node.
     */
	private static final int PHI = 4;
    private static final int ORDER = PHI + 1;

    /** The class for type K.
     */
    private final Class <K> classK;

    /** The class for type V.
     */
    private final Class <V> classV;

    /***************************************************************************
     * This inner class defines nodes that are stored in the B+tree map.
     * if n is a leaf then key[i] and ref[i] are a pair
     * if n is a node then the children of ref[i] are all strictly less
     * 	than key[i]
     * ref[0] is less than all keys and key[0] does not exist
     */
    private class Node
    {
        boolean   isLeaf;
        int       nKeys;
        K []      key;
        Object [] ref;
        Node previousLeaf;
        Node nextLeaf;
        @SuppressWarnings("unchecked")
        Node (boolean _isLeaf)
        {
            isLeaf = _isLeaf;
            nKeys  = 0;
            key    = (K []) Array.newInstance (classK, ORDER + 2);
            if (isLeaf) {
                ref = (V []) Array.newInstance (classV, ORDER + 2);
                // ref = new Object [ORDER];
            } else {
                ref = (Node []) Array.newInstance (Node.class, ORDER + 2);
            } // if
        } // constructor
        
        Node (Node _previousLeaf, Node _nextLeaf) {
        	this(true);
        	previousLeaf = _previousLeaf;
        	nextLeaf = _nextLeaf;
        	if (_previousLeaf != null) {
        		_previousLeaf.nextLeaf = this;
        	}
        	if (_nextLeaf != null) {
        		_nextLeaf.previousLeaf = this;
        	}
        }
    } // Node inner class

    /** The root of the B+Tree
     */
    private Node root;

    /** The counter for the number nodes accessed (for performance testing).
     */
    private int count = 0;
    
    /**
     * Set to true for testing output
     */
    private boolean testing = false;

    private Node firstLeaf = null;
    private Node lastLeafPointer;
    int size = 0;
    
    /***************************************************************************
     * Construct an empty B+Tree map.
     * @param _classK  the class for keys (K)
     * @param _classV  the class for values (V)
     */
    public BpTree (Class <K> _classK, Class <V> _classV)
    {
        classK = _classK;
        classV = _classV;
        lastLeafPointer = new Node (null, null);
        root   = new Node (null, lastLeafPointer);
        lastLeafPointer.previousLeaf = root;
        firstLeaf = root;
        size = 0;
    } // BpTree

    /***************************************************************************
     * Return null to use the natural order based on the key type.  This requires
     * the key type to implement Comparable.
     */
    public Comparator <? super K> comparator () 
    {
        return null;
    } // comparator

    /***************************************************************************
     * Return a set containing all the entries as pairs of keys and values.
     * @return  the set view of the map
     */
    @SuppressWarnings("unchecked")
    public Set <Map.Entry <K, V>> entrySet ()
    {
        Set <Map.Entry <K, V>> enSet = new HashSet <> ();
        Node n = firstLeaf;
        while(n != lastLeafPointer && n != null) {
        	for (int i = 1; i <= n.nKeys; i++) {
        		enSet.add((Map.Entry) new AbstractMap.SimpleEntry(n.key[i], n.ref[i]));
        	}
        	n = n.nextLeaf;
        }
        return enSet;
    } // entrySet

    /***************************************************************************
     * Given the key, look up the value in the B+Tree map.
     * @param key  the key used for look up
     * @return  the value associated with the key
     */
    @SuppressWarnings("unchecked")
    public V get (Object key)
    {
        return find ((K) key, root);
    } // get

    /***************************************************************************
     * Put the key-value pair in the B+Tree map.
     * @param key    the key to insert
     * @param value  the value to insert
     * @return  null (not the previous value)
     */
    public V put (K key, V value)
    {
    	V ret = get(key);
        insert (key, value, root, null);
        if (ret == null) {
        	size++;
        }
        return ret;
    } // put

    /***************************************************************************
     * Return the first (smallest) key in the B+Tree map.
     * @return  the first key in the B+Tree map.
     */
    public K firstKey () 
    {
    	return firstLeaf.key[1];
    } // firstKey

    /***************************************************************************
     * Return the last (largest) key in the B+Tree map.
     * @return  the last key in the B+Tree map.
     */
    public K lastKey () 
    {
    	Node last = lastLeafPointer.previousLeaf;
    	return last.key[last.nKeys];
    } // lastKey

    /***************************************************************************
     * Return the portion of the B+Tree map where key < toKey.
     * @return  the submap with keys in the range [firstKey, toKey)
     */
    public SortedMap <K,V> headMap (K toKey)
    {
    	SortedMap <K,V> map = new TreeMap<>();
    	Node n = firstLeaf;
    	outerloop:
    	while (n != null || n != lastLeafPointer) {
    		for (int i = 1; i <= n.nKeys; i++) {
    			if (toKey.compareTo(n.key[i]) <= 0) {
    				break outerloop;
    			}
    			map.put(n.key[i], (V) n.ref[i]);
    		}
    		n = n.nextLeaf;
    	}
        return map;
    } // headMap

    /***************************************************************************
     * Return the portion of the B+Tree map where fromKey <= key.
     * @return  the submap with keys in the range [fromKey, lastKey]
     */
    public SortedMap <K,V> tailMap (K fromKey)
    {
    	SortedMap <K,V> map = new TreeMap<>();
    	Node n = firstLeaf;
    	while (n != null) {
    		for (int i = 1; i <= n.nKeys; i++) {
    			if (fromKey.compareTo(n.key[i]) <= 0) {
        			map.put(n.key[i], (V) n.ref[i]);
    			}
    		}
    		n = n.nextLeaf;
    	}
        return map;
    } // tailMap

    /***************************************************************************
     * Return the portion of the B+Tree map whose keys are between fromKey and toKey,
     * i.e., fromKey <= key < toKey.
     * @return  the submap with keys in the range [fromKey, toKey)
     */
    public SortedMap <K,V> subMap (K fromKey, K toKey)
    {
    	SortedMap <K,V> map = new TreeMap<>();
    	Node n = firstLeaf;
    	outerloop:
    	while (n != null && n != lastLeafPointer) {
    		for (int i = 1; i <= n.nKeys; i++) {
    			if (fromKey.compareTo(n.key[i]) <= 0 && toKey.compareTo(n.key[i]) > 0) {
        			map.put(n.key[i], (V) n.ref[i]);
    			}
    		}
    		n = n.nextLeaf;
    	}
        return map;
    } // subMap

    /***************************************************************************
     * Return the size (number of keys) in the B+Tree.
     * @return  the size of the B+Tree
     */
    public int size ()
    {
    	return size;
    } // size

    /***************************************************************************
     * Print the B+Tree using a pre-order traveral and indenting each level.
     * @param n      the current node to print
     * @param level  the current level of the B+Tree
     */
    @SuppressWarnings("unchecked")
    private void print (Node n, int level)
    {
        // out.println ("BpTree");
        // out.println ("-------------------------------------------");
        if (testing) {
        	if (level == 0) {
        		out.println("----- BpTree ------------------------------");
        	}
	        for (int j = 0; j < level; j++) out.print ("\t");
	        if (n == null) {
	        	out.print (">>> [ NULL ] \n");
	        	return;
	        }
	        if (!n.isLeaf) {
	        	out.print (">>>" + n + ":[ . ");
	        	for (int i = 1; i <= n.nKeys; i++) out.print (n.key [i] + " . ");
	        	out.print ("]\n");
	        }
	        else {
	        	out.print(">>>" + n + ":[ ");
	        	boolean first = true;
	        	for (int i = 1; i <= n.nKeys; i++) {
	        		if (!first) out.print(" , ");
	        		out.print(n.key[i] + ":" + n.ref[i]);
	        		first = false;
	        	}
	            out.println ("]");
	        }
        }
        else {
        	out.println ("BpTree");
            out.println ("-------------------------------------------");
        	for (int j = 0; j < level; j++) out.print("\t");
        	out.print("[ . ");
        	for (int i = 0; i < n.nKeys; i++) out.print(n.key[i+1] + " . ");
        	out.print("]");
        }
        if ( n != null && ! n.isLeaf) {
            for (int i = 0; i <= n.nKeys; i++) {
            	print ((Node) n.ref [i], level + 1);
            }
        }
        if (!testing || level == 0) out.println ("-------------------------------------------");
    } // print
    
    private void print(boolean _test) {
    	if (_test == true) {
    		testing = true;
    		print(root, 0);
    		testing = false;
    	}
    }

    /***************************************************************************
     * Recursive helper function for finding a key in B+trees.
     * @param key  the key to find
     * @param ney  the current node
     */
    @SuppressWarnings("unchecked")
    private V find (K key, Node n)
    {
    	count++;
    	if (n.isLeaf) {
    		for (int i = 1; i <= n.nKeys; i++) {
    			if (key.compareTo(n.key[i]) == 0) {
    				return (V) n.ref[i];
    			}
    		}
    		return null;
    	}
    	else {
    		for (int i = 0; i <= n.nKeys; i++) {
    			if (i == n.nKeys || key.compareTo(n.key[i+1]) < 0) {
    				return find (key, (Node) n.ref [i]);
    			}
    		}
    	}
    	// should never reach this point:
    	out.println("something has gone wrong with find()");
    	return null;
    } // find

    public boolean containsKey(K key) {
    	return find(key, root) != null;
    }
    
    /***************************************************************************
     * Recursive helper function for inserting a key in B+trees.
     * @param key  the key to insert
     * @param ref  the value/node to insert
     * @param n    the current node
     * @param p    the parent node
     */
    @SuppressWarnings("unchecked")
    private AbstractMap.SimpleEntry<K, Object> insert (K key, Object ref, Node n, Node p)
    {
    	if (key == null) return null;
    	AbstractMap.SimpleEntry<K, Object> toReturn = null;
    	if (n.isLeaf) {
    		if (n.nKeys < PHI) {
    			int refPoint = n.nKeys + 1;
    			for (int i = 1; i <= n.nKeys; i++) {
    				if (key.compareTo(n.key[i]) < 0) {
    					refPoint = i; // LEAF NODE NO SPLIT
    					break;
    				}
    				else if (key.compareTo(n.key[i]) == 0) {
    					return null;
    				}
    			}
    			wedge(key, ref, n, refPoint);
    			toReturn = null;
    		}
    		else { // LEAF NODE IS FULL
    			if (p != null) {
	    			Node newNode = split(key, ref, n);
	    			if (newNode == null) return null;
	    			else {
	    			// RETURN THE NEW NODE FROM THE SPLIT LEAF AS A PUSHUP
		    			toReturn = new AbstractMap.SimpleEntry<K, Object> (
		    						newNode.key[1],
		    						newNode
		    					); // LEAF NODE SPLIT
	    			}
    			}
    			else {
    				Node newNode = split(key, ref, n);
    				if (newNode != null) {
						Node newRoot = new Node(false);
						newRoot.nKeys = 1;
						newRoot.key[1] = newNode.key[1];
						newRoot.ref[0] = n;
						newRoot.ref[1] = newNode;
						root = newRoot;
						toReturn = null; // LEAF NODE IS ROOT SPLIT WITH NEW ROOT
    				}
    			}
    		}
    	}
    	else { // N IS NOT A LEAF
    		int refPoint = n.nKeys;
    		AbstractMap.SimpleEntry<K, Object> pushUp = null;
    		for (int i = 0; i < n.nKeys; i++) {
    			if (key.compareTo(n.key[i+1]) < 0) {
    				refPoint = i;
    				break;
    			}
    		}
    		// INSERT DOWN THE RECURSION AND THE PUSHUP NODE (IF ANY) COMES
    		// BACK UP THE RECURSION
    		pushUp = insert(key, ref, (Node) n.ref[refPoint], n);
    		if (pushUp != null) {
    			K pushKey = pushUp.getKey();
    			Object pushRef = pushUp.getValue();
    			if (n.nKeys < PHI) { // INSERT PUSHUP NODE INTO NON-FULL NODE
    				refPoint = n.nKeys + 1;
    				for (int i = 1; i <= n.nKeys; i++) {
        				if (pushKey.compareTo(n.key[i]) < 0) {
        					refPoint = i;
        					break;
        				}
        				/*
        				else if (key.equals(n.key[i+1])) {
        					out.println("BpTree:insert: attempt to insert duplicate key = " + key);
        					return null; // DUPLICATE KEY ERROR
        				}
        				*/
        			}
        			wedge(pushKey, pushRef, n, refPoint);
        			toReturn = null;
    			}
    			else { // PUSHUP BEING INSERTED INTO FULL NODE
    				if (p != null) { // NOT ROOT
    	    			Node newNode = split(pushKey, pushRef, n);
    	    			// RETURN THE NEW PUSHUP AS SPLITS CASCADE UP THE
    	    			// RECURSION STACK
    	    			if (newNode == null) toReturn = null;
    	    			else {
	    	    			toReturn = new AbstractMap.SimpleEntry<K, Object> (
	    	    						newNode.key[1],
	    	    						newNode
	    	    					);
    	    			}
    				}
    				else { // FULL ROOT
    					Node newNode = split(pushKey, pushRef, n);
    					if (newNode != null) {
	    					Node newRoot = new Node(false);
	    					newRoot.nKeys = 1;
	    					newRoot.key[1] = newNode.key[1];
	    					newRoot.ref[0] = n;
	    					newRoot.ref[1] = newNode;
	    					root = newRoot;
	    					toReturn = null; // CREATE A NEW ROOT WITH THE SPLIT OLD
	    					// ROOT AS ITS TWO CHILD NODES
    					}
    				}
    	    	}
    		}
    		else { // PUSHUP IS NULL
    			toReturn = null;
    		}
    		
    	}
    	return toReturn;
    } // insert

    /***************************************************************************
     * Wedge the key-ref pair into node n.
     * @param key  the key to insert
     * @param ref  the value/node to insert
     * @param n    the current node
     * @param i    the insertion position within node n
     */
    private void wedge (K key, Object ref, Node n, int i)
    {
        for (int j = n.nKeys; j >= i; j--) {
            n.key [j+1] = n.key [j];
            n.ref [j+1] = n.ref [j];
        } // for
        n.key [i] = key;
        n.ref [i] = ref;
        n.nKeys++;
    } // wedge

    /***************************************************************************
     * Split node n and return the newly created node.
     * @param key  the key to insert
     * @param ref  the value/node to insert
     * @param n    the current node
     */
    private Node split (K key, Object ref, Node n)
    {
    	int refPoint = n.nKeys + 1;
    	for (int i = 1; i <= n.nKeys; i++) {
    		if (key.compareTo(n.key[i]) < 0) {
    			refPoint = i;
    			break;
    		}
    		else if (key.compareTo(n.key[i]) == 0) {
    			return null;
    		}
    	}
    	wedge(key, ref, n, refPoint);
    	int newNodeNKeys = n.nKeys / 2;
    	int oldNodeNKeys = n.nKeys - newNodeNKeys;
    	Node newNode;
    	if (n.isLeaf) {
    		newNode = new Node(n, n.nextLeaf);
    	}
    	else {
    		newNode = new Node(false);
    	}
    	for (int i = 1; i <= newNodeNKeys; i++) {
    		newNode.key[i] = n.key[oldNodeNKeys + i];
    		newNode.ref[i] = n.ref[oldNodeNKeys + i];
    	}
    	newNode.ref[0] = null;
    	newNode.nKeys = newNodeNKeys;
    	for (int i = oldNodeNKeys + 1; i <= n.nKeys; i++) {
    		n.key[i] = null;
    		n.ref[i] = null;
    	}
    	n.nKeys = oldNodeNKeys;
    	if (testing) {
    		out.println("split returning " + newNode + " after splitting into: ");
    		print(n,1);
    		print(newNode,1);
    	}
    	return newNode;
    } // split

    /***************************************************************************
     * The main method used for testing.
     * @param  the command-line arguments (args [0] gives number of keys to insert)
     */
    public static void main (String [] args)
    {
        /*BpTree <Integer, Integer> bpt = new BpTree <> (Integer.class, Integer.class);
        int totKeys = 100;
        ArrayList <AbstractMap.SimpleEntry<Integer, Integer>> list = new ArrayList <> ();
        for (int i = -1 * totKeys; i < totKeys; i += 2) {
        	list.add(new AbstractMap.SimpleEntry<> (i, i*i));
        }
        Collections.shuffle(list);
        for (AbstractMap.SimpleEntry<Integer, Integer> ent : list) {
        	bpt.put(ent.getKey(), ent.getValue());
        	out.print(".");
        }
        Set s = bpt.entrySet();
        Iterator it = s.iterator();
        while (it.hasNext()) {
        	out.println(it.next());
        }
        bpt.print(true);
        out.println("size " + bpt.size() + "first " + bpt.firstKey() + ", last " + bpt.lastKey());
        out.println(bpt.subMap(-25,25));
        out.print("\n");*/
     
    	BpTree <Integer, Integer> bpt = new BpTree <> (Integer.class, Integer.class);
        int totKeys = 10;
        if (args.length == 1) totKeys = Integer.valueOf (args [0]);
        for (int i = 1; i < totKeys; i += 2) bpt.put (i, i * i);
        bpt.print (bpt.root, 0);
        for (int i = 0; i < totKeys; i++) {
            out.println ("key = " + i + " value = " + bpt.get (i));
        } // for
        out.println ("-------------------------------------------");
        out.println ("Average number of nodes accessed = " + bpt.count / (double) totKeys);
    	
    } // main

} // BpTree class

