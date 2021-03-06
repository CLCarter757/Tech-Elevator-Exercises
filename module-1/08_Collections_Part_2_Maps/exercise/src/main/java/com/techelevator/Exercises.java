package com.techelevator;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;

public class Exercises {

	/*
	 * Given the name of an animal, return the name of a group of that animal
	 * (e.g. "Elephant" -> "Herd", "Rhino" - "Crash").
	 *
	 * The animal name should be case insensitive so "elephant", "Elephant", and
	 * "ELEPHANT" should all return "Herd".
	 *
	 * If the name of the animal is not found, null, or empty, return "unknown".
	 *
	 * Rhino -> Crash
	 * Giraffe -> Tower
	 * Elephant -> Herd
	 * Lion -> Pride
	 * Crow -> Murder
	 * Pigeon -> Kit
	 * Flamingo -> Pat
	 * Deer -> Herd
	 * Dog -> Pack
	 * Crocodile -> Float
	 *
	 * animalGroupName("giraffe") → "Tower"
	 * animalGroupName("") -> "unknown"
	 * animalGroupName("walrus") -> "unknown"
	 * animalGroupName("Rhino") -> "Crash"
	 * animalGroupName("rhino") -> "Crash"
	 * animalGroupName("elephants") -> "unknown"
	 *
	 */
	public String animalGroupName(String animalName) {
		Map<String, String> animalAndGroup = new HashMap<>();

		animalAndGroup.put("rhino", "Crash");
		animalAndGroup.put("giraffe", "Tower");
		animalAndGroup.put("elephant", "Herd");
		animalAndGroup.put("lion", "Herd");
		animalAndGroup.put("crow", "Murder");
		animalAndGroup.put("pigeon", "Kit");
		animalAndGroup.put("flamingo", "Pat");
		animalAndGroup.put("deer", "Herd");
		animalAndGroup.put("dog", "Pack");
		animalAndGroup.put("crocodile", "Float");

		if (animalName == null) {
			return "unknown";
		} else if (animalAndGroup.containsKey(animalName.toLowerCase())) {
			return animalAndGroup.get(animalName.toLowerCase());
		} return "unknown";
	}

	/*
	 * Given an String item number (a.k.a. SKU), return the discount percentage if the item is on sale.
	 * If the item is not on sale, return 0.00.
	 *
	 * If the item number is empty or null, return 0.00.
	 *
	 * "KITCHEN4001" -> 0.20
	 * "GARAGE1070" -> 0.15
	 * "LIVINGROOM"	-> 0.10
	 * "KITCHEN6073" -> 0.40
	 * "BEDROOM3434" -> 0.60
	 * "BATH0073" -> 0.15
	 *
	 * The item number should be case insensitive so "kitchen4001", "Kitchen4001", and "KITCHEN4001"
	 * should all return 0.20.
	 *
	 * isItOnSale("kitchen4001") → 0.20
	 * isItOnSale("") → 0.00
	 * isItOnSale("GARAGE1070") → 0.15
	 * isItOnSale("dungeon9999") → 0.00
	 *
	 */
	public double isItOnSale(String itemNumber) {
		Map<String, Double>  itemSKU = new HashMap<>();

		itemSKU.put("KITCHEN4001", 0.20);
		itemSKU.put("GARAGE", 0.15);
		itemSKU.put("LIVINGROOM", 0.10);
		itemSKU.put("KITCHEN6073", 0.40);
		itemSKU.put("BEDROOM3434", 0.60);
		itemSKU.put("BATH0073", 0.15);

		if (itemNumber == null) {
			return 0.00;
		} else if (itemSKU.containsKey(itemNumber.toUpperCase())) {
			return itemSKU.get(itemNumber.toUpperCase());
		} return 0.00;
	}

	/*
	 * Modify and return the given Map as follows: if "Peter" has more than 0 money, transfer half of it to "Paul",
	 * but only if Paul has less than $10s.
	 *
	 * Note, monetary amounts are specified in cents: penny=1, nickel=5, ... $1=100, ... $10=1000, ...
	 *
	 * robPeterToPayPaul({"Peter": 2000, "Paul": 99}) → {"Peter": 1000, "Paul": 1099}
	 * robPeterToPayPaul({"Peter": 2000, "Paul": 30000}) → {"Peter": 2000, "Paul": 30000}
	 *
	 */
	public Map<String, Integer> robPeterToPayPaul(Map<String, Integer> peterPaul) {

		int newPeter = peterPaul.get("Peter") / 2;
		int newPaul = newPeter + peterPaul.get("Paul");

		if (peterPaul.get("Peter") > 0 && peterPaul.get("Paul") < 1000) {
			if (peterPaul.get("Peter") % 2 != 0) {
				newPeter++;
				peterPaul.replace("Peter", newPeter);
				peterPaul.replace("Paul", newPaul);
			} else {
				peterPaul.replace("Peter", newPeter);
				peterPaul.replace("Paul", newPaul);
			}
		} return peterPaul;
	}

