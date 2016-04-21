package org.bild;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
	
	/*
	 * Credit Card Validator
	 */

	/**Main method*/
	public static void main(String[] args) {

		//Create scanner object
		Scanner input = new Scanner(System.in);

		//Ask user for number of card
		System.out.println("Unesite broj kartice:");
		long number = 0;
		while (true) {
			try {
				number = input.nextLong();
				break;
			} catch (InputMismatchException e) {
				System.out.println("Pogresan unos! Pokusajte ponovo!");
				input.nextLine();
			}
		}
		input.close();

		//Write a result
		if (CreditCard.isValid(number)) {
			System.out.println(number + " is valid!");
		}else{
			System.out.println(number + " is invalid!");
		}
		
	}

}
