// Tyler Bade

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class TBProg5
{
	public static void main(String[] args) throws FileNotFoundException
	{
		File inFile = new File("polyInput.txt");
		Scanner in = new Scanner(inFile);
		PrintWriter out = new PrintWriter("TBmyPoly.txt");
		
		ArrayList<Triangle> myTri = new ArrayList<Triangle>();
		ArrayList<Quad> myQuad = new ArrayList<Quad>();
		
		while (in.hasNextLine())
		{
			String line = in.nextLine();
			String[] splitLine = line.split(" ");
			if (splitLine.length == 7)
			{
				String name = splitLine[0];
				Point pt1 = new Point(Double.parseDouble(splitLine[1]), Double.parseDouble(splitLine[2]));
				Point pt2 = new Point(Double.parseDouble(splitLine[3]), Double.parseDouble(splitLine[4]));
				Point pt3 = new Point(Double.parseDouble(splitLine[5]), Double.parseDouble(splitLine[6]));
				if (triCheck(pt1, pt2, pt3))
				{
					myTri.add(new Triangle(name, pt1, pt2, pt3));
				}
				else
				{
					System.out.println("Not a triangle.\r\n");
					out.println("Not a triangle.\r\n");
				}
			}
			else if (splitLine.length == 9)
			{
				String name = splitLine[0];
				Point pt1 = new Point(Double.parseDouble(splitLine[1]), Double.parseDouble(splitLine[2]));
				Point pt2 = new Point(Double.parseDouble(splitLine[3]), Double.parseDouble(splitLine[4]));
				Point pt3 = new Point(Double.parseDouble(splitLine[5]), Double.parseDouble(splitLine[6]));
				Point pt4 = new Point(Double.parseDouble(splitLine[7]), Double.parseDouble(splitLine[8]));
				if (quadCheck(pt1, pt2, pt3, pt4))
				{
					myQuad.add(new Quad(name, pt1, pt2, pt3, pt4));
				}
				else
				{
					System.out.println("Not a quadrilateral.\r\n");
					out.println("Not a quadrilateral.\r\n");
				}
			}
			else
			{
				System.out.println("Not a quadrilateral or Triangle.\r\n");
			}
		}
		
		for (Triangle tri : myTri)
		{
			System.out.println(tri);
			out.println(tri);
		}
		
		for (Quad quad : myQuad)
		{
			System.out.println(quad);
			out.println(quad);
		}
		
		in.close();
		out.close();
	}
	
	public static boolean triCheck(Point pt1, Point pt2, Point pt3)
	{
		boolean triCheck = false;
		if (!Point.equals(pt1, pt2) && !Point.equals(pt2, pt3) && !Point.equals(pt3, pt1))
		{
			Triangle attempting = new Triangle("Attempting", pt1, pt2, pt3);
			double[] sides = attempting.sideList();
			if (!(sides[0] + sides[1] == sides[2]) && !(sides[1] + sides[2] == sides[0]) && !(sides[2] + sides[0] == sides[1]))
			{
				triCheck = true;
			}
		}
		return triCheck;
	}
	
	public static boolean quadCheck(Point pt1, Point pt2, Point pt3, Point pt4)
	{
		boolean quadCheck = false;
		if (!(Point.equals(pt1, pt2)) && !(Point.equals(pt2, pt3)) && !(Point.equals(pt3, pt4)) && !(Point.equals(pt4, pt1)))
		{
			Quad temp = new Quad("Temp", pt1, pt2, pt3, pt4);
			double[] sideList = temp.sidesList();
			double[] diagList = temp.diagsList();
			if (!(sideList[0] + sideList[1] == diagList[0]) && !(sideList[2] + sideList[3] == diagList[1])
				&& !(sideList[0] + sideList[1] == diagList[1]) && !(sideList[2] + sideList[3] == diagList[0])
				&& !(sideList[1] + sideList[2] == diagList[0]) && !(sideList[3] + sideList[0] == diagList[1])
				&& !(sideList[1] + sideList[2] == diagList[1]) && !(sideList[3] + sideList[0] == diagList[0]))
			{
				quadCheck = true;
			}
		}
		return quadCheck;
	}
}