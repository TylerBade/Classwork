// Tyler Bade

import java.util.*;

// Class stores all information being used for people and implements a way to compare them

public class Person implements Comparable<Person>
{
	String first;
	String last;
	String pNum;
	
	public Person(String lName, String fName, String PNum)
	{
		this.first = fName;
		this.last = lName;
		this.pNum = PNum;
	}
	
	public String getFirst()
	{
		return first;
	}
	
	public String getLast()
	{
		return last;
	}
	
	public String getName()
	{
		return first + " " + last;
	}
	
	public String getNum()
	{
		return pNum;
	}
		
	public String toString()
	{
		String retStr = first + " " + last + ", " + pNum;
		return retStr;
	}
	
	public int compareTo(Person p)
	{
		return last.compareTo(p.last);
	}
	
}