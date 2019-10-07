package test.test.persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Assistante implements Serializable {

	@Id 
	@GeneratedValue( strategy = GenerationType.IDENTITY ) 
	private Integer numas;
	private String nom;
	private String prenom;
	private String password;
	
	private String photo;
	private String typeaccee;
	private String adresse;
	private String email;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	private Integer telass;
	@ManyToOne
	@JsonIgnore
	private Rendezvous Rendezvous ; 
	
	
	public Integer getNumas() {
		return numas;
	}
	public void setNumas(Integer numas) {
		this.numas = numas;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Assistante(Integer numas, String nom, String prenom, String adresse, String password, Integer telass, String photo, String email, String typeaccee
			) {
		
		this.numas = numas;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.password =password;
		this.email = email;
		this.telass = telass;
		this.typeaccee = typeaccee;
		this.photo =photo;
	}
	public Assistante() {
		super();
		// TODO Auto-generated constructor stub
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
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
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
	public Integer getTelass() {
		return telass;
	}
	public void setTelass(Integer telass) {
		this.telass = telass;
	}
	
	
}
