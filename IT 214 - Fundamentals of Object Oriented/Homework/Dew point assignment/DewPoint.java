// Tyler Bade

// Program 1
/**
Dew point is the atmospheric temperature where dew will form (where water begins to condense) according to dictionary.com.
Relative Humidity is the amount of vapor present in the air, normally expressed as a percent.
Dew point is far more relevant to human perception of how the air outside feels, as such, more precautions are needed on days
with excessive dewpoints. Under 60 degrees F is usually a safe area, relative humidity has comfort points between 30-70%.
High dew points can also damage machinery and other types of equipment.
*/

/*
This program will take  the Relative humidity (Decimal between 0 and 1)
and the actual Temperature (in degrees Farenheit) and give the Dew Point level.
*/

import java.util.Scanner;


public class DewPoint
{
	public static void main(String[] args)
	{
		// Reads Temperature
		
		Scanner in = new Scanner(System.in);
		
		System.out.print("Please enter the temperature (in degrees F): ");
		double inTempF = in.nextDouble();
		
		// Reads General Humidity (In decimal)
		
		System.out.print("Please enter the Relative Humidity (value between 0-1 (%/100)): ");
		double inHum = in.nextDouble();
		
		// Formula variables a and b
		
		double a = 17.27;
		double b = 237.7;
		
		// convert to C
		
		double inTempC = (inTempF - 32) / 1.8;
		
		// Plug in variables (a and b given, inHum is input humidity, inTempC is the temperature in Celcius)
		// f = F(T,Hum)
		
		double f = (((a * inTempC) / (b + inTempC)) + Math.log(inHum));
		
		// Use f to finish formula
		
		double dewPointC = ((b * f) / (a - f));
		
		// Convert back to Farenheit
		
		double dewPointF = (1.8 * dewPointC) + 32;
		
		// Print result
		
		System.out.print("The Dew point is ");
		System.out.printf("%3.2f", dewPointF);
		System.out.println(" degrees Farenheit.");
	}
}