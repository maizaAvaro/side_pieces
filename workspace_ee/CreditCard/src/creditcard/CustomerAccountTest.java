package creditcard;

import java.util.ArrayList;

import junit.framework.TestCase;

public class CustomerAccountTest extends TestCase 
{

	public void testConstructor() 
	{
	  CustomerAccount instance1 = new CustomerAccount (1, "Gordon Gecko", "1 Wall Street, NYC",
			  10000000, 0, "");
	  assertEquals("instance 1 id",1,instance1.getId());
	  assertEquals("instance 1 customer name","Gordon Gecko",instance1.getCustName());
	  assertEquals("instance 1 customer address","1 Wall Street, NYC",instance1.getCustAddress());
	  assertEquals("instance 1 image URL","",instance1.getImageURL());
	  assertEquals("instance 1 error msg","",instance1.getErrorMessage());
	  assertEquals("instance 1 unpaid balance",0.0,instance1.getUnpaidBalance(),0.001);
	  assertEquals("instance 1 credit limit",10000000.0,instance1.getCreditLimit(),0.001);
	  
	  //Account with default credit limit
	  CustomerAccount instance2 = new CustomerAccount (2, "Fred Freekowtski", "22 Slum St");
	  assertEquals("instance 2 id",2,instance2.getId());
	  assertEquals("instance 2 customer name","Fred Freekowtski",instance2.getCustName());
	  assertEquals("instance 2 customer address","22 Slum St",instance2.getCustAddress());
	  assertEquals("instance 2 image URL","",instance2.getImageURL());
	  assertEquals("instance 2 error msg","",instance1.getErrorMessage());
	  assertEquals("instance 2 unpaid balance",0.0,instance2.getUnpaidBalance(),0.001);
	  assertEquals("instance 2 credit limit",1000.0,instance2.getCreditLimit(),0.001);
	}

	 /**
	  * Test that adding a purchase increases the unpaid balance, UNLESS the purchase
	  * would put the unpaid balance above the credit limit. Also test the error conditions
	  */
	  public void testSimpleAddPurchase() 
	  {
		  CustomerAccount instance3 = new CustomerAccount (3, "Fred Freekowtski", "22 Slum St");
		  String addPurchaseResult1 = instance3.addPurchase(0.0);
		  assertTrue("zero purchase result", addPurchaseResult1.isEmpty());
		  assertEquals("zero purchase unpaid balance",0.00, instance3.getUnpaidBalance(),0.001);
		  assertEquals("zero purchase error message","", instance3.getErrorMessage());
		  
		  String addPurchaseResult4 = instance3.addPurchase(-25.0);
		  assertFalse("negative purchase result", addPurchaseResult4.isEmpty());
		  assertEquals("negative purchase unpaid balance",0.00, instance3.getUnpaidBalance(),0.001);
		  assertEquals("negative purchase error message","Purchase amount must be positive", instance3.getErrorMessage());
	
		  String addPurchaseResult5 = instance3.addPurchase(300);
		  assertTrue("first purchase result", addPurchaseResult5.isEmpty());
		  assertEquals("first purchase unpaid balance",300.00, instance3.getUnpaidBalance());
		  assertEquals("first purchase error message","", instance3.getErrorMessage());
		  
		  String addPurchaseResult6 = instance3.addPurchase(500);
		  assertTrue("second purchase result", addPurchaseResult6.isEmpty());
		  assertEquals("second purchase unpaid balance",800.00, instance3.getUnpaidBalance());
		  assertEquals("second purchase error message","", instance3.getErrorMessage());
		  
		  String addPurchaseResult7 = instance3.addPurchase(300);
		  assertFalse("third purchase result", addPurchaseResult7.isEmpty());
		  assertEquals("third purchase unpaid balance",800.00, instance3.getUnpaidBalance());
		  assertEquals("third purchase error message","Amount exceeds your credit limit, sorry", instance3.getErrorMessage());
	  
		  instance3 = new CustomerAccount (2, "Fred Freekowtski", "22 Slum St");
		  instance3.addPurchase(0.0);
		  assertEquals("zero purchase unpaid balance",0.00, instance3.getUnpaidBalance(),0.001);
		  assertEquals("zero purchase error message","", instance3.getErrorMessage());
		  
		  instance3.addPurchase(-25.0);
		  assertEquals("negative purchase unpaid balance",0.00, instance3.getUnpaidBalance(),0.001);
		  assertEquals("negative purchase error message","Purchase amount must be positive", instance3.getErrorMessage());
	
		  instance3.addPurchase(300);
		  assertEquals("first purchase unpaid balance",300.00, instance3.getUnpaidBalance());
		  assertEquals("first purchase error message","", instance3.getErrorMessage());
		  
		  instance3.addPurchase(500);
		  assertEquals("second purchase unpaid balance",800.00, instance3.getUnpaidBalance());
		  assertEquals("second purchase error message","", instance3.getErrorMessage());
		  
		  instance3.addPurchase(300);
		  
		  assertEquals("third purchase unpaid balance",800.00, instance3.getUnpaidBalance());
		  assertEquals("third purchase error message","Amount exceeds your credit limit, sorry", instance3.getErrorMessage());
	  }
	  
	  /**
		  * Test that calling addPurchase adds a purchase to the list and that the data added is correct
		  * would put the unpaid balance above the credit limit. Also test the error conditions
		  */
		  public void testComplexAddPurchase() 
		  {
			  CustomerAccount instance4 = new CustomerAccount (4, "Geordi La Forge", "African Federation, Earth");
			  
			  String addPurchaseResult = instance4.addPurchase(1, 20.0, "Guinan", "10 Forward", "EP", "2365-01-01");
			  assertTrue("complex purchase succeeded", addPurchaseResult.isEmpty());
			  
			  ArrayList<Purchase> list = instance4.getPurchaseList();
			  assertEquals("complex purchase list size",1, list.size());
			  assertEquals("complex purchase id",1, list.get(0).getID());
			  assertEquals("complex purchase id",20, list.get(0).getPurchaseAmount(), 0.01);
			  assertEquals("complex purchase id","Guinan", list.get(0).getMerchantName());
			  assertEquals("complex purchase id","10 Forward", list.get(0).getMerchantCity());
			  assertEquals("complex purchase id","EP", list.get(0).getMerchantState());
			  assertEquals("complex purchase id",4, list.get(0).getCustomerID());
		  }
}
