package model;

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

	public void changePatient() {
		Patient p = notifSalleVide();
		Visite v1 = new Visite("date", p.getId(), nom, numSalle);
	}

	public Patient notifSalleVide() {
		return Hopital.getInstance("secretaire").notif();
	}

	public void LstVisiteEnBase() {
		createVisite();

		Hopital.getInstance("secretaire").showLstAttente();
	}

	public void showLstAttente() {
		Hopital.getInstance("secretaire").showLstAttente();
	}

}
