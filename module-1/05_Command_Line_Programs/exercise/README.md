# Command-line programs

The purpose of this exercise is to provide students with the opportunity to practice and reinforce the skills they have learned during lecture related to building command line applications. In this exercise, you'll create command-line applications that:

   * Convert a temperature from one unit of measure to another.
   * Convert a length from one unit of measure to another.

## Learning objectives

After completing this exercise, you'll understand:

* How to create command line applications.
* How to prompt and accept user input in a command-line application.
* How to write output to the console in a command-line application.

## Evaluation criteria and functional requirements

* The project must not have any build errors.
* Appropriate variable names and data types are used.
* The input and output match what's stated in the following requirements.

### Temperature conversion

The Fahrenheit to Celsius conversion formula is:

    temperatureCelcius = (temperatureFarenheit - 32) / 1.8

The Celsius to Fahrenheit conversion formula is:

    temperatureFarenheit = temperatureCelcius * 1.8 + 32

Write a command-line program which prompts a user to enter a temperature, and whether it's in degrees (C)elsius or (F)ahrenheit. Convert the temperature to the opposite degrees, and display the old and new temperatures to the console.

```
Please enter the temperature: 58
Is the temperature in (C)elsius, or (F)ahrenheit? F
58F is 14C.
```

### Linear conversion

Write a program that converts meters to feet and vice-versa.

The foot to meter conversion formula is:

    m = f * 0.3048

The meter to foot conversion formula is:

    f = m * 3.2808399

Write a command-line program which prompts a user to enter a length, and whether the measurement is in (m)eters or (f)eet. Convert the length to the opposite measurement, and display the old and new measurements to the console.

```
Please enter the length: 58
Is the measurement in (m)eter, or (f)eet? f
58f is 17m.
```

## Getting started

1. Import the command-line programs exercises project into IntelliJ.
2. For each exercise, navigate to the corresponding Java file, and provide the code needed to fulfill the requirements in the `main` method.
3. Run the application to verify that it works as expected.

## Tips and tricks

* The curriculum team provided the conversion formulas for each exercise.
* Take the time to review each of the tasks for the expected output, as well as the text you must use to prompt the user for information. Try to get this to match the specification as closely as possible when working through the exercise.

