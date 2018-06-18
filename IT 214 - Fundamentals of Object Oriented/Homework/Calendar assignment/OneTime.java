// Tyler Bade

import java.util.*;
import java.text.*;
import java.time.*;
import java.io.*;

public class OneTime extends Appointment
{
	String desc;
	Date date;
	String type;
	
	public OneTime(Date dates, String description)
	{
		date = dates;
		desc = description;
		this.type = "One Time";
	}
	
	public String getDesc()
	{
		return desc;
	}
	
	public String getDay()
	{	
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		String day = sdf.format(date);
		return day;
	}
	
	public String getTime()
	{
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm a");
		String time = sdf.format(date);
		return time;
	}
	
	public String toString()
	{
		String retStr = this.getDesc() + " on " + this.getDay() + " due at " + this.getTime();
		return retStr;
	}
}