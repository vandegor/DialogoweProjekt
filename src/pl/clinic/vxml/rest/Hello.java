package pl.clinic.vxml.rest;

import java.io.File;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.namespace.QName;

import com.j256.ormlite.dao.CloseableIterator;

import model.java.vxml.Block;
import model.java.vxml.Field;
import model.java.vxml.Form;
import model.java.vxml.Grammar;
import model.java.vxml.Item;
import model.java.vxml.MixedGrammar;
import model.java.vxml.ObjectFactory;
import model.java.vxml.OneOf;
import model.java.vxml.Return;
import model.java.vxml.Rule;
import model.java.vxml.Var;
import model.java.vxml.Vxml;
import model.java.vxml.VxmlSpeak;
import pl.clinic.vxml.model.Doctor;
import pl.clinic.vxml.model.Patient;
import pl.clinic.vxml.model.TimeOfDay;
import pl.clinic.vxml.model.utils.DaoUtils;
import pl.clinic.vxml.model.utils.ProjectURL;
import pl.clinic.vxml.model.utils.UnmarshallerUtils;

@Path("/clinicRest")
public class Hello {
	private static Unmarshaller unmarshaller = UnmarshallerUtils.getUnmarshaller();

	@GET
	@Produces(MediaType.TEXT_XML)
	@Path("/main")
	public Vxml main() throws MalformedURLException, JAXBException, SQLException {
		Vxml vxml = (Vxml) unmarshaller.unmarshal(new File(ProjectURL.getProjectURL("main.xml")));
		return vxml;
	}

	@POST
	@Path("/createVisit")
	@Produces(MediaType.TEXT_XML)
	@Consumes("application/x-www-form-urlencoded")
	public Response createVisit(@FormParam("checkresults.patientId") Integer patientId)
			throws MalformedURLException, JAXBException, SQLException {
		return Response.ok().build();
	}

	@POST
	@Path("/deleteVisit")
	@Produces(MediaType.TEXT_XML)
	@Consumes("application/x-www-form-urlencoded")
	public Response deleteVisit(@FormParam("checkresults.patientId") Integer patientId)
			throws MalformedURLException, JAXBException, SQLException {
		return Response.ok().build();
	}

	@SuppressWarnings("unchecked")
	@POST
	@Path("/selectDoctor")
	@Produces(MediaType.TEXT_XML)
	@Consumes("application/x-www-form-urlencoded")
	public Response selectDoctor(@FormParam("patientId") Integer patientId)
			throws MalformedURLException, JAXBException, SQLException {

		Vxml vxml = (Vxml) unmarshaller.unmarshal(new File(ProjectURL.getProjectURL("selectDoctor.xml")));
		Form form = (Form) vxml.getDataOrCatchOrHelp().get(0);
		Field field = (Field) form.getCatchOrHelpOrNoinput().get(0);

		List<String> surnames = new ArrayList<String>();
		List<String> surnamesWithDot = new ArrayList<String>();

		surnamesWithDot.add("Please provide doctor Name for visit.");
		for (Iterator<Doctor> i = DaoUtils.getDaoUtils().getDoctorDao().iterator(); i.hasNext();) {
			Doctor doctor = (Doctor) i.next();
			surnames.add(doctor.getSurname());
			surnamesWithDot.add(doctor.getSurname() + (i.hasNext() ? "," : "."));

		}
		field.addPrompt(surnamesWithDot);
		field.addGrammar(surnames);
		return Response.ok(vxml, MediaType.TEXT_XML).build();
	}

	@POST
	@Path("/selectTime")
	@Produces(MediaType.TEXT_XML)
	@Consumes("application/x-www-form-urlencoded")
	public Response selectTime(@FormParam("checkresults.patientId") Integer patientId)
			throws MalformedURLException, JAXBException, SQLException {

		Vxml vxml = (Vxml) unmarshaller.unmarshal(new File(ProjectURL.getProjectURL("selectTime.xml")));
		Form form = (Form) vxml.getDataOrCatchOrHelp().get(0);
		Field field = (Field) form.getCatchOrHelpOrNoinput().get(0);

		List<String> times = new ArrayList<String>();
		List<String> timesWithDot = new ArrayList<String>();

		timesWithDot.add("Please provide time for visit.");
		for (Iterator<TimeOfDay> i = DaoUtils.getDaoUtils().getTimeOfDayDao().iterator(); i.hasNext();) {
			TimeOfDay time = (TimeOfDay) i.next();
			times.add(time.getName());
			timesWithDot.add(time.getName() + (i.hasNext() ? "," : "."));

		}
		field.addPrompt(timesWithDot);
		field.addGrammar(times);

		return Response.ok(vxml, MediaType.TEXT_XML).build();
	}

