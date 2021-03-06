package pl.clinic.rest;

import java.io.File;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import pl.clinic.model.ModelInterface;
import pl.clinic.model.impl.Doctor;
import pl.clinic.model.impl.Patient;
import pl.clinic.model.impl.TimeOfDay;
import pl.clinic.model.impl.Visit;
import pl.clinic.model.utils.DaoUtils;
import pl.clinic.model.utils.ProjectURL;
import pl.clinic.vxml.schema.impl.Form;
import pl.clinic.vxml.schema.impl.Grammar;
import pl.clinic.vxml.schema.impl.Initial;
import pl.clinic.vxml.schema.impl.Var;
import pl.clinic.vxml.schema.impl.Vxml;
import pl.clinic.vxml.schema.utils.UnmarshallerUtils;
import pl.clinic.vxml.schema.utils.VxmlBuilder;

public class ClinicRestImpl {

	private static Unmarshaller unmarshaller = UnmarshallerUtils.getUnmarshaller();

	public Response main() throws MalformedURLException, JAXBException, SQLException {
		Vxml vxml = (Vxml) unmarshaller.unmarshal(new File(ProjectURL.getProjectURL("main.xml")));
		vxml.getChildByNameOrId("patientPassword");
		return Response.ok(vxml, MediaType.TEXT_XML).build();
	}

	public Response insertVisit(Integer patientId, Integer doctorId, String day, String month, String year,
			Integer timeOfDayId) throws MalformedURLException, JAXBException, SQLException, ParseException {
		Vxml vxml = (Vxml) unmarshaller.unmarshal(new File(ProjectURL.getProjectURL("insertVisit.xml")));
		Var insertVisit = (Var) vxml.getChildByName("insertVisit");

		Patient patient = DaoUtils.getPatientDao().queryForId(patientId);
		Doctor doctor = DaoUtils.getDoctorDao().queryForId(doctorId);
		Date visitDate = new SimpleDateFormat("yyyyMMMMMdd", Locale.US).parse(year + month + day);
		TimeOfDay timeOfDay = DaoUtils.getTimeOfDayDao().queryForId(timeOfDayId);

		Visit visit = new Visit(null, timeOfDay, patient, doctor, visitDate);

		DaoUtils.getVisitDao().create(visit);

		insertVisit.setExpr(visit.getId().toString());

		return Response.ok(vxml, MediaType.TEXT_XML).build();
	}

	public Response deleteVisit(Integer visitId)
			throws MalformedURLException, JAXBException, SQLException, ParseException {

		Vxml vxml = (Vxml) unmarshaller.unmarshal(new File(ProjectURL.getProjectURL("deleteVisit.xml")));
		Var updateVisit = (Var) vxml.getChildByName("deleteVisit");

		int toReturn = DaoUtils.getVisitDao().deleteById(visitId);

		updateVisit.setExpr("" + toReturn);

		return Response.ok(vxml, MediaType.TEXT_XML).build();
	}

	public Response selectDoctor(Integer patientId) throws MalformedURLException, JAXBException, SQLException {

		Vxml vxml = (Vxml) unmarshaller.unmarshal(new File(ProjectURL.getProjectURL("selectDoctor.xml")));
		Form form = (Form) vxml.getChildById("selectDoctor");
		Initial initial = (Initial) vxml.getChildByName("selectDoctor");

		List<ModelInterface> surnames = new ArrayList<ModelInterface>(DaoUtils.getDoctorDao().queryForAll());
		List<ModelInterface> surnamesWithDot = new ArrayList<ModelInterface>(DaoUtils.getDoctorDao().queryForAll());

		initial.getContent().add(VxmlBuilder.buildVxmlSpeak("Please provide doctor Name for visit.", surnamesWithDot));
		form.getCatchOrHelpOrNoinput().add(0, VxmlBuilder.buildGrammar(form.getId(), surnames));

		return Response.ok(vxml, MediaType.TEXT_XML).build();
	}

