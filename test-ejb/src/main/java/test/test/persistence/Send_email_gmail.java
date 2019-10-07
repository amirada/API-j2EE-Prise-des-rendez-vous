package test.test.persistence;

import java.util.*;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id; 
 
@Entity 
public class Send_email_gmail {
	@Id 
	@GeneratedValue( strategy = GenerationType.IDENTITY ) 
	private Integer id;
		public Send_email_gmail(Integer id, String username, String password, Properties props, String message,
			String email_id) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.props = props;
		this.message = message;
		this.email_id = email_id;
	}
		
		public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
		String username = "fromemail@gmail.com";
		String password = "password";
		
		Properties props = new Properties();
		String message="";
		String email_id="";
public Send_email_gmail() {
			super();
		}


		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public Properties getProps() {
			return props;
		}
		public void setProps(Properties props) {
			this.props = props;
		}
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
		public String getEmail_id() {
			return email_id;
		}
		public void setEmail_id(String email_id) {
			this.email_id = email_id;
		}
		public void send_emailgmail(String username, String password) {
			// TODO Auto-generated method stub
			 this.username = username;
	          this.password = password;
			Properties props = new Properties();
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.port", "587");
			Session session = Session.getInstance(props,
			  new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
				}
			  });
			try {
				Message message = new MimeMessage(session);
				message.setFrom(new InternetAddress("fromemail@gmail.com"));
				message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse("toemail@gmail.com"));
				message.setSubject("Testing Subject");
				message.setText("Dear Mail Crawler,"
					+ "\n\n No spam to my email, please!"
					+ "Visit https://chillyfacts.com");
				Transport.send(message);
				System.out.println("Done");
			} catch (MessagingException e) {
				throw new RuntimeException(e);
			}
		}
		public void send_email(String message, String email_id) {
			
			String smtpServer = null; 
	                String smtpPort = null;
			final String authAddress = "aliaminamin12255@gmail.com";      
			final String authPassword = "0123456789AM";    
			String subject = "NEW email";          
			//String message = "test by jinu";     
	        smtpServer = "smtp.gmail.com";
	        smtpPort = "587";    
	        try{    
	                Properties props = new Properties();     
	                props.put("mail.smtp.host", smtpServer); 
	                props.put("mail.smtp.port", smtpPort); 
	    			props.put("mail.smtp.starttls.enable", "true");
	                props.put("mail.smtp.auth", "true");         
	            // create some properties and get the default Session
	            Session sessionMail = Session.getInstance(props, new Authenticator() {
	                 public PasswordAuthentication getPasswordAuthentication() {      
	                         return new PasswordAuthentication(authAddress, authPassword);
	                 }                                                                    
	                });                                                                   
	            sessionMail.setDebug(true);
	            // create a message
	            Message msg = new MimeMessage(sessionMail);
	            // set the from and to address
	            InternetAddress addressFrom = new InternetAddress(authAddress);
	            msg.setFrom(addressFrom);
	            InternetAddress[] addressTo = new InternetAddress[1];
	            addressTo[0] = new InternetAddress(email_id);
	            msg.setRecipients(Message.RecipientType.TO, addressTo);
	            // Optional : You can also set your custom headers in the Email if you Want
	            msg.addHeader("site", "chillyfacts.com");
	            // Setting the Subject and Content Type
	            msg.setSubject(subject);
	            msg.setContent(message, "text/html");
	            Transport.send(msg);
	        }catch(Exception e){
	                System.out.println(e);
	        }
	}
}
