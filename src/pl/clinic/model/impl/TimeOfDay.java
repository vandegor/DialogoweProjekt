package pl.clinic.model.impl;

import java.lang.reflect.Field;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import pl.clinic.model.abstractImpl.ModelAbstract;

@DatabaseTable
public class TimeOfDay extends ModelAbstract {
	@DatabaseField(generatedId = true)
	private Integer id;

	@DatabaseField(canBeNull = false)
	private String name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public TimeOfDay() {
		super();
	}

	public TimeOfDay(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	@Override
	protected Object getFieldValue(Field field) throws IllegalAccessException, IllegalArgumentException {
		return field.get(this);
	}
	@Override
	public String toString() {
		return this.name;
	}
}
