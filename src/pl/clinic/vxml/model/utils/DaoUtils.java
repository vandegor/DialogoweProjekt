package pl.clinic.vxml.model.utils;

import java.sql.SQLException;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import pl.clinic.vxml.model.impl.Doctor;
import pl.clinic.vxml.model.impl.Patient;
import pl.clinic.vxml.model.impl.TimeOfDay;
import pl.clinic.vxml.model.impl.Visit;

public class DaoUtils {
	public static final String connection = "jdbc:sqlite:" + ProjectURL.getProjectURL("dialogowe.sqlite");

	private static Dao<Patient, Integer> patientDao;
	private static Dao<TimeOfDay, Integer> timeOfDayDao;
	private static Dao<Doctor, Integer> doctorDao;
	private static Dao<Visit, Integer> visitDao;

	static {
		new DaoUtils();
	}

	private DaoUtils() {
		try {
			patientDao = DaoManager.createDao(getsource(), Patient.class);
			timeOfDayDao = DaoManager.createDao(getsource(), TimeOfDay.class);
			doctorDao = DaoManager.createDao(getsource(), Doctor.class);
			visitDao = DaoManager.createDao(getsource(), Visit.class);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static ConnectionSource getsource() throws SQLException {
		return new JdbcConnectionSource(connection);
	}

	public static void createTableIfNotExists() throws SQLException {
		TableUtils.createTableIfNotExists(getsource(), Patient.class);
		TableUtils.createTableIfNotExists(getsource(), TimeOfDay.class);
		TableUtils.createTableIfNotExists(getsource(), Doctor.class);
		TableUtils.createTableIfNotExists(getsource(), Visit.class);
	}

	public static void createSampleData() throws SQLException {
		timeOfDayDao.create(new TimeOfDay(null, "morning"));
		timeOfDayDao.create(new TimeOfDay(null, "afternoon"));

		doctorDao.create(new Doctor(null, "Kowalski", "Adam"));
		doctorDao.create(new Doctor(null, "Wisniewski", "Tomek"));
		doctorDao.create(new Doctor(null, "Nowak", "Jakub"));
		doctorDao.create(new Doctor(null, "Zielinski", "Mateusz"));
		doctorDao.create(new Doctor(null, "Lewandowski", "Pawel"));

		patientDao.create(new Patient(null, "Wysokinski", "Adam", 10));
		patientDao.create(new Patient(null, "Szymanowski", "Michal", 11));
	}

	public static Dao<Patient, Integer> getPatientDao() {
		return patientDao;
	}

	public static Dao<TimeOfDay, Integer> getTimeOfDayDao() {
		return timeOfDayDao;
	}

	public static Dao<Doctor, Integer> getDoctorDao() {
		return doctorDao;
	}

	public static Dao<Visit, Integer> getVisitDao() {
		return visitDao;
	}

}
