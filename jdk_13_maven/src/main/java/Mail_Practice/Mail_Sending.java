package Mail_Practice;


import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.Scanner;

public class Mail_Sending
{
    public static void main(String [] args) throws MessagingException
    {
        Properties properties = new Properties();
        properties.put("mail.smtp.auth","true");
        properties.put("mail.smtp.starttls.enable","true");
        properties.put("mail.smtp.host","smtp.gmail.com");
        properties.put("mail.smtp.port","587");
        String mail = "haseebabbasi00@gmail.com";
        //String rec = "nazeerahmed44303@gmail.com";//(new Scanner(System.in)).next();
        String rec =  "Umairnoonari98@gmail.com";//
        String pass =  (new Scanner(System.in)).next();

        Session session = Session.getInstance(properties, new Authenticator()
        {
            @Override
            protected PasswordAuthentication getPasswordAuthentication()
            {
                return  new PasswordAuthentication(mail,pass);
            }
        });
        for (int j=0; j<50; j++)
        {
            System.out.print("sending "+j);
            Message message = prepareMessage(session,mail,pass,rec);
            Transport.send(message);
        }

    }
    static  int i = 0;
    private static Message prepareMessage(Session session, String mail, String pass,String rec) throws MessagingException
    {
        Message message = new MimeMessage(session);
        message.setFrom( new InternetAddress(mail) );
        message.setRecipient(Message.RecipientType.TO,new InternetAddress(rec));
        message.setSubject("Testing Mailing");
        message.setText("this is test message+"+i);
        i++;
        return message;
    }

}
