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

	public static Hopital getInstance() {
		if (instance == null) {
			instance = new Hopital("toto");
		}
		return instance;
	}

	public static LinkedList<Patient> getLstAttente() {
		return lstAttente;
	}

	public void addPatient(Patient patient) throws ClassNotFoundException, SQLException {

		lstAttente.add(patient);

	}

	public boolean checkPatient(int id) throws ClassNotFoundException, SQLException {
		boolean res = true;
		DaoPatient dp = new DaoPatient();

		if (dp.selectById(id) == null) {
			res = false;
		} else {

			this.addPatient(dp.selectById(id));
			res = true;
		}
		return res;
	}

	public void createPatient(Patient patient) throws ClassNotFoundException, SQLException {
		// Crée en BDD
		DaoPatient dp = new DaoPatient();
		dp.create(patient);
		// Ajoute à la liste d'attente
		this.addPatient(patient);
	}

	public String showLstAttente() {
		String res = "N°SS\tNom\tPrénom\tAge\tTél\tAdresse\n";
		// System.out.println(lstAttente.size());
		int i = 0;

		for (Patient e : lstAttente) {
			res += e + "\n";
			i++;
		}

		return res += "Nombre de patient en attente : " + i;
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
