package june26;

import java.util.*;

public class SeqSearch 
{
	/**
	 * Array size - given by user - arg[0]
	 */
	private int n;
	
	/**
	 * Number of tries to search - given by user - arg [1]
	 */
	private int numOfTries;

	/**
	 * Sequential search method constructor
	 * @param n
	 * @param numOfTries
	 */
	public SeqSearch(int n, int numOfTries)
	{
		this.n = n;
		this.numOfTries = numOfTries;
		
		int[] data = new int[n];
		
		for(int i = 0; i < n; i++)
		{
			
			data[i] = i;
			
		}	// for
		
	}	// Constructor
	
	/**
	 * Tests the SeqSearch method
	 */
	public void test()
	{
		
		int total = 0;
		
		for(int k = 0; k < numOfTries; k++)
		{
			
			int key = (int)(Math.random() * n);
			total = total + find(key);
			
		}	// for
		
		System.out.println("Probes: " + (total / (double) numOfTries));
		
	}	// test
	
	/**
	 * Finds the key in the array and returns the number of probes it took
	 * to find the key
	 * @param key
	 * @return
	 */
	public int find(int key)
	{
		int answer = -1;
		
		for(int i = 0; i < n; i++)
		{
			
			if(i == key)
			{
				
				answer = i + 1;
				
			}	// if
			
		}	// for
		
		return answer;
		
	}	// find
	
	
}	// SeqSearch
