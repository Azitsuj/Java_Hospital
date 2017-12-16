package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import dao.interf.PatientDao;
import dto.PatientDto;
import util.db.DbConnection;

public class PatientDaoImpl implements PatientDao {

	@Override
	public PatientDto get(Integer id) {
		// Set response content type
		PatientDto patient = null;
		PreparedStatement pstm = null;
		Connection conn = null;

		try {

			// Open a connection
			conn = DbConnection.getConnection();

			// Execute SQL query
			String sql = "SELECT idp, pname, psurname FROM patient WHERE idp = ?";
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);

			ResultSet rs = pstm.executeQuery();

			// Extract data from result set
			if (rs.next()) {
				patient = new PatientDto();
				// Retrieve by column name
				patient.setId(rs.getInt("idp"));
				patient.setName(rs.getString("pname"));
				patient.setSurname(rs.getString("psurname"));
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
		return patient;

	}

	@Override
	public Collection<PatientDto> getAll() {
		// Set response content type
		Collection<PatientDto> result = new ArrayList<>();
		Statement stmt = null;
		Connection conn = null;

		try {

			// Open a connection
			conn = DbConnection.getConnection();

			// Execute SQL query
			stmt = conn.createStatement();
			String sql;
			sql = "SELECT idp, pname, psurname FROM patient";
			ResultSet rs = stmt.executeQuery(sql);

			// Extract data from result set
			while (rs.next()) {
				PatientDto patient = new PatientDto();
				// Retrieve by column name
				patient.setId(rs.getInt("idp"));
				patient.setName(rs.getString("pname"));
				patient.setSurname(rs.getString("psurname"));
				result.add(patient);
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
			String sql = "DELETE FROM patient WHERE idp = ?";
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);

			pstm.executeUpdate();
			System.out.println("Usunąłeś pacjenta o numerze id: " + id);
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
	public void update(PatientDto patient) {
		// Set response content type
		PreparedStatement pstm = null;
		Connection conn = null;

		try {

			// Open a connection
			conn = DbConnection.getConnection();

			String sql = "UPDATE patient SET pname = ?, psurname = ? WHERE idp = ?";
			pstm = conn.prepareStatement(sql);

			pstm.setString(1, patient.getName());
			pstm.setString(2, patient.getSurname());
			pstm.setInt(3, patient.getId());

			pstm.executeUpdate();
			System.out.println("Dane pacjenta po aktualizacji, id: " + patient.getId() + ", imię: " + patient.getName() + ", nazwisko: " + patient.getSurname());
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
	public void create(PatientDto patient) {
		// Set response content type
		PreparedStatement pstm = null;
		Connection conn = null;

		try {

			// Open a connection
			conn = DbConnection.getConnection();

			String sql = "INSERT INTO patient (pname, psurname) VALUES (?, ?)";
			pstm = conn.prepareStatement(sql);

			pstm.setString(1, patient.getName());
			pstm.setString(2, patient.getSurname());
			pstm.executeUpdate();
			System.out.println("Utworzono następującego pacjenta, imię: " + patient.getName() + ", nazwisko: " + patient.getSurname());
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
	public Collection<PatientDto> search(PatientDto patientDto) {
		// TODO Auto-generated method stub
		return null;
	}

}
