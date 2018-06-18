// Tyler Bade

import java.util.*;
import java.text.*;
import java.time.*;
import java.io.*;

public class Monthly extends Appointment
{
	private Date date;
	private String desc;
	String type;
	
	public Monthly(Date dates, String description)
	{
		date = dates;
		desc = description;
		this.type = "Monthly";
	}
	
	public String getDesc()
	{
		return desc;
	}
	
	public int getDay()
	{	
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int day = cal.get(Calendar.DAY_OF_MONTH);
		return day;
	}
	
	public String getType()
	{
		return this.type;
	}
	
	public String toString()
	{
		String retStr = this.getDesc() + " on the " + this.getDay() + " of every month";
		return retStr;
	}
}