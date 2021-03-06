package pl.clinic.rest;

import java.net.MalformedURLException;
import java.sql.SQLException;
import java.text.ParseException;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBException;

@Path("/clinicRest")
public class ClinicRest {
	ClinicRestImpl clinicRestImpl;

	public ClinicRest() {
		clinicRestImpl = new ClinicRestImpl();
	}

	@GET
	@Produces(MediaType.TEXT_XML)
	@Path("/main")
	public Response main() throws MalformedURLException, JAXBException, SQLException {
		return clinicRestImpl.main();
	}

	@POST
	@Path("/insertVisit")
	@Produces(MediaType.TEXT_XML)
	@Consumes("application/x-www-form-urlencoded")
	public Response insertVisit(@FormParam("patientId") Integer patientId, @FormParam("doctorId") Integer doctorId,
			@FormParam("day") String day, @FormParam("month") String month, @FormParam("year") String year,
			@FormParam("timeOfDayId") Integer timeOfDayId)
			throws MalformedURLException, JAXBException, SQLException, ParseException {
		return clinicRestImpl.insertVisit(patientId, doctorId, day, month, year, timeOfDayId);
	}

	@POST
	@Path("/updateVisit")
	@Produces(MediaType.TEXT_XML)
	@Consumes("application/x-www-form-urlencoded")
	public Response updateVisit(@FormParam("doctorId") Integer doctorId, @FormParam("day") String day,
			@FormParam("month") String month, @FormParam("year") String year,
			@FormParam("timeOfDayId") Integer timeOfDayId, @FormParam("visitId") Integer visitId)
			throws MalformedURLException, JAXBException, SQLException, ParseException {
		return clinicRestImpl.updateVisit(doctorId, day, month, year, timeOfDayId, visitId);
	}

	@POST
	@Path("/deleteVisit")
	@Produces(MediaType.TEXT_XML)
	@Consumes("application/x-www-form-urlencoded")
	public Response deleteVisit(@FormParam("visitId") Integer visitId)
			throws MalformedURLException, JAXBException, SQLException, ParseException {
		return clinicRestImpl.deleteVisit(visitId);
	}

	@POST
	@Path("/selectDoctor")
	@Produces(MediaType.TEXT_XML)
	@Consumes("application/x-www-form-urlencoded")
	public Response selectDoctor(@FormParam("patientId") Integer patientId)
			throws MalformedURLException, JAXBException, SQLException {
		return clinicRestImpl.selectDoctor(patientId);
	}

	@POST
	@Path("/selectTime")
	@Produces(MediaType.TEXT_XML)
	@Consumes("application/x-www-form-urlencoded")
	public Response selectTime(@FormParam("patientId") Integer patientId)
			throws MalformedURLException, JAXBException, SQLException {
		return clinicRestImpl.selectTime(patientId);
	};

	@POST
	@Path("/selectDate")
	@Produces(MediaType.TEXT_XML)
	@Consumes("application/x-www-form-urlencoded")
	public Response selectDate(@FormParam("patientId") Integer patientId)
			throws MalformedURLException, JAXBException, SQLException {
		return clinicRestImpl.selectDate(patientId);
	}

	@POST
	@Path("/selectVisit")
	@Produces(MediaType.TEXT_XML)
	@Consumes("application/x-www-form-urlencoded")
	public Response selectVisit(@FormParam("patientId") Integer patientId)
			throws MalformedURLException, JAXBException, SQLException {
		return clinicRestImpl.selectVisit(patientId);
	}

	@POST
	@Path("/newVisit")
	@Produces(MediaType.TEXT_XML)
	@Consumes("application/x-www-form-urlencoded")
	public Response newVisit(@FormParam("patientId") Integer patientId)
			throws MalformedURLException, JAXBException, SQLException {
		return clinicRestImpl.newVisit(patientId);
	}

	@POST
	@Path("/postponeVisit")
	@Produces(MediaType.TEXT_XML)
	@Consumes("application/x-www-form-urlencoded")
	public Response postponeVisit(@FormParam("patientId") Integer patientId)
			throws MalformedURLException, JAXBException, SQLException {
		return clinicRestImpl.postponeVisit(patientId);
	}

	@POST
	@Path("/cancelVisit")
	@Produces(MediaType.TEXT_XML)
	@Consumes("application/x-www-form-urlencoded")
	public Response cancelVisit(@FormParam("patientId") Integer patientId)
			throws MalformedURLException, JAXBException, SQLException {
		return clinicRestImpl.cancelVisit(patientId);
	}

	@GET
	@Path("/dateGrammar")
	@Produces(MediaType.TEXT_XML)
	public Response dateGrammar() throws MalformedURLException, JAXBException, SQLException {
		return clinicRestImpl.dateGrammar();
	}

	@POST
	@Path("/checkPass")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes("application/x-www-form-urlencoded")
	public Response checkPass(@FormParam("patientId") Integer patientId,
			@FormParam("patientPassword") Integer patientPassword)
			throws MalformedURLException, JAXBException, SQLException {
		return clinicRestImpl.checkPass(patientId, patientPassword);
	}

}