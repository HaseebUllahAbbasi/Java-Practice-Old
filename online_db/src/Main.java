import java.sql.*;

public class Main
{
    private static Connection connection;
    private static ResultSet resultSet;
    private static Statement statement;
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://sql12.freemysqlhosting.net:3306/sql12341608","sql12341608","mrh5pzxe7h");
        statement = connection.createStatement();
        System.out.println("connection is done");

        resultSet = statement.executeQuery("select * from names");
        System.out.println("data from online table");
        while (resultSet.next())
        {
            System.out.println(resultSet.toString());
        }
    }
}
