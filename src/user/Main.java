package user;

import java.sql.SQLException;

import dao.DaoAuthentification;
import dao.DaoPatient;
import model.Hopital;
import model.Patient;

import java.util.ArrayList;
import java.util.Scanner;

import java.sql.SQLException;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub

		connexion();
//		 secretaire();
//		 medecin(2);
	}

	static void connexion() throws ClassNotFoundException, SQLException {
		Scanner clavierstr = new Scanner(System.in);
		System.out.println("Bienvenue � l'h�pital !\n\n" + "login :");
		String login = clavierstr.nextLine();
		System.out.println("mot de passe :");
		String mdp = clavierstr.nextLine();

		if (DaoAuthentification.checkConnection(login, mdp)) {
			System.out.println("connect�\n\n");
			
			Hopital.getInstance();

			int metier = DaoAuthentification.getMetier(login);

			if (metier == 0) {

				secretaire();
			} else {
				medecin(metier);
			}
		}

		else {
			System.out.println("�chec connexion\n\n");
			connexion();
		}

	}

	static void secretaire() throws ClassNotFoundException, SQLException {
		Scanner clavierint = new Scanner(System.in);
		System.out.println("Bienvenue dans l'interface secr�taire !\n"
				+ "___________________________________________\n\n" + "1 - Ajouter un patient � la liste d'attente\n"
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
		System.out.println("Quel est le num�ro de S�curit� Sociale du patient ?");
		int nss = clavierint.nextInt();
		
		if (Hopital.getInstance().checkPatient(nss)){
			System.out.println("Le patient existe d�j� dans la base de donn�es. Il a �t� ajout� la la liste d'attente");
			secretaire();
		}
		else{
			System.out.println("Le patient n'est pas connu dans la base de donn�es.");
			createPatient(nss);
		}
	}

	static void createPatient(int id) throws ClassNotFoundException, SQLException {
		Scanner clavierstr = new Scanner(System.in);
		Scanner clavierint = new Scanner(System.in);
		System.out.println("Nom :");
		String nom = clavierstr.nextLine();
		System.out.println("Pr�nom :");
		String prenom = clavierstr.nextLine();
		System.out.println("Age :");
		int age = clavierint.nextInt();

		System.out.println("Voulez-vous renseigner le t�l�phone et l'adresse ? o / n");

		String reponse = clavierstr.nextLine();
		System.out.println(reponse);

		if (reponse.equals("o")) {
			System.out.println("reponse o");
			System.out.println("T�l�phone :");
			String tel = clavierstr.nextLine();
			System.out.println("Adresse :");
			String adresse = clavierstr.nextLine();
			
			Patient p = new Patient(id, nom, prenom, age, tel, adresse);
			
			// Ajoute en bdd et � la liste d'attente
			Hopital.getInstance().createPatient(p);
			secretaire();

		}

		else {
			// Ajoute en bdd et � la liste d'attente
			Patient p = new Patient(id, nom, prenom, age);
			Hopital.getInstance().createPatient(p);
			secretaire();
		}

	}
	
	static void showNextPatient() throws ClassNotFoundException, SQLException {
		System.out.println("N�SS\tNom\tPr�nom\tAge\tT�l\tAdresse\n");
		System.out.println(Hopital.getInstance().showNextPatient());
		secretaire();
	}

	
	static void showLine(int metier) throws ClassNotFoundException, SQLException{
		System.out.println(Hopital.getInstance().showLstAttente());
		
		// On renvoie vers l'interface secr�taire ou m�decin en fonction
		// Du m�tier pass� en param�tre
		if (metier == 0){
			secretaire();
		}
		else{
			medecin(metier);
		}
		
	}
	
	
	static void medecin(int metier) throws ClassNotFoundException, SQLException {
		Scanner clavierint = new Scanner(System.in);
		System.out.println("Bienvenue dans l'interface m�decin !\n" + "___________________________________________\n\n"
				+ "1 - Lib�rer la salle\n" + "2 - Afficher la liste d'attente\n"
				+ "3 - Sauvegarder la liste des visites dans la BDD\n" + "4 - Revenir au menu de connexion\n\n"
				+ "Veuillez entrer votre choix");
		int choix = clavierint.nextInt();

		switch (choix) {
		case 1:
			// A coder
			// freeRoom();
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

	// ! Ici on r�cup�re la liste des patients en BDD mais pas la liste des
	// patients en file d'attente
	// static void showList() throws ClassNotFoundException, SQLException {
	//
	// System.out.println("Id\tNom\tPr�nom\tAge\tT�l�phone\tAdresse\n");
	// ArrayList<Patient> reponse = new DaoPatient().selectAll();
	// for (Patient p : reponse)
	// System.out.println(p.getId() + "\t" + p.getNom() + "\t" + p.getPrenom() +
	// "\t" + p.getAge() + "\t"
	// + p.getTelephone() + "\t" + p.getAdresse());
	//
	// }

}
