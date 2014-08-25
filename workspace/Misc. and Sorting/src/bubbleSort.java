import java.util.*;


public class bubbleSort {
	
	
	/*public static void bubble_srt(int b[], int n){
		
		int k, j, t = 0;
		
		for(k=0; k < n; k++){
			
			for(j=1; j < (n-k); j++){
				
				if(b[j-1] > b[j]){
					
					t = b[j-1];
					b[j-1] = b[j];
					b[j] = t;
					
				}
				
			}
			
		}
		
		
	}*/
	
	public static void main(String a[]){
		
		  /*int i;
		  int array[] = {12,9,4,99,120,1,3,10};
		  
		  System.out.println("Values Before the sort: ");
		  
		  for(i = 0; i < array.length; i++){
			  
			  System.out.print( array[i]+"  ");
			  
		  }
		  
		  System.out.println();
		  
		  bubble_srt(array, array.length);
		  
		  System.out.print("Values after the sort:\n");
		  
		  for(i = 0; i < array.length; i++){
			  
			  System.out.print(array[i]+"  ");
			  
		  }
		  
		  System.out.println();
		  System.out.println("PAUSE");
		
		    
		char[] orderList = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
		ArrayList<Character> arrayOrderList = new ArrayList<Character>();
		ArrayList<Character> arrayRanList = new ArrayList<Character>();
		ArrayList<Character> arrayBound = new ArrayList<Character>();
		Random random = new Random();
		char test;
		
		for(int i = 0; i < orderList.length; i++){
			arrayOrderList.add(i, orderList[i]);
			arrayBound.add(i, orderList[i]);
		}
		
		System.out.println("Ordered List: "+arrayOrderList);
		System.out.println("Size: "+arrayOrderList.size());
		
		System.out.print("Test Values: ");
		for(int n = 0; n < arrayOrderList.size(); n++){
			test = arrayOrderList.get(random.nextInt(arrayOrderList.size()));
			arrayRanList.add(n, test);
			arrayOrderList.remove(test);
			//System.out.print(" "+test+" ");
		}
		
		System.out.println("\nBound Array: "+arrayBound);
		System.out.println("Random List: "+arrayRanList);
		*/
		
		Random rand = new Random();
		
		int[] counter;
		counter = new int[26];
		String ranLetter = "abcdefghijklmnopqrstuvwxyz";
		int ranIndex = 0;
		int temp = 0;
		char guess1;
		int g = 0;
		String guessNew = null;
		
		for(int n = 0; n < counter.length; n++){
			counter[n] = n;
			System.out.print(" "+counter[n]+" ");
		}
		System.out.println();
		for(int i = (counter.length)-1; i > 0; i--){
			ranIndex = rand.nextInt(i);
			temp = counter[i];
			counter[i] = counter[ranIndex];
			counter[ranIndex] = temp;
			System.out.print(" "+counter[i]+" ");
		}

		System.out.println(counter[0]);
		guess1 = ranLetter.charAt(counter[g]);
		guessNew = Character.toString(guess1);
		System.out.println(guessNew);
		g = g+1;
		
	}
}
