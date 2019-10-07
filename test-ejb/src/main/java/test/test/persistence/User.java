package test.test.persistence;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User implements Serializable{
	@Id 
	@GeneratedValue( strategy = GenerationType.IDENTITY ) 
	private Integer idUser;
	
	public User(Integer idUser, String nom, String prenom, String password, String email) {
		super();
		this.idUser = idUser;
		Nom = nom;
		Prenom = prenom;
		Password = password;
		this.email = email;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getIdUser() {
		return idUser;
	}
	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
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
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	private String Nom;
	private String Prenom;
	private String Password;
	private String email;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
