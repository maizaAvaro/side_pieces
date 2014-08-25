import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;



public class Hangman {

    private static final String Dictionary = "proj2Dictionary.txt";
    
    // minimum length of a word to consider
    private static final int minLength = 1;
    
    public static void main(String[] args) {
        
    	HangmanAI hai = new HangmanAI();
    	
        System.out.println("Hangman Game");
        
        // read in the data from the dictionary to an ArrayList
        ArrayList<String> hiddenWords = new ArrayList<String>();
        
        // first, open the file and create a Scanner to read it in
        Scanner wordLoop = null;
        try {
            wordLoop = new Scanner(new File(Dictionary));
        }
        catch (FileNotFoundException e) {
            System.err.println(e);
            System.exit(1);
        }
        
        // read the contents of the file one word at a time
        while (wordLoop.hasNext()) {
            String nextScan = wordLoop.next();
            if (nextScan.length() >= minLength) {
                hiddenWords.add(nextScan);
            }
        }
        
        // create a random number generator to pick a word
        Random random = new Random();

        // create a Scanner to read keyboard input
        Scanner keyboard = new Scanner(System.in);
        
        boolean gameOver = false;
        while (!gameOver) {
            
            // Randomly find a word out of the ArrayList built from the dictionary to use as the word to guess
            String theWord = hiddenWords.get(random.nextInt(hiddenWords.size()));
            
            boolean wordOver = false;
            int missesLeft = 6;
            ArrayList<Character> guessed = new ArrayList<Character>();
            
            String naive = "abcdefghijklmnopqrstuvwxyz";
            char nInput;
            int n = 0;
            String nInput1 = null;
            char guess1;
            String guess2 = null;
            String test2;
            String computerGuess = "";
            String computerWord = null;
            
            
            // keep looping until the word has been guessed or too
            // many incorrect guesses have been made
            while (!wordOver) {
        	
            	/*do{
            		Random random2 = new Random();
            		guess1 = (char) random2.nextInt(26);
            		guess1 = (char)(guess1+'a');
            		guess2 = Character.toString(guess1);
            	}
            	while (maskWord(theWord, guessed).contains(guess2) || guessed.contains(guess1));
            		test2 = guess2;*/
        		
            	nInput = naive.charAt(n);
            	nInput1 = Character.toString(nInput);
            	n = n+1;
            	
            	for(int t = 0; t < guessed.size(); t++){
            		computerGuess = computerGuess + (Character.toString(guessed.get(t)));
            	}
            	computerWord = maskWord(theWord, guessed).replace('_', '-');
            	computerWord = computerWord.replace(" ","");
                
                printGallows(missesLeft);
                System.out.println("Word:  "+maskWord(theWord, guessed));
                boolean guessOK = false;
                String guess = null;
                while (!guessOK) {
                	
                	showGuessed(theWord, guessed);
                	System.out.print("Guess:  ");
                   
                	//guess = keyboard.next().toLowerCase(); // add this guess to our list of guessed letters HUMAN PLAYER
                    
                	guess = nInput1;
                    System.out.println(nInput1);   //NAIVE COMPUTER
                	
                	//guess = test2;             // RANDOM COMPUTER
                	//System.out.println(test2);
                	
                	//guess = Character.toString(hai.makeGuess(computerWord, computerGuess));
                	
                	char test = guess.charAt(0);
                    if(Character.isLetter(test)){
                    	
                    }
                    else{
                    	
                    	char test1 = guess.charAt(0);
                    	while(!(Character.isLetter(test1))){
                    		
                    		System.out.println("\nDigits or symbols are not a valid input for this game.\nPlease enter only letters for your guess.");
                    		printGallows(missesLeft);
                    		System.out.println("Word:  "+maskWord(theWord, guessed));
                    		showGuessed(theWord, guessed);
                        	System.out.print("Guess:  ");
                        	guess = keyboard.next().toLowerCase();
                        	test1 = guess.charAt(0);
                    		
                    	}
                    	
                    	
                    }
                   
                
                    if (guessed.contains(guess.charAt(0))) {
                        if(guess.length()>1){
                        	System.out.println("\nPlease enter only one letter at a time.\nThe game will proceed and recognize only the first letter you entered.");
                        }
                    	System.out.println("\nYou already guessed that!  Try again.");
                    	printGallows(missesLeft);
                    	System.out.println("Word:  "+maskWord(theWord, guessed));
                    }
                    else {
                        // insert the guess into the list of guessed
                        // letters in alphabetical order
                        int pos = 0;
                        while (pos < guessed.size() && guessed.get(pos) < guess.charAt(0)) {
                                   pos++;
                                }
                        guessed.add(pos, guess.charAt(0));
                        guessOK = true;
                    }
                }
                // checks first character of guess to see if it is part of the word being looked for
                if(guess.length()>1){
                	System.out.println("\nPlease enter only one character at a time.\nThe game will proceed and recognize only the first letter you entered.");
                }
          
                if (theWord.indexOf(guess.substring(0,1)) == -1) { // not in the word
                    System.out.println("\nThe letter " + guess.charAt(0) + " is not in the word.");
                    missesLeft--;
                    if (missesLeft == 0) {
                    	printGallows(missesLeft);
                		System.out.println("Word:  "+maskWord(theWord, guessed));
                		showGuessed(theWord, guessed);
   
                    	System.out.println("\nWe're sorry.\nYou're swinging from a short rope thanks to sub-par guessing skills.\nIt's probably best you were eliminated from the gene pool.\n\nThe word you were looking for was:  " + theWord);
                    	System.out.println("\nThanks for playing.");
                    	wordOver = true;
                        System.exit(1);
                    }
                }
                else {
                    // it is in the word
                    System.out.println("\nGood - you have a match.");
                    if (theWord.equals(maskWord(theWord, guessed))) {
                    	printGallows(missesLeft);
                		System.out.println("Word:  "+maskWord(theWord, guessed));
                		showGuessed(theWord, guessed);
                		
                    	System.out.println("\nCongratulations!\nYou avoided certain doom via correctly guessing the word " + theWord + ".");
                        System.out.println("\nThanks for playing.");
                        wordOver = true;
                        System.exit(1);
                    }
                }
            }
            
            
            
        }
        
        
    }
    
