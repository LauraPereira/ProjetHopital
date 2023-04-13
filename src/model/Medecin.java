package model;

import java.sql.SQLException;

import dao.DaoVisite;

public class Medecin {

	private String nom;
	private String login;
	private String pwd;

	public Medecin(String nom, String login, String pwd, int numSalle) {
		super();
		this.nom = nom;
		this.login = login;
		this.pwd = pwd;
		this.numSalle = numSalle;
	}

	public void changePatient(Salle salle) {
		Patient p = notifSalleVide();
		salle.addVisite(new Visite(p.getId(), nom, numSalle, "date"));
	}

	public Patient notifSalleVide() {
		return Hopital.getInstance("secretaire").notif();
	}

	public void LstVisiteEnBase(Salle salle) throws ClassNotFoundException, SQLException {
		DaoVisite dv = new DaoVisite();

		for (Visite v : salle.getLstVisite()) {
			dv.create(v);
		}

	}

	public void showLstAttente() {
		Hopital.getInstance("secretaire").showLstAttente();
	}

}
