package creditcard;


import java.util.ArrayList;

import org.junit.Test;

import junit.framework.TestCase;

public class CustomerAccountTest extends TestCase 
{
	
	/**
	 * Sets a constant for the maximum credit limit that can be
	 * assigned to an account
	 */
	private static final double MAX_CREDIT_LIMIT = 10000000.00;

	/** Verifies that a newly created CustomerAccount contains the
	 *  supplied initial data and tests that the initial name and address
	 *  on the account cannot be set to the null or empty string as well
	 *  as that the credit limit cannot be set to a negative value via
	 *  an IllegalArgumentException.  The fact that a credit limit cannot
	 *  exceed the defined MAX_CREDIT_LIMIT is also tested via an 
	 *  IllegalArgumentException
	 */
	@SuppressWarnings("unused")
	@Test
	public void testConstructor() {
		
		
		// Account with null customer name
		try {
			
			CustomerAccount badAcct1 = new CustomerAccount(1, null, "12 Easy St", 1000);
			fail("Creating account with null customer name did not throw Exception");
			
		}
		catch(IllegalArgumentException error){
			
			assertEquals("Error message for null customer name", "Customer name must not be empty.", error.getMessage());
			
		}	// End of try-catch block
		
		
		// Account with empty string customer name
		try {
			
			CustomerAccount badAcct2 = new CustomerAccount(1, "", "12 Easy St", 1000);
			fail("Creating account with empty string customer name did not throw Exception");
			
		}
		catch(IllegalArgumentException error){
			
			assertEquals("Error message for empty string customer name", "Customer name must not be empty.", error.getMessage());
			
		}	// End of try-catch block
		
		
		// Account with null customer address
		try {
			
			CustomerAccount badAcct3 = new CustomerAccount(1, "Nathan Ray", null, 1000);
			fail("Creating account with null customer address did not throw Exception");
			
		}
		catch(IllegalArgumentException error){
			
			assertEquals("Error message for null customer address", "Customer address must not be empty.", error.getMessage());
			
		}	// End of try-catch block
		
		
		// Account with empty string customer address
		try {
			
			CustomerAccount badAcct4 = new CustomerAccount(1, "Nathan Ray", "", 1000);
			fail("Creating account with empty string customer address did not throw Exception");
			
		}
		catch(IllegalArgumentException error){
			
			assertEquals("Error message for empty string customer address", "Customer address must not be empty.", error.getMessage());
			
		}	// End of try-catch block
		
		
		// Account with a negative credit limit
		try{
			
			CustomerAccount badAcct5 = new CustomerAccount(1, "Nathan Ray", "1 Magnolia Lane", -1000);
			fail("Creating account with negative credit limit did not throw Exception");
			
		}
		catch(IllegalArgumentException error){
			
			assertEquals("Error message for negative credit limit on customer account", "A customer cannot have a negative credit limit.", error.getMessage());
			
		}	// End of try-catch block
		
		// Account with a credit limit exceeding the MAX_CREDIT_LIMIT
		try{
			
			CustomerAccount badAcct6 = new CustomerAccount(1, "Nathan Ray", "1 Magnolia Lane", MAX_CREDIT_LIMIT + 1);
			fail("Creating account with credit limit over max value did not throw Exception");
			
		}
		catch(IllegalArgumentException error){
			
			assertEquals("Error message for credit limit over max value", "The credit limit set cannot be greater than the maximum credit limit of $10,000,000.", error.getMessage());
			
		}	// End of try-catch block
		
		
		CustomerAccount instance1 = new CustomerAccount(1, "Gordon Gecko", "1 Wall Street, NYC", 10000000.00);
		ArrayList<Purchase> purchaseList = instance1.getTransactionList();
		
		assertEquals("instance 1 account no", 1, instance1.getAccountNo());
		assertEquals("instance 1 customer name", "Gordon Gecko", instance1.getCustName());
		assertEquals("instance 1 customer address", "1 Wall Street, NYC", instance1.getCustAddress());
		assertEquals("instance 1 image URL", null, instance1.getImageURL());
		assertEquals("instance 1 credit limit", 10000000.00, instance1.getCreditLimit(), 0.001);
		assertEquals("instance 1 unpaid balance", 0.0, instance1.getUnpaidBalance(), 0.001);
		assertEquals("instance 1 error message", "", instance1.getErrorMessage());
		assertTrue("instance 1 initial purchase list is empty", purchaseList.isEmpty());
		
		CustomerAccount instance2 = new CustomerAccount(2, "Nathan Ray", "ComputerScience Department, UGA", 50.00);
		ArrayList<Purchase> purchaseList2 = instance2.getTransactionList();
		
		assertEquals("instance 2 account no", 2, instance2.getAccountNo());
		assertEquals("instance 2 customer name", "Nathan Ray", instance2.getCustName());
		assertEquals("instance 2 customer address", "ComputerScience Department, UGA", instance2.getCustAddress());
		assertEquals("instance 2 image URL", null, instance2.getImageURL());
		assertEquals("instance 2 credit limit", 50.00, instance2.getCreditLimit(), 0.001);
		assertEquals("instance 2 unpaid balance", 0.0, instance2.getUnpaidBalance(), 0.001);
		assertEquals("instance 2 error message", "", instance2.getErrorMessage());
		assertTrue("instance 2 initial purchase list is empty", purchaseList2.isEmpty());
		
		// Testing of overloaded special-case constructor
		CustomerAccount instance3 = new CustomerAccount(3, "Fred Flintstone", "Bedrock");
		ArrayList<Purchase> purchaseList3 = instance3.getTransactionList();
		
		assertEquals("instance 3 account no", 3, instance3.getAccountNo());
		assertEquals("instance 3 customer name", "Fred Flintstone", instance3.getCustName());
		assertEquals("instance 3 customer address", "Bedrock", instance3.getCustAddress());
		assertEquals("instance 3 image URL", null, instance3.getImageURL());
		assertEquals("instance 3 credit limit", 1000.00, instance3.getCreditLimit(), 0.001);
		assertEquals("instance 3 unpaid balance", 0.0, instance3.getUnpaidBalance(), 0.001);
		assertEquals("instance 3 error message", "", instance3.getErrorMessage());
		assertTrue("instance 1 initial purchase list is empty", purchaseList3.isEmpty());
		
	}	// End of testConstructor method
	