    /**
     * return a String with the characters not in the list of characters
     * replaced with _ characters.
     * 
     * @param word the word to be guessed
     * @param letters the ArrayList of characters to be revealed
     * @return the word with all characters not in letters replaced by _'s
     */
    private static String maskWord(String word, ArrayList<Character> letters) {
        
        String answer = "";
        for (int i = 0; i<word.length(); i++) {
            if (letters.contains(word.charAt(i))) {
                answer = answer + word.charAt(i);
            }
            else {
                answer = answer + " _ ";
            }
        }
        return answer;
    }
    
    /**
     * Show the list of guessed letters that were not found in the word.
     * 
     * @param theWord the word being guessed
     * @param letters the ArrayList of characters guessed so far
     */
    private static void showGuessed(String theWord, ArrayList<Character> letters) {
        
        System.out.print("Misses:  ");
        for (int i = 0; i<letters.size(); i++) {
            if (theWord.indexOf(letters.get(i)) == -1) {
                System.out.print(letters.get(i) + ", ");
            }
        }
        System.out.println();
    }

    
    public static void printGallows(int numMissesRem){

    	if (numMissesRem == 6){

    		System.out.println("   _____    ");
    		System.out.println("  |     |   ");
    		System.out.println("        |   ");
    		System.out.println("        |   ");
    		System.out.println("        |   ");
    		System.out.println("        |   ");
    		System.out.println("        |   ");
    		System.out.println("        |   ");
    		System.out.println("        |   ");
    		System.out.println("  ______|___");
    	}
    	if (numMissesRem == 5){

    		System.out.println("   _____    ");
    		System.out.println(" _|_    |   ");
    		System.out.println("|   |   |   ");
    		System.out.println("|_ _|   |   ");
    		System.out.println("        |   ");
    		System.out.println("        |   ");
    		System.out.println("        |   ");
    		System.out.println("        |   ");
    		System.out.println("        |   ");
    		System.out.println("  ______|___");
    	}
    	if (numMissesRem == 4){

    		System.out.println("   _____    ");
    		System.out.println(" _|_    |   ");
    		System.out.println("|   |   |   ");
    		System.out.println("|_ _|   |   ");
    		System.out.println("  |     |   ");
    		System.out.println("  |     |   ");
    		System.out.println("  |     |   ");
    		System.out.println("        |   ");
    		System.out.println("        |   ");
    		System.out.println("  ______|___");
    	}
    	if (numMissesRem == 3){

    		System.out.println("   _____    ");
    		System.out.println(" _|_    |   ");
    		System.out.println("|   |   |   ");
    		System.out.println("|_ _|   |   ");
    		System.out.println("  |     |   ");
    		System.out.println(" \\|     |   ");
    		System.out.println("  |     |   ");
    		System.out.println("        |   ");
    		System.out.println("        |   ");
    		System.out.println("  ______|___");
    	}
    	if (numMissesRem == 2){

    		System.out.println("   _____    ");
    		System.out.println(" _|_    |   ");
    		System.out.println("|   |   |   ");
    		System.out.println("|_ _|   |   ");
    		System.out.println("  |     |   ");
    		System.out.println(" \\|/    |   ");
    		System.out.println("  |     |   ");
    		System.out.println("        |   ");
    		System.out.println("        |   ");
    		System.out.println("  ______|___");
    	}
    	if (numMissesRem == 1){

    		System.out.println("   _____    ");
    		System.out.println(" _|_    |   ");
    		System.out.println("|   |   |   ");
    		System.out.println("|_ _|   |   ");
    		System.out.println("  |     |   ");
    		System.out.println(" \\|/    |   ");
    		System.out.println("  |     |   ");
    		System.out.println(" /      |   ");
    		System.out.println("/       |   ");
    		System.out.println("  ______|___");
    	}
    	if (numMissesRem == 0){

    			System.out.println("   _____    ");
    			System.out.println(" _|_    |   ");
    			System.out.println("|x x|   |   ");
    			System.out.println("|_~_|   |   ");
    			System.out.println("  |     |   ");
    			System.out.println(" \\|/    |   ");
    			System.out.println("  |     |   ");
    			System.out.println(" / \\    |   ");
    			System.out.println("/   \\   |   ");
    			System.out.println("  ______|___");
    	}
}
}
