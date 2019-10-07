package test.test.services;

import java.util.List;

import javax.ejb.Remote;
import javax.jws.WebParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import test.test.persistence.User;



@Remote
@Path("User")
public interface UserServiceRemote {
	@Path("add")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	void create(@WebParam(name="user")User user);
	
	@Path("All")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	List<User> findAll();
}