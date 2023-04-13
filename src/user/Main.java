package user;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		connexion();
	}

	static void connexion() {
		Scanner clavierstr = new Scanner(System.in);
		System.out.println("Bienvenue à l'hôpital !\n\n" + "login :");
		String login = clavierstr.nextLine();
		System.out.println("mot de passe :");
		String mdp = clavierstr.nextLine();
	}

	static void secretaire() {
		Scanner clavierint = new Scanner(System.in);
		System.out.println("Bienvenue dans l'interface secrétaire !\n\n" + "______________________________\n"
				+ "1 - Ajouter un patient à la liste d'attente\n" + "2 - Afficher la liste d'attente\n"
				+ "3 - Afficher le prochain patient de la liste d'attente\n" + "4 - Revenir au menu de connexion\n\n"
						+ "Veuillez entrer votre choix");
		int choix = clavierint.nextInt();

		switch (choix) {
		case 1:
			// (laura ok)checkPatient()
			// (laura ok) createPatient()
			// (laura ok) addPatientToList()
		case 2:
			// A coder
			// laura ok showList();
		case 3:
			// A coder
			// laura ok showNextPatient();
		case 4:
			connexion();
		}
	}
		
		
		static void medecin() {
			Scanner clavierint = new Scanner(System.in);
			System.out.println("Bienvenue dans l'interface médecin !\n\n" + "______________________________\n"
					+ "1 - Libérer la salle\n" + "2 - Afficher la liste d'attente\n"
					+ "3 - Sauvegarder la liste des visites dans la BDD\n" + "4 - Revenir au menu de connexion\n\n"
						+ "Veuillez entrer votre choix");
			int choix = clavierint.nextInt();

			switch (choix) {
			case 1:
				// A coder
				// freeRoom();
			case 2:
				// A coder
				// showList();
			case 3:
				// A coder
				// saveVisitsList();
			case 4:
				connexion();
			}

	}

}
