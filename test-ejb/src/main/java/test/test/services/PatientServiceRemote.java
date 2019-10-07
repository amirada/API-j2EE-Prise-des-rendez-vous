package test.test.services;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.ejb.Remote;
import javax.jws.WebParam;
import javax.ws.rs.*;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import test.test.persistence.Patients;
import test.test.persistence.MyEntity;

@Remote
@Path("Patients")
public interface PatientServiceRemote {
	@Path("add")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	void create(@WebParam(name="patient")Patients patient);
	
	@Path("login")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Patients login(@RequestBody Patients patient);
	
	
	
	@Path("All")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	List<Patients> findAll();
	
	@Path("GetMatricule/{email}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	Integer getmatricule (@PathParam("email")String email);
	
	@Path("ajouter")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	Patients ajout(@WebParam(name="patient")Patients patient);
	
	
	@Path("delete/{matriculePatient}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	void delete(@PathParam("matriculePatient")Integer matriculePatient);
	
	
	@Path("edit/{matriculePatient}")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public void Edit(@PathParam("matriculePatient")Integer matriculePatient ,@WebParam(name="patient")Patients patient);

	@Path("GetById/{matriculePatient}")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	void EditById(@PathParam("matriculePatient")Integer matriculePatient ,@WebParam(name="patient")Patients patient );
	Patients GetById(@PathParam("matriculePatient")Integer matriculePatient);

	
	
	@POST
    @Path("uploadimage/{matriculePatient}")
	
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public void uploadBinary(@MultipartForm MyEntity myEntity ,@PathParam("matriculePatient") Integer matriculePatient) ;

	
	
}
