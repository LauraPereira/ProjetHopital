package model;

import java.util.LinkedList;

public class Hopital {

	private static Hopital instance;
	private String secretaire;
	private LinkedList<Patient> lstAttente;

	public Hopital(String secretaire) {
		super();
		this.secretaire = secretaire;
	}

	public static Hopital getInstance(String secretaire) {
		if (instance == null) {
			instance = new Hopital(secretaire);
		}
		return instance;
	}

	public void addPatient(Patient patient) {
		DaoPatient dp = new DaoPatient();
		dp.selectById();
		dp.insert();
		lstAttente.add(patient);
	}

	public String showLstAttente() {
		String res = "";

		for (Patient e : lstAttente) {
			res = "";
		}

		return res;
	}

	public Patient showNextPatient() {
		Patient p = lstAttente.peek();
		System.out.println(p);
	}

}
