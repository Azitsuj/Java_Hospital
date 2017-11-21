package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import dto.DoctorDto;
import util.db.DbConnection;

public class DoctorDaoImpl implements DoctorDao {

	@Override
	public DoctorDto get(Integer id) {
		// Set response content type
		DoctorDto doctor = null;
		PreparedStatement pstm = null;
		Connection conn = null;

		try {

			// Open a connection
			conn = DbConnection.getConnection();

			// Execute SQL query
			String sql = "SELECT idd, dname, surname, specialization FROM doctor WHERE idd = ?";
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);

			ResultSet rs = pstm.executeQuery();

			// Extract data from result set
			if (rs.next()) {
				doctor = new DoctorDto();
				// Retrieve by column name
				doctor.setId(rs.getInt("idd"));
				doctor.setName(rs.getString("dname"));
				doctor.setSurname(rs.getString("surname"));
				doctor.setSpec(rs.getString("specialization"));
			}

			// Clean-up environment
			rs.close();
			pstm.close();
			DbConnection.closeConnection(conn);
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (pstm != null)
					pstm.close();
			} catch (SQLException se2) {
			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try
		return doctor;
	}

	@Override
	public Collection<DoctorDto> getAll() {
		// Set response content type
		Collection<DoctorDto> result = new ArrayList<>();
		Statement stmt = null;
		Connection conn = null;

		try {

			// Open a connection
			conn = DbConnection.getConnection();

			// Execute SQL query
			stmt = conn.createStatement();
			String sql;
			sql = "SELECT idd, dname, surname, specialization FROM doctor";
			ResultSet rs = stmt.executeQuery(sql);

			// Extract data from result set
			while (rs.next()) {
				DoctorDto doctor = new DoctorDto();
				// Retrieve by column name
				doctor.setId(rs.getInt("idd"));
				doctor.setName(rs.getString("dname"));
				doctor.setSurname(rs.getString("surname"));
				doctor.setSpec(rs.getString("specialization"));
				result.add(doctor);
			}

			// Clean-up environment
			rs.close();
			stmt.close();
			DbConnection.closeConnection(conn);
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try
		return result;
	}

	@Override
	public void delete(Integer id) {
		PreparedStatement pstm = null;
		Connection conn = null;

		try {

			// Open a connection
			conn = DbConnection.getConnection();

			// Execute SQL query
			String sql = "DELETE FROM doctor WHERE idd = ?";
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);

			pstm.executeUpdate();
			System.out.println("Usun¹³êœ lekarza o numerze id: " + id);
			// Clean-up environment
			// rs.close();
			pstm.close();
			DbConnection.closeConnection(conn);
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (pstm != null)
					pstm.close();
			} catch (SQLException se2) {
			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try

	}

	@Override
	public void update(DoctorDto doctor) {
		// Set response content type
		PreparedStatement pstm = null;
		Connection conn = null;

		try {

			// Open a connection
			conn = DbConnection.getConnection();

			String sql = "UPDATE doctor SET dname = ?, surname = ?, specialization = ? WHERE idd = ?";
			pstm = conn.prepareStatement(sql);

			pstm.setString(1, doctor.getName());
			pstm.setString(2, doctor.getSurname());
			pstm.setString(3, doctor.getSpec());
			pstm.setInt(4, doctor.getId());

			pstm.executeUpdate();
			System.out.println("Dane lekarza po aktualizacji, id: " + doctor.getId() + ", imiê: " + doctor.getName() + ", nazwisko: " + doctor.getSurname()
					+ ", specjalizacja: " + doctor.getSpec());
			// Clean-up environment
			pstm.close();
			DbConnection.closeConnection(conn);
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (pstm != null)
					pstm.close();
			} catch (SQLException se2) {
			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try

	}

	@Override
	public void create(DoctorDto doctor) {
		// Set response content type
		PreparedStatement pstm = null;
		Connection conn = null;

		try {

			// Open a connection
			conn = DbConnection.getConnection();

			String sql = "INSERT INTO doctor (dname, surname, specialization) VALUES (?, ?, ?)";
			pstm = conn.prepareStatement(sql);

			pstm.setString(1, doctor.getName());
			pstm.setString(2, doctor.getSurname());
			pstm.setString(3, doctor.getSpec());
			pstm.executeUpdate();
			System.out.println("Utworzono nastêpuj¹cego lekarza, imiê: " + doctor.getName() + ", nazwisko: " + doctor.getSurname()
					+ ", specjalizacja: " + doctor.getSpec());
			// Clean-up environment
			pstm.close();
			DbConnection.closeConnection(conn);
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (pstm != null)
					pstm.close();
			} catch (SQLException se2) {
			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try

	}

	@Override
	public Collection<DoctorDto> search(DoctorDto doctortDto) {
		// TODO Auto-generated method stub
		return null;
	}

}
