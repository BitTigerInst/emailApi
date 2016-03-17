/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package mycompany;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.*;


/**
 *
 * @author aznable
 */
public class sendEmail {
    private class SMTPAuthenticator extends Authenticator
    {
        private PasswordAuthentication authentication;
        
        public SMTPAuthenticator(String login, String password)
        {
            authentication = new PasswordAuthentication(login, password);
        }
        
        @Override
        protected PasswordAuthentication getPasswordAuthentication()
        {
            return authentication;
        }
    }
    
    public void mail(String to, String subject, String message)
    {
        
        String from = "wukongproject@hotmail.com";
        String login = "wukongproject@hotmail.com";
        String password = "Wukongteam";
        
        Properties props = new Properties();
        props.setProperty("mail.transport.protocol", "smtp");
        props.setProperty("mail.host", "smtp.live.com");
        props.setProperty("mail.smtp.port", "587");
        props.setProperty("mail.smtp.auth", "true");
        props.setProperty("mail.smtp.starttls.enable", "true");
        
        Authenticator auth = new SMTPAuthenticator(login, password);
        
        Session session = Session.getInstance(props, auth);
        
        MimeMessage msg = new MimeMessage(session);
        
        try
        {
            msg.setText(message);
            msg.setSubject(subject);
            msg.setFrom(new InternetAddress(from));
            msg.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(to));
            Transport.send(msg);
        }
        catch (MessagingException ex)
        {
            System.out.printf("wrong");
        }
    }
    public static void main(String[] args){
        sendEmail test=new sendEmail();
        test.mail("haotingliu1990@gmail.com", "test", "this is for test");
    }
}
