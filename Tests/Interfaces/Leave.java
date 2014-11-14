public interface Leave
{
	public String startDate;
	public String endDate;
	
	public Leave(String s, String e);
	public void submit();
	public void delete(String date);
	public void setStartDate(String s);
	public void setEndDate(String s);
	public String getStartDate();
	public String getEndDate();
}