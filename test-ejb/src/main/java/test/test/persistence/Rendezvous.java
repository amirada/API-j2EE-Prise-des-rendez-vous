package test.test.persistence;

import java.io.Serializable;
import java.util.*;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity 
public class Rendezvous  implements Serializable{
	@Id 
	@GeneratedValue( strategy = GenerationType.IDENTITY ) 
	private Integer id;
	
	private String Daterendezvous;
	private String heurerendezvous;
	@ManyToOne
	@JsonIgnore
	private Patients patient ; 
	@OneToMany(mappedBy="Rendezvous" , fetch = FetchType.EAGER)
	@JsonIgnore
	private List<Assistante> assistanteList ;
	@ManyToOne
	private Medecins medecins;
	public Rendezvous() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Medecins getMedecins()
	{ 
		return medecins;
	}
	/*@Temporal(TemporalType.DATE)
	private Date Daterendezvous;
	*/
	

	public String getHeurerendezvous() {
		return heurerendezvous;
	}

	public void setHeurerendezvous(String heurerendezvous) {
		this.heurerendezvous = heurerendezvous;
	}

	

	public String getDaterendezvous() {
		return Daterendezvous;
	}

	public void setDaterendezvous(String daterendezvous) {
		Daterendezvous = daterendezvous;
	}

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Patients getPatient() {
		return patient;
	}

	public void setPatient(Patients patient) {
		this.patient = patient;
	}

	public List<Assistante> getAssistanteList() {
		return assistanteList;
	}

	public void setAssistanteList(List<Assistante> assistanteList) {
		this.assistanteList = assistanteList;
	}

	public void setMedecins(Medecins medecins) {
		this.medecins = medecins;
	}
	
	
}
