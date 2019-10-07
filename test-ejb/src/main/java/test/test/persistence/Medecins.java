package test.test.persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.ws.rs.FormParam;

import org.jboss.resteasy.annotations.providers.multipart.PartType;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Medecins implements Serializable{

	@Id 
	@GeneratedValue( strategy = GenerationType.IDENTITY ) 
	private Integer matmed;
	private String Nom;
	private String Prenom;
	
	private String Spicialite;
	 @Lob
	  private byte[] data;
	
	private String Adresse;
	private String email;
	@OneToMany(mappedBy="medecins")
	@JsonIgnore
	private List<Rendezvous> rendezvous;			 
	
	public List<Rendezvous> getRendezvous()
	{
		 return rendezvous;
	}
	public String getEmail() {
		return email;
	}
	
	
	public void setRendezvous(List<Rendezvous> rendezvous) {
		this.rendezvous = rendezvous;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	private String photo;
	private String password;
	
public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
private String typeaccee;
	private Integer Telmed;
	

	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getTypeaccee() {
		return typeaccee;
	}
	public void setTypeaccee(String typeaccee) {
		this.typeaccee = typeaccee;
	}
	
		
	public Integer getMatmed() {
		return matmed;
	}
	public void setMatmed(Integer matmed) {
		matmed = matmed;
	}
	
	public String getNom() {
		return Nom;
	}
	public void setNom(String nom) {
		Nom = nom;
	}
	public String getPrenom() {
		return Prenom;
	}
	public void setPrenom(String prenom) {
		Prenom = prenom;
	}
	public String getSpicialite() {
		return Spicialite;
	}
	public void setSpicialite(String spicialite) {
		Spicialite = spicialite;
	}
	public String getAdresse() {
		return Adresse;
	}
	public void setAdresse(String adresse) {
		Adresse = adresse;
	}
	public Integer getTelmed() {
		return Telmed;
	}
	public void setTelmed(Integer telmed) {
		Telmed = telmed;
	}
	
	
	
	  public Medecins()
	  {
		  
	  }



	public Medecins(Integer matmed, String nom, String prenom, String spicialite, String adresse, String email,
		 String password, String typeaccee, Integer telmed) {
	super();
	this.matmed = matmed;
	Nom = nom;
	Prenom = prenom;
	Spicialite = spicialite;
	
	Adresse = adresse;
	this.email = email;
	
	this.password = password;
	this.typeaccee = typeaccee;
	Telmed = telmed;
}
	
	public byte[] getData() {
		return data;
	}

	@FormParam("uploadedFile")
	@PartType("application/octet-stream")
	public void setData(byte[] data) {
		this.data = data;
	}
 

}

