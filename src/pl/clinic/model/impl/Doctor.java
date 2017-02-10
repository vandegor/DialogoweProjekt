package pl.clinic.model.impl;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import pl.clinic.model.ModelInterface;

@DatabaseTable
public class Doctor implements ModelInterface {

	@DatabaseField(generatedId = true)
	private Integer id;

	@DatabaseField(canBeNull = false)
	private String surname;

	@DatabaseField(canBeNull = false)
	private String name;

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

	public Doctor() {
		super();
	}

	public Doctor(Integer id, String surname, String name) {
		super();
		this.id = id;
		this.surname = surname;
		this.name = name;
	}

	@Override
	public String toString() {
		return surname.toString();
	}
}