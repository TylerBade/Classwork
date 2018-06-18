// Tyler Bade

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class TBCityPop
{
	public static String[][] CityPop(Scanner input)
	{
		// Creates arraylists for data to be stored in
		ArrayList<String> cities = new ArrayList<String>();
		ArrayList<String> cityPops = new ArrayList<String>();
		final int ARRAYCOUNT = 2;
			
		// splits all of the data in the input file at the separation punctuation
		while (input.hasNextLine())
		{
			String data = input.nextLine();
			String[] split = data.split(",");
			boolean usable = true;
			for (int i = 0; i < split[1].length(); i++)
			{
				// Figures out whether or not the data is actually usable (whether it has a name-population)
				char ch = split[1].charAt(i);
				if (!Character.isDigit(ch))
				{
					usable = false;
				}
			}
			if (usable != false)
			{
				//Adds the splits to the arraylists
			for (int i = 0; i <= 1; i++)
				{
					if (i == 0)
					{
						cities.add(split[i]);
					}
					else if (i == 1)
					{
						cityPops.add(split[i]);
					}
				}
			}
		}
	
		String[][] cityPop = new String[cities.size()][ARRAYCOUNT];
		int i = 0;
		
		// puts the splits into their respective places in the arrays.
		while (i < cities.size())
		{
			for (int j = 0; j <= 1; j++)
			{
				if (j == 0)
				{
					cityPop[i][j] = cities.get(i);
				}
				else if (j == 2)
				{
					cityPop[i][j] = cityPops.get(i);
				}
			}
			i++;
		}
		return cityPop;
	}
}