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

import test.test.persistence.Medecins;
import test.test.persistence.Ordonnance;

@Remote
@Path("Ordonnance")
public interface OrdonnanceServiceRemote {
	@Path("add")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	void create(@WebParam(name="ordonnance")Ordonnance ordonnance);
	@Path("All")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	List<Ordonnance> findAll();
}
