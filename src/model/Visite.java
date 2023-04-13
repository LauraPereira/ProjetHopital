package model;

import java.util.Date;

public class Visite {
	
	private int id;
	private int idPatient;
	private String nomMedecin;
	private int numSalle;
	private int tarif;
	private String dateVisite;
	
	
	public Visite() {
	}


	public Visite(int idPatient, String nomMedecin, int numSalle, int tarif, String dateVisite) {
		this.idPatient = idPatient;
		this.nomMedecin = nomMedecin;
		this.numSalle = numSalle;
		this.tarif = tarif;
		this.dateVisite = dateVisite;
	}


	public Visite(int id, int idPatient, String nomMedecin, int numSalle, int tarif, String dateVisite) {
		this.id = id;
		this.idPatient = idPatient;
		this.nomMedecin = nomMedecin;
		this.numSalle = numSalle;
		this.tarif = tarif;
		this.dateVisite = dateVisite;
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

	
	public int getNumSalle() {
		return numSalle;
	}


	public void setNumSalle(int numSalle) {
		this.numSalle = numSalle;
	}


	public int getTarif() {
		return tarif;
	}

	

	public String getDateVisite() {
		return dateVisite;
	}


	public void setDateVisite(String dateVisite) {
		this.dateVisite = dateVisite;
	}


	@Override
	public String toString() {
		return "Visite [id=" + id + ", idPatient=" + idPatient + ", nomMedecin=" + nomMedecin + ", tarif=" + tarif
				+ ", dateVisite=" + dateVisite + "]";
	}
	
	
	
	
}
