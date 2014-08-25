package creditcard;

import java.sql.*;
import java.util.ArrayList;


/**
 * Handles database access for the Credit Card project
 */
public class CreditDAO {
	private PreparedStatement addCustomerStatement;
	private PreparedStatement clearCustomersStatement;
	private PreparedStatement listCustomersStatement;
	
	private PreparedStatement addPurchaseStatement;
	private PreparedStatement clearPurchasesStatement;
	private PreparedStatement listPurchaseStatement;
	
	private PreparedStatement updateUnpaidBalanceStatement;
	
	private static String JDBC_URL = "jdbc:mysql://localhost/cs4300";
	
	private int currentCustomerID; //the id of the account that is currently being viewed
	
	/**
	 * Connect to DB and create PreparedStatements
	 */
	public CreditDAO()
	{
		
		currentCustomerID = 0;
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(JDBC_URL, "root", "Taoisone1?");
			
			String statementStr = "insert into Customer " +
					"(custName, custAddr, creditLimit, unpaidBalance, imageURL) " +
					"values (?, ?, ?, ?, ?)";
			addCustomerStatement = conn.prepareStatement(statementStr);
			
			statementStr = "delete from Customer";
			clearCustomersStatement = conn.prepareStatement(statementStr);
			
			statementStr = "select id, custName, custAddr, creditLimit, unpaidBalance, imageURL " +
					"from Customer";
			listCustomersStatement = conn.prepareStatement(statementStr);
			
			statementStr = "insert into Purchase " +
					"(merchantName, merchantCity, merchantState, purchaseDate, purchaseAmount, custID) " +
					"values (?, ?, ?, NOW(), ?, ?)";
			addPurchaseStatement = conn.prepareStatement(statementStr);
			
			statementStr = "delete from Purchase";
			clearPurchasesStatement = conn.prepareStatement(statementStr);
			
			statementStr = "select id, merchantName, merchantCity, merchantState, purchaseDate, " +
					"purchaseAmount, custID from Purchase";
			listPurchaseStatement = conn.prepareStatement(statementStr);
		
			statementStr = "update Customer set unpaidBalance=? where id=?";
			updateUnpaidBalanceStatement = conn.prepareStatement(statementStr);
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * @return the currentCustomerID
	 */
	public int getCurrentCustomerID() 
	{
		return currentCustomerID;
	}

	/**
	 * @param currentCustomerID the currentCustomerID to set
	 */
	public void setCurrentCustomerID(int currentCustomerID) 
	{
		this.currentCustomerID = currentCustomerID;
	}

	/**
	 * Adds a new record to the Customer table
	 */
	public void addCustomer(String custName, String custAddress,
		String imageURL,double creditLimit)
	{
		try 
		{
			addCustomerStatement.setString(1, custName);
			addCustomerStatement.setString(2, custAddress);
			addCustomerStatement.setDouble(3, creditLimit);
			addCustomerStatement.setDouble(4, 0.0);
			addCustomerStatement.setString(5, imageURL);
			addCustomerStatement.executeUpdate();
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Returns a list of all Customers in the Customer table, but without embedded
	 * Purchases
	 */
	public ArrayList<CustomerAccount> getCustomerList()
	{
		ArrayList<CustomerAccount> result = new ArrayList<CustomerAccount>();
		try 
		{
			ResultSet rs = listCustomersStatement.executeQuery();
			while( rs.next() ) 
			{
				int id = rs.getInt("id");
				String name = rs.getString("custName");
				String address = rs.getString("custAddr");
				double limit = rs.getDouble("creditLimit");
				double balance = rs.getDouble("unpaidBalance");
				String url = rs.getString("imageURL");
				ArrayList<Purchase> purchases = getPurchaseList(id);
				
				result.add(new CustomerAccount(id, name, address, limit, balance, url, purchases));
			}
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * Returns the Customer with account no 'id', including the list
	 * of Purchases
	 */
	public CustomerAccount getCustomerByID(int id){
		ArrayList<CustomerAccount> custList = getCustomerList();
		
		for(CustomerAccount ca: custList) 
		{
			if(ca.getId() == id)
				return ca;
		}
		
		return null;
	}
	
	/**
	 * Same as above, but takes no parameters; uses currentCustomerID instead
	 */
	public CustomerAccount getCustomer()
	{
		return getCustomerByID(currentCustomerID);
	}
	
	/**
	 * Remove all the customers from the table
	 */
	public void clearCustomers() 
	{
		try 
		{
			clearCustomersStatement.executeUpdate();
		} catch(Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Adds a Purchase to 'account' with purchase date the present moment.
	 * If the purchase would put 'account' over its credit limit, does not
	 * add the Purchase but sets the error message of 'account'.
	 */
	public String addPurchase (int custID, String merchantName, String merchantCity,
		String merchantState, double purchaseAmount)
	{
		
		CustomerAccount customer = getCustomerByID(custID);
		String error = customer.addPurchase(purchaseAmount);
		if( !error.isEmpty() )
			return error;
		
		try 
		{
			addPurchaseStatement.setString(1, merchantName);
			addPurchaseStatement.setString(2, merchantCity);
			addPurchaseStatement.setString(3, merchantState);
			addPurchaseStatement.setDouble(4, purchaseAmount);
			addPurchaseStatement.setDouble(5, custID);
			addPurchaseStatement.executeUpdate();
			
			updateUnpaidBalanceStatement.setDouble(1, customer.getUnpaidBalance());
			updateUnpaidBalanceStatement.setInt(2, customer.getId());
			updateUnpaidBalanceStatement.executeUpdate();
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return "";
	}
	
	/**
	 * Returns a list of all Purchases associated with the specified customer
	 */
	public ArrayList<Purchase> getPurchaseList(int custID)
	{
		//id, merchantName, merchantCity, merchantState, purchaseDate, puchaseAmount, custID
		ArrayList<Purchase> result = new ArrayList<Purchase>();
		try 
		{
			ResultSet rs = listPurchaseStatement.executeQuery();
			while( rs.next() ) 
			{
				if(rs.getInt("custID") == custID) 
				{
					int id = rs.getInt("id");
					String name = rs.getString("merchantName");
					String city = rs.getString("merchantCity");
					String state = rs.getString("merchantState");
					String date = rs.getDate("purchaseDate").toString();
					double amount = rs.getDouble("purchaseAmount");
					
					result.add(new Purchase(id, name, city, state, date, amount, custID));
				}
			}
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * Same as above, but takes no arguments (to be used as a bean method)
	 */
	public ArrayList<Purchase> getPurchases(){
		return getPurchaseList(currentCustomerID);
	}
	
	/**
	 * Returns the purchase with the specified id that is associated with the specified
	 * customer account
	 */
	public Purchase getPurchase(int id, int custID){
		ArrayList<Purchase> purchaseList = getPurchaseList(custID);
		
		for(Purchase p: purchaseList) {
			if(p.getID() == id)
				return p;
		}
		
		return null;
	}
	
	/**
	 * Remove all the customers from the table
	 */
	public void clearPurchasess() {
		try {
			clearPurchasesStatement.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
