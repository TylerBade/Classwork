// Tyler Bade

import java.text.DecimalFormat;

public class Triangle
{
	String triName;
	Point vert1;
	Point vert2;
	Point vert3;
	String[][] vertices = new String[3][2];
	String[][] sideLengths = new String[3][2];
	
	
	public Triangle(String name, Point p1, Point p2, Point p3)
	{
		triName = name;
		vert1 = p1;
		vert2 = p2;
		vert3 = p3;
	}
	
	private String sideLength(Point vertex1, Point vertex2)
	{
		double sideLen = Math.sqrt((Math.pow((vertex2.getX() - vertex1.getX()), 2)) + (Math.pow((vertex2.getY() - vertex1. getY()), 2)));
		DecimalFormat df = new DecimalFormat("#.00");
		return df.format(sideLen);
	}
	
	public String[][] listVertices()
	{
		vertices [0][0] = "Vertex 1: ";
		vertices [0][1] = "(" + Double.toString(vert1.getX()) + ", " + Double.toString(vert1.getY()) + ")";
		vertices [1][0] = "Vertex 2: ";
		vertices [1][1] = "(" + Double.toString(vert2.getX()) + ", " + Double.toString(vert2.getY()) + ")";
		vertices [2][0] = "Vertex 3: ";
		vertices [2][1] = "(" + Double.toString(vert3.getX()) + ", " + Double.toString(vert3.getY()) + ")";
		return vertices;
	}
	
	public String[][] listSides()
	{
		sideLengths[0][0] = "Side 1: ";
		sideLengths[0][1] = sideLength(vert1, vert2);
		sideLengths[1][0] = "Side 2: ";
		sideLengths[1][1] = sideLength(vert2, vert3);
		sideLengths[2][0] = "Side 3: ";
		sideLengths[2][1] = sideLength(vert3, vert1);
		return sideLengths;
	}
	
	public String toString()
	{
		String[][] verts = this.listVertices();
		String[][] sides = this.listSides();
		String vertex1 = verts[0][1];
		String vertex2 = verts[1][1];
		String vertex3 = verts[2][1];
		String side1 = sides[0][0] + sides[0][1];
		String side2 = sides[1][0] + sides[1][1];
		String side3 = sides[2][0] + sides[2][1];
		String retStr = "The triangle is " + triName + "\r\n" + "Veteces: " + vertex1 + " " + vertex2 + " " + vertex3 + "\r\n" + side1 + "\r\n" + side2 + "\r\n" + side3 + "\r\n";
		return retStr;
	}
}