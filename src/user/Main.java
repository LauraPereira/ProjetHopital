package user;

import java.sql.SQLException;

import dao.DaoAuthentification;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		test1();
	}
	
	static void test1() throws ClassNotFoundException, SQLException
	{
		
		if(DaoAuthentification.selectById("Med1", "psw"))
			System.out.println("connecté");
		else
			System.out.println("échec connexion");
	}

}
