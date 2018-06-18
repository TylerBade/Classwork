// Tyler Bade

import java.util.*;

public class NameComparator implements Comparator<Person>
{
	public int compare(Person a, Person b)
	{
		if (a.getName() == null) {return -1;}
		else if (a.getName() == b.getName()) {return 0;}
		else if (b.getName() == null) {return 1;}
		return a.getName().compareToIgnoreCase(b.getName());
	}
}