package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Manages database access for the Bands project.
 */
public class DBHelper 
{
	
	/**
	 * Represents the URL used to connect to the necessary database
	 */
	private static String JDBC_URL = "jdbc:mysql://localhost/cs4300";
	
	/**
	 * Statement to add a Band to the Band table in the database
	 */
	private PreparedStatement addBandStatement;
	
	/**
	 * Statement to delete all the bands from the Band table in the database
	 */
	private PreparedStatement clearBandsStatement;
	
	/**
	 * Statement to list all the bands from the Band table in the database
	 */
	private PreparedStatement listBandsStatement;
	
	/**
	 * Statement to list all the albums from a Band in the Album table of the database
	 */
	private PreparedStatement listAlbumsStatement;
	
	/**
	 * Statement to add and Album to the Album table in the database
	 */
	private PreparedStatement addAlbumStatement;
	
	/**
	 * Statement to delete all the albums from the Album table in the database
	 */
	private PreparedStatement clearAlbumsStatement;
	
	/**
	 * Represents the Band id of a given Band object
	 */
	private int bandId;
	
	
  /**
   * Establish a connection to the database and create the
   * PreparedStgatements
   */
	public DBHelper()
	{
			try
			{
				
				Class.forName("com.mysql.jdbc.Driver");
				System.out.println("Instantiated MySQL Driver.");
				Connection conn = DriverManager.getConnection(JDBC_URL, "root", "Taoisone1?");
				System.out.println("Connected to cs4300 database.");
				
				clearBandsStatement = conn.prepareStatement("delete from Band");
				listBandsStatement = conn.prepareStatement("select id, bandName from Band");
				addBandStatement = conn.prepareStatement("insert into Band (bandName) values (?)");
				listAlbumsStatement = conn.prepareStatement("select bandId, albumName from Album");
				addAlbumStatement = conn.prepareStatement("insert into Album(albumName, bandId) values (?,?)");
				clearAlbumsStatement = conn.prepareStatement("delete from Album");
				
			}
		    catch(Exception error)
		    {
		    	
		    	System.out.println(error.getClass().getName() + ": " + error.getMessage());
		    	
		    }
			
		}	// End of DBHelper constructor
	
	/**
	 * Adds Band 'bandName' to the bands table
	 */
	public void addBand(String bandName)
	{
		
		try
		{
			
			addBandStatement.setString(1, bandName);
			
			addBandStatement.executeUpdate();
			
		}
		catch(Exception error)
		{
			
			System.out.println("Error adding band\n" + error.getClass().getName() + ": " + error.getMessage());
			
		}	// End of try-catch block
		
	}	// End of addBand method
	
	/**
	 * Adds Album 'albumName' to the Album table with a foreign key of bandId
	 * @param albumName name of the  album
	 * @param bandId id of the band that recorded this album
	 */
	public void addAlbum(String albumName, int bandId)
	{
		
		try
		{
			
			addAlbumStatement.setString(1, albumName);
			addAlbumStatement.setInt(2, bandId);
			
			addAlbumStatement.executeUpdate();
			
		}
		catch(Exception error)
		{
			
			System.out.println("Error adding album\n" + error.getClass().getName() + ": " + error.getMessage());
			
		}	// End of try-catch block
		
	}	// End of addAlbum method
	
	/**
	 * Pulls the list of bands with associated albums from the database and creates the Band objects
	 */
	public ArrayList<Band> getBandList()
	{
		
		ArrayList <Band> result = new ArrayList<Band>();
		
		try
		{
			
			ResultSet rs = listBandsStatement.executeQuery();
			
			// On one iteration of this loop the Band database is queried, the id and  
			// band name of that query are obtained, the album list corresponding to the
			// band id of this query is obtained and these three parameters are then used to 
			// create a Band object which is then added to the ArrayList 'result'
			while(rs.next())
			{
				
				int id = rs.getInt("id");
				String bandName = rs.getString("bandName");
				bandId = id;
				ArrayList<String> albums = getAlbumList();
				Band band = new Band(id, bandName, albums);
				
				result.add(band);
				
			}	// End of while-loop
			
		}
		catch(Exception error)
		{
			
			System.out.println("Error populating Band list\n" + error.getClass().getName() + ": " + error.getMessage());
			
		}	// End of try-catch block
		
		return result;
		
	}	// End of getBandList method
	
	/**
	 * Returns a list of all the albums which have the band id of 'bandId'
	 * @return
	 */
	public ArrayList<String> getAlbumList()
	{
		
		ArrayList <String> result = new ArrayList<String>();
		
		try
		{
			
			ResultSet rs = listAlbumsStatement.executeQuery();
			
			// On one iteration of this loop the Album database is queried and the band id
			// corresponding to that query is obtained, if this band id matches the band id
			// given via option selection on the index page, then the album name of this query
			// is obtained and is added to the ArrayList 'result'
			while(rs.next())
			{
					
					if(rs.getInt("bandId") == bandId)
					{
						
						String albumName = rs.getString("albumName");
						result.add(albumName);
						
					}	// End of if statement
					
				
			}	// End of while-loop
			
		}
		catch(Exception error)
		{
			
			System.out.println("Error populating Album list\n" + error.getClass().getName() + ": " + error.getMessage());
			
		}	// End of try-catch block
		
		return result;
		
	}	// End of getAlbumList method
	
	/**
	 * Removes all the bands from the Band table
	 */
	public void clearBands()
	{
		
		try
		{
			
			clearBandsStatement.executeUpdate();
			
		}
		catch(Exception error)
		{
			
			System.out.println(error.getClass().getName() + ": " + error.getMessage());
			
		}	// End of try-catch block
		
	}	// End of clearBands method
	
	/**
	 * Removes all the Albums from the Album table
	 */
	public void clearAlbums()
	{
		
		try
		{
			
			clearAlbumsStatement.executeUpdate();
			
		}
		catch(Exception error)
		{
			
			System.out.println(error.getClass().getName() + ": " + error.getMessage());
			
		}	// End of try-catch block
		
	}	// End of clearAlbums method
	
	/**
	 * Wrapper class that calls addBand for JavaBean purposes
	 * @param bandName - name of the band to add to the JSP page
	 */
	public void setBandName(String bandName)
	{
		
		addBand(bandName);
		
	}	// End of setBandName method 
	
	/**
	 * Sets the bandId for a Band object used for the JavaBean
	 * @param bandId - the id of a Band object
	 */
	public void setBandId(int bandId)
	{
		
		this.bandId = bandId;
		
	}	// End of setBandId method
	
	/**
	 * Wrapper class that calls addAlbum for JavaBean purposes
	 * @param albumName - name of the album to add to the JSP page
	 * @param bandID - unique band ID set by the database
	 */
	public void setAlbumName(String albumName)
	{
		
		addAlbum(albumName, bandId);
		
		
	}	// End of setAlbumName method
	
}	// End of DBHelper class