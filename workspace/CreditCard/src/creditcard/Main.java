package creditcard;


/**
 * Generates and prints out some CustomerAccount objects - excerpt taken from
 * Dr. Everett's Exceptions lab
 * @author Nathan
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		
		// Declare two object variables, but initialize only one
		CustomerAccount geckoAccount, nathanAccount;
		
		geckoAccount = new CustomerAccount(1, "Gordon Gecko", "1 Wall St, NYC", 10000000.0);
		nathanAccount = new CustomerAccount(2, "Nathan Ray", "University of Georgia", 50.0);
		//nathanAccount = null;
		
		try{
			
			System.out.println("Valued customer:  " + geckoAccount.getCustName());
			System.out.println("Valued customer:  " + nathanAccount.getCustName());
			
		}
		catch(Exception error){
			
			System.out.println("Yikes! Our code threw a " + error.getClass().getName() + "!");
			
		}	// End of try-catch block
		
	}	// End of main method

}	// End of Main class
