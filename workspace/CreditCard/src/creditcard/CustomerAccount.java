package creditcard;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Customer Account class that is used in the Credit Card Lab iterations for 
 * CSCI 1302 Everett
 * @author Nathan
 */
public class CustomerAccount {
	
	/** Unique account number */
	private int accountNo;
	
	/** Customer name, not null */
	private String custName;
	
	/** Customer address */
	private String custAddress;
	
	/** Unpaid balance, could be negative */
	private double unpaidBalance;
	
	/** Credit limit; purchases that would make the
	 *  unpaid balance exceed this limit are rejected
	 */
	private double creditLimit;
	
	/** URL for customer image, either relative or on
	 *  the web
	 */
	private String imageURL;
	
	/** Default initial credit limit for new account */
	private static final double DEFAULT_CREDIT_LIMIT = 1000.00;
	
	/**
	 * Sets a constant for the maximum credit limit that can be
	 * assigned to an account
	 */
	private static final double MAX_CREDIT_LIMIT = 10000000.00;
	
	/**
	 * Error message variable to inform user of instance when a purchase
	 * amount has overrun the available credit limit
	 */
	private String errorMessage;
	
	/**
	 * List of transactions for this account
	 */
	private static ArrayList<Purchase> transactionList;
	
	/** Creates a new account with zero balance and no image
	 * @param newAccountNo accountNo for new account
	 * @param newCustName new account customer name
	 * @param newCustAddr new account customer address
	 * @param creditLimit initial credit limit
	 * @throws IllegalArgumentException if String params are empty
	 * or creditLimit is negative or larger than MAX_CREDIT_LIMIT
	 */
	public CustomerAccount(int newAccountNo, String newCustName, String newCustAddr, double newCreditLimit) throws IllegalArgumentException
	{
		
		if(newCustName == null || newCustName.isEmpty())
		{
			
			throw new IllegalArgumentException("Customer name must not be empty.");
			
		}	// End of if statement
		
		if(newCustAddr == null || newCustAddr.isEmpty())
		{
			
			throw new IllegalArgumentException("Customer address must not be empty.");
			
		}	// End of if statement
		
		if(newCreditLimit < 0)
		{
			
			throw new IllegalArgumentException("A customer cannot have a negative credit limit.");
			
		}	// End of if statement
		
		if(newCreditLimit > MAX_CREDIT_LIMIT)
		{
			
			throw new IllegalArgumentException("The credit limit set cannot be greater than the maximum credit limit of $10,000,000.");
			
		}	// End of if statement
		
		this.accountNo = newAccountNo;
		this.custName = newCustName;
		this.custAddress = newCustAddr;
		this.creditLimit = newCreditLimit;
		this.unpaidBalance = 0.0;
		this.imageURL = null;
		this.errorMessage = "";
		CustomerAccount.transactionList = new ArrayList<Purchase>();
		
	}	// End of default CustomerAccount constructor
	
	/** Creates a new account with zero balance and default credit limit
	 *  @param newAccountNo  accountNo for new account
	 *  @param newCustName  new account customer name
	 *  @param newCustAddr  new account customer address
	 */
	public CustomerAccount(int newAccountNo, String newCustName, String newCustAddr)
	{
		// Constructor chaining to simplify code
		this(newAccountNo, newCustName, newCustAddr, DEFAULT_CREDIT_LIMIT);
		
	}	// End of special-case overloaded CustomerAccount constructor

	/**
	 * Gets the account number of the customer associated with the account
	 * @return int
	 */
	public int getAccountNo()
	{
		
		return accountNo;
		
	}	//	End of getAccountNo method

	/**
	 * Gets the name of the customer associated with the account
	 * @return String
	 */
	public String getCustName() 
	{
		
		return custName;
		
	}	// End of getCustName method

	/**
	 * Sets the name of the customer associated with the account
	 * @param custName the name of the customer associated with the account
	 * @throws IllegalArgumentException if customer name is set to the empty
	 * string or null
	 */
	public void setCustName(String custName) throws IllegalArgumentException
	{
		if(custName == null || custName.isEmpty())
		{
			
			throw new IllegalArgumentException("Customer name must not be empty.");
			
		}	// End of if statement
		
		this.custName = custName;
		
	}	// End of setCustName method

