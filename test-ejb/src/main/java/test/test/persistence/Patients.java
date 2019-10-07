package test.test.persistence;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.ws.rs.FormParam;

import org.jboss.resteasy.annotations.providers.multipart.PartType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity 
public class Patients implements Serializable {
	@Id 
	@GeneratedValue( strategy = GenerationType.IDENTITY ) 
	private Integer MatriculePatient;
	private String nom;
	private String prenom;
	private String password;
	private String antecedents;
	private String photo;
	
	 private String fileName;
	  private String contentType;
	  @Lob
	  private byte[] data;
	
	private String adresse;
	private String email;

	private String typeaccee ="Patients";
	private Integer telephone;
	private String datenaissance;
	private String sexe;
	private String groupesanguine;
	
	
	@OneToMany(mappedBy="patient" , fetch = FetchType.EAGER)
	private List<Rendezvous> Rendezvous ;

	public Integer getMatriculePatient() {
		return MatriculePatient;
	}

	public void setMatriculePatient(Integer matriculePatient) {
		MatriculePatient = matriculePatient;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAntecedents() {
		return antecedents;
	}

	public void setAntecedents(String antecedents) {
		this.antecedents = antecedents;
	}

	public String getPhoto() {
		return photo;
	}
	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
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

	public Integer getTelephone() {
		return telephone;
	}

	public void setTelephone(Integer telephone) {
		this.telephone = telephone;
	}

	public String getDatenaissance() {
		return datenaissance;
	}

	public void setDatenaissance(String datenaissance) {
		this.datenaissance = datenaissance;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public String getGroupesanguine() {
		return groupesanguine;
	}

	public void setGroupesanguine(String groupesanguine) {
		this.groupesanguine = groupesanguine;
	}

	public List<Rendezvous> getRendezvous() {
		return Rendezvous;
	}

	public void setRendezvous(List<Rendezvous> rendezvous) {
		Rendezvous = rendezvous;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Patients() {
		super();
		// TODO Auto-generated constructor stub
	} 

	public Patients(Integer matriculePatient, String nom, String prenom, String password, String antecedents,
			String photo, String typeaccee, Integer telephone , String adresse, String datenaissance, String sexe, String groupesanguine,
			String email) {
		super();
		MatriculePatient = matriculePatient;
		this.nom = nom;
		this.prenom = prenom;
		this.password = password;
		this.antecedents = antecedents;
		this.photo = photo;
		this.typeaccee = "Patients";
		this.telephone = telephone;
		this.adresse = adresse;
		this.datenaissance = datenaissance;
		this.sexe = sexe;
		this.groupesanguine = groupesanguine;
		this.email = email;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
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
