package model;

import java.sql.SQLException;
import java.util.LinkedList;

import dao.DaoPatient;

public class Hopital {

	private static Hopital instance;
	private String secretaire;
	private static LinkedList<Patient> lstAttente = new LinkedList<Patient>();

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

	public static LinkedList<Patient> getLstAttente() {
		return lstAttente;
	}

	public void addPatient(Patient patient) throws ClassNotFoundException, SQLException {

		lstAttente.add(patient);
		System.out.println("patient ajouter");
	}

	public boolean checkPatient(Patient patient) throws ClassNotFoundException, SQLException {
		boolean res = true;
		DaoPatient dp = new DaoPatient();

		if (dp.selectById(patient.getId()) == null) {
			res = false;
		} else {
			this.addPatient(patient);
			res = true;
		}
		return res;
	}

	public void createPatient(Patient patient) throws ClassNotFoundException, SQLException {
		this.addPatient(patient);
	}

	public String showLstAttente() {
		String res = "";

		for (Patient e : lstAttente) {
			res += e + "\n";
		}

		return res;
	}

	public Patient showNextPatient() {
		Patient p = lstAttente.peek();

		return p;
	}

	public Patient notif() {
		Patient p = lstAttente.poll();
		return p;
	}

}