	/*
	 * Modify and return the given Map as follows: if "Peter" has $50 or more, AND "Paul" has $100 or more,
	 * then create a new "PeterPaulPartnership" worth a combined contribution of a quarter of each partner's
	 * current worth.
	 *
	 * peterPaulPartnership({"Peter": 50000, "Paul": 100000}) → {"Peter": 37500, "Paul": 75000, "PeterPaulPartnership": 37500}
	 * peterPaulPartnership({"Peter": 3333, "Paul": 1234567890}) → {"Peter": 3333, "Paul": 1234567890}
	 *
	 */
	public Map<String, Integer> peterPaulPartnership(Map<String, Integer> peterPaul) {
		int petersMoney = peterPaul.get("Peter");
		int paulsMoney = peterPaul.get("Paul");
		int petersShare = petersMoney / 4;
		int paulsShare = paulsMoney / 4;

		if (petersMoney >= 5000 && paulsMoney >= 10000) {
			peterPaul.replace("Peter", petersMoney - petersShare);
			peterPaul.replace("Paul", paulsMoney - paulsShare);
			peterPaul.put("PeterPaulPartnership", petersShare + paulsShare);
		} return peterPaul;
	}

	/*
	 * Given an array of non-empty Strings, return a Map<String, String> where for every different String in the array,
	 * there is a key of its first character with the value of its last character.
	 *
	 * beginningAndEnding(["code", "bug"]) → {"b": "g", "c": "e"}
	 * beginningAndEnding(["man", "moon", "main"]) → {"m": "n"}
	 * beginningAndEnding(["muddy", "good", "moat", "good", "night"]) → {"g": "d", "m": "t", "n": "t"}
	 */
	public Map<String, String> beginningAndEnding(String[] words) {
		Map<String, String> firstAndLast = new HashMap<>();

		for (String key : words) {
			String firstChar = key.substring(0, 1);
			String lastChar = key.substring(key.length()-1, key.length());
			firstAndLast.put(firstChar, lastChar);
		}
		return firstAndLast;
	}

	/*
	 * Given an array of Strings, return a Map<String, Integer> with a key for each different String, with the value the
	 * number of times that String appears in the array.
	 *
	 * ** A CLASSIC **
	 *
	 * wordCount(["ba", "ba", "black", "sheep"]) → {"ba" : 2, "black": 1, "sheep": 1 }
	 * wordCount(["a", "b", "a", "c", "b"]) → {"b": 2, "c": 1, "a": 2}
	 * wordCount([]) → {}
	 * wordCount(["c", "b", "a"]) → {"b": 1, "c": 1, "a": 1}
	 *
	 */
	public Map<String, Integer> wordCount(String[] words) {
		Map<String, Integer> wordCount = new HashMap<>(); //create a Map to receive new data

		for (String word : words) {  //iterate thru words
			if (wordCount.containsKey(word)) {		// check if word is already in wordCount
				int counter = wordCount.get(word); //get value (current count) of word
				counter++;                         //increase count by one
				wordCount.put(word, counter);      //read element to replace value with current count
			} else {   //add to wordCount if not in yet
				wordCount.put(word, 1);
			}
		} return wordCount;
	}

	/*
	 * Given an array of int values, return a Map<Integer, Integer> with a key for each int, with the value the
	 * number of times that int appears in the array.
	 *
	 * ** The lesser known cousin of the classic wordCount **
	 *
	 * intCount([1, 99, 63, 1, 55, 77, 63, 99, 63, 44]) → {1: 2, 44: 1, 55: 1, 63: 3, 77: 1, 99:2}
	 * intCount([107, 33, 107, 33, 33, 33, 106, 107]) → {33: 4, 106: 1, 107: 3}
	 * intCount([]) → {}
	 *
	 */
	public Map<Integer, Integer> integerCount(int[] ints) {
		Map<Integer, Integer> numberTimes = new HashMap<>();

		for (Integer num : ints) {
			if (numberTimes.containsKey(num)) {
				int counter = numberTimes.get(num);
				counter++;
				numberTimes.put(num, counter);
			} else {
				numberTimes.put(num, 1);
			}
			} return numberTimes;

	}

