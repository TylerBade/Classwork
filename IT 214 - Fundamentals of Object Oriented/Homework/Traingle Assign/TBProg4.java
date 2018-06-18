// Tyler Bade

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class TBProg4
{
	public static void main(String args[]) throws FileNotFoundException
	{
		ArrayList<Triangle> tris = new ArrayList<Triangle>();
		
		File inputFile = new File("triInput.txt");
		File outputFile = new File("TBProg4.txt");
		
		Scanner in = new Scanner(inputFile);
		PrintWriter out = new PrintWriter(outputFile);
		
		while (in.hasNextLine())
		{
			String[] triArray = in.nextLine().split("\\s+");
			String name = triArray[0];
			Point first = new Point(Double.parseDouble(triArray[1]), Double.parseDouble(triArray[2]));
			Point second = new Point(Double.parseDouble(triArray[3]), Double.parseDouble(triArray[4]));
			Point third = new Point(Double.parseDouble(triArray[5]), Double.parseDouble(triArray[6]));
			boolean valid = true;
			if (first.equals(second) || second.equals(third))
			{
				valid = false;
				System.out.println("Two points in triangle " + name + " are equal, it cannot be a triangle.\r\n");
				out.println("Two points in triangle " + name + " are equal, it cannot be a triangle.\r\n");
			}
			
			if (first.getX() == second.getX() && second.getX() == third.getX())
			{
				valid = false;
				System.out.println("All X values are the same, " + name + " can't be a triangle.\r\n");
				out.println("All X values are the same, " + name + " can't be a triangle.\r\n");
			}
			
			if (first.getY() == second.getY() && second.getY() == third.getY())
			{
				valid = false;
				System.out.println("All Y values are the same, " + name + " can't be a triangle.\r\n");
				out.println("All Y values are the same, " + name + " can't be a triangle.\r\n");
			}
			
			if (valid != false)
			{
				Triangle thisTri = new Triangle(name, first, second, third);
				tris.add(thisTri);
			}
		}
		
		for (int i = 0; i < tris.size(); i++)
		{
			System.out.println(tris.get(i));
			out.println(tris.get(i));
		}
		in.close();
		out.close();
	}
}