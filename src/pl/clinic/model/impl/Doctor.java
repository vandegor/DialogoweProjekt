package pl.clinic.model.impl;

import java.lang.reflect.Field;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import pl.clinic.model.abstractImpl.ModelAbstract;

@DatabaseTable
public class Doctor extends ModelAbstract {

	@DatabaseField(generatedId = true)
	protected Integer id;

	@DatabaseField(canBeNull = false)
	protected String surname;

	@DatabaseField(canBeNull = false)
	protected String name;

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
	protected Object getFieldValue(Field field) throws IllegalAccessException, IllegalArgumentException {
		return field.get(this);
	}
	@Override
	public String toString() {
		return this.surname;
	}

}
