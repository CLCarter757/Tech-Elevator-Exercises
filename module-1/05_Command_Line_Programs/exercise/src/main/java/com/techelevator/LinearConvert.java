package com.techelevator;

import java.util.Scanner;
import java.util.Locale;

public class LinearConvert {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.print("Please enter the length: ");
		String userInput = input.nextLine();
		double lengthInput = Double.parseDouble(userInput);

		System.out.print("Is the measurement in (m)eter, or (f)feet? : ");
		String unitType = input.nextLine();

		System.out.print(lengthInput + unitType + " is " + conversion(lengthInput, unitType) + (unitType.startsWith("f") ? "m." : "f."));
	}


	public static double conversion(double lengthInput, String unitType) {
		if (unitType.toLowerCase().startsWith("f")) {
			double convertToMeters = lengthInput * 0.3048;
			int finalMeter = (int)convertToMeters;
			return finalMeter;
		} else {
			double convertToFeet = lengthInput * 3.2808399;
			int finalFeet = (int)convertToFeet;
			return finalFeet;
	}







	}

}