	/*
	 * Given an array of Strings, return a Map<String, Boolean> where each different String is a key and value
	 * is true only if that String appears 2 or more times in the array.
	 *
	 * wordMultiple(["a", "b", "a", "c", "b"]) → {"b": true, "c": false, "a": true}
	 * wordMultiple(["c", "b", "a"]) → {"b": false, "c": false, "a": false}
	 * wordMultiple(["c", "c", "c", "c"]) → {"c": true}
	 *
	 */
	public Map<String, Boolean> wordMultiple(String[] words) {
		Map<String, Integer> wordCount = new HashMap<>(); //create a Map to receive new data
		Map<String, Boolean> appearsTwice = new HashMap<>();

		for (String word : words) {  //iterate thru words
			if (wordCount.containsKey(word)) {		// check if word is already in wordCount
				int counter = wordCount.get(word); //get value (current count) of word
				counter++;                         //increase count by one
				wordCount.put(word, counter);      //read element to replace value with current count
			} else {   //add to wordCount if not in yet
				wordCount.put(word, 1);
			}

		for (String count : wordCount.keySet()) {   //iterate through wordCount Map
			if (wordCount.get(word) > 1) {			//check total count at least 2
				appearsTwice.put(word, true);		//add to final Map w/ value true
			} else {
				appearsTwice.put(word, false);		//add to final Map w/ value false
			}
		}

		} return appearsTwice;
	}

	/*
	 * Given two Maps, Map<String, Integer>, merge the two into a new Map, Map<String, Integer> where keys in Map2,
	 * and their int values, are added to the int values of matching keys in Map1. Return the new Map.
	 *
	 * Unmatched keys and their int values in Map2 are simply added to Map1.
	 *
	 * consolidateInventory({"SKU1": 100, "SKU2": 53, "SKU3": 44} {"SKU2":11, "SKU4": 5})
	 * 	 → {"SKU1": 100, "SKU2": 64, "SKU3": 44, "SKU4": 5}
	 *
	 */
	public Map<String, Integer> consolidateInventory(Map<String, Integer> mainWarehouse,
			Map<String, Integer> remoteWarehouse) {
		Map<String, Integer> inventoryMerge = new HashMap<>();

		inventoryMerge.putAll(mainWarehouse);

		for (String item: remoteWarehouse.keySet()) {
			if (inventoryMerge.containsKey(item)) {
				int count = inventoryMerge.get(item) + remoteWarehouse.get(item);
				inventoryMerge.put(item, count);
			} else {
				inventoryMerge.put(item, remoteWarehouse.get(item));
			}
		}
		return inventoryMerge;
	}

	/*
	 * Just when you thought it was safe to get back in the water --- last2Revisited!!!!
	 *
	 * Given an array of Strings, for each String, count the number of times that a subString length 2 appears
	 * in the String and also as the last 2 chars of the String, so "hixxxhi" yields 1.
	 *
	 * We don't count the end subString, but the subString may overlap a prior position by one.  For instance, "xxxx"
	 * has a count of 2, one pair at position 0, and the second at position 1. The third pair at position 2 is the
	 * end subString, which we don't count.
	 *
	 * Return Map<String, Integer>, where the key is String from the array, and its last2 count.
	 *
	 * last2Revisited(["hixxhi", "xaxxaxaxx", "axxxaaxx"]) → {"hixxhi": 1, "xaxxaxaxx": 1, "axxxaaxx": 2}
	 *
	 */
	public Map<String, Integer> last2Revisited(String[] words) {
		Map<String, Integer> twoCount = new HashMap<>();

		for (String letters : words) {  //iterate through given String
			int counter = 0;			//variable to keep track or number times repeated
			String last2 = letters.substring(letters.length()-2); //variable to show last two chars
			for (int i = 0; i < letters.length()-2; i++) {  //nested for loop to iterate each word until last 2
				if (letters.substring(i).startsWith(last2)) {  //checks each index for last2
					counter++;		//add to counter
				}
			} twoCount.put(letters, counter); //add to new Map
		}
		return twoCount;
	}

}
