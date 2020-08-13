import java.sql.*;

public class Main
{
    public static void main(String[] args)
    {
        try
        {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:/home/peaceseeker/test.db");
            Statement statement = connection.createStatement();
            statement.execute("Create Table admin (name Text, phone Integer, password text)");
            statement.close();
            connection.close();
        } catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
    }
}
