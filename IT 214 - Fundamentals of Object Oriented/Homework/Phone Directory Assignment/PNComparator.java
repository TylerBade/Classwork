// Tyler Bade
	
import java.util.Comparator;

// Comparing class for phone numbers, returns compareTo of phone number to help sort.

public class PNComparator implements Comparator<Person>
{
	public int compare(Person a, Person b)
	{
		if (a.pNum == null) {return -1;}
		else if (a.pNum == b.pNum) {return 0;}
		else if (b.pNum == null) {return 1;}
		return a.getNum().compareToIgnoreCase(b.getNum());
	}
}
