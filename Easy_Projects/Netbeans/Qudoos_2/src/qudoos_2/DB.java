package qudoos_2;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Handles all of the application's database interaction
 * 
 * @author You, mainly!
 */
public class DB {
	
	private String connectionString = "jdbc:sqlite:data/vaccination_centres.db";

	/**
	 * Queries the database to find out how many vaccination sites it contains
	 * @return The number of sites in the vaccination_centres.db database
	 */
	public int getSite() {
		try (Connection c = DriverManager.getConnection(connectionString); ) {
			
			//run the query
			Statement statement = c.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM vaccination_site WHERE City = Manchester");

			//loops through the results 
			while (rs.next()) {
			String SiteName = rs.getString ("SiteName");
			String AddressL1 = rs.getString("AddressLine1");
			String AddressL2 = rs.getString ("AddressLine2");
			
			}
		
		} 
		catch (SQLException e) {
			e.printStackTrace();
			return -1;	
		}
		return 0;
	
	
}
	
}
