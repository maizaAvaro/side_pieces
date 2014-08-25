package creditcard;

import java.util.Calendar;

/**
 * Represents a customer purchase made on a credit card
 */
public class Purchase 
{

	/**
	 * Amount of the purchase
	 */
	double purchaseAmount;
	
	/**
	 * Date at which the purchase is made
	 */
	String purchaseDate;
	
	/**
	 * Name of the merchant at whom purchase was made
	 */
	String merchantName;
	
	/**
	 * City location of the merchant
	 */
	String merchantCity;
	
	/**
	 * State location of the merchant
	 */
	String merchantState;
	
	/**
	 * Initializes a new purchase with the amount and merchant data specified by the purchase object
	 * @param newPurchaseAmount  the amount of the purchase
	 * @param newPurchaseDate  the date of the purchase
	 * @param newMerchantName  the name of the merchant
	 * @param newMerchantCity  the city location of the merchant
	 * @param newMerchantState  the state location of the merchant
	 */
	public Purchase(double newPurchaseAmount, String newPurchaseDate, String newMerchantName, String newMerchantCity, String newMerchantState)
	{
		
		this.purchaseAmount = newPurchaseAmount;
		this.purchaseDate = newPurchaseDate;
		this.merchantName = newMerchantName;
		this.merchantCity = newMerchantCity;
		this.merchantState = newMerchantState;
		
	}	// End of Purchase constructor
	
	/**
	 * Initializes a new purchase with the amount and merchant data specified by the purchase object,
	 * however, this constructor initializes no date, letting the date be determined by the current time
	 * when the object is constructed
	 * @param newPurchaseAmount  the amount of the purchase
	 * @param newMerchantName  the name of the merchant
	 * @param newMerchantCity  the city location of the merchant
	 * @param newMerchantState  the state location of the merchant
	 */
	public Purchase(double newPurchaseAmount, String newMerchantName, String newMerchantCity, String newMerchantState)
	{
		
		this.purchaseAmount = newPurchaseAmount;
		this.merchantName = newMerchantName;
		this.merchantCity = newMerchantCity;
		this.merchantState = newMerchantState;
		
		Calendar calendarInstance = Calendar.getInstance();
		
		int monthInt = calendarInstance.get(Calendar.MONTH) + 1;
		int dayInt = calendarInstance.get(Calendar.DAY_OF_MONTH);
		int yearInt = calendarInstance.get(Calendar.YEAR);
		
		String year = Integer.toString(yearInt);
		String month = Integer.toString(monthInt);
		String day = Integer.toString(dayInt);
		
		String calendarDate = new String(year + "-" + month + "-" + day);
		
		this.purchaseDate = calendarDate;
		
	}	// End of special-case overloaded constructor

	/**
	 * Gets the purchase amount of the transaction
	 * @return double
	 */
	public double getPurchaseAmount() 
	{
		
		return purchaseAmount;
		
	}	// End of getPurchaseAmount method

	/**
	 * Gets the purchase date of the transaction
	 * @return String
	 */
	public String getPurchaseDate() 
	{
		
		return purchaseDate;
		
	}	// End of getPurchaseDate method

	/**
	 * Gets the merchant name of where the transaction took place
	 * @return String
	 */
	public String getMerchantName() 
	{
		
		return merchantName;
		
	}	// End of getMerchantName method

	/**
	 * Gets the city location of the merchant where the transaction took place
	 * @return String
	 */
	public String getMerchantCity() 
	{
		
		return merchantCity;
		
	}	// End of getMerchantCity method

	/**
	 * Gets the state location of the merchant where the transaction took place
	 * @return String
	 */
	public String getMerchantState() 
	{
		
		return merchantState;
		
	}	// End of getMerchantState method
	
}	// End of class Purchase
