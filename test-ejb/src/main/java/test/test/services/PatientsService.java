package test.test.services;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.List;

import javax.ejb.Stateless;
import javax.json.Json;
import javax.json.JsonObject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.FormParam;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;
import org.jboss.resteasy.annotations.providers.multipart.PartType;
import org.jboss.resteasy.plugins.providers.multipart.InputPart;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;

import test.test.persistence.Medecins;
import test.test.persistence.MyEntity;
import test.test.persistence.Patients;

@Stateless
public class PatientsService implements PatientServiceRemote {

	private static final Response Response = null;
	@PersistenceContext
	private EntityManager empat;

	public PatientsService() {
	}

	@Override
	public void create(Patients patient) {
		// TODO Auto-generated method stub
       
		System.out.println(patient);
		empat.persist(patient);
		
		patient.setTypeaccee("Patients");
	    System.out.println(patient.getTypeaccee());
		empat.merge(patient);

	}
	

	@Override
	public List<Patients> findAll() {
		// TODO Auto-generated method stub
		return empat.createQuery("from Patients", Patients.class).getResultList();
	}

	
	@Override
	public Patients login(Patients patient) {

		List<Patients> patientList = empat.createQuery("from Patients", Patients.class).getResultList();
		for (int i = 0; i < patientList.size(); i++) {
			if (patient.getPassword().equals(patientList.get(i).getPassword())
					&& patient.getNom().equals(patientList.get(i).getNom())) {
			return patientList.get(i);
			}

		}
		return null;
	}
	@Override
	public Patients ajout(Patients patient) {
	    empat.persist(patient);
		return patient;
	}
	
	public class LoginForm implements Serializable {

		public LoginForm() {
			super();
			// TODO Auto-generated constructor stub
		}

		public LoginForm(String nom, String password) {
			super();
			this.nom = nom;
			this.password = password;
		}

		public String nom;
		public String password;
	}

	/*@Override
	public void uploadImage(InputStream uploadedInputStream) {

		   ///System.out.println(fileDetails.getFileName());
		   //System.out.println(uploadedInputStream.getClass()));

		   String uploadedFileLocation = "C:\\" ;

		   // save it
		   writeToFile(uploadedInputStream, uploadedFileLocation);

		   String output = "File uploaded to : " + uploadedFileLocation;

		   
		}*/

	

		@Override
		public void delete(Integer matriculePatient) {
			// TODO Auto-generated method stub
			Object message = "succee";
			Object message1 = "non";
			Patients u = empat.find(Patients.class, matriculePatient);

			if (u != null) {
				empat.remove(u);
			
				
			} 
		}
		@Override
		public Patients GetById(Integer  matriculePatient) {
			// TODO Auto-generated method stub
			return empat.find(Patients.class, matriculePatient);
			
			
			
			//2eme methode
			/*user.setIdUser(u.getIdUser());		
			em.merge(user);*/
			
			
		}
		
		@Override
		public void EditById(Integer matriculePatient, Patients patient) {
			// TODO Auto-generated method stub
			Patients p= empat.find(Patients.class, matriculePatient);
			
			
			//1ere methode
			p.setNom(patient.getNom());
			p.setPrenom(patient.getPrenom());
			p.setEmail(patient.getEmail());
			p.setAdresse(patient.getAdresse());
			p.setGroupesanguine(patient.getGroupesanguine());
			p.setAntecedents(patient.getAntecedents());
			p.setDatenaissance(patient.getDatenaissance());
			p.setTelephone(patient.getTelephone());
			empat.merge(p);
			
			//2eme methode
			/*user.setIdUser(u.getIdUser());		
			em.merge(user);*/
			
			
		}

	


		@Override
		public void Edit(Integer matriculePatient, Patients patient) {
			
			Patients pat=empat.find(Patients.class, matriculePatient);
			
			System.out.println(matriculePatient);
			System.out.println(patient.getNom());
			
			
		
			patient.setMatriculePatient(pat.getMatriculePatient());
			empat.merge(patient);
		}
		
		@Override
		public void uploadBinary( MyEntity myEntity,Integer matriculePatient) {
			
			
			System.out.println("iciiiiii");
			System.out.println(myEntity.getData());
			
			Patients p = empat.find(Patients.class, matriculePatient);
			System.out.println(myEntity.getData());
			
			p.setData(myEntity.getData());
			
			empat.merge(p);
				 
		}

		@Override
		public Integer getmatricule(String email) {
			
			Patients p= empat.find(Patients.class, email);
			return p.getMatriculePatient();
		}

		
		
}