	/**
	 * Verify that setting a customer's name accurately sets the customer name on the account to
	 * the new customer name given.  Also tests that the customer name cannot be set to the null
	 * or empty string via an IllegalArgumentException
	 */
	@Test
	public void testSetCustomerName()
	{
		
		CustomerAccount resetAccount = new CustomerAccount(1, "Nathan Ray", "123 Easy St", 1000);
		
		resetAccount.setCustName("Batman");
		
		assertEquals("New customer name", "Batman", resetAccount.getCustName());
		
		// Account setting customer name to null
		try{
			
			resetAccount.setCustName(null);
			fail("Setting the customer name to null should raise Exception");
			
		}
		catch(IllegalArgumentException error){
			
			assertEquals("Error message for setting customer name to null", "Customer name must not be empty.", error.getMessage());
			
		}	// End of try-catch block
		
		// Account setting customer name to the empty string
		try{
			
			resetAccount.setCustName("");
			fail("Setting the customer name to the empty string should raise Exception");
			
		}
		catch(IllegalArgumentException error){
			
			assertEquals("Error message for setting customer name to the empty string", "Customer name must not be empty.", error.getMessage());
			
		}	// End of try-catch block
		
	}	// End of testSetCustomerName method
	
	/**
	 * Verify that setting a customer's address accurately sets the customer address on the account to
	 * the new customer address given.  Also tests that the customer address cannot be set to the null
	 * or empty string via an IllegalArgumentException
	 */
	@Test
	public void testSetCustAddress()
	{
		
		CustomerAccount resetAccount = new CustomerAccount(1, "Nathan Ray", "123 Easy St", 1000);
		
		resetAccount.setCustAddress("1 Magnolia Lane");
		
		assertEquals("New customer address", "1 Magnolia Lane", resetAccount.getCustAddress());
		
		// Account setting customer address to null
		try{
			
			resetAccount.setCustAddress(null);
			fail("Setting the customer address to null should raise Exception");
			
		}
		catch(IllegalArgumentException error){
			
			assertEquals("Error message for setting customer address to null", "Customer address must not be empty.", error.getMessage());
			
		}	// End of try-catch block
		
		// Account setting customer address to the empty string
		try{
			
			resetAccount.setCustAddress("");
			fail("Setting the customer address to the empty string should raise Exception");
			
		}
		catch(IllegalArgumentException error){
			
			assertEquals("Error message for setting customer address to the empty string", "Customer address must not be empty.", error.getMessage());
			
		}	// End of try-catch block
		
	}	// End of testSetCustAddress method
	
