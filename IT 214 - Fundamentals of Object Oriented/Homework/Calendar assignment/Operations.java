// Tyler Bade

import java.util.*;
import java.text.*;
import java.time.*;
import java.io.*;

public class Operations
{
	public static ArrayList<Appointment> TodayEvents(Calendar time, Scanner schedule)
	{
		ArrayList<OneTime> oneTimeEvents = new ArrayList<OneTime>();
		ArrayList<Monthly> monthlyEvents = new ArrayList<Monthly>();
		ArrayList<Daily> dailyEvents = new ArrayList<Daily>();
		Date day;
		
		while (schedule.hasNextLine())
		{
			String[] line = schedule.nextLine().split(",");
			String type = line[0];
			int month = Integer.parseInt(line[1]);
			int dayInt = Integer.parseInt(line[2]);
			int year = Integer.parseInt(line[3]);
			String timeOfDay = line[4];
			String date = month + "/" + dayInt + "/" + year + " " + timeOfDay;
			DateFormat form = new SimpleDateFormat("MM/dd/yyyy HH:mm a");
			String descript = line [5];
			
			try
			{
				day = (Date) form.parse(date);
				
				if (Operations.equality(day, time))
				{
					if (type.equalsIgnoreCase("OneTime"))
					{
						oneTimeEvents.add(new OneTime(day, descript));
					}
				
					else if (type.equalsIgnoreCase("Monthly"))
					{
						monthlyEvents.add(new Monthly(day,descript));
					}
					
					else if (type.equalsIgnoreCase("Daily"))
					{
						dailyEvents.add(new Daily(day, descript));
					}
					
					else
					{
						continue;
					}
				}
			}
			catch (ParseException e)
			{
				System.out.println(e);
				continue;
			}
		}
		
		ArrayList<Appointment> retArr = Operations.makeArray(oneTimeEvents, monthlyEvents, dailyEvents);
		return retArr;
	}
	
	public static ArrayList<Appointment> TomorrowEvents(Calendar time, Scanner schedule)
	{
		ArrayList<OneTime> oneTimeEvents = new ArrayList<OneTime>();
		ArrayList<Monthly> monthlyEvents = new ArrayList<Monthly>();
		ArrayList<Daily> dailyEvents = new ArrayList<Daily>();
		Date day;
		
		while (schedule.hasNextLine())
		{
			String[] line = schedule.nextLine().split(",");
			String type = line[0];
			int month = Integer.parseInt(line[1]);
			int dayInt = Integer.parseInt(line[2]);
			int year = Integer.parseInt(line[3]);
			String timeOfDay = line[4];
			String date = month + "/" + dayInt + "/" + year + " " + timeOfDay;
			DateFormat form = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
			
			try
			{
				day = form.parse(date);
			}
			catch (ParseException e)
			{
				continue;
			}
			
			String descript = line [5];
			
			time.add(Calendar.DATE, 1);
			
			if (Operations.equality(day, time))
			{
				if (type.equalsIgnoreCase("OneTime"))
				{
					oneTimeEvents.add(new OneTime(day, descript));
				}
			
				else if (type.equalsIgnoreCase("Monthly"))
				{
					monthlyEvents.add(new Monthly(day,descript));
				}
				
				else if (type.equalsIgnoreCase("Daily"))
				{
					dailyEvents.add(new Daily(day, descript));
				}
				
				else
				{
					continue;
				}
			}
		}
		ArrayList<Appointment> retArr = Operations.makeArray(oneTimeEvents, monthlyEvents, dailyEvents);
		return retArr;
	}
	
	public static ArrayList<Appointment> WeekEvents(Calendar time, Scanner schedule)
	{
		ArrayList<OneTime> oneTimeEvents = new ArrayList<OneTime>();
		ArrayList<Monthly> monthlyEvents = new ArrayList<Monthly>();
		ArrayList<Daily> dailyEvents = new ArrayList<Daily>();
		Date day;
		
		while (schedule.hasNextLine())
		{
			String[] line = schedule.nextLine().split(",");
			String type = line[0];
			int month = Integer.parseInt(line[1]);
			int dayInt = Integer.parseInt(line[2]);
			int year = Integer.parseInt(line[3]);
			String timeOfDay = line[4];
			String date = month + "/" + dayInt + "/" + year + " " + timeOfDay;
			DateFormat form = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
			
			try
			{
				day = form.parse(date);
			}
			catch (ParseException e)
			{
				continue;
			}
			
			String descript = line [5];
			
			Calendar comp = Calendar.getInstance();
			comp.add(Calendar.DATE, 7);
			
			if (Operations.betweenDates(day, time, comp))
			{
				if (type.equalsIgnoreCase("OneTime"))
				{
					oneTimeEvents.add(new OneTime(day, descript));
				}
			
				else if (type.equalsIgnoreCase("Monthly"))
				{
					monthlyEvents.add(new Monthly(day,descript));
				}
				
				else if (type.equalsIgnoreCase("Daily"))
				{
					dailyEvents.add(new Daily(day, descript));
				}
				
				else
				{
					continue;
				}
			}
		}
		ArrayList<Appointment> retArr = Operations.makeArray(oneTimeEvents, monthlyEvents, dailyEvents);
		return retArr;
	}
	
