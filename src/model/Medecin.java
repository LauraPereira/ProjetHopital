package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
		salle.addVisite(new Visite(p.getId(), nom, numSalle, "date"));
	}

	public Patient notifSalleVide() {
		return Hopital.getInstance().notif();
	}

	public void LstVisiteEnBase(Salle salle) throws ClassNotFoundException, SQLException {
		DaoVisite dv = new DaoVisite();

		for (Visite v : salle.getLstVisite()) {
			dv.create(v);
		}

	}

	public void showLstAttente() {
		Hopital.getInstance().showLstAttente();
	}

}
