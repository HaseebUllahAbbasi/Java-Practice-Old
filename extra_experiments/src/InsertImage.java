import java.sql.*;
import java.io.*;

public class InsertImage {
public static void main(String[] args) {
try{
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con=DriverManager.getConnection(
"jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
			
PreparedStatement ps=con.prepareStatement("insert into imgtable values(?,?)");
		
FileInputStream fin=new FileInputStream("d:\\g.jpg");
		
ps.setString(1,"sonoo");
ps.setBinaryStream(2,fin,fin.available());
int i=ps.executeUpdate();
System.out.println(i+" records affected");
		
con.close();
			
}catch (Exception e) {e.printStackTrace();}
}
}
