package pl.clinic.rest;

import java.io.File;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import pl.clinic.model.ModelInterface;
import pl.clinic.model.impl.Doctor;
import pl.clinic.model.impl.Patient;
import pl.clinic.model.impl.TimeOfDay;
import pl.clinic.model.impl.Visit;
import pl.clinic.model.utils.DaoUtils;
import pl.clinic.model.utils.ProjectURL;
import pl.clinic.vxml.schema.impl.Field;
import pl.clinic.vxml.schema.impl.Form;
import pl.clinic.vxml.schema.impl.Var;
import pl.clinic.vxml.schema.impl.Vxml;
import pl.clinic.vxml.schema.utils.UnmarshallerUtils;
import pl.clinic.vxml.schema.utils.VxmlBuilder;

public class ClinicRestImpl {

	private static Unmarshaller unmarshaller = UnmarshallerUtils.getUnmarshaller();

	public Vxml main() throws MalformedURLException, JAXBException, SQLException {
		Vxml vxml = (Vxml) unmarshaller.unmarshal(new File(ProjectURL.getProjectURL("main.xml")));
		return vxml;
	}

	public Response insertVisit(Integer patientId, Integer doctorId, String date, Integer timeOfDayId)
			throws MalformedURLException, JAXBException, SQLException, ParseException {
		Vxml vxml = (Vxml) unmarshaller.unmarshal(new File(ProjectURL.getProjectURL("insertVisit.xml")));
		Form form = (Form) vxml.getDataOrCatchOrHelp().get(0);
		Var insertVisit = (Var) form.getCatchOrHelpOrNoinput().get(0);

		Patient patient = DaoUtils.getPatientDao().queryForId(patientId);
		Doctor doctor = DaoUtils.getDoctorDao().queryForId(doctorId);
		Date visitDate = new SimpleDateFormat("yyyyMMdd").parse(date);
		TimeOfDay timeOfDay = DaoUtils.getTimeOfDayDao().queryForId(timeOfDayId);

		Visit visit = new Visit(null, timeOfDay, patient, doctor, visitDate);
		DaoUtils.getVisitDao().create(visit);

		insertVisit.setExpr(visit.getId().toString());

		return Response.ok(vxml, MediaType.TEXT_XML).build();
	}

	public Response deleteVisit(Integer patientId) throws MalformedURLException, JAXBException, SQLException {
		return Response.ok().build();
	}

	public Response selectDoctor(Integer patientId) throws MalformedURLException, JAXBException, SQLException {

		Vxml vxml = (Vxml) unmarshaller.unmarshal(new File(ProjectURL.getProjectURL("selectDoctor.xml")));
		Form form = (Form) vxml.getDataOrCatchOrHelp().get(0);
		Field field = (Field) form.getCatchOrHelpOrNoinput().get(0);

		List<ModelInterface> surnames = new ArrayList<ModelInterface>(DaoUtils.getDoctorDao().queryForAll());
		List<ModelInterface> surnamesWithDot = new ArrayList<ModelInterface>(DaoUtils.getDoctorDao().queryForAll());

		field.getContent().add(VxmlBuilder.buildVxmlSpeak("Please provide doctor Name for visit.", surnamesWithDot));
		field.getContent().add(VxmlBuilder.buildGrammar(field.getName(), surnames));

		return Response.ok(vxml, MediaType.TEXT_XML).build();
	}

	public Response selectTime(Integer patientId) throws MalformedURLException, JAXBException, SQLException {

		Vxml vxml = (Vxml) unmarshaller.unmarshal(new File(ProjectURL.getProjectURL("selectTime.xml")));
		Form form = (Form) vxml.getDataOrCatchOrHelp().get(0);
		Field field = (Field) form.getCatchOrHelpOrNoinput().get(0);

		List<ModelInterface> times = new ArrayList<ModelInterface>(DaoUtils.getTimeOfDayDao().queryForAll());
		List<ModelInterface> timesWithDot = new ArrayList<ModelInterface>(DaoUtils.getTimeOfDayDao().queryForAll());

		field.getContent().add(VxmlBuilder.buildVxmlSpeak("Please provide time for visit.", timesWithDot));
		field.getContent().add(VxmlBuilder.buildGrammar(field.getName(), times));

		return Response.ok(vxml, MediaType.TEXT_XML).build();
	}

	public Response selectDate(Integer patientId) throws MalformedURLException, JAXBException, SQLException {
		Vxml vxml = (Vxml) unmarshaller.unmarshal(new File(ProjectURL.getProjectURL("selectDate.xml")));
		return Response.ok(vxml, MediaType.TEXT_XML).build();
	}

	public Response selectVisit(Integer patientId) throws MalformedURLException, JAXBException, SQLException {
		Vxml vxml = (Vxml) unmarshaller.unmarshal(new File(ProjectURL.getProjectURL("selectVisit.xml")));
		return Response.ok(vxml, MediaType.TEXT_XML).build();
	}

	public Response listVisits(Integer patientId) throws MalformedURLException, JAXBException, SQLException {
		Vxml vxml = (Vxml) unmarshaller.unmarshal(new File(ProjectURL.getProjectURL("listVisits.xml")));
		return Response.ok(vxml, MediaType.TEXT_XML).build();
	}

	public Response newVisit(Integer patientId) throws MalformedURLException, JAXBException, SQLException {
		Vxml vxml = (Vxml) unmarshaller.unmarshal(new File(ProjectURL.getProjectURL("newVisit.xml")));
		return Response.ok(vxml, MediaType.TEXT_XML).build();
	}

	public Response postponeVisit(Integer patientId) throws MalformedURLException, JAXBException, SQLException {
		Vxml vxml = (Vxml) unmarshaller.unmarshal(new File(ProjectURL.getProjectURL("postponeVisit.xml")));
		return Response.ok(vxml, MediaType.TEXT_XML).build();
	}

	public Response cancelVisit(Integer patientId) throws MalformedURLException, JAXBException, SQLException {
		Vxml vxml = (Vxml) unmarshaller.unmarshal(new File(ProjectURL.getProjectURL("cancelVisit.xml")));
		return Response.ok(vxml, MediaType.TEXT_XML).build();
	}

	public Response checkPass(Integer patientId, Integer patientPassword)
			throws MalformedURLException, JAXBException, SQLException {
		Vxml vxml = (Vxml) unmarshaller.unmarshal(new File(ProjectURL.getProjectURL("checkAuth.xml")));
		Form form = (Form) vxml.getDataOrCatchOrHelp().get(0);
		Var response = (Var) form.getCatchOrHelpOrNoinput().get(0);
		Var name = (Var) form.getCatchOrHelpOrNoinput().get(1);
		Var surname = (Var) form.getCatchOrHelpOrNoinput().get(2);

		Patient patient = DaoUtils.getPatientDao().queryForId(patientId);
		if (patient != null) {
			name.setExpr("'" + patient.getName() + "'");
			surname.setExpr("'" + patient.getSurname() + "'");
			response.setExpr("'YES'");
		} else {
			response.setExpr("'NO'");
		}
		return Response.ok(vxml, MediaType.TEXT_XML).build();
	}

}