package model;

import java.sql.SQLException;
import java.util.Date;

import dao.DaoVisite;

public class Visite {

	private int id;
	private int idPatient;
	private String nomMedecin;
	private int numSalle;
	private final static int tarif = 23;
	private String dateVisite;

	public Visite() {
	}

	public Visite(int idPatient, String nomMedecin, int numSalle, String dateVisite) {
		this.idPatient = idPatient;
		this.nomMedecin = nomMedecin;
		this.numSalle = numSalle;
		this.dateVisite = dateVisite;
	}

	public Visite(int id, int idPatient, String nomMedecin, int numSalle, String dateVisite) {
		this.id = id;
		this.idPatient = idPatient;
		this.nomMedecin = nomMedecin;
		this.numSalle = numSalle;
		this.dateVisite = dateVisite;
	}

	public int getId() {
		return id;
	}

	public int getIdPatient() {
		return idPatient;
	}

	public String getNomMedecin() {
		return nomMedecin;
	}

	public int getNumSalle() {
		return numSalle;
	}

	public int getTarif() {
		return tarif;
	}

	public String getDateVisite() {
		return dateVisite;
	}

	public void saveLstVisite(Salle s) throws ClassNotFoundException, SQLException {
		DaoVisite dv = new DaoVisite();

		if (s.getLstVisite().size() == 3) {
			for (Visite v : s.getLstVisite()) {
				dv.create(v);
			}
			s.viderLst();
		}

	}

	@Override
	public String toString() {
		return "Visite [id=" + id + ", idPatient=" + idPatient + ", nomMedecin=" + nomMedecin + ", tarif=" + tarif
				+ ", dateVisite=" + dateVisite + "]";
	}

}
