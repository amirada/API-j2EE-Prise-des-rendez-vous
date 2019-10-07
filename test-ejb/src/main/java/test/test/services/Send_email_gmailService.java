package test.test.services;
import java.util.*; 
import javax.mail.*;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.internet.*;
import javax.persistence.EntityManager;

import test.test.persistence.Send_email_gmail;
public class Send_email_gmailService implements Send_email_gmailRemote  {
	
	@Override
	public void send(String message, String email_id) {
		Send_email_gmail obj_send_mail=new Send_email_gmail();
		obj_send_mail.send_email(message,email_id);
		
	}
	
	@Override
	public void sendgmail(String username, String password) {
		Send_email_gmail obj_send_mail1=new Send_email_gmail();
		obj_send_mail1.send_emailgmail(username,password);
		
	}
	
	
	}
		
	


