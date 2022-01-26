package com.techelevator;

import java.util.*;

public class Lecture {

	public static void main(String[] args) {

		// Creating all the things
		int[] numbersArray = new int[10]; // array
		List<Integer> numbersList = new ArrayList<>(); // list
		Queue<Integer> numbersQueue = new LinkedList<>(); // queue
		Stack<Integer> numbersStack = new Stack<>(); // stack

		double y = 2.0;

		int myInt = (int) y;

		doStuff(numbersList, y);

		System.out.println("####################");
		System.out.println("        MAPS");
		System.out.println("####################");
		System.out.println();

		// create map
		Map<String, String> namesToZipCodes = new HashMap<>();

		// add to map
		/*
				"David" -> "14015"
				"Dan" -> "14160"
				"Elizabeth" -> "14015"
		 */
		namesToZipCodes.put("David", "14015");
		namesToZipCodes.put("Dan", "14160");
		namesToZipCodes.put("Elizabeth", "14015");

		// replace something in the map
		namesToZipCodes.put("David", "14160");

		// iterate the map
		// iterate using keys to get the values
		for(String key : namesToZipCodes.keySet()) {
			String value = namesToZipCodes.get(key); // retrieve value by key
			System.out.println(key + " -> " + value);
		}

		System.out.println();

		// iterate over key value pairs
		for(Map.Entry<String, String> entry : namesToZipCodes.entrySet()) {
			System.out.println(entry.getKey() + " -> " + entry.getValue());
		}

		System.out.println();

		if(namesToZipCodes.containsKey("David")) {
			System.out.println("David is in the Map!");
			System.out.println();
		}

		// remove from Map
		namesToZipCodes.remove("David");

		// iterate again
		for(String key : namesToZipCodes.keySet()) {
			String value = namesToZipCodes.get(key); // retrieve value by key
			System.out.println(key + " -> " + value);
		}

		System.out.println();

		// create a more complex map
		/*
			"word 1" -> { "definition 1", "definition 2", "definition 3" ... }
			"word 2  -> { "definition 1", "definition 2", "definition 3" ... }


			"Java" -> { "The best programming language.", "Your morning coffee." }
			"C#" -> { "The other language.",  "A musical note." }
		 */
		Map<String, List<String>> dictionary = new HashMap<>();

		List<String> javaDefinitions = new ArrayList<>();
		javaDefinitions.add("The best programming language.");
		javaDefinitions.add("Your morning coffee.");

		dictionary.put("Java", javaDefinitions);

		List<String> cSharpDefinitions = new ArrayList<>();
		cSharpDefinitions.add("The other language.");
		cSharpDefinitions.add("A musical note.");

		dictionary.put("C#", cSharpDefinitions);

		for(String word : dictionary.keySet()) {
			List<String> definitions = dictionary.get(word);

			System.out.print(word + " -> ");
			for(String definition : definitions) {
				System.out.print(definition + " ");
			}
			System.out.println();
		}

		dictionary.get("Java").get(0); // get the first definition of Java



		System.out.println("####################");
		System.out.println("        SETS");
		System.out.println("####################");
		System.out.println();

		// create an empty set
		Set<String> keywords = new HashSet<>();

		// add to a set
		keywords.add("class");
		keywords.add("return");
		keywords.add("new");
		keywords.add("final");
		keywords.add("double");

		// remove from a set
		keywords.remove("new");

		// check if exists
		if(keywords.contains("return")) {
			System.out.println("return is in the Set!");
		}

		// iterate over the Set
		for(String keyword : keywords) {
			System.out.println(keyword);
		}


		/*

			Hashing

			f(input) -> output (int)

			f(class) ->  2
			f(return) -> 2
			f(final) ->  1
			f(double) -> 0

			0 -> { "double" }
			1 -> { "final" }
			2 -> { "class", "return" }

			List -> { "class", "return", "final", "double" }

		 */

		keywords.contains("class");


		// 1
		List<Integer> ints = List.of(1, 5, 10, 25);

		// N
		for(Integer num : ints) {
			System.out.println(num);
		}

		// N
		for(Integer num : ints) {
			System.out.println(num);
		}


		// N + N + 1 = 2N + 1 = O(N)

		/*

			log(N) -> Binary Search

			1, 20, 35, 100,     1000, 5000, 8000, 100000000, 1002402042034

			1000, 5000, 8000, 100000000, 1002402042034

			 8000, 100000000, 1002402042034

			 8000
			  ^

			Search for: 100,000


		    N * log(N) -> Quick/Merge Sort


		 */

	}

	public static boolean doStuff(List<Integer> list, double x) {
		return false;
	}

}
