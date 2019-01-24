//============================================================================
//Name        : Main.java
//Course      : CS 2261: Objected-Oriented Programming
//Date        : 10/28/2018
//Author      : Yu Kuwahara
//============================================================================

// prompting how many humans should exist

import java.util.*;

// takes input
import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		System.out.println("How many people do you have?");
		int numHumans = input.nextInt();
	
		// create an ArrayList for number of humans 
		ArrayList<Human> humans = new ArrayList<Human>(numHumans);
		for(int i = 0; i < numHumans; ++i)
		{
			System.out.print("Enter human " + (i + 1) + "'s name: ");
			String humanName = input.next();
			humans.add(new Human(humanName));
			input.nextLine();
		}
		
		// create a menu with string instead of outputting everything
		String menu = "1. Go for a walk with your dog\n" +
					  "2. Bath your dog\n" +
					  "3. Buy your dog food\n" +
					  "4. Feed your dog\n" +
					  "5. Quit this service\n";
		
		boolean isRunning = true;
		while (isRunning)
		{
			// for all the humans in Human
			for(Human human : humans)
			{
					// print attributes 
					System.out.print(human.toString());
					
					// display the menu
					System.out.print(menu);
					
					int selection = -1;
					selection = input.nextInt();				
					switch (selection)
					{
					case 1:
						human.walks();
						break;
					case 2:
						human.bathes();
						break;
					case 3:
						human.buyFood();
						break;
					case 4:
						human.feeds();
						break;
					case 5:
						System.out.println("Thank you for using our service!");
						isRunning = false;
						break;
					default:
						System.out.println("You selected an invalid choice!");
						break;
					}
					
					// stop the service if the user chose to do so 
					if(!isRunning)
						break;
					
					// check loyalty
					if(!human.checkLoyalty())
						isRunning =  false;
					
					// pass the time
					human.passTheTime();
				
				}
			}
		
		// for some reasons, it threw errors if I close the input scanner
		// input.close();
	}	
}
