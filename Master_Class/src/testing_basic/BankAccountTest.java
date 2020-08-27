package testing_basic;

import org.junit.Test;

import static org.junit.Assert.*;

public class BankAccountTest {

    @Test
    public void deposit() //throws Exception
    {
        BankAccount bankAccount = new BankAccount("Haseeb Ullah","Abbasi",1000,BankAccount.CHECKING);
        double balance = bankAccount.deposit(200,true);
        assertEquals(1200.00,balance,0);
    }

    @Test
    public void withdraw() //throws  Exception
    {

        BankAccount bankAccount = new BankAccount("Haseeb Ullah","Abbasi",1000,BankAccount.CHECKING);
        double balance = bankAccount.withdraw(200,true);
        assertEquals(800.00,balance,0);
        //fail("this test fails");
    }


    @Test
    public void getBalance_withdraw() {

        BankAccount bankAccount = new BankAccount("Haseeb Ullah","Abbasi",1000,BankAccount.CHECKING);
        double balance = bankAccount.withdraw(200,true);
        assertEquals(800.00,bankAccount.getBalance(),0);
    }

    @Test
    public void getBalance_deposit() {

        BankAccount bankAccount = new BankAccount("Haseeb Ullah","Abbasi",1000,BankAccount.CHECKING);
        double balance = bankAccount.deposit(200,true);
        assertEquals(1200.00,bankAccount.getBalance(),0);
    }
    public void isChecking_true()
    {

        BankAccount bankAccount = new BankAccount("Haseeb Ullah","Abbasi",1000,BankAccount.CHECKING);
        assertTrue("the Count is not checking ", bankAccount.checking());

        //assertEquals("the Count is not checking ",true,bankAccount.checking());
       // assertEquals("the Count is not checking ",bankAccount.checking());

    }
    /*
    @Test
    public void dummy_Test()
    {
        assertEquals (21,21);
        assertEquals (21,20);
    }

     */
}