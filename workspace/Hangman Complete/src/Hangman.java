import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;

class Hangman
{
    public static void main (String args[])
    {
	HangmanBoard hb = new HangmanBoard();
	Player player = new HumanPlayer(); //for the compiler's sake
	
	//initialize player object
	if (args[1].equals("human"))
	{
	    player = new HumanPlayer();
	}
	
	else if (args[1].equals("naive"))
	{
	    player = new NaiveComputerPlayer();
	}

	else if (args[1].equals("random"))
	{
	    player = new RandomComputerPlayer();
	}

	else if (args[1].equals("cutthroat"))
	{
	    player = new CutThroatComputerPlayer();
	}

	else
	{
	    System.out.println("You have entered an invalid guesser. Please enter human, naive, random, or cutthroat for the second argument");
	    System.exit(1);
	}

	//initialize operator object
	if (!args[0].equals("computer"))
	{
	    System.out.println("You have entered an invalid operator.  Please enter computer for the first argument.");
	    System.exit(1);
	}



	while(!hb.isGameOver())
	{
	    hb.printBoard();
	    char guess = player.makeGuess(hb.getMaskedWord(), hb.getGuesses());
	    hb.processGuess(guess);
	    //press enter to proceed?
	}
    }
}



interface Board
{
    void printBoard();
    void processGuess(char guess);
    String getMaskedWord();
    String getGuesses();
    boolean isGameOver();
}



class HangmanBoard implements Board
{
    private String guesses, theWord, missed;
    private boolean gameOver;


    public HangmanBoard()
    {
	System.out.println("Hangman Game\n");
	guesses = "";
	missed = "";
	theWord = selectTheWord();
	gameOver = false;
    }


    public void printBoard() //prints gallows, word as revealed thus far, and missed characters
    {
        //note four characters in missed for each incorrect guess, the guess plus a comma between two spaces
	//aside from the last character
	int numMisses = (missed.length() + 3) / 4;
	//print ascii gallows
	if (numMisses == 0)
	{
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
	if (numMisses == 1)
	{
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
	if (numMisses == 2)
	{
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
	if (numMisses == 3)
	{
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
	if (numMisses == 4)
	{
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
	if (numMisses == 5)
	{
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

	System.out.println("\nWord:\t" + getMaskedWord() + "\nMissed:\t" + missed + "\n");
	//alphabetize missed? format masked word nicely?
    }


    public void processGuess(char guess) //updates guesses and gameOver, handles win and lose condition
    {
	//note that it is the responsibility of the makeGuess method of the Player class
	//to ensure a valid guess, e.g. not repeating a guess twice
	String oldMaskedWord = getMaskedWord(); 
	guesses += guess;

	if (oldMaskedWord.equals(getMaskedWord())) //i.e. if your guess didn't affect the masked word
	{
	    System.out.println("The letter " + guess + " is not in the word.\n\n\n");
	    
	    if (missed.length() != 0)
	    {
		missed += " , " + guess;
	    }

	    else
	    {
		missed = Character.toString(guess);
	    }
	}

	else
	{
	    System.out.println("Good - " + guess + " is a match.\n\n\n");
	}


	if (theWord.equals(getMaskedWord())) //win condition
	{
	    gameOver = true;
	    System.out.println("\nCongratulations!\nYou avoided certain doom by correctly guessing the word " + theWord + ".");
	    System.out.println("\nThanks for playing.");
	}
	else if ((missed.length() + 3) / 4 == 6) //lose condition
	{
	    gameOver = true;
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
	    System.out.println("\nWe're sorry.\nYou're swinging from a short rope thanks to sub-par guessing skills.");
	    System.out.println("It's probably for that best that you were eliminated from the gene pool.");
	    System.out.println("The word you were looking for was " + theWord + ".");
	}

    }


    public String getMaskedWord() //hides unguessed characters of theWord with dashes
    {
	String maskedWord = "";

	for (int i = 0; i < theWord.length(); i++)
	{
	    if (guesses.indexOf(theWord.charAt(i)) != -1) //indexOf returns -1 if the character does not occur in a string
	    {
		maskedWord += theWord.charAt(i);
	    }

	    else
	    {
		maskedWord += "-";
	    }
	}
	
	return maskedWord;
    }


    public boolean isGameOver()
    {
	return gameOver;
    }


    public String getGuesses()
    {
	return guesses;
    }


    private String selectTheWord() //helper method, loads dictionary and selects word at random
    {
	String choice;
	Scanner dictionaryScanner = new Scanner(System.in); //for the compiler's sake
	Random random = new Random();
	ArrayList<String> dictionary = new ArrayList<String>();

	try
	{
	    dictionaryScanner = new Scanner(new File("dictionary.data"));
	}
	catch (FileNotFoundException e)
	{
	    System.out.println("Failed to find dictionary.data. Are you sure it is in the current directory?");
	    System.exit(1);
	}

	System.out.println("dictionary.data located.  Loading the dictionary... "); //fills up an ArrayList with words
	while (dictionaryScanner.hasNext())
	{
	    dictionary.add(dictionaryScanner.next());
	}
	System.out.print("Dictionary loaded! \n\n\n"); //how long will this take?

	choice = dictionary.get(random.nextInt(dictionary.size()));

	return choice;
    }
}




abstract class Player //how else can we implement polymorphism and inheritance?
{
    abstract char makeGuess(String word, String guesses);
}




class HumanPlayer extends Player
{
    char makeGuess(String word, String guesses)
    {
	char guess;
	String input = "";
	Scanner keyboard = new Scanner(System.in);

	System.out.println("Please enter your guess:\t");
	input = keyboard.next().toLowerCase();
	
	while(input.length() != 1 || !Character.isLetter(input.charAt(0)) || guesses.contains(Character.toString(input.charAt(0)))) //checking user input
        {
	    if (input.length() != 1)
	    {
		System.out.println("Please enter only one character at a time:\t");
	    }
	    else if (!Character.isLetter(input.charAt(0)))
	    {
		System.out.println("Please enter a letter, not a digit or a symbol:\t");
	    }
	    else if (guesses.contains(Character.toString(input.charAt(0))))
	    {
		System.out.println("You already chose that letter.  Please choose another:\t");
	    }

	    input = keyboard.next().toLowerCase();
        }

	guess = input.charAt(0);
	return guess;
    }
}




abstract class ComputerPlayer extends Player //what to do with this subclass?
{
}




class NaiveComputerPlayer extends ComputerPlayer
{
    char makeGuess(String word, String guesses) //guesses alphabetically
    {
	char guess = (char) guesses.length();
	guess = (char)(guess + 'a');
	return guess;
    } //robust: make sure guesses contains less than 26 letters
}




class RandomComputerPlayer extends ComputerPlayer
{
    Random random = new Random();
    char makeGuess(String word, String guesses) //guesses randomly
    {
	char guess;
	do
	{
	    guess = (char)(random.nextInt(26) + 'a');
	}
	while (guesses.contains(Character.toString(guess))); //ensure we're not double guessing 
	return guess;
    } //robust: make sure guesses contains less than 26 letters
}




class CutThroatComputerPlayer extends ComputerPlayer
{
    HangmanAI hai = new HangmanAI();
    char makeGuess(String word, String guesses)
    {
	return hai.makeGuess(word, guesses);
    }
}
