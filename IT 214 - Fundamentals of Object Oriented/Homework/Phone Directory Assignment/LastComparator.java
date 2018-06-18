// Tyler Bade

import java.util.Comparator;

// Comparator to help sort Collections by last name

public class LastComparator implements Comparator<Person>
{
	public int compare(Person a, Person b)
	{
		if (a.last == null) {return -1;}
		else if (a.last == b.last) {return 0;}
		else if (b.last == null) {return 1;}
		return a.getLast().compareToIgnoreCase(b.getLast());
	}
}