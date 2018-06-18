// Tyler Bade


import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class TBCityCty
{
	public static String[][] CityCty(Scanner input)
	{
		// Creates arraylists for data to be stored in
		ArrayList<String> cities = new ArrayList<String>();
		ArrayList<String> counties = new ArrayList<String>();
		final int ARRAYCOUNT = 2;
			
		// splits all of the data in the input file at the separation punctuation
		while (input.hasNextLine())
		{
			String data = input.nextLine();
			String[] split = data.split(",");
			
			//Adds the splits to the arraylists
			for (int i = 0; i <= 1; i++)
			{
				if (i == 0)
				{
					cities.add(split[i]);
				}
				else
				{
					counties.add(split[i]);
				}
			}
			
		}
	
		String[][] cityCty = new String[cities.size()][ARRAYCOUNT];
		int i = 0;
		// puts the splits into their respective places in the arrays.
		while (i < cities.size())
		{
			for (int j = 0; j <= 1; j++)
			{
				if (j == 0)
				{
					cityCty[i][j] = cities.get(i);
				}
				else
				{
					cityCty[i][j] = counties.get(i);
				}
			}
			i++;
		}
		return cityCty;
	}
}