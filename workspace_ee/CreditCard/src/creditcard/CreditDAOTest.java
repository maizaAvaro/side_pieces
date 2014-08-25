package creditcard;


import java.util.ArrayList;

import junit.framework.TestCase;
/**
 * Tests the CreditDAO class, which manages DB
 * access for the Credit Card project
 * @author drdan
 *
 */
public class CreditDAOTest extends TestCase 
{

	/**
	 * Tests that an object can be created
	 */
	public void testConstructor() 
	{
		CreditDAO instance = new CreditDAO();
		assertNotNull("newly created CreditDAO", instance);
	}
	
	/**
	 * Tests creating accounts
	 */
	public void testCreate()
	{
		CreditDAO instance = new CreditDAO();
		
		//add first customer
		instance.addCustomer("Gordon Gecko", "1 Wall St, NYC","", 10000000.0);
		ArrayList<CustomerAccount> acctList = instance.getCustomerList();
		assertEquals("number of customers after one addition",1,acctList.size());
		CustomerAccount acct0 = acctList.get(0);
		
		//test the first customer's data
		assertEquals("First cust name after one addition",
				 "Gordon Gecko",acct0.getCustName());
		assertEquals("First cust address after one addition",
				 "1 Wall St, NYC",acct0.getCustAddress());
		assertEquals("First cust image url after one addition",
				 "",acct0.getImageURL());
		assertEquals("First cust unpaid balance after one addition",
				 0.0,acct0.getUnpaidBalance(),0.001);
		assertEquals("First cust credit limit after one addition",
				 10000000.0,acct0.getCreditLimit(),0.001);
		
		//add second customer
		instance.addCustomer("Fred Freekowtski", "22 Slum St, Oakland CA",
				"http://ecx.images-amazon.com/images/I/61zenAO2uOL._SL500_SS500_.jpg", 50.0);
		acctList = instance.getCustomerList();
		assertEquals("number of customers after two additions",2,acctList.size());
		
	    
		//test that the first customer is still the same
		acct0 = acctList.get(0);
		assertEquals("First cust name after two additions",
				 "Gordon Gecko",acct0.getCustName());
		assertEquals("First cust address after two additions",
				 "1 Wall St, NYC",acct0.getCustAddress());
		assertEquals("First cust image url after two additions",
				 "",acct0.getImageURL());
		assertEquals("First cust unpaid balance after two additions",
				 0.0,acct0.getUnpaidBalance(),0.001);
		assertEquals("First cust credit limit after two additions",
				 10000000.0,acct0.getCreditLimit(),0.001);
		assertEquals("number of customers after two additions",2,acctList.size());
		
		//test the second customer's data
		CustomerAccount acct1 = acctList.get(1);
		assertEquals("Second cust name after two additions",
	    "Fred Freekowtski", acct1.getCustName());
		assertEquals("Second cust address after two additions",
				 "22 Slum St, Oakland CA",acct1.getCustAddress());
		assertEquals("Second cust image url after two additions",
				"http://ecx.images-amazon.com/images/I/61zenAO2uOL._SL500_SS500_.jpg",acct1.getImageURL());
		assertEquals("Second cust unpaid balance after two additions",
				 0.0,acct0.getUnpaidBalance(),0.001);
		assertEquals("Second cust credit limit after two additions",
				 50.0,acct1.getCreditLimit(),0.001);
		
		//add a purchase
		instance.addPurchase(acct0.getId(), "Fannie May", "New York", "NY", 3000000.0);
		Purchase purch0 = instance.getPurchaseList(acct0.getId()).get(0);
		
		//test the purchase
		assertEquals("Purchase 0 merchant name","Fannie May", purch0.getMerchantName());
		assertEquals("Purchase 0 merchant city","New York", purch0.getMerchantCity());
		assertEquals("Purchase 0 merchant state","NY", purch0.getMerchantState());
		assertEquals("Purchase 0 amount",3000000, purch0.getPurchaseAmount(), 0.01);
		
	}

}
