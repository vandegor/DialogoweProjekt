package pl.clinic.vxml.schema;

import java.util.List;

public interface VxmlChild {

	public List<VxmlChild> getChildrens();

	public NameVC getChildByName(String Name);

	public IdentityVC getChildByIdentity(String identity);

}
