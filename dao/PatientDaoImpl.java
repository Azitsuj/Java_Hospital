package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

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
			String sql = "SELECT idp, pname, surname FROM patient WHERE id = ?";
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);

			ResultSet rs = pstm.executeQuery();

			// Extract data from result set
			if (rs.next()) {
				patient = new PatientDto();
				// Retrieve by column name
				patient.setId(rs.getInt("idp"));
				patient.setName(rs.getString("pname"));
				patient.setSurname(rs.getString("surname"));
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
			sql = "SELECT idp, pname, surname FROM patient";
			ResultSet rs = stmt.executeQuery(sql);

			// Extract data from result set
			while (rs.next()) {
				PatientDto patient = new PatientDto();
				// Retrieve by column name
				patient.setId(rs.getInt("idp"));
				patient.setName(rs.getString("pname"));
				patient.setSurname(rs.getString("surname"));
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
		// TODO Auto-generated method stub

	}

	@Override
	public void update(PatientDto patient) {
		// TODO Auto-generated method stub

	}

	@Override
	public void create(PatientDto patient) {
		// Set response content type
		PreparedStatement pstm = null;
		Connection conn = null;

		try {

			// Open a connection
			conn = DbConnection.getConnection();

			String sql = "INSERT INTO patient (pname, surname) VALUES (?, ?)";
			pstm = conn.prepareStatement(sql);

			pstm.setString(1, patient.getName());
			pstm.setString(2, patient.getSurname());
			pstm.executeUpdate();

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