	/**
	 * Verify that setting a customer's credit limit for an account accurately sets the credit limit
	 * on the account to the new credit limit given.  Also tests that the credit limit cannot be set
	 * to an amount that is less than the unpaid balance on the account as well as that the credit
	 * limit set cannot exceed the maximum credit limit via an IllegalArgumentException
	 */
	@Test
	public void testSetCreditLimit()
	{
		
		CustomerAccount limitAccount = new CustomerAccount(1, "Nathan Ray", "1 Magnolia Lane", 1000);
		
		limitAccount.addPurchase(500, "2012-02-03", "Tiffany's", "Atlanta", "GA");
		
		limitAccount.setCreditLimit(2000.00);
		
		assertEquals("New customer credit limit", 2000.00, limitAccount.getCreditLimit(), 0.001);
		
		// Setting account credit limit to a value less than the current unpaid balance on the account
		try{
			
			limitAccount.setCreditLimit(300.00);
			fail("Setting the credit limit to a value less than the unpaid balance should raise Exception");
			
		}
		catch(IllegalArgumentException error){
			
			assertEquals("Error message for setting the credit limit to a value less than the unpaid balance on the account", "The credit limit set must be greater than or equal to the unpaid balance on the account.", error.getMessage());
			
		}	// End of try-catch block
		
		// Setting account credit limit to a value that exceeds the given maximum credit limit
		try{
			
			limitAccount.setCreditLimit(150000000.00);
			fail("Setting the credit limit above the maximum value should raise Exception");
			
		}
		catch(IllegalArgumentException error){
			
			assertEquals("Error message for setting the credit limit above the maximum value", "The credit limit set cannot be greater than the maximum credit limit of $10,000,000.", error.getMessage());
			
		}	// End of try-catch block
		
		
	}	// End of testSetCreditLimit method
	
