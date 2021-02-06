package console_1;

import java.sql.SQLException;

public interface Room 
{

    public void order_fod() throws SQLException;

    public void check_out() throws SQLException;

    public void add_room()throws Input_Exception, SQLException;
    public void display_detail() throws Exception;;

    public int availability();
    public void search(String name);
    
}
