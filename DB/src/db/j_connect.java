import java.sql.*;
public class j_connect
{
	public static void main(String[] args) 
	{
		try
		{
		
		//Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/temp","root","");
		System.out.println("database connected");	
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		
	}
}