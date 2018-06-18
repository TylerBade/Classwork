// Tyler Bade

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import java.util.Random;
import java.util.Collections;
import java.util.Comparator;

public class TBProg6
{
	public static void main(String[] args) throws FileNotFoundException, IOException
	{
		int numAttempts = 0;
		Scanner numInput = new Scanner(System.in);
		System.out.println("How many people will be in this directory? ");
		
		if (numInput.hasNextInt())
		{
			numAttempts = numInput.nextInt();
		}
		
		ArrayList<Person> directory = new ArrayList<Person>();
		
		// Area code list
		ArrayList<Integer> validCodes = new ArrayList<Integer>();
		BufferedReader areaCodes = new BufferedReader(new FileReader("AreaCodes.csv"));
		String line;
		while ((line = areaCodes.readLine()) != null)
		{
			try
			{
				String[] lineSplit = line.split(",");
				validCodes.add(Integer.parseInt(lineSplit[0]));
			}
			catch (NumberFormatException NF)
			{
				continue;
			}
		}
		
		// First Names list
		ArrayList<String> firstNames = new ArrayList<String>();
		BufferedReader fNames = new BufferedReader(new FileReader("FirstNames.csv"));
		int iteration = 0;
		while ((line = fNames.readLine()) != null)
		{
			if (iteration == 0)
			{
				iteration++;
				continue;
			}
			firstNames.add(line);
		}		
		
		// Last Names list
		ArrayList<String> lastNames = new ArrayList<String>();
		BufferedReader lNames = new BufferedReader(new FileReader("LastNames.csv"));
		iteration = 0;
		while ((line = lNames.readLine()) != null)
		{
			if (iteration == 0)
			{
				iteration++;
				continue;
			}
			lastNames.add(line);
		}
		
		int fNamesSize = firstNames.size();
		int lNamesSize = lastNames.size();
		int acSize = validCodes.size();
		
		// Randomly assigns first name, last name and phone number to every person being added to directory
		for (int i = 0; i < numAttempts; i++)
		{
			Random fnRandInt = new Random();
			int fNameNum = fnRandInt.nextInt(fNamesSize);
			Random lnRandInt = new Random();
			int lNameNum = lnRandInt.nextInt(lNamesSize);
			Random acRandInt = new Random();
			int areaCodeNum = acRandInt.nextInt(acSize);
			
			String areaCode = Integer.toString(validCodes.get(areaCodeNum));
			Random randint = new Random();
			int remNum = randint.nextInt(9000000) +1000000;
			
			String pNum = areaCode + remNum;
			String first = firstNames.get(fNameNum);
			String last = lastNames.get(lNameNum);
			
			Person addition = new Person(first, last, pNum);
			directory.add(addition);
		}
		
		StopWatch timer = new StopWatch();
		
		Scanner sortType = new Scanner(System.in);
		System.out.println("What value are you looking for? (first, first name, last, last name, number, phone number, name are valid) ");
		
		String type = "";
		if (sortType.hasNextLine())
		{
			type = sortType.nextLine();
		
			if (type.equalsIgnoreCase("first") || type.equalsIgnoreCase("first name"))
			{
				// Sort arraylist by first name
				Collections.sort(directory, new FirstComparator());
				
				// get the first name to be searched for
				String firstName = "";
				Scanner fninput =  new Scanner(System.in);
				System.out.println("Whats the first name of who you're looking for? ");
				if (fninput.hasNextLine())
				{
					firstName = fninput.nextLine();
				}
			
				// Starts timer and starts search for the name
				timer.start();
				ArrayList<Integer> indexes = Searchers.searchByFN(directory, 0, directory.size() - 1, firstName);
				timer.stop();
		
				// Prints results
				if (indexes.size() > 0)
				{
					for (int i : indexes)
					{
						System.out.println(directory.get(i));
					}
				}
				else
				{
					System.out.println("Sorry, couldn't find anyone with that first name.");
				}
				System.out.println("Time for this search: " + timer.getElapsedTime() + " milliseconds.");
			}
			
			else if (type.equalsIgnoreCase("last") || type.equalsIgnoreCase("last name"))
			{
				// Sort arraylist by last name
				Collections.sort(directory, new LastComparator());
			
				// get the last name to be searched for
				String lastName = "";
				Scanner lninput =  new Scanner(System.in);
				System.out.println("Whats the last name of who you're looking for? ");
				if (lninput.hasNextLine())
				{
					lastName = lninput.nextLine();
				}
				
				// Starts timer and starts search for the name
				timer.start();
				ArrayList<Integer> indexes = Searchers.searchByLN(directory, 0, directory.size() - 1, lastName);
				timer.stop();
		
				// Prints results
				if (indexes.size() > 0)
				{
					for (int i : indexes)
					{
						System.out.println(directory.get(i));
					}
				}
				else
				{
					System.out.println("Sorry, couldn't find anyone with that last name.");
				}
				System.out.println("Time for this search: " + timer.getElapsedTime() + " milliseconds.");
			}
		
			else if (type.equalsIgnoreCase("Name"))
			{
				// Sort arraylist by first name
				Collections.sort(directory, new NameComparator());
			
				// get the first name to be searched for
				String fullName = "";
				Scanner fullinput =  new Scanner(System.in);
				System.out.println("Whats the full name of who you're looking for? ");
				if (fullinput.hasNextLine())
				{
					fullName = fullinput.nextLine();
				}
				
				// Starts timer and starts search for the name
				timer.start();
				ArrayList<Integer> indexes = Searchers.searchByFullName(directory, 0, directory.size() - 1, fullName);
				timer.stop();
		
				// Prints results
				if (indexes.size() > 0)
				{
					for (int i : indexes)
					{
						System.out.println(directory.get(i));
					}
				}
				else
				{
					System.out.println("Sorry, couldn't find anyone with that full name.");
				}
				System.out.println("Time for this search: " + timer.getElapsedTime() + " milliseconds.");
				}
			
			else if (type.equalsIgnoreCase("number") || type.equalsIgnoreCase("phone number"))
			{
				// Sort arraylist by first name
				Collections.sort(directory, new PNComparator());
				
				// get the first name to be searched for
				String phone = "";
				Scanner numinput =  new Scanner(System.in);
				System.out.println("Whats the number you're looking for? ");
				if (numinput.hasNextLine())
				{	
					phone = numinput.nextLine();
				}
			
				// Starts timer and starts search for the name
				timer.start();
				ArrayList<Integer> indexes = Searchers.searchByPN(directory, 0, directory.size() - 1, phone);
				timer.stop();
		
				// Prints results
				if (indexes.size() > 0)
				{
					for (int i : indexes)
					{
						System.out.println(directory.get(i));
					}
				}
				else
				{
					System.out.println("Sorry, couldn't find anyone with that Phone number.");
				}
				System.out.println("Time for this search: " + timer.getElapsedTime() + " milliseconds.");
			}
			
			 else
			 {
				 System.out.println("Can't recognize the type of data you want to search for, sorry. =(");
			}
		}
		
		areaCodes.close();
		fNames.close();
		lNames.close();
	}
}