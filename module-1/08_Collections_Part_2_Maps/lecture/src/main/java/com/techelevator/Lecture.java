package com.techelevator;

import java.util.*;

public class Lecture {

	public static void main(String[] args) {

		System.out.println("####################");
		System.out.println("        MAPS");
		System.out.println("####################");
		System.out.println();

		//create map
		Map<String, String> namesToZipCodes = new HashMap<>();

		//add to map
		namesToZipCodes.put("David", "14015");
		namesToZipCodes.put("Elizabeth", "14015");
		namesToZipCodes.put("Dan", "14160");

		//replace
		namesToZipCodes.put("David", "14160"); //changes 14015 to 14160

		//iterate the map using keys to get values
		for(String key : namesToZipCodes.keySet()) {
			String value = namesToZipCodes.get(key); // retrieve value by key
			System.out.println(key + " -> " + value);
		}
		System.out.println();

		//iterate over key value pairs
		for(Map.Entry<String, String> entry : namesToZipCodes.entrySet()) {
			System.out.println(entry.getKey() + " -> " + entry.getValue());
		}
		System.out.println();

		//check if key exists
		if(namesToZipCodes.containsKey("David")) {
			System.out.println("David is in the Map!");
		}
		System.out.println();

		//remove from map
		namesToZipCodes.remove("David");

		for(String key : namesToZipCodes.keySet()) {
			String value = namesToZipCodes.get(key); // retrieve value by key
			System.out.println(key + " -> " + value);
		}
		System.out.println();

		//create a more complex map
		Map<String, List<String>> dictionary = new HashMap<>();

		List<String> javaDefinitions = new ArrayList<>();
		javaDefinitions.add("The best programming language.");
		javaDefinitions.add("Your morning coffee.");

		dictionary.put("Java", javaDefinitions);

		List<String> cSharpDefinitions = new ArrayList<>();
		cSharpDefinitions.add("The other language.");
		cSharpDefinitions.add ("A musical note.");

		dictionary.put("C#", cSharpDefinitions);

		//nested for loop
		for(String word : dictionary.keySet()) {
			List<String> definitions = dictionary.get(word);
			System.out.print((word + " -> "));
			for (String definition : definitions) {
				System.out.print(definition + " ");
			} 		System.out.println();
		}

	//	dictionary.get("Java").get(0); //get the first definition of Java

		System.out.println("####################");
		System.out.println("        SETS");
		System.out.println("####################");
		System.out.println();

		//create empty set
		Set<String> keywords = new HashSet<>();

		//add to a set
		keywords.add("class");
		keywords.add("return");
		keywords.add("new");
		keywords.add("final");
		keywords.add("double");

		//remove
		keywords.remove("new");

		//check if exists
		if(keywords.contains("return")) {
			System.out.println("return is in the Set!");
		}

		//iterate
		for(String keyword : keywords) {
			System.out.println(keyword);
		}

	}

}
