package pl.clinic.vxml.schema.utils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class UnmarshallerUtils {

	private static Unmarshaller unmarshaller;
	private static UnmarshallerUtils UnmarshallerUtils;

	public UnmarshallerUtils() throws JAXBException {
		unmarshaller = JAXBContext.newInstance("pl.clinic.vxml.schema.impl").createUnmarshaller();
	}

	public static Unmarshaller getUnmarshaller() {
		try {
			if (UnmarshallerUtils == null) {
				UnmarshallerUtils = new UnmarshallerUtils();
			}
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return unmarshaller;
	}
}
