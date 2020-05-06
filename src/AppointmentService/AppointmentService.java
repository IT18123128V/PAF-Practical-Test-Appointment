package AppointmentService;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
//For JSON
import com.google.gson.*;

import AppointmentModel.Appointment;

//For XML
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document; 

@Path("/Appointment") 
public class AppointmentService {
	
		Appointment appObj = new Appointment();
		
		@GET
		@Path("/test")
		@Produces(MediaType.TEXT_HTML)
		public String readItems()
		 {
		 return "Hello";
		 } 
		
		
		
		@GET
		@Path("/")
		@Produces(MediaType.TEXT_HTML)
		public String readSession()
		 {
		 return appObj.readSession();
		 }
		
		
		@POST
		@Path("/")
		@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
		@Produces(MediaType.TEXT_PLAIN)
		public String insertSession(@FormParam("nic") String nic,
		@FormParam("specialality") String specialality,
		 @FormParam("doctor") String doctor,
		 @FormParam("date") String date,
		 @FormParam("time") String time,
		 @FormParam("hospital") String hospital)
		 
		{
		 String output = appObj.addSession(nic,specialality,doctor,date,time,hospital);
		return output;
		}
		
		
		@PUT
		@Path("/")
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.TEXT_PLAIN)
		public String updateSession(String docData)
		{
		//Convert the input string to a JSON object
		 JsonObject docObject = new JsonParser().parse(docData).getAsJsonObject();
		//Read the values from the JSON object
		 String nic = docObject.get("nic").getAsString();
		 String specialality = docObject.get("specialality").getAsString();
		 String doctor = docObject.get("doctor").getAsString();
		 String date = docObject.get("date").getAsString();
		 String time = docObject.get("time").getAsString();
		 String hospital = docObject.get("hospital").getAsString();
		 
		 String output = appObj.updateSession(nic,specialality,doctor,date,time,hospital);
		return output;
		}
		
		
		@DELETE
		@Path("/")
		@Consumes(MediaType.APPLICATION_XML)
		@Produces(MediaType.TEXT_PLAIN)
		public String deleteSession(String docData)
		{
		//Convert the input string to an XML document
		 Document doc = Jsoup.parse(docData, "", Parser.xmlParser());

		//Read the value from the element <itemID>
		 String nic = doc.select("nic").text();
		 String output = appObj.deleteSession(nic);
		return output;
		}
}
