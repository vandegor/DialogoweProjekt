package pl.clinic.vxml.schema;

import java.util.List;

public interface VxmlChild {

	public List<VxmlChild> getVxmlChildrens();

	public VxmlChild getChildByName(String Name);

	public VxmlChild getChildById(String identity);

	public VxmlChild getChildByNameOrId(String value);

	public List<Object> getObjectChildrens();

}
