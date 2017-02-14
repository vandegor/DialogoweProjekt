package pl.clinic.vxml.schema.abstractImpl;

import pl.clinic.vxml.schema.NameVC;
import pl.clinic.vxml.schema.VxmlChild;

public abstract class AbstractNVC extends AbstractVC implements NameVC {

	public boolean isNameEquals(String name) {
		return getName() == null ? false : getName().equals(name);
	}

	@Override
	public VxmlChild getChildByName(String Name) {
		if (isNameEquals(Name)) {
			return this;
		} else {
			return super.getChildByName(Name);
		}
	}

	@Override
	public VxmlChild getChildByNameOrId(String value) {
		if (isNameEquals(value)) {
			return this;
		} else {
			return super.getChildByNameOrId(value);
		}
	}
}
