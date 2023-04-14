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

	public void changePatient(Salle salle) throws ClassNotFoundException, SQLException {
		Patient p = notifSalleVide();
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Date date = new Date();
		Visite v = new Visite(p.getId(), nom, numSalle, format.format(date).toString());
		salle.addVisite(v);
		v.saveLstVisite(salle);
	}

	public Patient notifSalleVide() {
		return Hopital.getInstance().notif();
	}

	public String LstVisiteEnBase(Salle salle) throws ClassNotFoundException, SQLException {
		DaoVisite dv = new DaoVisite();
		String res = "Liste des patients envoyés en base de donnée : \n";

		if (salle.getLstVisite().size() != 0) {
			for (Visite v : salle.getLstVisite()) {
				dv.create(v);
				res += v + "\n";
			}
			salle.viderLst();
			return res;
		} else {
			return "vide";
		}
	}

	public String showLstAttente() {
		return Hopital.getInstance().showLstAttente();
	}

}
