import java.util.Date;
import java.text.SimpleDateFormat;
import java.sql.*;

enum Type
{
	FEEDBACK, COMPLAINT
}

enum Status
{
	PENDING, PROCESSED
}

public class Feedback
{
	public String description;
	public String title;
	public Status status;
	public String studentID;
	public int feedbackID;
	public Type type;
	public String date;// = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
	
	public Feedback(Type t)
	{
		type = t;
		status = Status.PENDING;
		date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
	}
	
	public Feedback(int id, Type t)
	{
		type = t;
		feedbackID = id;
		DBM db = new DBM("Feedback.db");
		
		if(type = Type.FEEDBACK)
		{
			sql = "SELECT * FROM FEEDBACK WHERE FEEDBACK_ID = '" + Integer.toString(id); + "'";
			rs = db.selectData(sql);
			
			while(rs.next())
			{
				studentID = rs.getString("STUDENT_ID");
				description = rs.getString("DESCRIPTION");
				date = rs.getString("DATE");
				status = null;
				title = null;
			}
			
			db.closeConnection();
		}
		else if(type = Type.COMPLAINT)
		{
			sql = "SELECT * FROM COMPLAINTS WHERE COMPLAINT_ID = '" + Integer.toString(id); + "'";
			rs = db.selectData(sql);
			
			while(rs.next())
			{
				studentID = rs.getString("STUDENT_ID");
				title = rs.getString("TITLE");
				
				if(rs.getString("STATUS").equals("PENDING"))
					status = Status.PENDING;
				else
					status = Type.PROCESSED;
				
				description = rs.getString("DESCRIPTION");
				date = rs.getString("DATE");
			}
			
			db.closeConnection();
		}
	}
	public void submit()
	{
		DBM db = new DBM("Feedback.db");
		
		if(type = Type.FEEDBACK)
		{
			String[] keys = {"STUDENT_ID", "FEEDBACK_ID", "DATA", "DATE"};
			String[] values = {studentID, feedbackID, description, date};
			db.insertData("FEEDBACK", keys, values);
		}
		else if(type = Type.COMPLAINT)
		{
			String keys = {"COMPLAINT_ID", "STUDENT_ID", "TITLE", "DESCRIPTION", "STATUS", "DATE"}
			String[] values = {feedbackID, studentID, title, description, "PENDING", date};
			db.insertData("COMPLAINTS", keys, values);
			db.closeConnection();
		}	
	}
	
	public String getDescription();
	{
		return description;
	}
	
	public String getTitle();
	{
		return title;
	}
	
	public Status getStatus();
	{
		return status;
	}
	
	public String getStudentID()
	{
		return studentID;
	}
	
	public String getFeedbackID()
	{
		return FeedbackID;
	}
		
	public String getDate()
	{
		return date;
	}
	
	public Type getType()
	{
		return Type;
	}
	
	public void setDescription(String s);
	{
		description = s;
	}
	
	public void setTitle(String s);
	{
		title = s;
	}
	
	public void setStatus(Status s);
	{
		status = s;
	}
	
	public void setType(Type t)
	{
		Type = t;
	}
	
	public void setStudentID(String s);
	{
		studentId = s;
	}
	
	public void setFeedbackID(int i)
	{
		feedbackId = i;
	}
}	
	