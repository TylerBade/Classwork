// Tyler Bade

import java.util.ArrayList;

public class Searchers
{
	
	// Binary search function for First Names
	public static ArrayList<Integer> searchByFN(ArrayList<Person> dir, int first, int last, String firstName)
	{
		ArrayList<Integer> validInts = new ArrayList<Integer>();
		
		boolean found = false;
		int low = first;
		int high = last;
		int pos = 0;
		
		// Binary search of array
		while (low <= high && !found)
		{
			pos = (high + low) / 2;
			
			if (dir.get(pos).getFirst().compareToIgnoreCase(firstName) > 0)
			{
				high = pos - 1;
			}
			else if (dir.get(pos).getFirst().compareToIgnoreCase(firstName) < 0)
			{
				low = pos + 1;
			}
			else
			{
				found = true;
				validInts.add(pos);
			}
		}
		
		if (found)
		{
			// Checks to the right for other matches
			for (int i = pos + 1; i < dir.size(); i++)
			{
				if (checkRightByFirst(dir, i, firstName))
				{
					validInts.add(i);
				}
				else
				{
					break;
				}
			}
			
			// Checks to the left for other matches
			for (int i = pos - 1; i > 0; i--)
			{
				if (checkLeftByFirst(dir, i, firstName))
				{
					validInts.add(i);
				}
				else
				{
					break;
				}
			}
		}
		return validInts;
	}
	
	// Binary search function for Phone numbers
	public static ArrayList<Integer> searchByPN(ArrayList<Person> dir, int first, int last, String phone)
	{
		ArrayList<Integer> validInts = new ArrayList<Integer>();
		
		boolean found = false;
		int low = first;
		int high = last;
		int pos = 0;
		
		// Binary search of array
		while (low <= high && !found)
		{
			pos = (high + low) / 2;
			
			if (dir.get(pos).getNum().compareToIgnoreCase(phone) > 0)
			{
				high = pos - 1;
			}
			else if (dir.get(pos).getNum().compareToIgnoreCase(phone) < 0)
			{
				low = pos + 1;
			}
			else
			{
				found = true;
				validInts.add(pos);
			}
		}
		
		if (found)
		{
			// Checks everything to the right to see if there's matches
			for (int i = pos + 1; i < dir.size(); i++)
			{
				if (checkRightByPN(dir, i, phone))
				{
					validInts.add(i);
				}
				else
				{
					break;
				}
			}
			// Checks everything to the left to see if there's matches
			for (int i = pos - 1; i > 0; i--)
			{
				if (checkLeftByPN(dir, i, phone))
				{
					validInts.add(i);
				}
				else
				{
					break;
				}
			}
		}
		return validInts;
	}
	
	// Binary search function for Last Names
	public static ArrayList<Integer> searchByLN(ArrayList<Person> dir, int first, int last, String lastName)
	{
		ArrayList<Integer> validInts = new ArrayList<Integer>();
		
		boolean found = false;
		int low = first;
		int high = last;
		int pos = 0;
		
		// Binary search of array
		while (low <= high && !found)
		{
			pos = (high + low) / 2;
			
			if (dir.get(pos).getLast().compareToIgnoreCase(lastName) > 0)
			{
				high = pos - 1;
			}
			else if (dir.get(pos).getLast().compareToIgnoreCase(lastName) < 0)
			{
				low = pos + 1;
			}
			else
			{
				found = true;
				validInts.add(pos);
			}
		}
		
		if (found)
		{
			// Checks everything to the right to see if there's matches
			for (int i = pos + 1; i < dir.size(); i++)
			{
				if (checkRightByLast(dir, i, lastName))
				{
					validInts.add(i);
				}
				else
				{
					break;
				}
			}
			// Checks everything to the left to see if there's matches
			for (int i = pos - 1; i > 0; i--)
			{
				if (checkLeftByLast(dir, i, lastName))
				{
					validInts.add(i);
				}
				else
				{
					break;
				}
			}
		}
		return validInts;
	}
	
	public static ArrayList<Integer> searchByFullName(ArrayList<Person> dir, int first, int last, String fullName)
	{
		ArrayList<Integer> validInts = new ArrayList<Integer>();
		
		boolean found = false;
		int low = first;
		int high = last;
		int pos = 0;
		
		// Binary search of array
		while (low <= high && !found)
		{
			pos = (high + low) / 2;
			
			if (dir.get(pos).getName().compareToIgnoreCase(fullName) > 0)
			{
				high = pos - 1;
			}
			else if (dir.get(pos).getName().compareToIgnoreCase(fullName) < 0)
			{
				low = pos + 1;
			}
			else
			{
				found = true;
				validInts.add(pos);
			}
		}
		
		if (found)
		{
			// Checks to the right for other matches
			for (int i = pos + 1; i < dir.size(); i++)
			{
				if (checkRightByFull(dir, i, fullName))
				{
					validInts.add(i);
				}
				else
				{
					break;
				}
			}
			
			// Checks to the left for other matches
			for (int i = pos - 1; i > 0; i--)
			{
				if (checkLeftByFull(dir, i, fullName))
				{
					validInts.add(i);
				}
				else
				{
					break;
				}
			}
		}
		return validInts;
	}
	
	// Left check for First Name
	public static boolean checkLeftByFirst(ArrayList<Person> dir, int index, String firstName)
	{
		if (dir.get(index).getFirst().equalsIgnoreCase(firstName))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	// Right check for first name
	public static boolean checkRightByFirst(ArrayList<Person>dir, int index, String firstName)
	{
		if (dir.get(index).getFirst().equalsIgnoreCase(firstName))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	// left check for last name
	public static boolean checkLeftByLast(ArrayList<Person> dir, int index, String lastName)
	{
		if (dir.get(index).getLast().equalsIgnoreCase(lastName))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	// right check for last name
	public static boolean checkRightByLast(ArrayList<Person> dir, int index, String lastName)
	{
		if (dir.get(index).getLast().equalsIgnoreCase(lastName))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	// left check for phone number
	public static boolean checkLeftByPN(ArrayList<Person> dir, int index, String phone)
	{
		if (dir.get(index).getNum().equalsIgnoreCase(phone))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	// right check for phone number
	public static boolean checkRightByPN(ArrayList<Person> dir, int index, String phone)
	{
		if (dir.get(index).getNum().equalsIgnoreCase(phone))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public static boolean checkLeftByFull(ArrayList<Person> dir, int index, String fullName)
	{
		if (dir.get(index).getName().equalsIgnoreCase(fullName))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	// right check for phone number
	public static boolean checkRightByFull(ArrayList<Person> dir, int index, String fullName)
	{
		if (dir.get(index).getName().equalsIgnoreCase(fullName))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}