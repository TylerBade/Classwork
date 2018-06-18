// Tyler Bade

public class Point
{
	private double xValue;
	private double yValue;
	
	public Point(double xVal, double yVal)
	{
		{
			xValue = xVal;
			yValue = yVal;
		}
	}
	
	public double getX()
	{
		return xValue;
	}
	
	public double getY()
	{
		return yValue;
	}
	
	public static boolean equals(Point p1, Point p2)
	{
		if (p1.getX() == p2.getX() && p1.getY() == p2.getY())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public String toString()
	{
		String retStr = "(" + this.getX() + "," + this.getY() + ")";
		return retStr;
	}
}