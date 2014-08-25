package recursion;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * Tests adding and retrieving words from a Trie data strucure
 * @author drdan
 *
 */
public class TrieNodeTest extends TestCase 
{

	@Test
	/**
	 * Test extracting the first char of a suffix
	 */
	public void testFirstCharOfSuffix()
	{
		TrieNode instance = new TrieNode("fre");
		Character suffix1 = instance.firstCharOfSuffix("frenetic");
		assertEquals("suffix of 'frenetic' starts with",'n',suffix1.charValue());
		Character suffix2 = instance.firstCharOfSuffix("fresh");
		assertEquals("suffix of 'fresh' starts with",'s', suffix2.charValue());
		Character suffix3 = instance.firstCharOfSuffix("fretful");
		assertEquals("suffix of 'fretful' starts with", 't', suffix3.charValue());
		
	}
	
	@Test
	/**
	 * Add a word repeatedly
	 */
	public void testRepeatAdd() 
	{
		TrieNode instance = new TrieNode("");
		assertFalse("Empty data structure contains String", instance.contains("Rumplestiltskin"));
		
		instance.addWord("Rumplestiltskin");
		assertTrue("Contains word after one addition", instance.contains("Rumplestiltskin"));
		
		instance.addWord("Rumplestiltskin");
		assertTrue("Contains word after two additions", instance.contains("Rumplestiltskin"));
		
		instance.addWord("red");
		assertTrue("Contains 'red' after three additions", instance.contains("red"));
		assertTrue("Contains 'Rumplestiltskin' after three additions", instance.contains("Rumplestiltskin"));
	
		instance.addWord("Rumplestiltskin");
		assertTrue("Contains word after four additions", instance.contains("Rumplestiltskin"));
		
	}//testRepeatAdd
	
	@Test
	/**
	 * Test adding multiple words from a list
	 */
	public void testMultipleWords(){
		String[] word = {"fat","fate","cry","catch","cat","father","fare","far",
				         "car","care"};
		TrieNode instance = new TrieNode("");
		
		for (int i=0; i<word.length;i++)
		{
			//add i-th word and test membership of all words
			instance.addWord(word[i]);
			//TODO: inner loop asserting words in the Trie
			//assertTrue("After "+i+"insertions, ...",
			//TODO: inner loop asserting words not in the Trie
			
		}
	
	}

}

