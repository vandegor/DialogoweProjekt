package pl.clinic.vxml.schema.abstractImpl;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBElement;
import pl.clinic.vxml.schema.VxmlChild;

public abstract class AbstractVC implements VxmlChild {

	@SuppressWarnings("rawtypes")
	@Override
	public List<VxmlChild> getVxmlChildrens() {
		List<VxmlChild> list = new ArrayList<VxmlChild>();
		for (Object object : getObjectChildrens()) {
			if (object instanceof JAXBElement) {
				if (((JAXBElement) object).getValue() instanceof VxmlChild) {
					list.add((VxmlChild) ((JAXBElement) object).getValue());
				}
			} else if (object instanceof VxmlChild) {
				list.add((VxmlChild) object);
			}
		}
		return list;
	}

	@Override
	public VxmlChild getChildByName(String Name) {
		VxmlChild child = null;
		for (VxmlChild vc : getVxmlChildrens()) {
			child = vc.getChildByName(Name);
			if (child != null)
				break;
		}
		return child;
	}

	@Override
	public VxmlChild getChildById(String id) {
		VxmlChild child = null;
		for (VxmlChild vc : getVxmlChildrens()) {
			child = vc.getChildById(id);
			if (child != null)
				break;
		}
		return child;
	}

	@Override
	public VxmlChild getChildByNameOrId(String value) {
		VxmlChild child = null;
		for (VxmlChild vc : getVxmlChildrens()) {
			child = vc.getChildByNameOrId(value);
			if (child != null)
				break;
		}
		return child;
	}
}
