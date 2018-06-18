// Tyler Bade

public class Quad extends Poly
{
	String quadName;
	Point vert1;
	Point vert2;
	Point vert3;
	Point vert4;
	double side1;
	double side2;
	double side3;
	double side4;
	double diag1;
	double diag2;
	Point[] vertices = new Point[4];
	double[] sideLengths = new double[4];
	double[] diags = new double[2];
	
	
	public Quad(String name, Point p1, Point p2, Point p3, Point p4)
	{
		quadName = name;
		vert1 = p1;
		vert2 = p2;
		vert3 = p3;
		vert4 = p4;
	}
	
	public String printName()
	{
		String name = "The name of this quadrilateral is " + quadName;
		return name;
	}
	
	public String listVertices()
	{
		String retStr = "Vertices: " + vert1 + ", " + vert2 + ", " + vert3 + ", " + vert4;
		return retStr;
	}
	
	public double[] sidesList()
	{
		double[] sides = new double[4];
		sides[0] =  Double.parseDouble(super.sideLength(vert1, vert2));
		sides[1] = Double.parseDouble(super.sideLength(vert2, vert3));
		sides[2] = Double.parseDouble(super.sideLength(vert3, vert4));
		sides[3] = Double.parseDouble(super.sideLength(vert4, vert1));
		return sides;
	}
	
	public String listSides()
	{
		side1 = Double.parseDouble(super.sideLength(vert1, vert2));
		side2 = Double.parseDouble(super.sideLength(vert2, vert3));
		side3 = Double.parseDouble(super.sideLength(vert3, vert4));
		side4 = Double.parseDouble(super.sideLength(vert4, vert1));
		String retStr = "Side lengths: " + side1 + "  " + side2 + "  " + side3 + "  " + side4;
		return retStr;
	}
	
	public double[] diagsList()
	{
		double[] diagList = new double[2];
		diagList[0] = Double.parseDouble(super.sideLength(vert1, vert3));
		diagList[1] = Double.parseDouble(super.sideLength(vert2, vert4));
		return diagList;
	}
	
	public String listDiags()
	{
		diag1 = Double.parseDouble(super.sideLength(vert1, vert3));
		diag2 = Double.parseDouble(super.sideLength(vert2, vert4));
		String retStr = "Diagonals: " + diag1 + "  " + diag2;
		return retStr;
	}
	
	public String toString()
	{
		String retStr = this.printName() + "\r\n" + this.listVertices() + "\r\n" + this.listSides() + "\r\n" + this.listDiags() + "\r\n";
		if (super.sideEquals(side1, side3) || super.sideEquals(side2, side4) || super.sideEquals(side1, side2)
			|| super.sideEquals(side3, side4) || super.sideEquals(side1, side4) || super.sideEquals(side2, side3))
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