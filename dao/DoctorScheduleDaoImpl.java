package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import dao.interf.DoctorScheduleDao;
import dto.DoctorScheduleDto;
import util.db.DbConnection;

public class DoctorScheduleDaoImpl implements DoctorScheduleDao {

	@Override
	public DoctorScheduleDto get(Integer id) {
		// Set response content type
		DoctorScheduleDto schedule = null;
		PreparedStatement pstm = null;
		Connection conn = null;

		try {

			// Open a connection
			conn = DbConnection.getConnection();

			// Execute SQL query
			String sql = "SELECT idds, doctor.idd, doctor.dname, doctor.dsurname, dday, dtime_start, dtime_end specialization FROM doctor_schedule NATURAL JOIN "
					+ "doctor USING(idd) WHERE idds = ?";
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);

			ResultSet rs = pstm.executeQuery();

			// Extract data from result set
			if (rs.next()) {
				schedule = new DoctorScheduleDto();
				// Retrieve by column name
				schedule.setId(rs.getInt("idds"));
				schedule.setDay(rs.getString("dday"));
				schedule.setStart(rs.getString("dtime_start"));
				schedule.getDoctor().setId(rs.getInt("doctor.idd"));
				schedule.getDoctor().setName(rs.getString("doctor.dname"));
				schedule.getDoctor().setSurname(rs.getString("doctor.dsurname"));
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
		return schedule;
	}

	@Override
	public Collection<DoctorScheduleDto> getAll() {
		// Set response content type
		Collection<DoctorScheduleDto> result = new ArrayList<>();
		Statement stmt = null;
		Connection conn = null;

		try {

			// Open a connection
			conn = DbConnection.getConnection();

			// Execute SQL query
			stmt = conn.createStatement();
			String sql;
			sql = "SELECT idds, doctor.idd, doctor.dname, doctor.dsurname, dday, dtime_start, dtime_end FROM doctor_schedule JOIN "
					+ "doctor USING(idd)";
			ResultSet rs = stmt.executeQuery(sql);

			// Extract data from result set
			while (rs.next()) {
				DoctorScheduleDto schedule = new DoctorScheduleDto();
				// Retrieve by column name
				schedule.setId(rs.getInt("idds"));
				schedule.setDay(rs.getString("dday"));
				schedule.setStart(rs.getString("dtime_start"));
				schedule.setEnd(rs.getString("dtime_end"));
				schedule.getDoctor().setId(rs.getInt("doctor.idd"));
				schedule.getDoctor().setName(rs.getString("doctor.dname"));
				schedule.getDoctor().setSurname(rs.getString("doctor.dsurname"));
				result.add(schedule);
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
		// Set response content type
		PreparedStatement pstm = null;
		Connection conn = null;

		try {

			// Open a connection
			conn = DbConnection.getConnection();

			// Execute SQL query
			String sql = "DELETE FROM doctor_schedule WHERE idds = ?";
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);

			pstm.executeUpdate();
			System.out.println("Usun¹³êœ dy¿ur o numerze id: " + id);
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
	public void update(DoctorScheduleDto schedule) {
		// Set response content type
		PreparedStatement pstm = null;
		Connection conn = null;

		try {

			// Open a connection
			conn = DbConnection.getConnection();

			String sql = "UPDATE doctor_schedule SET idd = ?, dday = ?, dtime_start = ?, dtime_end = ? WHERE idds = ?";
			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, schedule.getDoctor().getId());
			pstm.setString(2, schedule.getDay());
			pstm.setString(3, schedule.getStart());
			pstm.setString(4, schedule.getEnd());
			pstm.setInt(5, schedule.getId());

			pstm.executeUpdate();
			System.out.println("Dane dy¿uru po aktualizacji, id: " + schedule.getId() + ", imiê lekarza: " + schedule.getDoctor().getName()
					+ ", nazwisko lekarza: " + schedule.getDoctor().getSurname() + ", dnia: " + schedule.getDay() + ", pocz¹tek: " + schedule.getStart()
					+ ", koniec: " + schedule.getEnd());
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
	public void create(DoctorScheduleDto schedule) {
		// Set response content type
		PreparedStatement pstm = null;
		Connection conn = null;

		try {

			// Open a connection
			conn = DbConnection.getConnection();

			String sql = "INSERT INTO doctor_schedule (idd, dday, dtime_start, dtime_end) VALUES (?, ?, ?, ?)";
			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, schedule.getDoctor().getId());
			pstm.setString(2, schedule.getDay());
			pstm.setString(3, schedule.getStart());
			pstm.setString(4, schedule.getEnd());
			pstm.executeUpdate();
			System.out.println("Utworzono nastêpuj¹cy dy¿ur, imiê lekarza: " + schedule.getDoctor().getName() + ", nazwisko lekarza: " + schedule.getDoctor().getSurname()
					+ ", specjalizacja: " + schedule.getDoctor().getSpec() + ", dnia: " + schedule.getDay() + ", pocz¹tek: " + schedule.getStart()
					+ ", koniec: " + schedule.getEnd());
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
	public Collection<DoctorScheduleDto> search(DoctorScheduleDto scheduleDto) {
		// TODO Auto-generated method stub
		return null;
	}

}
