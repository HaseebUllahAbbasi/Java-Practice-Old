package console_1;
public class Customer 
{
    int room_no;
    String name;
    String contact;
    int bill;

    public Customer(String name, String contact) {
        this.name = name;
        this.contact = contact;
        bill = 0;
    }
    public Customer() 
    {
        
    }
    public String toString()
    {
        return "name :"+ name +" , contact : "+contact+", room : "+room_no+", bill "+bill;
    }
}
