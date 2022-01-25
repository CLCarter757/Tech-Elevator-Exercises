package com.techelevator;

import java.util.*;

public class Lecture {

	public static void main(String[] args) {
		System.out.println("####################");
		System.out.println("       LISTS");
		System.out.println("####################");

		List<String> names = new ArrayList<>();

		names.add("Tom");
		names.add("Beth");
		names.add("Walt");
		names.add("Tom");

		System.out.println("####################");
		System.out.println("Lists are ordered");
		System.out.println("####################");

		System.out.println("####################");
		System.out.println("Lists allow duplicates");
		System.out.println("####################");

		for (int i = 0; i < names.size(); i++) {
			System.out.println(names.get(i));
		}


		System.out.println("####################");
		System.out.println("Lists allow elements to be inserted in the middle");
		System.out.println("####################");

		names.add(1, "Zach");
		names.add(1, "Cassie");

		for(String name : names) {
			System.out.println(name);
		}

		System.out.println("####################");
		System.out.println("Lists allow elements to be removed by index");
		System.out.println("####################");

		names.remove(3);

		for(String name : names) {
			System.out.println(name);
		}

		System.out.println("####################");
		System.out.println("Find out if something is already in the List");
		System.out.println("####################");

		if(names.contains("Beth")) {
			System.out.println("Beth is in the List!");
		} else {
			System.out.println("Beth is not in the List :(");
		}

		for(String name : names) {
			if(name.equals("Beth")) {
				System.out.println("Beth is in the List!");
			}
		}


		System.out.println("####################");
		System.out.println("Find index of item in List");
		System.out.println("####################");

		System.out.println("The index of Walt is " + names.indexOf("Walt"));

		int indexOfWalt = -1;
		for (int i = 0; i < names.size(); i++) {
			if(names.get(i).equals("Walt")) {
				indexOfWalt = i;
				break;
			}
		}


		System.out.println("####################");
		System.out.println("Lists can be turned into an array");
		System.out.println("####################");

		// From List copied into Array
		String[] namesArray = new String[names.size()]; // make a String array of the same size as the List!
		for (int i = 0; i < names.size(); i++) {
			namesArray[i] = names.get(i);
		}

		String[] namesArray2 = names.toArray(new String[0]); // short-hand for List to Array conversion

		// From Array copied into List
		List<String> namesList2 = new ArrayList<>();
		for(String name : namesArray) {
			namesList2.add(name);
		}

		List<String> namesList3 = Arrays.asList(namesArray); // short-hand for Array to List

		System.out.println("####################");
		System.out.println("Lists can be sorted");
		System.out.println("####################");

		Collections.sort(names);

		for(String name : names) {
			System.out.println(name);
		}


		System.out.println("####################");
		System.out.println("Lists can be reversed too");
		System.out.println("####################");

		Collections.reverse(names);

		for(String name : names) {
			System.out.println(name);
		}

		// long form way of doing reverse
		List<String> reversedNames = new ArrayList<>();
		for(int i = names.size() - 1; i >= 0; i--) {
			reversedNames.add(names.get(i));
		}


		System.out.println("####################");
		System.out.println("       FOREACH");
		System.out.println("####################");
		System.out.println();



		/*
		 Primitive Wrappers
		 */

		List<Integer> numbers = new ArrayList<>();

		for (int i = 0; i < 50; i++) {
			numbers.add(i); // autoboxing
		}

		int sum = 0;
		for (int i = 0; i < numbers.size(); i++) {
			sum = sum + numbers.get(i); // unboxing
		}


		/*
			Queues
		 */
		Queue<String> myQueue = new LinkedList<>();

		// add to the end of the queue
		myQueue.offer("Emily");
		myQueue.offer("Lana");
		myQueue.offer("Britt");
		myQueue.offer("Scott");

		// remove from the front of the queue
		String emily = myQueue.poll();

		// check the size of the queue
		System.out.println("The size of my queue is " + myQueue.size());

		// check who is next in the queue
		String lana = myQueue.peek();

		// check if the queue is empty
		if(myQueue.isEmpty()) {
			System.out.println("The queue is empty");
		}

		// Iterate over the queue using for each and while loop to show the difference
		for(String whoIsNext : myQueue) {
			System.out.println(whoIsNext);
		}

		while(!myQueue.isEmpty()) {
			String whoIsNext = myQueue.poll();
			System.out.println(whoIsNext);
		}

		/*
			Stacks


		->	https://google.com
			https://techelevator.com
		 */

		Stack<String> urls = new Stack<>();

		// add to the top of the Stack
		urls.push("https://techelevator.com");
		urls.push("https://google.com");
		urls.push("https://neopets.com");

		// Retrieve and remove from the top of the Stack
		String neoPets = urls.pop(); // https://neopets.com

		// Check the size of the Stack
		System.out.println("The size of my Stack is " + urls.size());

		// Retrieve, but do not remove, from the top of the Stack
		String google = urls.peek(); // https://google.com

		if(urls.isEmpty()) {
			System.out.println("The Stack is empty.");
		}

		// Iterate the Stack using for each and while loop to show the difference
		for(String url : urls) {
			System.out.println(url);
		}

		while(!urls.isEmpty()) {
			String nextUrl = urls.pop();
			System.out.println(nextUrl);
		}





	}
}
