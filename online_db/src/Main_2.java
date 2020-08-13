import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main_2 {

    public static void main(String[] args) throws SQLException
    {
        String url = "jdbc:mysql://localhost:3306/mysql?useSSL=false";
        String user = "root";
        String password = "root";

        String query = "SELECT * from component";

         Connection con = DriverManager.getConnection(url, user, password);
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(query) ;


            if (rs.next()) {

                System.out.println(rs.getString(1));
            }



    }
}