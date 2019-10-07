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

import org.springframework.web.bind.annotation.RequestBody;

import test.test.persistence.Assistante;
import test.test.persistence.Medecins;

@Remote
@Path("Assistante")
public interface AssistanteServiceRemote {

	@Path("add")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	void create(@WebParam(name="assistante")Assistante assistante);
	@Path("All")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	List<Assistante> findAll();
	
	
	@Path("login")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Assistante login(@RequestBody Assistante assistante);
}

