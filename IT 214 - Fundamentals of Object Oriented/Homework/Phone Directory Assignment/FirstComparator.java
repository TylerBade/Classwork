// Tyler Bade

import java.util.Comparator;

// Comparator used for sorting collections by First Name
public class  FirstComparator implements Comparator<Person>
{
	public int compare(Person a, Person b)
	{
		if (a.first == null) {return -1;}
		else if (a.first == b.first) {return 0;}
		else if (b.first == null) {return 1;}
		return a.getFirst().compareToIgnoreCase(b.getFirst());
	}
}