import java.sql.*;

public class database {
    public static void main(String[] args) {


        try
        {
            String host = "jdbc:mysql://localhost:3306/numbers?useSSL=false";
            String uName = "root";
            String uPass = "";

            Connection con = DriverManager.getConnection(host, uName, uPass);
            System.out.println("Success");
        } catch (SQLException err)
        {
            System.out.println(err.getMessage());
        }

    }
}
