package model;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import dao.DaoVisite;

public class Medecin {

	private String nom;
	private String login;
	private String pwd;
	private int numSalle;

	public Medecin(String nom, String login, String pwd, int numSalle) {
		super();
		this.nom = nom;
		this.login = login;
		this.pwd = pwd;
		this.numSalle = numSalle;
	}

	public void changePatient(Salle salle) {
		Patient p = notifSalleVide();
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Date date = new Date();
		salle.addVisite(new Visite(p.getId(), nom, numSalle, format.format(date).toString()));
	}

	public Patient notifSalleVide() {
		return Hopital.getInstance().notif();
	}

	public void LstVisiteEnBase(Salle salle) throws ClassNotFoundException, SQLException {
		DaoVisite dv = new DaoVisite();

		for (Visite v : salle.getLstVisite()) {
			dv.create(v);
		}

		salle.viderLst();

	}

	public void showLstAttente() {
		Hopital.getInstance().showLstAttente();
	}

}
