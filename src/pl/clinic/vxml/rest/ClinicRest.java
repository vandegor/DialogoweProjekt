package pl.clinic.vxml.rest;

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

import pl.model.java.vxml.Vxml;

@Path("/clinicRest")
public class ClinicRest {
	ClinicRestImpl clinicRestImpl;

	public ClinicRest() {
		clinicRestImpl = new ClinicRestImpl();
	}

	@GET
	@Produces(MediaType.TEXT_XML)
	@Path("/main")
	public Vxml main() throws MalformedURLException, JAXBException, SQLException {
		return clinicRestImpl.main();
	}

	@POST
	@Path("/insertVisit")
	@Produces(MediaType.TEXT_XML)
	@Consumes("application/x-www-form-urlencoded")
	public Response insertVisit(@FormParam("patientId") Integer patientId, @FormParam("doctorId") Integer doctorId,
			@FormParam("date") String date, @FormParam("timeOfDayId") Integer timeOfDayId)
			throws MalformedURLException, JAXBException, SQLException, ParseException {
		return clinicRestImpl.insertVisit(patientId, doctorId, date, timeOfDayId);
	}

	@POST
	@Path("/deleteVisit")
	@Produces(MediaType.TEXT_XML)
	@Consumes("application/x-www-form-urlencoded")
	public Response deleteVisit(@FormParam("patientId") Integer patientId)
			throws MalformedURLException, JAXBException, SQLException {
		return clinicRestImpl.deleteVisit(patientId);
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
	@Path("/listVisits")
	@Produces(MediaType.TEXT_XML)
	@Consumes("application/x-www-form-urlencoded")
	public Response listVisits(@FormParam("patientId") Integer patientId)
			throws MalformedURLException, JAXBException, SQLException {
		return clinicRestImpl.listVisits(patientId);
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

	@POST
	@Path("/checkPass")
	@Produces(MediaType.TEXT_XML)
	@Consumes("application/x-www-form-urlencoded")
	public Response checkPass(@FormParam("patientId") Integer patientId,
			@FormParam("patientPassword") Integer patientPassword)
			throws MalformedURLException, JAXBException, SQLException {
		return clinicRestImpl.checkPass(patientId, patientPassword);
	}

}