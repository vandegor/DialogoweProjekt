package pl.clinic.model.abstractImpl;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import pl.clinic.model.ModelInterface;

public abstract class ModelAbstract implements ModelInterface {

	protected String createFieldString(String fieldName, Object fieldValue) {
		return fieldName + "=" + fieldValue.toString() + "\n";
	}

	protected abstract Object getFieldValue(Field field) throws IllegalAccessException, IllegalArgumentException;

	@Override
	public Map<String, Object> getFieldsMap() {
		Map<String, Object> fieldsMap = new HashMap<String, Object>();
		for (Field field : Arrays.asList(getClass().getDeclaredFields())) {
			try {
				if (getFieldValue(field) != null) {
					fieldsMap.put(field.getName(), getFieldValue(field));
				}
			} catch (IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return fieldsMap;
	}

	public Map<String, Object> getFieldsMapWithoutId() {
		Map<String, Object> fieldsMap = getFieldsMap();
		fieldsMap.remove("id");
		return fieldsMap;
	}

}
