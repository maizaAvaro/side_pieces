package creditcard;

public class Purchase 
{
	private int id;
	private String merchantName;
	private String merchantCity;
	private String merchantState;
	private String date;
	private double purchaseAmount;
	private int customerID;
	
	/**
	 * constructor that takes only the id as an argument
	 */
	public Purchase(int id) 
	{
		this(id, "", "", "", "", 0, 0);
	}
	
	/**
	 * Creates an object based on the fields
	 */
	public Purchase(int id, String merchantName, String merchantCity, String merchantState,
			String date, double purchaseAmount, int customerID) 
	{
		this.id = id;
		this.merchantName = merchantName;
		this.merchantCity = merchantCity;
		this.merchantState = merchantState;
		this.date = date;
		this.purchaseAmount = purchaseAmount;
		this.customerID = customerID;
	}

	/**
	 * @return the id
	 */
	public int getID() 
	{
		return id;
	}

	/**
	 * @return the merchant's name
	 */
	public String getMerchantName() 
	{
		return merchantName;
	}

	/**
	 * @return the merchant's city
	 */
	public String getMerchantCity() 
	{
		return merchantCity;
	}

	/**
	 * @return the merchant's state (two letter abbreviation)
	 */
	public String getMerchantState() 
	{
		return merchantState;
	}

	/**
	 * @return the date, formatted as a string
	 */
	public String getDate() 
	{
		return date;
	}

	/**
	 * @return the dollar amount of the purchase
	 */
	public double getPurchaseAmount() 
	{
		return purchaseAmount;
	}

	/**
	 * @return the ID of the customer who made the purchase
	 */
	public int getCustomerID() 
	{
		return customerID;
	}
	
	public boolean equals(Purchase other)
	{
		return this.id == other.getID();
	}

}
