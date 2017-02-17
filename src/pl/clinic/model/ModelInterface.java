package pl.clinic.model;

import java.util.Map;

public interface ModelInterface {

	public abstract Map<String, Object> getFieldsMap();

	public abstract Map<String, Object> getFieldsMapWithoutId();

	public abstract Integer getId();

}
