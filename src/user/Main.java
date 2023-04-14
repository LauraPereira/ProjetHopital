package user;

import java.sql.SQLException;

import dao.DaoAuthentification;
import dao.DaoPatient;
import model.Hopital;
import model.Patient;
import model.Visite;

import java.util.ArrayList;
import java.util.Scanner;

import java.sql.SQLException;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub

		connexion();
		// secretaire();
		// medecin(2);
	}

	static void connexion() throws ClassNotFoundException, SQLException {
		Scanner clavierstr = new Scanner(System.in);
		System.out.println("Bienvenue à l'hôpital !\n\n" + "login :");
		String login = clavierstr.nextLine();
		System.out.println("mot de passe :");
		String mdp = clavierstr.nextLine();

		if (DaoAuthentification.checkConnection(login, mdp)) {
			System.out.println("connecté\n\n");

			Hopital.getInstance();

			int metier = DaoAuthentification.getMetier(login);

			if (metier == 0) {

				secretaire();
			} else {
				medecin(metier);
			}
		}

		else {
			System.out.println("échec connexion\n\n");
			connexion();
		}

	}

	static void secretaire() throws ClassNotFoundException, SQLException {
		Scanner clavierint = new Scanner(System.in);
		System.out.println("Bienvenue dans l'interface secrétaire !\n"
				+ "___________________________________________\n\n" + "1 - Ajouter un patient à la liste d'attente\n"
				+ "2 - Afficher la liste d'attente\n" + "3 - Afficher le prochain patient de la liste d'attente\n"
				+ "4 - Revenir au menu de connexion\n\n" + "Veuillez entrer votre choix");
		int choix = clavierint.nextInt();

		switch (choix) {
		case 1:

			checkPatient();
			break;
		case 2:
			showLine(0);
			break;
		case 3:
			showNextPatient();
			break;
		case 4:
			connexion();
		}
	}

	static void checkPatient() throws ClassNotFoundException, SQLException {
		Scanner clavierint = new Scanner(System.in);
		System.out.println("Quel est le numéro de Sécurité Sociale du patient ?");
		int nss = clavierint.nextInt();

		if (Hopital.getInstance().checkPatient(nss)) {
			System.out.println("Le patient existe déjà dans la base de données. Il a été ajouté la la liste d'attente");
			secretaire();
		} else {
			System.out.println("Le patient n'est pas connu dans la base de données.");
			createPatient(nss);
		}
	}

	static void createPatient(int id) throws ClassNotFoundException, SQLException {
		Scanner clavierstr = new Scanner(System.in);
		Scanner clavierint = new Scanner(System.in);
		System.out.println("Nom :");
		String nom = clavierstr.nextLine();
		System.out.println("Prénom :");
		String prenom = clavierstr.nextLine();
		System.out.println("Age :");
		int age = clavierint.nextInt();

		System.out.println("Voulez-vous renseigner le téléphone et l'adresse ? o / n");

		String reponse = clavierstr.nextLine();
		System.out.println(reponse);

		if (reponse.equals("o")) {
			System.out.println("reponse o");
			System.out.println("Téléphone :");
			String tel = clavierstr.nextLine();
			System.out.println("Adresse :");
			String adresse = clavierstr.nextLine();

			Patient p = new Patient(id, nom, prenom, age, tel, adresse);

			// Ajoute en bdd et à la liste d'attente
			Hopital.getInstance().createPatient(p);
			secretaire();

		}

		else {
			// Ajoute en bdd et à la liste d'attente
			Patient p = new Patient(id, nom, prenom, age);
			Hopital.getInstance().createPatient(p);
			secretaire();
		}

	}

	static void showNextPatient() throws ClassNotFoundException, SQLException {
		// ! A coder
		// System.out.println("Nombre de patients dans la file d'attente :");
		System.out.println("N°SS\tNom\tPrénom\tAge\tTél\tAdresse\n");
		System.out.println(Hopital.getInstance().showNextPatient());
		secretaire();
	}

	static void showLine(int metier) throws ClassNotFoundException, SQLException {
		System.out.println(Hopital.getInstance().showLstAttente());

		// On renvoie vers l'interface secrétaire ou médecin en fonction
		// Du métier passé en paramètre
		if (metier == 0) {
			secretaire();
		} else {
			medecin(metier);
		}

	}

	static void medecin(int metier) throws ClassNotFoundException, SQLException {
		Scanner clavierint = new Scanner(System.in);
		System.out.println("Bienvenue dans l'interface médecin " + metier
				+ " !\n___________________________________________\n\n" + "1 - Libérer la salle\n"
				+ "2 - Afficher la liste d'attente\n" + "3 - Sauvegarder la liste des visites dans la BDD\n"
				+ "4 - Revenir au menu de connexion\n\n" + "Veuillez entrer votre choix");
		int choix = clavierint.nextInt();

		switch (choix) {
		case 1:
			// A coder
			freeRoom(metier);
			break;
		case 2:
			showLine(metier);
			break;
		case 3:
			// A coder
			// saveVisitsList();
		case 4:
			connexion();
		}
	}

	static void freeRoom(int medecin) {
		// On notif que la salle est libre
		
		// On récupère l'id du prochain patient sur la liste
		Patient p = Hopital.getInstance().showNextPatient();
		int idP = p.getId();
		
		// On récupère infos médecin : nom
//		String nomM = 
		
		// On crée une visite
//		Visite v = new Visite (idP, );
		
		// On ajoute la visite à la liste
		
		//
	}

}