	/**
	 * Gets the address of the customer associated with the account
	 * @return String
	 */
	public String getCustAddress() 
	{
		
		return custAddress;
		
	}	// End of getCustAddress method

	/**
	 * Sets the address of the customer associated with the account
	 * @param custAddress the address of the customer associated with the account
	 */
	public void setCustAddress(String custAddress) throws IllegalArgumentException
	{
		if(custAddress == null || custAddress.isEmpty())
		{
			
			throw new IllegalArgumentException("Customer address must not be empty.");
			
		}	// End of if statement
		
		this.custAddress = custAddress;
		
	}	// End of setCustAddress method

	/**
	 * Gets the unpaid balance of the customer associated with the account
	 * @return double
	 */
	public double getUnpaidBalance() 
	{
		
		return unpaidBalance;
		
	}	// End of getUnpaidBalance method

	/**
	 * Gets the credit limit of the customer associated with the account
	 * @return double
	 */
	public double getCreditLimit() 
	{
		
		return creditLimit;
		
	}	// End of getCreditLimit method

	/**
	 * Sets the credit limit for the customer associated with the account
	 * @param creditLimit credit limit of the customer associated with the account
	 * @throws IllegalArgumentException if the credit limit set is less than the
	 * unpaid balance
	 */
	public void setCreditLimit(double creditLimit) throws IllegalArgumentException
	{
		
		if(creditLimit < unpaidBalance)
		{
			
			throw new IllegalArgumentException("The credit limit set must be greater than or equal to the unpaid balance on the account.");
			
		}	// End of if statement
		
		if(creditLimit > MAX_CREDIT_LIMIT)
		{
			
			throw new IllegalArgumentException("The credit limit set cannot be greater than the maximum credit limit of $10,000,000.");
			
		}	// End of if statement
		
		this.creditLimit = creditLimit;
		
	}	// End of setCreditLimit method

	/**
	 * Gets the image URL of the customer associated with the account
	 * @return String
	 */
	public String getImageURL() 
	{
		
		return imageURL;
		
	}	// End of getImageURL method

	/**
	 * Sets the image URL of the customer that is associated with the account
	 * @param imageURL image URL of the customer associated with the account
	 */
	public void setImageURL(String imageURL) 
	{
		
		this.imageURL = imageURL;
		
	}	// End of setImageURL method

	/**
	 * Gets the error message if one has occurred, returning the empty string
	 * if no error has occurred, i.e. customer has not exceeded his or her available
	 * balance
	 * @return String
	 */
	public String getErrorMessage() 
	{
		
		return errorMessage;
		
	}	// End of getErrorMessage method
	
	/**
	 * Reports whether a transaction made on a customer account is valid or not,
	 * i.e. if the purchase puts the customer over his or her available credit limit,
	 * this method will return false, returning true if the purchase does not put the
	 * customer over his or her available credit limit
	 * @param purchaseAmount amount of a new purchase to be added to this account
	 * @param purchaseDate date of purchase transaction
	 * @param merchantName name of merchant involved in transaction
	 * @param merchantCity city location of merchant involved in transaction
	 * @param merchantState state location of merchant involved in transaction
	 * @return boolean
	 */
	public boolean addPurchase(double purchaseAmount, String purchaseDate, String merchantName, String merchantCity, String merchantState)
	{
		
		boolean transactionSuccess = false;
		
		if((purchaseAmount + unpaidBalance) <= creditLimit)
		{
			
			if(purchaseDate == null || purchaseDate.equals(""))
			{
				
				errorMessage = "Please enter a purchase date.";
				transactionSuccess = false;
				
			}else if(merchantName == null || merchantName.equals(""))
				{
				
					errorMessage = "Please enter a merchant name.";
					transactionSuccess = false;
				
				}else if(merchantCity == null || merchantCity.equals(""))
					{
					
						errorMessage = "Please enter a merchant city location.";
						transactionSuccess = false;
					
					}else if(merchantState == null || merchantState.equals(""))
						{
						
							errorMessage = "Please enter a merchant state location.";
							transactionSuccess = false;
						
						}else{
							
							unpaidBalance = unpaidBalance + purchaseAmount;
							errorMessage = "";
							Purchase successfulPurchase = new Purchase(purchaseAmount, purchaseDate, merchantName, merchantCity, merchantState);
							transactionList.add(successfulPurchase);
							transactionSuccess = true;
							
						}	// End of nested if-else statement
			
		}else
			{
			
				errorMessage = "This purchase would have you exceeding your available credit limit.  The purchase has therefore been denied.";
				transactionSuccess = false;
				
			}	// End of if-else statement
		
		return transactionSuccess;
		
	}	// End of addPurchase method

