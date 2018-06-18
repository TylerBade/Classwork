// Tyler Bade

import java.util.*;
import java.text.*;
import java.time.*;
import java.io.*;

public class Appointment
{
	Date date;
	String description;
	String type;
	
	public Appointment()
	{
	}
	
	public Date getDate()
	{
		return this.date;
	}
	
	public String getDesc()
	{
		return this.description;
	}
	
	public String getType()
	{
		return this.type;
	}
}