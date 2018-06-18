// Tyler Bade

import java.text.DecimalFormat;

public class Poly
{
	public String sideLength(Point vertex1, Point vertex2)
	{
		double sideLen = Math.sqrt((Math.pow((vertex2.getX() - vertex1.getX()), 2)) + (Math.pow((vertex2.getY() - vertex1. getY()), 2)));
		DecimalFormat df = new DecimalFormat("#.00");
		return df.format(sideLen);
	}
	
	public boolean sideEquals(Double side1, Double side2)
	{
		boolean isEqual = false;
		double doubleSide1 = side1;
		double doubleSide2 = side2;
		double epsilonVal = .0001;
		if (Math.abs(doubleSide1 - doubleSide2) <= epsilonVal)
		{
			isEqual = true;
		}
		return isEqual;
	}
}