	/**
	 * Gets the default credit limit
	 * @return double
	 */
	public static double getDefaultCreditLimit() 
	{
		
		return DEFAULT_CREDIT_LIMIT;
		
	}	// End of getDefaultCreditLimit method
	
	/**
	 * Gets the transaction list from an array list
	 * @return ArrayList<Purchase>
	 */
	public ArrayList<Purchase> getTransactionList()
	{
		
		return transactionList;
		
	}	// End of getTransactionList method
	
	/**
	 * Initialize a CustomerAccount object, give it three transactions, and print
	 * out the data in the object
	 * @param args
	 */
	public static void main(String[] args)
	{
		
		Calendar calendarInstance = Calendar.getInstance();
		
		int monthInt = calendarInstance.get(Calendar.MONTH) + 1;
		int dayInt = calendarInstance.get(Calendar.DAY_OF_MONTH);
		int yearInt = calendarInstance.get(Calendar.YEAR);
		
		String year = Integer.toString(yearInt);
		String month = Integer.toString(monthInt);
		String day = Integer.toString(dayInt);
		
		String calendarDate = new String(year + "-" + month + "-" + day);
		
		CustomerAccount geckoAccount = new CustomerAccount(1, "Gordon Gecko", "1 Wall Street  New York, NY 10002", 100000000);
		
		geckoAccount.addPurchase(250000.00, "2012-09-08", "Rolls Royce", "New York", "NY");
		geckoAccount.addPurchase(300000.00, "2012-09-10", "Tiffany's", "New York", "NY");
		geckoAccount.addPurchase(250000.00, "2012-09-15", "Alfa Romero", "New York", "NY");
		
		System.out.println();
		System.out.println("Valued CardHolder:\t" + geckoAccount.getCustName());
		System.out.println("Cardholder Address:\t" + geckoAccount.getCustAddress());
		System.out.println("Credit Limit:\t\t" + geckoAccount.getCreditLimit());
		System.out.println("Current Unpaid Balance:\t" + geckoAccount.getUnpaidBalance());
		System.out.println();
		System.out.println("Transactions on this account as of " + calendarDate + ":\n");
		System.out.println("\tDate:\t\t\tMerchant:\t\tCity:\t\t\tState:\t\tAmount:\n");
		
		String purchaseDate = "";
		String merchantName = "";
		String merchantCity = "";
		String merchantState = "";
		String purchaseAmount = "";
		
		// Initializes a purchase object in order to access the transactionList array and then prints the
		// purchase data via calling the appropriate getter methods
		for(int index = 0; index < transactionList.size(); index++)
		{
			
			Purchase purchase = transactionList.get(index);
			
			purchaseDate = purchase.getPurchaseDate();
			merchantName = purchase.getMerchantName();
			merchantCity = purchase.getMerchantCity();
			merchantState = purchase.getMerchantState();
			
			double amount = purchase.getPurchaseAmount();
			purchaseAmount = Double.toString(amount);
			
			System.out.println("\t" + purchaseDate + "\t\t" + merchantName + "\t\t" + merchantCity + "\t\t" + merchantState + "\t\t$" + purchaseAmount);
			
		}	// End of for loop
		
		
		
	}	// End of main method

}	// End of CustomerAccount class
