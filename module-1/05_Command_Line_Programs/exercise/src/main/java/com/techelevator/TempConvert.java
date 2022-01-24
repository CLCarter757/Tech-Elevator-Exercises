package com.techelevator;

import java.util.Locale;
import java.util.Scanner;

public class TempConvert {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.print("Please enter the temperature: ");
		String userInput = input.nextLine();
		double tempInput = Double.parseDouble(userInput);

		System.out.print("Is the temperature in (C)elsius or (F)ahrenheit? : ");
		String unitType = input.nextLine();

		System.out.print(tempInput + unitType + " is " + conversion(tempInput, unitType) + (unitType.toUpperCase().startsWith("F") ? "C" : "F"));
	}


	public static double conversion(double tempInput, String unitType) {
		if (unitType.toUpperCase().startsWith("F")) {
			double fahrenheitToCelsius = (tempInput - 32) / 1.8;
			int celsiusTemp = (int) fahrenheitToCelsius;
			return celsiusTemp;
		} else {
			double celsiusToFahrenheit = tempInput * 1.8 + 32;
			int fahrenheitTemp = (int) celsiusToFahrenheit;
			return fahrenheitTemp;
		}
		}


	}


