package pl.clinic.vxml.schema.abstractImpl;

import pl.clinic.vxml.schema.IdentityVC;
import pl.clinic.vxml.schema.VxmlChild;

public abstract class AbstractIVC extends AbstractVC implements IdentityVC {

	public boolean isIdEquals(String id) {
		return getId() == null ? false : getId().equals(id);
	}

	@Override
	public VxmlChild getChildById(String id) {
		if (isIdEquals(id)) {
			return this;
		} else {
			return super.getChildById(id);
		}
	}

	@Override
	public VxmlChild getChildByNameOrId(String value) {
		if (isIdEquals(value)) {
			return this;
		} else {
			return super.getChildByNameOrId(value);
		}
	}
}
