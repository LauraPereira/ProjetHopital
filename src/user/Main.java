package user;

import java.sql.SQLException;

import model.Hopital;
import model.Patient;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Hopital h = Hopital.getInstance("secretaire");

		Patient p = new Patient(1, "test", "test", 25, "0202020202", "5 rue du test");
		Patient newP = new Patient(2, "test2", "test2", 30);

		h.addPatient(p);
		h.addPatient(newP);
		System.out.println(h.showLstAttente());
		System.out.println(h.showNextPatient());
	}

}
