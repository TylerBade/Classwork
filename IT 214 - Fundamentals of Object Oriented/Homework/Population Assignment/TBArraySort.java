// Tyler Bade

import java.io.*;
import java.lang.*;
import java.util.ArrayList;
import java.util.Scanner;

public class TBArraySort
{
	public static String[][] ArraySort(String[][] ctyPop, String[][] cityPop, String[][] cityCty)
	{
		String[][] arraySort = new String[ctyPop.length][6];
		
		// Begins searching by county
		for (int i = 0; i < ctyPop.length; i++)
		{
			// Gives the county population variables
			String county = ctyPop[i][0];
			int countyPop = Integer.parseInt(ctyPop[i][1]);
			int total = 0;
			String largest = "none";
			int largePop = 0;
			double rural;
			
			// Searches city-county list for matches
			for (int k = 0; k < cityCty.length; k++)
			{
				if (county.equals(cityCty[k][1]))
				{
					// figures out what city to look for in the citypop list
					String lookFor = cityCty[k][0];
					for (int m = 0; m < cityPop.length; m++)
					{
						String city = cityPop[m][0];
						if (city.equals(lookFor))
						{
							// Figures out if population is larger than the largest on record
							if (Integer.parseInt(cityPop[m][1]) > largePop)
							{
								largest = city;
								largePop = Integer.parseInt(cityPop[m][1]);
							}
							total = total + Integer.parseInt(cityPop[m][1]);
						}
					}
				}
			}
			rural = ((double) total / countyPop) * 100;
			
			arraySort[i][0] = county;
			arraySort[i][1] = Integer.toString(countyPop);
			arraySort[i][2] = Integer.toString(total);
			arraySort[i][3] = largest;
			arraySort[i][4] = Integer.toString(largePop);
			arraySort[i][5] = Double.toString(rural);
		}
		return arraySort;
	}
}