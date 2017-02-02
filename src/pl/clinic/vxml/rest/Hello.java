package pl.clinic.vxml.rest;

import java.io.File;
import java.net.MalformedURLException;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import model.java.vxml.Form;
import model.java.vxml.Vxml;

@Path("/clinicRest")
public class Hello {

	@GET
	@Produces(MediaType.TEXT_XML)
	@Path("/main") 
	public Vxml sayPlainTextHello() throws JAXBException {
		Unmarshaller um = JAXBContext.newInstance("model.java.vxml").createUnmarshaller();
		Vxml vxml = (Vxml) um.unmarshal(new File("D:\\workspace_neon\\DialogoweProjekt\\main.xml"));
		Form form = vxml.getDataOrCatchOrHelp().stream()
				.filter(o -> o instanceof Form && ((Form) o).getId().equals("action")).map(o -> (Form) o).findFirst()
				.get(); 
		return vxml;
	}

	@POST
	@Path("/checkPass") 
	@Produces(MediaType.TEXT_XML)
	@Consumes("application/x-www-form-urlencoded")
	public Response sayXMLHello(@FormParam("patientNumber") String patientNumber, @FormParam("patientPassword") String patientPassword
			) throws MalformedURLException, JAXBException {
		Unmarshaller um = JAXBContext.newInstance("model.java.vxml").createUnmarshaller();
		Vxml vxml = (Vxml) um.unmarshal(new File("D:\\workspace_neon\\DialogoweProjekt\\subdialog.xml"));
		// ObjectFactory factory = new ObjectFactory();
		// Form form = factory.createForm("check");
		// Block block = factory.createBlock(); 
		// block.setName("patientNumberOK");
		// form.getCatchOrHelpOrNoinput().add(block);
		// vxml.getDataOrCatchOrHelp().add();
		return Response.ok(vxml, MediaType.TEXT_XML).build();
	}
	
	@GET
	@Produces(MediaType.TEXT_XML)
	@Path("/checkPass2") 
	public Vxml sayXMLHello2() throws JAXBException {
		Unmarshaller um = JAXBContext.newInstance("model.java.vxml").createUnmarshaller();
		Vxml vxml = (Vxml) um.unmarshal(new File("D:\\workspace_neon\\DialogoweProjekt\\subdialog.xml"));
		return vxml;
	}


}