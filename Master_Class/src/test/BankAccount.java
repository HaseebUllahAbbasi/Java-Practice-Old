package test;

public class BankAccount
{
    public static final int CHECKING = 1;
    public static final int SAVINGS = 2;
    public int type_of_account;
    private String first_Name;
    private String last_Name;
    private double balance;

    public BankAccount(String first_Name, String last_Name, double balance,int type_of_account) {
        this.first_Name = first_Name;
        this.last_Name = last_Name;
        this.balance = balance;
        this.type_of_account = type_of_account;
    }
    public boolean checking()
    {
        return type_of_account ==CHECKING;
    }
    public double deposit(double amount,boolean branch)
    {
        balance+=amount;
        return balance;
    }

    public double withdraw(double amount,boolean branch)
    {
        balance-=amount;
        return balance;
    }


    public String getFirst_Name() {
        return first_Name;
    }

    public void setFirst_Name(String first_Name) {
        this.first_Name = first_Name;
    }

    public String getLast_Name() {
        return last_Name;
    }

    public void setLast_Name(String last_Name) {
        this.last_Name = last_Name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