	public static ArrayList<Appointment> ToDate(Calendar time, Scanner schedule, Date toTime)
	{
		ArrayList<OneTime> oneTimeEvents = new ArrayList<OneTime>();
		ArrayList<Monthly> monthlyEvents = new ArrayList<Monthly>();
		ArrayList<Daily> dailyEvents = new ArrayList<Daily>();
		Date day;
		
		while (schedule.hasNextLine())
		{
			String[] line = schedule.nextLine().split(",");
			String type = line[0];
			int month = Integer.parseInt(line[1]);
			int dayInt = Integer.parseInt(line[2]);
			int year = Integer.parseInt(line[3]);
			String timeOfDay = line[4];
			String date = month + "/" + dayInt + "/" + year + " " + timeOfDay;
			DateFormat form = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
			String descript = line [5];
			
			try
			{
				day = form.parse(date);
				
				Calendar end = Calendar.getInstance();
				end.setTime(toTime);
				
				if (Operations.betweenDates(day, time, end))
				{
					if (type.equalsIgnoreCase("OneTime"))
					{
						oneTimeEvents.add(new OneTime(day, descript));
					}
				
					else if (type.equalsIgnoreCase("Monthly"))
					{
						monthlyEvents.add(new Monthly(day,descript));
					}
					
					else if (type.equalsIgnoreCase("Daily"))
					{
						dailyEvents.add(new Daily(day, descript));
					}
					
					else
					{
						continue;
					}
				}
			}
			catch (ParseException e)
			{
				continue;
			}
			
		}
		ArrayList<Appointment> retArr = Operations.makeArray(oneTimeEvents, monthlyEvents, dailyEvents);
		return retArr;
	}
	
	public static boolean equality(Date day, Calendar time)
	{
		Calendar comp = Calendar.getInstance();
		comp.setTime(day);
		boolean eq = false;
		if (comp.get(Calendar.YEAR) == time.get(Calendar.YEAR) && comp.get(Calendar.DAY_OF_YEAR) == time.get(Calendar.DAY_OF_YEAR))
		{
			eq = true;
		}
		return eq;
	}
	
	public static boolean betweenDates(Date day, Calendar start, Calendar last)
	{
		Calendar between = Calendar.getInstance();
		between.setTime(day);
		boolean bet = false;
		int years = last.get(Calendar.YEAR) - start.get(Calendar.YEAR);
		if (start.get(Calendar.DAY_OF_YEAR) < between.get(Calendar.DAY_OF_YEAR) && between.get(Calendar.DAY_OF_YEAR) < (last.get(Calendar.DAY_OF_YEAR) + (years * 365)));
		{
			bet = true;
		}
		return bet;
	}
	
	public static ArrayList<Appointment> makeArray(ArrayList<OneTime> oneTimeEvents, ArrayList<Monthly> monthlyEvents, ArrayList<Daily> dailyEvents)
	{
		ArrayList<Appointment> madeArray = new ArrayList<Appointment>();
		for (int i = 0; i < oneTimeEvents.size(); i++)
		{
			madeArray.add(oneTimeEvents.get(i));
		}
		for (int i = 0; i < monthlyEvents.size(); i++)
		{
			madeArray.add(monthlyEvents.get(i));
		}
		for (int i = 0; i < dailyEvents.size(); i++)
		{
			madeArray.add(dailyEvents.get(i));
		}
		return madeArray;
	}
	
	public static String StringBuild(ArrayList<Appointment> events)
	{
		String oneTime = "One time events: \r\n";
		String monthly = "Monthly events: \r\n";
		String daily = "Daily events: \r\n";
		for (int i = 0; i < events.size(); i++)
		{
			if (events.get(i) instanceof OneTime)
			{
				oneTime = oneTime + events.get(i).toString() + "\r\n";
			}
			else if (events.get(i) instanceof Monthly)
			{
				monthly = monthly + events.get(i).toString() + "\r\n";
			}
			else if (events.get(i) instanceof Daily)
			{
				daily = daily + events.get(i).toString() + "\r\n";
			}
		}
		
		String finalString = "\n" + oneTime + "\r\n" + monthly + "\r\n" + daily;
		return finalString;
	}
}