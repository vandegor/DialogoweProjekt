package pl.clinic.vxml.rest;

import java.io.File;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import model.java.vxml.Form;
import model.java.vxml.Var;
import model.java.vxml.Vxml;
import pl.clinic.vxml.model.Patient;
import pl.clinic.vxml.model.utils.DaoUtils;
import pl.clinic.vxml.model.utils.ProjectURL;
import pl.clinic.vxml.model.utils.UnmarshallerUtils;

@Path("/clinicRest")
public class Hello {
	private static Unmarshaller unmarshaller = UnmarshallerUtils.getUnmarshaller();

	@GET
	@Produces(MediaType.TEXT_XML)
	@Path("/main")
	public Vxml sayPlainTextHello() throws MalformedURLException, JAXBException, SQLException {
		Vxml vxml = (Vxml) unmarshaller.unmarshal(new File(ProjectURL.getProjectURL("main.xml")));
		Form form = vxml.getDataOrCatchOrHelp().stream()
				.filter(o -> o instanceof Form && ((Form) o).getId().equals("action")).map(o -> (Form) o).findFirst()
				.get();
		return vxml;
	}

	@POST
	@Path("/checkPass")
	@Produces(MediaType.TEXT_XML)
	@Consumes("application/x-www-form-urlencoded")
	public Response sayXMLHello(@FormParam("patientNumber") String patientNumber,
			@FormParam("patientPassword") String patientPassword)
			throws MalformedURLException, JAXBException, SQLException {
		Vxml vxml = (Vxml) unmarshaller.unmarshal(new File(ProjectURL.getProjectURL("subdialog.xml")));
		// ObjectFactory factory = new ObjectFactory();
		// Form form = factory.createForm("check");
		// Block block = factory.createBlock();
		// block.setName("patientNumberOK");
		// form.getCatchOrHelpOrNoinput().add(block);
		// vxml.getDataOrCatchOrHelp().add();
		return Response.ok(vxml, MediaType.TEXT_XML).build();
	}

	@POST
	@Path("/checkPass2")
	@Produces(MediaType.TEXT_XML)
	@Consumes("application/x-www-form-urlencoded")
	public Response sayXMLHello2(@FormParam("patientNumber") Integer patientNumber,
			@FormParam("patientPassword") Integer patientPassword)
			throws MalformedURLException, JAXBException, SQLException {
		Vxml vxml = (Vxml) unmarshaller.unmarshal(new File(ProjectURL.getProjectURL("checkAuth.xml")));
		Form form = (Form) vxml.getDataOrCatchOrHelp().get(0);
		Var response = (Var) form.getCatchOrHelpOrNoinput().get(0);
		Var name = (Var) form.getCatchOrHelpOrNoinput().get(1);
		Var surname = (Var) form.getCatchOrHelpOrNoinput().get(2);

		DaoUtils daoUtils = DaoUtils.getDaoUtils();
		List<Patient> patients = daoUtils.getPatientDao().queryForEq("login", patientNumber);
		if (patients.size() == 1 && patients.get(0).getPassword().equals(patientPassword)) {
			Patient patient = patients.get(0);
			name.setExpr("'" + patient.getName() + "'");
			surname.setExpr("'" + patient.getSurname() + "'");
			response.setExpr("'YES'");
		} else {
			response.setExpr("'NO'");
		}
		return Response.ok(vxml, MediaType.TEXT_XML).build();
	}

}