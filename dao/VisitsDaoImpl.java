package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import dao.interf.VisitsDao;
import dto.DoctorDto;
import dto.VisitsDto;
import util.db.DbConnection;
import util.tools.Tools;

public class VisitsDaoImpl implements VisitsDao {

	String startDateString, endDateString;
	DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");

	@Override
	public void createBlank(VisitsDto visit, int minutes, Date startDate, Date endDate) {
		// Set response content type
		PreparedStatement pstm = null;
		Connection conn = null;
		try {

			// Open a connection
			conn = DbConnection.getConnection();
			int visitsNumber = minutes / 10;
			for (int i = 1; i <= visitsNumber; i++) {
				String sql = "INSERT INTO visits (idd, idp, vtime_start, vtime_end) VALUES (?, ?, ?, ?)";
				pstm = conn.prepareStatement(sql);
				pstm.setInt(1, visit.getDoctor().getId());
				pstm.setNull(2, Types.INTEGER);
				pstm.setString(3, visit.getVisit_start());
				// Czas trwania jednej wizyty to 10 minut:
				endDateString = df.format(Tools.addMinutesToDate(10, startDate));
				visit.setVisit_end(endDateString);
				pstm.setString(4, visit.getVisit_end());
				// Dodanie 10 minut do daty pocz�tkowej dla kolejnej wizyty:
				startDate = Tools.addMinutesToDate(10, df.parse(visit.getVisit_start()));
				visit.setVisit_start(df.format(startDate));
				pstm.executeUpdate();
			}
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
	public void create(VisitsDto visit) {
		// Set response content type
		PreparedStatement pstm = null;
		Connection conn = null;

		try {
			// Open a connection
			conn = DbConnection.getConnection();
			// Execute SQL query
			String sql = "UPDATE visits SET idp = ? WHERE idd = ? AND vtime_start >= ? AND vtime_end <= ?";
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, visit.getPatient().getId());
			pstm.setInt(2, visit.getDoctor().getId());
			pstm.setString(3, visit.getVisit_start());
			pstm.setString(4, visit.getVisit_end());
			pstm.executeUpdate();
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
	public Collection<DoctorDto> search(VisitsDto visitDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateBlank(VisitsDto visit, int minutes, Date startDateOld, Date endDateOld, Date startDate, Date endDate) {
		Integer id = visit.getDoctor().getId();
		deleteSet(id, startDateOld, endDateOld);
		createBlank(visit, minutes, startDate, endDate);
	}

	@Override
	public void deleteSet(Integer id, Date startDateOld, Date endDateOld) {
		// Set response content type
		PreparedStatement pstm = null;
		Connection conn = null;

		try {
			// Open a connection
			conn = DbConnection.getConnection();
			// Execute SQL query
			String sql = "DELETE FROM visits WHERE idd = ? AND vtime_start >= ? AND vtime_end <= ?";
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			pstm.setString(2, df.format(startDateOld));
			pstm.setString(3, df.format(endDateOld));
			pstm.executeUpdate();
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
	public Collection<VisitsDto> getPatientsVisit() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Integer id) {
		// Set response content type
		PreparedStatement pstm = null;
		Connection conn = null;

		try {
			// Open a connection
			conn = DbConnection.getConnection();
			// Execute SQL query
			String sql = "UPDATE visits SET idp = null WHERE idv = ?";
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			pstm.executeUpdate();
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
	public Collection<VisitsDto> getDoctorVisit(Integer id) {
		// Set response content type
		Collection<VisitsDto> result = new ArrayList<>();
		PreparedStatement pstm = null;
		Connection conn = null;

		try {
			// Open a connection
			conn = DbConnection.getConnection();
			// Execute SQL query
			String sql;
			sql = "SELECT idv, idd, doctor.dname, doctor.dsurname, doctor.specialization, idp, patient.pname, patient.psurname, "
					+ "vtime_start, vtime_end FROM visits JOIN " + "doctor USING(idd) LEFT JOIN patient USING(idp) WHERE idd = ? ORDER BY vtime_start";
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			ResultSet rs = pstm.executeQuery();
			// Extract data from result set
			while (rs.next()) {
				VisitsDto visit = new VisitsDto();
				// Retrieve by column name
				visit.setId(rs.getInt("idv"));
				visit.setVisit_start(rs.getString("vtime_start"));
				visit.setVisit_end(rs.getString("vtime_end"));
				visit.getDoctor().setId(rs.getInt("idd"));
				visit.getDoctor().setName(rs.getString("dname"));
				visit.getDoctor().setSurname(rs.getString("dsurname"));
				visit.getDoctor().setSpec(rs.getString("specialization"));
				visit.getPatient().setId(rs.getInt("idp"));
				if (rs.getString("pname") == null) {
					visit.getPatient().setName("\\wolny/");
				} else {
					visit.getPatient().setName(rs.getString("pname"));
				}
				if (rs.getString("psurname") == null) {
					visit.getPatient().setSurname("\\termin/");
				} else {
					visit.getPatient().setSurname(rs.getString("psurname"));
				}
				result.add(visit);
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
		return result;
	}

}
