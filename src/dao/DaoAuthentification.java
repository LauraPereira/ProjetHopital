package dao;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;


public class DaoAuthentification {
	
	public static boolean selectById(String login, String password) throws ClassNotFoundException, SQLException {

		boolean connected=false;
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
