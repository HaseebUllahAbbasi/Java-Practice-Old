package db;

public class j_connect
{
	public static void main(String[] args) 
	{
		try
		{
			//Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/sys?useSSL=false";
			String user = "root";
			String password = "";
			Connection con = DriverManager.getConnection(url, user, password);

		//Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/temp","root","");

			System.out.println("database connected");
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		
	}
}