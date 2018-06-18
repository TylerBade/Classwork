// Tyler Bade

import java.util.*;
import java.text.*;
import java.time.*;
import java.io.*;

public class Daily extends Appointment
{
	Date date;
	String desc;
	String type;
	
	public Daily(Date dates, String description)
	{
		date = dates;
		desc = description;
		this.type = "Daily";
	}
	
	public String getDesc()
	{
		return desc;
	}
	
	public String getTime()
	{	
		SimpleDateFormat sdf = new SimpleDateFormat("H:mm a");
		String time = sdf.format(date);
		return time;
	}
	
	public String getType()
	{
		return this.type;
	}	
	
	public String toString()
	{
		String retStr = this.getDesc() + " at " + this.getTime() + " Every Day.";
		return retStr;
	}
}