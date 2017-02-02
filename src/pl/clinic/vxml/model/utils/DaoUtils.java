package pl.clinic.vxml.model.utils;

import java.sql.SQLException;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import pl.clinic.vxml.model.Doctor;
import pl.clinic.vxml.model.Patient;
import pl.clinic.vxml.model.TimeOfDay;
import pl.clinic.vxml.model.Visit;

public class DaoUtils {
	//public static final String connection = "jdbc:sqlite:C:\\workspaces\\workspace_neon\\Dialogowe\\dialogowe.sqlite";
	public static final String connection = "jdbc:sqlite:D:\\workspace_neon\\DialogoweProjekt\\dialogowe.sqlite";

	private Dao<Patient, Integer> patientDao;
	private Dao<TimeOfDay, Integer> timeOfDayDao;
	private Dao<Doctor, Integer> doctorDao;
	private Dao<Visit, Integer> visitDao;
	private static DaoUtils daoUtils;

	private DaoUtils() throws SQLException {
		patientDao = DaoManager.createDao(getsource(), Patient.class);
		timeOfDayDao = DaoManager.createDao(getsource(), TimeOfDay.class);
		doctorDao = DaoManager.createDao(getsource(), Doctor.class);
		visitDao = DaoManager.createDao(getsource(), Visit.class);
	}

	ConnectionSource getsource() throws SQLException {
		return new JdbcConnectionSource(connection);
	}

	public void createTableIfNotExists() throws SQLException {
		TableUtils.createTableIfNotExists(getsource(), Patient.class);
		TableUtils.createTableIfNotExists(getsource(), TimeOfDay.class);
		TableUtils.createTableIfNotExists(getsource(), Doctor.class);
		TableUtils.createTableIfNotExists(getsource(), Visit.class);
	}

	public void createSampleData() throws SQLException {
		timeOfDayDao.create(new TimeOfDay(null, "morning"));
		timeOfDayDao.create(new TimeOfDay(null, "afternoon"));

		doctorDao.create(new Doctor(null, "Kowalski", "Adam"));
		doctorDao.create(new Doctor(null, "Wisniewski", "Tomek"));
		doctorDao.create(new Doctor(null, "Nowak", "Jakub"));
		doctorDao.create(new Doctor(null, "Zielinski", "Mateusz"));
		doctorDao.create(new Doctor(null, "Lewandowski", "Pawel"));

		patientDao.create(new Patient(null, "Wysokinski", "Adam", 1, 10));
		patientDao.create(new Patient(null, "Szymanowski", "Michal", 2, 11));
	}

	public static DaoUtils getDaoUtils() throws SQLException {
		if (daoUtils == null)
			daoUtils = new DaoUtils();
		return daoUtils;
	}

	public Dao<Patient, Integer> getPatientDao() {
		return patientDao;
	}

	public Dao<TimeOfDay, Integer> getTimeOfDayDao() {
		return timeOfDayDao;
	}

	public Dao<Doctor, Integer> getDoctorDao() {
		return doctorDao;
	}

	public Dao<Visit, Integer> getVisitDao() {
		return visitDao;
	}

}