	/**
	 * Verify that adding a purchase increases the unpaid balance and inserts a new Purchase into
	 * transactionList, UNLESS the purchase would put the unpaid balance above the credit limit.
	 * Also test the error conditions when the String data is not provided
	 */
	@Test
	public void testAddPurchase()
	{
		
		CustomerAccount instance = new CustomerAccount(2, "Fred Freekowtski", "22 Slum Lane");
		
		boolean addPurchaseResult1 = instance.addPurchase(300.0, "", "Slacker Comix", "Athens", "GA");
		ArrayList<Purchase> transactionList = instance.getTransactionList();
		
		assertEquals("no purchase date result", false, addPurchaseResult1);
		assertEquals("no purchase date error message", "Please enter a purchase date.", instance.getErrorMessage());
		assertEquals("no purchase date balance", 0.00, instance.getUnpaidBalance(), 0.001);
		assertTrue("purchase list empty after no purchase date", transactionList.isEmpty());
		
		boolean addPurchaseResult2 = instance.addPurchase(500.0, "2012-03-02", "", "Athens", "GA");
		
		assertEquals("no merchant name result", false, addPurchaseResult2);
		assertEquals("no merchant name error message", "Please enter a merchant name.", instance.getErrorMessage());
		assertEquals("no merchant name balance", 0.00, instance.getUnpaidBalance(), 0.001);
		assertTrue("purchase list empty after no purchase merchant name", transactionList.isEmpty());
		
		boolean addPurchaseResult3 = instance.addPurchase(500.0, "2012-03-02", "Slacker Comix", "", "GA");
		
		assertEquals("no merchant city result", false, addPurchaseResult3);
		assertEquals("no merchant city error message", "Please enter a merchant city location.", instance.getErrorMessage());
		assertEquals("no merchant city balance", 0.00, instance.getUnpaidBalance(), 0.001);
		assertTrue("purchase list empty after no purchase merchant city", transactionList.isEmpty());
		
		boolean addPurchaseResult4 = instance.addPurchase(100.0, "2012-03-02", "Slacker Comix", "Athens", "");
		
		assertEquals("no merchant state result", false, addPurchaseResult4);
		assertEquals("no merchant state error message", "Please enter a merchant state location.", instance.getErrorMessage());
		assertEquals("no merchant state balance", 0.00, instance.getUnpaidBalance(), 0.001);
		assertTrue("purchase list empty after no purchase merchant state", transactionList.isEmpty());
		
		boolean addPurchaseResult5 = instance.addPurchase(300.00, "2012-08-01", "Slacker Comix", "Athens", "GA");
		
		assertEquals("first purchase result", true, addPurchaseResult5);
		assertEquals("first purchase unpaid balance", 300.00, instance.getUnpaidBalance(), 0.001);
		assertEquals("first purchase error message", "", instance.getErrorMessage());
		
		transactionList = instance.getTransactionList();
		
		assertEquals("length of purchase list after first purchase", 1, transactionList.size());
		
		Purchase purchase1 = transactionList.get(0);
		
		assertEquals("first purchase amount", 300.00, purchase1.getPurchaseAmount(), 0.001);
		assertEquals("first purchase date", "2012-08-01", purchase1.getPurchaseDate());
		assertEquals("first purchase merchant", "Slacker Comix", purchase1.getMerchantName());
		assertEquals("first purchase city", "Athens", purchase1.getMerchantCity());
		assertEquals("first purchase state", "GA", purchase1.getMerchantState());
		
		boolean addPurchaseResult6 = instance.addPurchase(500.00, "2012-08-01", "Slacker Comix", "Athens", "GA");
		
		assertEquals("second purchase result", true, addPurchaseResult6);
		assertEquals("second purchase unpaid balance", 800.00, instance.getUnpaidBalance(), 0.001);
		assertEquals("second purchase error message", "", instance.getErrorMessage());
		
		transactionList = instance.getTransactionList();
		
		assertEquals("length of purchase list after first purchase", 2, transactionList.size());
		
		Purchase purchase2 = transactionList.get(1);
		
		assertEquals("second purchase amount", 500.00, purchase2.getPurchaseAmount(), 0.001);
		assertEquals("second purchase date", "2012-08-01", purchase2.getPurchaseDate());
		assertEquals("second purchase merchant", "Slacker Comix", purchase2.getMerchantName());
		assertEquals("second purchase city", "Athens", purchase2.getMerchantCity());
		assertEquals("second purchase state", "GA", purchase2.getMerchantState());
		
		boolean addPurchaseResult7 = instance.addPurchase(500.00, "2012-08-01", "Slacker Comix", "Athens", "GA");
		
		assertEquals("third purchase result", false, addPurchaseResult7);
		assertEquals("third purchase unpaid balance", 800.00, instance.getUnpaidBalance(), 0.001);
		assertEquals("third purchase error message", "This purchase would have you exceeding your available credit limit.  The purchase has therefore been denied.", instance.getErrorMessage());
		
		transactionList = instance.getTransactionList();
		
		assertEquals("length of purchase list after first purchase", 2, transactionList.size());
		
		boolean addPurchaseResult8 = instance.addPurchase(100.00, "2012-08-01", "Slacker Comix", "Athens", "GA");
		
		assertEquals("fourth purchase result", true, addPurchaseResult8);
		assertEquals("fourth purchase unpaid balance", 900.00, instance.getUnpaidBalance(), 0.001);
		assertEquals("fourth purchase error message", "", instance.getErrorMessage());
		
		transactionList = instance.getTransactionList();
		
		assertEquals("length of purchase list after first purchase", 3, transactionList.size());
		
		Purchase purchase4 = transactionList.get(2);
		
		assertEquals("fourth purchase amount", 100.00, purchase4.getPurchaseAmount(), 0.001);
		assertEquals("fourth purchase date", "2012-08-01", purchase4.getPurchaseDate());
		assertEquals("fourth purchase merchant", "Slacker Comix", purchase4.getMerchantName());
		assertEquals("fourth purchase city", "Athens", purchase4.getMerchantCity());
		assertEquals("fourth purchase state", "GA", purchase4.getMerchantState());
		
	}	// End of testAddPurchase method
	
}	// End of CustomerAccountTest class
