package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DaoAuthentification {
	
	public static Boolean selectById(String login, String password) throws ClassNotFoundException, SQLException {

		Boolean connected=false;
		String sql = "select * from authentification where login= '"+login+"' AND password = '"+password+"'" ;
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hopital-obs", "root", "root");

		Statement st = conn.createStatement();

		ResultSet rs = st.executeQuery(sql);

		if(rs.next())
			connected=true;
		else
			connected=false;
		
		return connected;

	}

}