	public Response selectTime(Integer patientId) throws MalformedURLException, JAXBException, SQLException {

		Vxml vxml = (Vxml) unmarshaller.unmarshal(new File(ProjectURL.getProjectURL("selectTime.xml")));
		Form form = (Form) vxml.getChildById("selectTime");
		Initial initial = (Initial) vxml.getChildByName("selectTime");

		List<ModelInterface> times = new ArrayList<ModelInterface>(DaoUtils.getTimeOfDayDao().queryForAll());
		List<ModelInterface> timesWithDot = new ArrayList<ModelInterface>(DaoUtils.getTimeOfDayDao().queryForAll());

		initial.getContent().add(VxmlBuilder.buildVxmlSpeak("Please provide time for visit.", timesWithDot));
		form.getCatchOrHelpOrNoinput().add(0, VxmlBuilder.buildGrammar(form.getId(), times));

		return Response.ok(vxml, MediaType.TEXT_XML).build();
	}

	public Response selectDate(Integer patientId) throws MalformedURLException, JAXBException, SQLException {
		Vxml vxml = (Vxml) unmarshaller.unmarshal(new File(ProjectURL.getProjectURL("selectDate.xml")));
		return Response.ok(vxml, MediaType.TEXT_XML).build();
	}

	public Response selectVisit(Integer patientId) throws MalformedURLException, JAXBException, SQLException {
		Vxml vxml = (Vxml) unmarshaller.unmarshal(new File(ProjectURL.getProjectURL("selectVisit.xml")));

		Form form = (Form) vxml.getChildById("selectVisit");
		Initial initial = (Initial) vxml.getChildByName("selectVisit");

		List<Visit> visitList = new ArrayList<Visit>(DaoUtils.getVisitDao().queryForEq("patient_id", patientId));
		visitList.removeIf(visit->visit.getDate().before(new Date()));

		initial.getContent().addAll(VxmlBuilder.buildVxmlSpeakForVisit("Please provide, ID: ", visitList));
		form.getCatchOrHelpOrNoinput().add(0, VxmlBuilder.buildGrammarForVisit(form.getId(), visitList));

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

	@SuppressWarnings("unchecked")
	public Response dateGrammar() throws MalformedURLException, JAXBException, SQLException {
		JAXBElement<Grammar> grammar = (JAXBElement<Grammar>) unmarshaller
				.unmarshal(new File(ProjectURL.getProjectURL("dateGrammar.xml")));
		return Response.ok(grammar, MediaType.TEXT_XML).build();
	}

	public Response checkPass(Integer patientId, Integer patientPassword)
			throws MalformedURLException, JAXBException, SQLException {
		Vxml vxml = (Vxml) unmarshaller.unmarshal(new File(ProjectURL.getProjectURL("checkAuth.xml")));

		Var response = (Var) vxml.getChildByNameOrId("response");
		Var name = (Var) vxml.getChildByName("name");
		Var surname = (Var) vxml.getChildByName("surname");

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

	public Response updateVisit(Integer doctorId, String day, String month, String year, Integer timeOfDayId,
			Integer visitId) throws JAXBException, SQLException, ParseException {

		Vxml vxml = (Vxml) unmarshaller.unmarshal(new File(ProjectURL.getProjectURL("updateVisit.xml")));

		Var updateVisit = (Var) vxml.getChildByName("updateVisit");

		Visit visit = DaoUtils.getVisitDao().queryForId(visitId);
		visit.setDoctor(DaoUtils.getDoctorDao().queryForId(doctorId));
		visit.setDate(new SimpleDateFormat("yyyyMMMMMdd", Locale.US).parse(year + month + day));
		visit.setTime(DaoUtils.getTimeOfDayDao().queryForId(timeOfDayId));

		DaoUtils.getVisitDao().update(visit);

		updateVisit.setExpr(visit.getId().toString());

		return Response.ok(vxml, MediaType.TEXT_XML).build();
	}

}