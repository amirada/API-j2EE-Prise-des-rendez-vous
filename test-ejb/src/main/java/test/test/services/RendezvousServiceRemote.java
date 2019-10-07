package test.test.services;

import java.util.List;

import javax.ejb.Remote;
import javax.jws.WebParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import test.test.persistence.Rendezvous;

@Remote
@Path("Rendezvous")
public interface RendezvousServiceRemote {
	@Path("add/{Matmed}/{MatriculePatient}")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	void create( @WebParam(name="rendezvous")Rendezvous rendezvous,@PathParam("Matmed") int matmed,@PathParam("MatriculePatient") int matpat);
	
	@Path("All")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	List<Rendezvous> findAll();
	
}
