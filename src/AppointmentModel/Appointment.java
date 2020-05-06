package AppointmentModel;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.sun.research.ws.wadl.Request;

public class Appointment {
	

	
	public Connection connect()
	{
		Connection con=null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/newdb", "root", ""); 
			System.out.print("Successfully connected"); 
			
			
		}
		catch(Exception e)
		{
			System.out.print("error");
			e.printStackTrace(); 
		}
		return con;
	}
	public String addSession(String nic,String specialality,String doctor,String date,String time,String hospital)
	{
	String Output ="";
	
	try {
		//patientDatabase newp = new patientDatabase();
		Connection con = connect();

		if (con == null) {
			//return "Error while connectingto the database for inserting";
		}

		String query = " insert into appointment_details (`patient_nic`,`doc_speciality`,`doc_name`, `appointment_date`, `appointment_time`,`appointment_hospital`) "
				+ "values(?,?,?,?,?,?)";
//		Date date = Calendar.getInstance().getTime();
//		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
//		String strDate = dateFormat.format(date);
		
		PreparedStatement preparedStmt = con.prepareStatement(query);
	
		preparedStmt.setString(1, nic);
		preparedStmt.setString(2, specialality);
		preparedStmt.setString(3, doctor);
		preparedStmt.setString(4, date);
		preparedStmt.setString(5, time );
		preparedStmt.setString(6, hospital);
		
		preparedStmt.execute();
		con.close();
		System.out.println("inserted");
		Output = "Inserted successfully"; 
	} catch (Exception e) {
		e.printStackTrace();
		System.out.println(" not inserted");
	}

	return Output;
}
	public String deleteSession(String nic)
	{
		String output="";
		
		try {
			Connection connection=connect();
			
			if(connection==null)
			{
				return "Error while connecting to the database for deleting.";
			}
			
			String query="delete from appointment_details where patient_nic=?";
			
			PreparedStatement prepareStmt=connection.prepareStatement(query);
			
			prepareStmt.setString(1,nic);
			prepareStmt.execute();
			connection.close();
			
			output= "deleted successfully";
		}
		catch(Exception e)
		{
			output="error while deleting the Doctor";
			System.err.println(e.getMessage());
		}
		return output;
	}
	public String updateSession(String nic,String specialality,String doctor,String date,String time,String hospital)
	{
		String output="";
		
		try {
			Connection connection=connect();
			if(connection==null)
			{
				return "error while connecting to the database for updating";
			}
			
			String query="UPDATE appointment_details SET `patient_nic=?`,`doc_speciality=?`,`doc_name=?`, `appointment_date=?`, `appointment_time=?`,`appointment_hospital=?` "
					+ "where patient_nic=?";
					
					PreparedStatement pStatement=connection.prepareStatement(query);
					
					//pStatement.setString(1, appointmentNum);
					
					pStatement.setString(1, nic);
					pStatement.setString(2, specialality);
					pStatement.setString(3, doctor);
					pStatement.setString(4, date);
					pStatement.setString(5, time);
					pStatement.setString(6, hospital);	
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					pStatement.execute();
					connection.close();
					System.out.print("updated");
					output="updated successfully";
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.print("not updated");
			output="error while updating the appointment";
			System.err.println(e.getMessage());
		}
		return output;
	}
	public String readSession()
	{
		String output= "";
		
		try {
			Connection con=connect();
			
			if(con==null)
			{
				return "error while connecting to the database for reading";
			}
//			output += "<<td><input id=\"hidItemIDUpdate\" name=\"hidItemIDUpdate\" type=\"hidden\" value=\"" + nic + "\">" + Name + "</td>"; 
			output = "<table class=\"table\"><tr>				"
					 +"<th>Patient NIC</th>"
					 +"<th>Doctor's Specialty</th>"
					 +"<th>Doctor</th>"
					 + "<th>Date</th>"
					 +"<th>Time</th>"
					 +"<th>Hospital</th>"
					 +"<th>Update</th>"
					 +"<th>Delete</th>"+"</tr>";
					 //+"<th>hospital</th></tr>";
					// + "<th>Update</th><th>Remove</th></tr>"; 	
			
			String  query="select * from appointment_details order by appointment_id DESC ";
			Statement stmtStatement=con.createStatement();
			ResultSet rs=stmtStatement.executeQuery(query);
			
			
			while (rs.next())
			{
				String nic=rs.getString("patient_nic");
				String specialality=rs.getString("doc_speciality");
				String doctor=rs.getString("doc_name");
				String date=rs.getString("appointment_date");
				String time=rs.getString("appointment_time");
				String hospital=rs.getString("appointment_hospital");
				
				
			
				
				output += "<tr></td>";
				output += "<td>" + nic + "</td>";
				output += "<td>" + specialality + "</td>"; 
				output += "<td>" + doctor + "</td>"; 
				output += "<td>" + date + "</td>"; 
				output += "<td>" + time + "</td>"; 
				output += "<td>" + hospital + "</td>"; 
				output += "<td><input name=\"btnUpdate\" id=\"btnUpdate\" type=\"button\" value=\"Update\" class=\"btnUpdate btn btn-secondary\"></td>";	
				output += "<td><form method=\"post\" action=\"Appointment.jsp\">"
				 +"<input name=\"btnRemove\" type=\"submit\" value=\"Remove\" class=\"btn btn-danger\">"
				 +"<input name=\"hidItemIDDelete\" type=\"hidden\" value=\"" + nic + "\">" + "</form></td></tr>"; 
				
				//-------------------------------------------------------
				
			
				
				
				
				
				
				
				
				
			}
			con.close();
			
			output+="</table>";
			System.out.println("table can be view");
		}
		catch(Exception e)
		{
			output="error while reading the appointment";
			System.err.println(e.getMessage());
			System.out.println("table can't be view");
		}
		return output;	
		
	}
	
	

}