	@POST
	@Path("/selectDate")
	@Produces(MediaType.TEXT_XML)
	@Consumes("application/x-www-form-urlencoded")
	public Response selectDate(@FormParam("checkresults.patientId") Integer patientId)
			throws MalformedURLException, JAXBException, SQLException {
		Vxml vxml = (Vxml) unmarshaller.unmarshal(new File(ProjectURL.getProjectURL("selectDate.xml")));
		return Response.ok(vxml, MediaType.TEXT_XML).build();
	}
	
	
	@POST
	@Path("/selectVisit")
	@Produces(MediaType.TEXT_XML)
	@Consumes("application/x-www-form-urlencoded")
	public Response selectVisit(@FormParam("checkresults.patientId") Integer patientId)
			throws MalformedURLException, JAXBException, SQLException {
		Vxml vxml = (Vxml) unmarshaller.unmarshal(new File(ProjectURL.getProjectURL("selectVisit.xml")));
		return Response.ok(vxml, MediaType.TEXT_XML).build();
	}
	
	@POST
	@Path("/listVisits")
	@Produces(MediaType.TEXT_XML)
	@Consumes("application/x-www-form-urlencoded")
	public Response listVisits(@FormParam("checkresults.patientId") Integer patientId)
			throws MalformedURLException, JAXBException, SQLException {
		Vxml vxml = (Vxml) unmarshaller.unmarshal(new File(ProjectURL.getProjectURL("listVisits.xml")));
		return Response.ok(vxml, MediaType.TEXT_XML).build();
	}

	@POST
	@Path("/newVisit")
	@Produces(MediaType.TEXT_XML)
	@Consumes("application/x-www-form-urlencoded")
	public Response newVisit(@FormParam("patientId") Integer patientId)
			throws MalformedURLException, JAXBException, SQLException {
		Vxml vxml = (Vxml) unmarshaller.unmarshal(new File(ProjectURL.getProjectURL("newVisit.xml")));
		return Response.ok(vxml, MediaType.TEXT_XML).build();
	}

	@POST
	@Path("/postponeVisit")
	@Produces(MediaType.TEXT_XML)
	@Consumes("application/x-www-form-urlencoded")
	public Response postponeVisit(@FormParam("checkresults.patientId") Integer patientId)
			throws MalformedURLException, JAXBException, SQLException {
		Vxml vxml = (Vxml) unmarshaller.unmarshal(new File(ProjectURL.getProjectURL("postponeVisit.xml")));
		return Response.ok(vxml, MediaType.TEXT_XML).build();
	}

	@POST
	@Path("/cancelVisit")
	@Produces(MediaType.TEXT_XML)
	@Consumes("application/x-www-form-urlencoded")
	public Response cancelVisit(@FormParam("checkresults.patientId") Integer patientId)
			throws MalformedURLException, JAXBException, SQLException {
		Vxml vxml = (Vxml) unmarshaller.unmarshal(new File(ProjectURL.getProjectURL("cancelVisit.xml")));
		return Response.ok(vxml, MediaType.TEXT_XML).build();
	}

	@POST
	@Path("/checkPass")
	@Produces(MediaType.TEXT_XML)
	@Consumes("application/x-www-form-urlencoded")
	public Response checkPass(@FormParam("patientNumber") Integer patientNumber,
			@FormParam("patientPassword") Integer patientPassword)
			throws MalformedURLException, JAXBException, SQLException {
		Vxml vxml = (Vxml) unmarshaller.unmarshal(new File(ProjectURL.getProjectURL("checkAuth.xml")));
		Form form = (Form) vxml.getDataOrCatchOrHelp().get(0);
		Var response = (Var) form.getCatchOrHelpOrNoinput().get(0);
		Var name = (Var) form.getCatchOrHelpOrNoinput().get(1);
		Var surname = (Var) form.getCatchOrHelpOrNoinput().get(2);
		Var patientId = (Var) form.getCatchOrHelpOrNoinput().get(3);

		DaoUtils daoUtils = DaoUtils.getDaoUtils();
		List<Patient> patients = daoUtils.getPatientDao().queryForEq("login", patientNumber);
		if (patients.size() == 1 && patients.get(0).getPassword().equals(patientPassword)) {
			Patient patient = patients.get(0);
			name.setExpr("'" + patient.getName() + "'");
			surname.setExpr("'" + patient.getSurname() + "'");
			patientId.setExpr("" + patient.getId());
			response.setExpr("'YES'");
		} else {
			response.setExpr("'NO'");
		}
		return Response.ok(vxml, MediaType.TEXT_XML).build();
	}

}