// Tyler Bade

/* The purpose of this program is to sort counties in alphabetical order, find and display their largest city
and display the rural population of that county using text files as input and outputting results to both the screen and to an
external text file */

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class TBPopRead
{
	public static void main(String[] args) throws FileNotFoundException
	{
	
		// File input and output
		File inputFile1 = new File("CountyPopulations.txt");
		File inputFile2 = new File("CityPopulation.txt");
		File inputFile3 = new File("CityCountyData.txt");
		File outputFile = new File("TBProg3.txt");
	
		Scanner input1 = new Scanner( inputFile1);
		Scanner input2 = new Scanner(inputFile2);
		Scanner input3 = new Scanner(inputFile3);
		PrintWriter out = new PrintWriter(outputFile);
		
		String[][] countyPops = TBCtyPop.CtyPop(input1);
		String[][] cityPops = TBCityPop.CityPop(input2);
		String[][] cityCty = TBCityCty.CityCty(input3);
		
		String[][] sorted = TBArraySort.ArraySort(countyPops, cityPops, cityCty);
		
		for (int i = 0; i < sorted.length; i++)
		{
			String county = sorted[i][0];
			String countyPop = sorted[i][1];
			String largeCity = sorted[i][3];
			String largePop = sorted[i][4];
			String ruralPop = sorted[i][5];
			
			System.out.println(county + " : " + countyPop + " (Largest City = " + largeCity + " : " + largePop + ") Rural % : " + ruralPop);
			out.println(county + " : " + countyPop + " (Largest City = " + largeCity + " : " + largePop + ") Rural % : " + ruralPop);
		}
			
		input1.close();
		input2.close();
		input3.close();
		out.close();
	}
}