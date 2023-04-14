package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Visite;

public class DaoVisite {

	public void create(Visite v) throws ClassNotFoundException, SQLException {

		String sql = "insert into visites values (?,?,?,?,?,?)";

		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hopital-obs", "root", "root");

		PreparedStatement ps = conn.prepareStatement(sql);

		ps.setInt(1, 0);
		ps.setInt(2, v.getIdPatient());
		ps.setString(3, v.getDateVisite());
		ps.setString(4, v.getNomMedecin());
		ps.setInt(5, v.getIdPatient());
		ps.setInt(6, v.getTarif());

		ps.executeUpdate();

		System.out.print("INSERT OK ");
		conn.close();

	}

	public Visite selectById(int id) throws ClassNotFoundException, SQLException {

		Visite v = null;
		String sql = "select * from visites where id=" + id;
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hopital-obs", "root", "root");

		Statement st = conn.createStatement();

		ResultSet rs = st.executeQuery(sql);

		if (rs.next()) {
			v = new Visite(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getString(6));

		}

		conn.close();
		return v;

	}

	public ArrayList<Visite> selectAll() throws ClassNotFoundException, SQLException {

		ArrayList<Visite> listeVisites = new ArrayList<Visite>();
		String sql = "select * from visites";
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hopital-obs", "root", "root");

		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(sql);

		while (rs.next()) {
			Visite v = new Visite(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getString(6));
			listeVisites.add(v);
		}

		conn.close();
		return listeVisites;

	}

	public void update(Visite v) throws ClassNotFoundException, SQLException {
		String sql = "update visites set idpatient='" + v.getIdPatient() + "', date='" + v.getDateVisite()
				+ "',medecin=" + v.getNomMedecin() + "',num-salle=" + v.getNumSalle() + "',tarif=" + v.getTarif();
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hopital-obs", "root", "root");

		Statement st = conn.createStatement();
		st.executeUpdate(sql);

		System.out.print("UPDATE OK ");
		conn.close();
	}

	public void delete(int id) throws ClassNotFoundException, SQLException {
		String sql = "delete from visites where id=" + id;
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hopital-obs", "root", "root");

		Statement st = conn.createStatement();
		st.executeUpdate(sql);

		System.out.print("DELETE OK ");
		conn.close();
	}

}
