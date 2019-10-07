package test.test.services;

import javax.ejb.Remote;
import javax.jws.WebParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import test.test.persistence.Patients;
@Remote
@Path("Send_email_gmail")
public interface Send_email_gmailRemote {

	@Path("sentemail/{message}/{email_id}")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	void send (@PathParam("message")String message,@PathParam("email_id")String email_id);
	
	@Path("sentemailgmail/{username}/{password}")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	void sendgmail (@PathParam("username")String username,@PathParam("password")String password);

}