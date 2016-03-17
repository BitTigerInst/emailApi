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
    
    public boolean mail(String to, String subject, String message, emailPool pool)
    {
        
        String from = pool.chooseEmail();
        String login = pool.chooseEmail();
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
            return false;
        }
        return true;
    }
    public static void main(String[] args){
        sendEmail test=new sendEmail();
        emailPool pool=new emailPool();
        int tmp=pool.emailNum;
        while(true){
            /*            if(!test.mail("haotingliu1990@gmail.com", "test", "this is for test", pool))  {
            if(pool.tryNext()) continue;
            else break;
            }*/
            if(!test.mail("haotingliu1990@gmail.com", "test", "this is for test", pool)){
                if(!pool.tryNext()) break;
            }
        }
    }
}
