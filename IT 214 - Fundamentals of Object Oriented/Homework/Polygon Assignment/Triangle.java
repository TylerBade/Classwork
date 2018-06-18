// Tyler Bade

public class Triangle extends Poly
{
	String triName;
	Point vert1;
	Point vert2;
	Point vert3;
	double side1;
	double side2;
	double side3;
	Point[] vertices = new Point[3];
	double[] sideLengths = new double[3];
	
	public Triangle(String name, Point p1, Point p2, Point p3)
	{
		triName = name;
		vert1 = p1;
		vert2 = p2;
		vert3 = p3;
	}
	
	public String listVertices()
	{
		String retStr = "Vertices: " + vert1 + ", " + vert2 + ", " + vert3;
		return retStr;
	}
	
	public double[] sideList()
	{
		double[] sides = new double[3];
		sides[0] = Double.parseDouble(super.sideLength(vert1, vert2));
		sides[1] = Double.parseDouble(super.sideLength(vert2, vert3));
		sides[2] = Double.parseDouble(super.sideLength(vert3, vert1));
		return sides;
	}
		
	public String listSides()
	{
		side1 = Double.parseDouble(super.sideLength(vert1, vert2));
		side2 = Double.parseDouble(super.sideLength(vert2, vert3));
		side3 = Double.parseDouble(super.sideLength(vert3, vert1));
		String retStr = "Side lengths: " + side1 + "  " + side2 + "  " + side3;
		return retStr;
	}
	
	public String toString()
	{
		String retStr = "The triangle is " + triName + "\r\n" + this.listVertices() + "\r\n" + this.listSides() + "\r\n";
		if (super.sideEquals(side1,side2) || super.sideEquals(side2,side3) || super.sideEquals(side3, side1))
		{
			retStr = retStr + "At least two sides are of equal length. \r\n";
		}
		else
		{
			retStr = retStr + "No sides are of equal length. \r\n";
		}
		return retStr;
	}
}