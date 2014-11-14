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
	public String date;
	
	public Feedback(Type t);
	public Feedback(int id, Type t);
	public void submit();
	public String getDescription();
	public String getTitle();
	public Status getStatus();
	public String getStudentID();
	public int getFeedbackID();
	public String getDate();
	public Type getType();
	public void setDescription(String s);
	public void setTitle(String s);
	public void setStatus(Status s);
	public void setType(Type t);
	public void setStudentID(String s);
	public void setFeedbackID(int i)
}	
	