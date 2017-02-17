package pl.clinic.model.impl;

import java.lang.reflect.Field;
import java.util.Date;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import pl.clinic.model.abstractImpl.ModelAbstract;

@DatabaseTable
public class Visit extends ModelAbstract {
	@DatabaseField(generatedId = true)
	private Integer id;

	@DatabaseField(canBeNull = false, foreign = true)
	private TimeOfDay time;

	@DatabaseField(canBeNull = false, foreign = true)
	private Patient patient;

	@DatabaseField(canBeNull = false, foreign = true)
	private Doctor doctor;

	@DatabaseField(canBeNull = false)
	private Date date;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TimeOfDay getTime() {
		return time;
	}

	public void setTime(TimeOfDay time) {
		this.time = time;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Visit() {
		super();
	}

	public Visit(Integer id, TimeOfDay time, Patient patient, Doctor doctor, Date date) {
		super();
		this.id = id;
		this.time = time;
		this.patient = patient;
		this.doctor = doctor;
		this.date = date;
	}
	@Override
	protected Object getFieldValue(Field field) throws IllegalAccessException, IllegalArgumentException {
		return field.get(this);
	}
}
