package test.test.persistence;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name ="Ordonnance")
public class Ordonnance implements Serializable {
	@Id 
	@GeneratedValue( strategy = GenerationType.IDENTITY ) 
	private Integer nummed;
	private String Nommed;
	public Integer getNummed() {
		return nummed;
	}
	public void setNummed(Integer nummed) {
		this.nummed = nummed;
	}
	public String getNommed() {
		return Nommed;
	}
	public void setNommed(String nommed) {
		Nommed = nommed;
	}
	private String Nompat;
	private String Prepat;
	private String Date;
	private String Heure;
	private String Dosagemed;
	private String Formemed;
		private String Pasologiemed;
		private Integer Quantitemed;
	
	private Ordonnance ordonnance;
	
	
	  
	public Ordonnance ()
	{}
	public Ordonnance (String NomMed, String Nompat, String prepat, String date, String heure, String dosagemed, String formemed,String Pasologiemed,Integer quantitemed)
	{
		this.Nommed = NomMed;
		this.Nompat = Nompat;
		this.Prepat= prepat;
		this.Date = date;
		this.Heure= heure;
		this.Dosagemed = dosagemed;
		this.Formemed = formemed;
		this.Pasologiemed = Pasologiemed;
		this.Quantitemed = quantitemed;
	}
	 public Ordonnance getOrdonnance() {
			
			return ordonnance;
		}

		public void setOrdonnance(Ordonnance ordonnance) {
			this.ordonnance = ordonnance;
		}
		public String getNomMed() {
			return Nommed;
		}
		public void setNomMed(String nomMed) {
			Nommed = nomMed;
		}
		public String getNompat() {
			return Nompat;
		}
		public void setNompat(String nompat) {
			Nompat = nompat;
		}
		public String getPrepat() {
			return Prepat;
		}
		public void setPrepat(String prepat) {
			Prepat = prepat;
		}
		public String getDate() {
			return Date;
		}
		public void setDate(String date) {
			Date = date;
		}
		public String getHeure() {
			return Heure;
		}
		public void setHeure(String heure) {
			Heure = heure;
		}
		public String getDosagemed() {
			return Dosagemed;
		}
		public void setDosagemed(String dosagemed) {
			Dosagemed = dosagemed;
		}
		public String getFormemed() {
			return Formemed;
		}
		public void setFormemed(String formemed) {
			Formemed = formemed;
		}
		public String getPasologiemed() {
			return Pasologiemed;
		}
		public void setPasologiemed(String pasologiemed) {
			Pasologiemed = pasologiemed;
		}
		public Integer getQuantitemed() {
			return Quantitemed;
		}
		public void setQuantitemed(Integer quantitemed) {
			Quantitemed = quantitemed;
		}
		
}
