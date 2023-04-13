package model;

import java.util.Date;

public class Visite {

	private int id;
	private int idPatient;
	private Date date;
	private String medecin;
	private int numSalle;
	private static double tarif = 23;

	public Visite(int id, int idPatient, Date date, String medecin, int numSalle) {
		super();
		this.id = id;
		this.idPatient = idPatient;
		this.date = date;
		this.medecin = medecin;
		this.numSalle = numSalle;
	}

}
