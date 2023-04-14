package model;

import dao.DaoPatient;

public class Patient {

	private int id;
	private String nom;
	private String prenom;
	private int age;
	private String telephone;
	private String adresse;

	public Patient(int id, String nom, String prenom, int age) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
	}

	public Patient(int id, String nom, String prenom, int age, String telephone, String adresse) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.telephone = telephone;
		this.adresse = adresse;
	}

	public int getId() {
		return id;
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public int getAge() {
		return age;
	}

	public String getTelephone() {
		return telephone;
	}

	public String getAdresse() {
		return adresse;
	}

	@Override
	public String toString() {
		return  id + "\t" + prenom + "\t" + nom+"\t"+age +"\t"+telephone+"\t"+adresse;
	}

}
