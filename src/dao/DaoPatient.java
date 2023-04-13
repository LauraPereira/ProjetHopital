package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Patient;

public class DaoPatient {

	public void create(Patient p) throws ClassNotFoundException, SQLException {

		String sql = "insert into patients values (?,?,?,?,?,?)";

		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hopital-obs", "root", "root");

		PreparedStatement ps = conn.prepareStatement(sql);

		ps.setInt(1, p.getId());
		ps.setString(2, p.getNom());
		ps.setString(3, p.getPrenom());
		ps.setInt(4, p.getAge());
		ps.setString(5, p.getTelephone());
		ps.setString(6, p.getAdresse());

		ps.executeUpdate();

		System.out.print("INSERT OK ");
		conn.close();

	}
	
	
	public Patient selectById(int id) throws ClassNotFoundException, SQLException {

		Patient p = null;
		String sql = "select * from patients where id="+id;
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hopital-obs", "root", "root");

		Statement st = conn.createStatement();

		ResultSet rs = st.executeQuery(sql);

		if(rs.next()){
			p = new Patient(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4), rs.getString(5), rs.getString(6));
			
		}
				
		conn.close();
		return p;

	}
	
	public ArrayList<Patient> selectAll() throws ClassNotFoundException, SQLException {

		ArrayList<Patient> liste = new ArrayList<Patient>();
		String sql = "select * from patients";
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hopital-obs", "root", "root");

		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(sql);

		
		while (rs.next()){
			Patient p = new Patient(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6));
			liste.add(p);
		}
		
		conn.close();
		return liste;

	}
	
	public void update(Patient p) throws ClassNotFoundException, SQLException{
		String sql = "update patients set nom='"+p.getNom()+"', prenom='"+p.getPrenom()+"',age="+p.getAge()+" where id="+p.getId();
		Class.forName("com.mysql.jdbc.Driver") ;
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/hopital-obs", "root", "root");

		Statement st = conn.createStatement();
		st.executeUpdate(sql) ;

		System.out.print("UPDATE OK ");
		conn.close();
	}
	
	public void delete(int id) throws ClassNotFoundException, SQLException{
		String sql = "delete from patients where id="+id;
		Class.forName("com.mysql.jdbc.Driver") ;
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/hopital-obs", "root", "root");

		Statement st = conn.createStatement();
		st.executeUpdate(sql) ;

		System.out.print("DELETE OK ");
		conn.close();
	}
	

}
