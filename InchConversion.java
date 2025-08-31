/******************************************************************************
Programmer: Justice Gutierrez 
Date: 8/29/2025
Lab 1 
Instructor: Dr. Rafael Azuaje
College: San Antonio College

*******************************************************************************/

import java.util.Scanner;

// Define the InchConversion class
public class InchConversion
{
    // Define the main method
	public static void main(String [] args)
    {
        // Declare an int variable to store the number of inches
		int inches;

        // Create a Scanner object for input
		Scanner sc = new Scanner(System.in);
		while (true) {
			// Prompt the user to enter inches
			System.out.print("Enter amount of inches >> ");
			while (!sc.hasNextInt()) { //Veryifies user typed in a number.
				System.out.print("Please enter a number >> ");
				sc.next(); //Gets rid of old scanner input to allow re-entry.
			}
			inches = Math.abs(sc.nextInt()); //Makes sure int is positive
			sc.nextLine(); //I didn't know that nextInt leaves an "". Thanks ChatGPT.
		
			// Read the entered number of inches
			System.out.print(inches +" inches? (Y/N) >> "); 
			char choice = sc.nextLine().toUpperCase().charAt(0); //First character of the next String the user gives. If they type in something like "Yellow", that'd also process as a 'Y'
			if (choice == 'Y') {
				break; //If They type in literally anyting else, loops resets making them type in the inital value of inches again.
			}
		}
		//System.out.println("success"); //check if user input is accepted
		
        // Call the convertToFeet method with the entered inches
		convertToFeet(inches);
        
		// Call the convertToYards method with the entered inches
		convertToYards(inches);
		
		sc.close();
    }

    // Define the convertToFeet method that takes an int parameter inches
	public static void convertToFeet(int x)
    {
		if (x < 12) { //checks if inches are enough to make a foot.
			System.out.println(x + " isn't enough inches to make a foot.");
			return;
		}
        // Declare a double variable to store feet
		double convertedFoot;
        // Declare a constant for the number of inches in a foot
		final double inchesInAFoot = 12.0;

        // Calculate the number of feet
		convertedFoot = x / inchesInAFoot;
		
        // Print the result in feet
		System.out.print(x + " inches is ");
		
		//Singular over plural
		if (convertedFoot == 1) {
			if (x > 12) {
				System.out.print("1 foot with a remainder of " + (double)(x - 12));//Double to match the format
			} else {
				System.out.println("1 foot.");
				
			}
			return;
		}
		if (x % 12 == 0) {
			System.out.print(convertedFoot + " feet.\n");			
		} else { //Prints out feet with a remainder 
			System.out.println((int)convertedFoot + ".0 feet with a remainder of " + (x % 12) + " inches.");//Converted to Int to get whole number with remainder
		}
		return;
    }

    // Define the convertToYards method that takes an int parameter inches
	public static void convertToYards(int x)
    {
		if (x < 36) { //Checks if inches are enough to make a yard.
			System.out.println(x +" isn't enough inches to make a yard.");
			return;
		}
        // Declare a double variable to store yards
		double convertedYard;
        // Declare a constant for the number of inches in a yard
		final double inchesToYard = 36.0;

        // Calculate the number of yards
		convertedYard = x / inchesToYard;
		
        // Print the result in yards
		System.out.print(x + " inches is ");
		
		//Singular over plural
		if (convertedYard == 1) {
			if (x > 36) {
				System.out.println("1 yard with a remainder of " + (double)(x - 36));//Double to match the format
			} else {
				System.out.println("1 yard.");
				
			}
			return;
		}
		//Check if number is a perfect yard
		if (x % 36 == 0) {
			System.out.print(convertedYard + " yards.\n");		
		} else { //Prints out yards with a remainder 
			System.out.println((int)convertedYard + ".0 yards with a remainder of " + (x % 36) + " inches.");//Converted to Int to get whole number with remainder
		}
		return;
    }
}