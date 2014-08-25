class Hangman
{
    public static void main (String args[])
    {
	HangmanAI hai = new HangmanAI();
	HangmanBoard hb = new HangmanBoard();
	
	if (args[1].equals("human"))
	{
	    Player player = new HumanPlayer(); //what class on the lhs?
	}
	
	else if (args[1].equals("naive"))
	{
	    Player player = new NaiveComputerPlayer(); //what class on the lhs?
	}

	else if (args[1].equals("random"))
	{
	    Player player = new RandomComputerPlayer(); //what class on the lhs?
	}

	else if (args[1].equals("cutthoat"))
	{
	    Player player = new CutThroatComputerPlayer(); //what class on the lhs?
	}

	else
	{
	    System.out.println("You have entered an invalid guesser. Please enter human, naive, random, or cutthroat for the second argument.  Thank you!");
	}

    }
}

interface Board
{
    
}

class HangmanBoard implements Board
{
    private int numGuesses;

    public HangmanBoard()
    {
	System.out.println("Hangman Game");
	numGuesses = 0;
	printGallows();
    }

    public static void printGallows()
    {
	if (numGuesses == 0)
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
	if (numGuess == 1)
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
	if (numGuesses == 2)
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
	if (numGuesses == 3)
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
	if (numGuesses == 4)
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
	if (numGuesses == 5)
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
	if (numGuesses == 6)
	{
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

abstract class Player
{
    
}

class HumanPlayer extends Player
{
    
}

abstract class ComputerPlayer extends Player
{
    
}

class NaiveComputerPlayer extends ComputerPlayer
{
    
}

class RandomComputerPlayer extends ComputerPlayer
{
    
}

class CutThroatComputerPlayer extends ComputerPlayer
{
    
}
