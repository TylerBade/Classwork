// Tyler Bade

import java.text.*;
import java.util.*;
import java.time.*;
import java.io.*;

public class TBProg7
{
	public static void main(String[] args) throws FileNotFoundException
	{
		ArrayList<Appointment> events = new ArrayList<Appointment>();
		Scanner sched = new Scanner(new File("dates.txt"));
		Calendar curr = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm a");
		
		System.out.println("1: Print all of today's events.\n2: Print tomorrows events.");
		System.out.println("3: Print all events for the next week (today as well).\n4: Get your schedule up to an entered day.");
		Scanner in = new Scanner(System.in);
		System.out.println("What do you want to do? ");
		int input = in.nextInt();
		
		if (input == 1)
		{
			events = Operations.TodayEvents(curr, sched);
		}
		else if (input == 2)
		{
			events = Operations.TomorrowEvents(curr, sched);
		}
		else if (input == 3)
		{
			events = Operations.WeekEvents(curr, sched);
		}
		else if (input == 4)
		{
			Date toTime;
			
			for (int retries = 0; ; retries++)
			{
				try
				{
					Scanner inDate = new Scanner(System.in);
					System.out.println("Please give a date (MM/DD/YYYY): ");
					String day = inDate.next();
					String time = "11:59 PM";
					toTime = sdf.parse(day + " " + time);
					break;
				}
				catch (Exception e)
				{
					System.out.println("That isn't a date this program can use, try again.");
					if (retries < 5)
					{
						continue;
					}
					else
					{
						System.out.println("We can't get a good date to use, something went wrong somewhere");
					}
				}
			}
			events = Operations.ToDate(curr, sched, toTime);
		}
		
		String printout = Operations.StringBuild(events);
		System.out.println(printout);
		
		Scanner secondIn = new Scanner(System.in);
		String option;
		
		do
		{
			System.out.println("\n5: Add event.\n6: Remove event.\n7: Quit");
			System.out.println("What would you like to do? ");
			option = secondIn.next();
			if (option.equals("5"))
			{
				boolean usable = true;
				while (usable)
				{
					Date dayOfAppt;
					
					//Event description
					Scanner newEvent = new Scanner(System.in);
					System.out.println("What is this event? ");
					String description = newEvent.nextLine();
					
					for (int retries = 0; ; retries++)
					{
						
						try
						{
							//Event date
							Scanner newEventDate = new Scanner(System.in);
							System.out.println("Whats the date? (MM/DD/YYYY) ");
							String day = newEventDate.nextLine();
							Scanner newEventTime = new Scanner(System.in);
							System.out.println("At what time? (hh:mm (am/pm)) ");
							String time = newEventTime.nextLine();
							dayOfAppt = sdf.parse(day + " " + time);
							break;
						}
						catch (Exception e)
						{
							System.out.println("That isn't a date this program can use, try again.");
							if (retries < 5)
							{
								continue;
							}
							else
							{
								System.out.println("We can't get a good date to use, something went wrong somewhere");
								usable = false;
							}
						}
					}
					
					// event type
					Scanner eventType = new Scanner(System.in);
					System.out.println("Daily, monthly or one time?" );
					String type = eventType.nextLine();
					
					if (type.equalsIgnoreCase("OneTime") || type.equals("One Time"))
					{
						events.add(new OneTime(dayOfAppt, description));
					}
				
					else if (type.equalsIgnoreCase("Monthly"))
					{
						events.add(new Monthly(dayOfAppt,description));
					}
					
					else if (type.equalsIgnoreCase("Daily"))
					{
						events.add(new Daily(dayOfAppt, description));
					}
					break;
				}
			}
			
			if (option.equals("6"))
			{
				if (events.size() <=0)
				{
					System.out.println("Nothing to remove");
					continue;
				}
				else
				{
					Scanner eventRemoval = new Scanner(System.in);
					System.out.println("What do you want to remove? (Enter the whole description please) ");
					String removedEvent = eventRemoval.next();
					
					for (Appointment event : events)
					{
						if (removedEvent.equals(event.getDesc()))
						{
							events.remove(removedEvent);
						}
					}
					continue;
				}
			}
			
			if (option.equals("7"))
			{
				PrintWriter outFile = new PrintWriter("TBProg7.txt");
				String output = Operations.StringBuild(events);
				outFile.println(output);
				outFile.close();
				sched.close();
				System.exit(0);
			}
			
		}
		while (option != "7");
	}
}