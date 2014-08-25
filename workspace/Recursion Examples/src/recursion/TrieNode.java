package recursion;

import java.util.HashMap;


/**
 * Represents a node in a 'trie', a specialized data structure for storing
 * words
 * @author drdan
 *
 */
public class TrieNode 
{

     HashMap<Character, Object> map;
     String prefix;
     boolean prefixIsWord = false;
     
     
     /**
      * Creates a new TrieNode to contain words starting with 'prefix'
      */
     public TrieNode(String prefix)
     {
            
    	 this.prefix = prefix;
    	 map = new HashMap<Character, Object>();
    	 
     }	// End of TrieNode constructor
     
     
     /**
      * Returns a Character object wrapping the first char of 'newWord'
      * following prefix
      * @param newWord a String containing this.prefix as a prefix
      */
     protected Character firstCharOfSuffix(String newWord)
     {
    	
    	int firstCharIndex = prefix.length();
    	char firstChar = newWord.charAt(firstCharIndex);
    	
    	return firstChar; 
    	 
     }	// End of method firstCharOfSuffix
     
     
     /**
      * Adds 'newWord' to this node
      * @param newWord a String with trieNode.prefix as a prefix
      */
     public void addWord(String newWord)
     {
    	 System.out.println("Adding "+ newWord +" to " + prefix);
    	 if (newWord.equalsIgnoreCase(prefix))
    	 {
    		 
    		 prefixIsWord = true;
    		 return;
    		 
    	 }	// End of if statement
    	 
    	 Character firstCharOfSuffix = firstCharOfSuffix(newWord);
         
    	 if (map.get(firstCharOfSuffix) == null)
    	 {
    		
    		map.put(firstCharOfSuffix, newWord);
    		 
    	 }else if (map.get(firstCharOfSuffix) instanceof TrieNode)
    	 {
        	 TrieNode nextTrieNode = (TrieNode)map.get(firstCharOfSuffix);
    		 nextTrieNode.addWord(newWord);
    		 
         }else if (((String) map.get(firstCharOfSuffix)).equalsIgnoreCase(newWord))
         {		
        	
        	//Do nothing here, since the word already exists in the map
        	 
         }else
         {
        	  
        	 // Get prefix, get first character of suffix and combine and then add the trieNode
        	 String newPrefix = prefix + firstCharOfSuffix;
        	 TrieNode newTrieNode = new TrieNode(newPrefix);
        	 String oldWord = (String)map.get(firstCharOfSuffix);
        	 map.put(firstCharOfSuffix, newTrieNode);
        	 newTrieNode.addWord(oldWord);
        	 newTrieNode.addWord(newWord);
        	 
         }	// End of multiple if-else statement
         
     }	// End of method addWord
     
     
     /**
      * Checks if a word is present in a TrieNode
      * @param word a word which contains this node's prefix as a prefix
      */
     public boolean contains(String word)
     {
    	 
    	 Character firstCharOfSuffix = firstCharOfSuffix(word);
    	 
    	 if (word.equalsIgnoreCase(prefix))
    	 {
    		 
    		if(prefixIsWord == true)
    		{
    			
    			return true;
    			
    		}else{
    			
    			return false;
    			
    		}	// End of if-else statement
    		 
    	 }	// End of if statement
    		  
    	 if (map.get(firstCharOfSuffix(word)) == null)
    	 {
    		 
    		return false;
    		 
    	 }else if (map.get(firstCharOfSuffix(word)) instanceof TrieNode)
    	 {
        	 
    		 TrieNode nextTrieNode = (TrieNode)map.get(firstCharOfSuffix);
    		 if(nextTrieNode.contains(word) == true)
    		 {
    			 
    			 return true;
    			 
    		 }else{
    			 
    			 return false;
    			 
    		 }	// End of if-else statement
    		 
         }else 
         {
         	 
        	 String checkWord = (String)map.get(firstCharOfSuffix(word));
        	 
        	 if(checkWord.equalsIgnoreCase(word))
        	 {
        		 
        		 return true;
        		 
        	 }else{
        		 
        		 return false;
        		 
        	 }	// End of if-else statement
        	 
    	 }	// End of multiple if-else statement

     }	// End of method contains
     
}	// End of class TrieNode 
