package creditcard;
import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Acts as a data transfer object, holding information about a customer
 * so it can be displayed on the jsp page
 * @author Mark Boltri
 */
public class CustomerAccount 
{
	private int id;
	private String custName;
	private String custAddress;
	private double unpaidBalance;
	private double creditLimit;
	private String imageURL;
	private String errorMessage;
	private ArrayList<Purchase> purchaseList;
	
	public static final double DEFAULT_CREDIT_LIMIT = 1000.0;
	public static final double MAX_CREDIT_LIMIT = 10000000.0;
	
	/**
	 * no-arg constuctor
	 */
	public CustomerAccount() 
	{
		this(0);
	}
	
	/**
	 * constructor that takes an id only
	 */
	public CustomerAccount(int id) 
	{
		this(id, "", "");
	}
	
	/**
	 * constructor that takes an id, name, and address but uses default values for credit limit and unpaid balance
	 */
	public CustomerAccount(int acctNo, String name, String addr) 
	{
		this(acctNo, name, addr, DEFAULT_CREDIT_LIMIT, 0, "");
	}
	
	/**
	 * constructor that accepts all fields except the list of purchases, for which it just creates
	 * an empty list
	 */
	public CustomerAccount(int acctNo, String name, String addr, double limit, double unpaid, String imageURL) 
	{
		this(acctNo, name, addr, limit, unpaid, imageURL, new ArrayList<Purchase>());
	}
	
	/**
	 * constructor that accepts all fields, including a list of purchases
	 */
	public CustomerAccount(int acctNo, String name, String addr, double limit, double unpaid, String imageURL, ArrayList<Purchase> list) 
	{
		this.id = acctNo;
		this.custName = name;
		this.custAddress = addr;
		this.creditLimit = limit;
		this.errorMessage = "";
		this.unpaidBalance = unpaid;
		this.imageURL = imageURL;
		this.purchaseList = list;
	}
	
	/**
	 * Adds a purchase to the list of purchases and updates the unpaid balance, but only if the 
	 * purchase is legitimate
	 * @return true if the purchase was added, false otherwise
	 */
	public String addPurchase( int purchaseID, double purchaseAmount, String name, String city, String state, String date )
	{
		
		errorMessage = "";
		
		if( purchaseAmount < 0 ) 
		{ 	// User entered a negative value
			errorMessage = "Purchase amount must be positive";
		} else if ( unpaidBalance + purchaseAmount < creditLimit) 
		{ 	// Purchase is allowed
			unpaidBalance += purchaseAmount;
			purchaseList.add(new Purchase(purchaseID, name, city, state, date, purchaseAmount, id));
		} else 
		{ 	// Purchase amount exceeds credit limit
			errorMessage = "Amount exceeds your credit limit, sorry";
		}
		
		return errorMessage;
	}
	
	/**
	 * Adds a purchase using only a purchase amount, other data is filled in as 0 or null
	 */
	public String addPurchase( double purchaseAmount )
	{
		return addPurchase( 0, purchaseAmount, "a", "a", "a", "a");		
	}
	
	public int getId() 
	{
		return id;
	}
	
	public void setId(int id) 
	{
		this.id = id;
	}
	
	public String getCustName() 
	{
		return custName;
	}
	
	public void setCustName(String custName) 
	{
		this.custName = custName;
	}
	
	public String getCustAddress() 
	{
		return custAddress;
	}
	
	public void setCustAddress(String custAddress) 
	{
		this.custAddress = custAddress;
	}
	
	public double getUnpaidBalance() 
	{
		return unpaidBalance;
	}
	
	public void setUnpaidBalance(double unpaidBalance) 
	{
		this.unpaidBalance = unpaidBalance;
	}
	
	public double getCreditLimit() 
	{
		return creditLimit;
	}
	
	public void setCreditLimit(double creditLimit) 
	{
		this.creditLimit = creditLimit;
	}
	
	public String getImageURL() 
	{
		return imageURL;
	}
	
	public void setImageURL(String imageURL) 
	{
		this.imageURL = imageURL;
	}
	
	public static String doubleToString(double d) 
	{
		return new DecimalFormat("$#,###,##0.00").format(d);
	}

	public String getErrorMessage() 
	{
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) 
	{
		this.errorMessage = errorMessage;
	}

	public ArrayList<Purchase> getPurchaseList() 
	{
		return purchaseList;
	}

	public void setPurchaseList(ArrayList<Purchase> purchaseList) 
	{
		this.purchaseList = purchaseList;
	}
	
	public boolean equals(CustomerAccount other) 
	{
		return this.id == other.getId();
	}
}
