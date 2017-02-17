package pl.clinic.model.impl;

import java.lang.reflect.Field;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import pl.clinic.model.abstractImpl.ModelAbstract;

@DatabaseTable
public class Patient extends ModelAbstract {
	@DatabaseField(generatedId = true)
	private Integer id;

	@DatabaseField(canBeNull = false)
	private String surname;

	@DatabaseField(canBeNull = false)
	private String name;

	@DatabaseField(canBeNull = false)
	private Integer password;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPassword() {
		return password;
	}

	public void setPassword(Integer password) {
		this.password = password;
	}

	public Patient() {
		super();
	}

	public Patient(Integer id, String surname, String name, Integer password) {
		super();
		this.id = id;
		this.surname = surname;
		this.name = name;
		this.password = password;
	}
	@Override
	protected Object getFieldValue(Field field) throws IllegalAccessException, IllegalArgumentException {
		return field.get(this);
	}@Override
	public String toString() {
		return this.surname;
	}
}
