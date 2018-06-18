// Tyler Bade

// THE INCREDIBLE MONTY HALL PARADOX

/* The purpose of this program is to test the Monty Hall Paradox, which, according to the myths
is when you have three doors and know which one is incorrect, your chance of winning will be higher
if you switch than if you stay.
*/

import java.util.Scanner;

public class TBMontyHall
{
	public static void main(String[] args)
	{
		// Introduction and attempts
		
		Scanner in = new Scanner(System.in);
		System.out.println("Welcome to the Monty Hall program, where we test the paradox behind the mathematical conundrum.");
		System.out.println("This game will play itself, inlcuding the door choices of you and the host choice and switching doors.");
		System.out.print("Please enter how many attempts you wish to take: ");
		
		// Input number of attempts
		
		int attempts = in.nextInt();
		
		// Initialize all other variables needed.
		
		int attNum;
		int timesStayed = 0;
		int timesSwitched = 0;
		int stayWins = 0;
		int stayLosses = 0;
		int swapWins = 0;
		int swapLosses = 0;
		int hostDoor;
		int newDoor;
		
		// Loop for number of attempts being lower than input number of attempts
		for (attNum = 0; attNum < attempts; attNum ++)
		{
			// Shh.... This is the winner.
			int prizeDoor = (int) (Math.random() * 3) + 1;
			
			// Choose a door Contestant!
			int contDoor = (int) (Math.random() * 3) + 1;
			
			// I'll choose a door for you now, this won't be yours, or the correct one
			do
			{
				hostDoor = (int) (Math.random() * 3) + 1;
			}
			while (hostDoor == contDoor || hostDoor == prizeDoor);
			
			// You now have the option to stick or switch (0 = stick, 1 = switch)
			
			int stickSwitch = (int) (Math.random() * 2);
			
			// You stuck, was it smart?
			
			if (stickSwitch == 0)
			{
				timesStayed ++;
				newDoor = contDoor;
				
				if (newDoor == prizeDoor)
				{
					// YOU WIN!!!
					stayWins ++;
				}
				else
				{
					// Sorry, you lost. Enjoy the goat
					stayLosses ++;
				}
			}
			
			// You swapped, did you beat me?
			
			if (stickSwitch == 1)
			{
				timesSwitched ++;
				do
				{
					newDoor = (int) (Math.random() * 3) + 1;
				}
				while (newDoor == contDoor || newDoor == hostDoor);
				
				if (newDoor == prizeDoor)
				{
					// YOU WIN!!!
					swapWins ++;
				}
				
				else
				{
					// Sorry, you lost. Enjoy the goat
					swapLosses ++;
				}
			}
		}
		
		// And here are your results for playing.
		
		System.out.println("You Switched " + timesSwitched + " Times, winning " + swapWins + " times.");
		System.out.println("You Stayed " + timesStayed + " Times, winning " + stayWins + " times.");
		
		double percWinSwitch = ((double) swapWins / timesSwitched) * 100;
		double percWinStay = ((double) stayWins / timesStayed) * 100;
		
		System.out.printf("You won %.2f percent of the time when switching. %n", percWinSwitch);
		System.out.printf("You won %.2f percent of the time when staying. %n", percWinStay);
	}		
}