package model;

import java.util.Date;

public class Visite {
	
	private int id;
	private int idPatient;
	private String nomMedecin;
	private int cout = 23;
	private Date dateVisite;
	private Date heureVisite;
	
	
	public Visite() {
	}


	public Visite(int idPatient, String nomMedecin, int cout, Date dateVisite, Date heureVisite) {
		this.idPatient = idPatient;
		this.nomMedecin = nomMedecin;
		this.cout = cout;
		this.dateVisite = dateVisite;
		this.heureVisite = heureVisite;
	}


	public Visite(int id, int idPatient, String nomMedecin, int cout, Date dateVisite, Date heureVisite) {
		this.id = id;
		this.idPatient = idPatient;
		this.nomMedecin = nomMedecin;
		this.cout = cout;
		this.dateVisite = dateVisite;
		this.heureVisite = heureVisite;
	}


	public int getId() {
		return id;
	}


	public int getIdPatient() {
		return idPatient;
	}


	public void setIdPatient(int idPatient) {
		this.idPatient = idPatient;
	}


	public String getNomMedecin() {
		return nomMedecin;
	}


	public void setNomMedecin(String nomMedecin) {
		this.nomMedecin = nomMedecin;
	}


	public int getCout() {
		return cout;
	}


	public Date getDateVisite() {
		return dateVisite;
	}


	public void setDateVisite(Date dateVisite) {
		this.dateVisite = dateVisite;
	}


	public Date getHeureVisite() {
		return heureVisite;
	}


	public void setHeureVisite(Date heureVisite) {
		this.heureVisite = heureVisite;
	}


	@Override
	public String toString() {
		return "Visite [id=" + id + ", idPatient=" + idPatient + ", nomMedecin=" + nomMedecin + ", cout=" + cout
				+ ", dateVisite=" + dateVisite + ", heureVisite=" + heureVisite + "]";
	}
	
	
	
	
}
