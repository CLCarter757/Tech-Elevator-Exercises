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

		if (names.contains("Beth")) {
			System.out.println("Beth is in the List!");
		} else {
			System.out.println("Beth is not in the List :(");
		}

		for(String name : names) {
			if(name.equals("Beth")) {
				System.out.println("Beth is in the List");
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

		//From List into Array
		String[] namesArray = new String[names.size()]; // make a String array of the same size as list
		for (int i = 0; i < names.size(); i++) {
			namesArray[i] = names.get(i);
		}

		String[] namesArray2 = names.toArray(new String[0]); //short-hand conversion, 0 bc it will automatically give you an array of the right size

		//From Array into List
		List<String> namesList2 = new ArrayList<>();
		for(String name : namesArray) {
			namesList2.add(name);
		}

//		List<String> namesList3 = new ArrayList<String>(namesArray);

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

		//long form reverse
		List<String> reversedNames = new ArrayList<>();
		for (int i = names.size() - 1; i >= 0; i--) {
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
			numbers.add(i); // (Integer.valueOf(i)), autoboxing
		}

		int sum = 0;
		for (int i = 0; i < numbers.size(); i++) {
			sum = sum + numbers.get(i); //unboxing
		}

		/*
		Queues
		*/

		Queue<String> myQueue = new LinkedList<>();

		//Add to end of queue
		myQueue.offer("Emily");
		myQueue.offer("Lana");
		myQueue.offer("Britt");
		myQueue.offer("Scott");

		//remove from the front of the queue
		String emily = myQueue.poll();

		//check size of the queue
		System.out.println("The size of my queue is " + myQueue.size()); //->3

		//Check who is next in the queue
		String lana = myQueue.peek(); //->size still 3

		//Check if queue is empty
		if (myQueue.isEmpty()) {
			System.out.println("The queue is empty.");
		}

		//iterating over queue
		for (String whoIsNext : myQueue) {
			System.out.println(whoIsNext);
		}


		while(!myQueue.isEmpty()) {									//prefer while loop
			String whoIsNext = myQueue.poll();
			System.out.println("The next person is " + whoIsNext);
		}


		/*
		Stacks
		 */

		Stack<String> urls = new Stack<>();

		// add to the top of the stack
		urls.push("http://techelevator.com"); //last
		urls.push("http://google.com"); //second
		urls.push("http://neopets.com"); //first

		//Retireve and remove from the top
		String neoPets = urls.pop(); //removes neopets

		//Check size of stack
		System.out.println("The size of my stack is " + urls.size()); //now 2

		//Retrieve but not remove from top of stack
		String google = urls.peek();

		if (urls.isEmpty()) {
			System.out.println("The stack is empty.");
		}

		//iterate stack
		for(String url: urls) {
			System.out.println(url);
		}

		while(!urls.isEmpty()) {				//prefer while loops
			String nextUrl = urls.pop();
			System.out.println(nextUrl);
		}

	}
}
