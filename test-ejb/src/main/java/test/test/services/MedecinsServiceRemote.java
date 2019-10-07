package test.test.services;

import java.util.List;

import javax.ejb.Remote;
import javax.jws.WebParam;
import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;

import org.springframework.web.bind.annotation.RequestBody;
import test.test.persistence.Medecins;
import test.test.persistence.MyEntity;


@Remote
@Path("Medecins")
public interface MedecinsServiceRemote {
	@Path("add")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	void create(@WebParam(name="medecins")Medecins medecins);
	
	@Path("All2")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	List<Medecins> findAll();
		
	@Path("edit/{matmed}")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public void Edit(@PathParam("matmed")Integer matmed ,@WebParam(name="medecins")Medecins medecins);

	@Path("login")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Medecins login(@RequestBody Medecins medecins);
	
	@Path("ajouter")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	Medecins ajout(@WebParam(name="medecin")Medecins medecin);
//	
//	@Path("delete/{matmed}")
//	@DELETE
//	@Produces(MediaType.APPLICATION_JSON)
//	void delete(@PathParam("matmed")Integer matmedt);
//	
	@Path("delete/{matmed}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	void delete(@PathParam("matmed")Integer matmed);
	
	
	
    @Path("getimage/{matmed}")
    @GET
    @Produces(MediaType.MULTIPART_FORM_DATA)
	void getimage(@PathParam("matmed")Integer matmed);
    

	
	@POST
    @Path("uploadimage/{matmed}")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
    public void uploadBinary(@MultipartForm MyEntity myEntity ,@PathParam("matmed") Integer matmed) ;

	

}
