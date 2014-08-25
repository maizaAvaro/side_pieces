package db;

import java.util.ArrayList;

/**
 * Represents a band and the albums it has recorded
 */
public class Band 
{
	
	/**
	 * Represents the unique id of a Band
	 */
	private int id;
	
	/**
	 * Represents the name of a Band
	 */
	private String bandName;
	
	/**
	 * Represents the album list associated with a Band
	 */
	private ArrayList<String> albumList = new ArrayList<String>();
	
	
	/**
	 * Initialize with a band name and empty album list
	 */
	public Band (int id, String bandName, ArrayList<String> albumList)
	{
	
		this.id = id;
		this.bandName = bandName;
		this.albumList = albumList;
		
	}	// End of Band constructor
	
	/**
	 * Add an album to this band
	 * @param albumTitle title of an album recorded by this band.
	 */
	 public void addAlbum(String albumTitle)
	 {
	
		 albumList.add(albumTitle);
		 
	 }	// End of addAlbum method

	/**
	 * Gets the unique Id of a Band 
	 * @return
	 */
	public int getId() 
	{
		
		return id;
		
	}	// End of method getId

	/**
	 * Gets the name of a Band
	 * @return
	 */
	public String getBandName() 
	{
		
		return bandName;
	
	}	// End of method getBandName

	/**
	 * Gets the album list associated with a Band
	 * @return
	 */
	public ArrayList<String> getAlbumList() 
	{
		
		return albumList;
	
	}	// End of method getAlbumList
	 
}	// End of class Band