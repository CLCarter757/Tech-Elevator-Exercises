package com.techelevator.farm;

public class OldMacdonald {
	public static void main(String[] args) {
		Cow cow2 = new Cow();
		cow2.sleep();

		Singable[] singables =
				new Singable[] {cow2, new Chicken(), new Pig(), new Tractor()};

		for (Singable singable : singables) {
			String name = singable.getName();
			String sound = singable.getSound();
			System.out.println("Old MacDonald had a farm, ee, ay, ee, ay, oh!");
			System.out.println("And on his farm he had a " + name
					+ ", ee, ay, ee, ay, oh!");
			System.out.println("With a " + sound + " " + sound + " here");
			System.out.println("And a " + sound + " " + sound + " there");
			System.out.println("Here a " + sound + " there a " + sound
					+ " everywhere a " + sound + " " + sound);
			System.out.println();
		}

		Sellable[] sellables = new Sellable[] {new Cow(), new Pig(), new Egg()};

		for (Sellable sellable : sellables) {
			System.out.println("Step right up and get your " + sellable.getName());
			System.out.println("Only $" + sellable.getPrice());
		}

		System.out.println();

		FarmAnimal cow = new Cow();
		FarmAnimal chicken = new Chicken();
		FarmAnimal pig = new Pig();

		System.out.println(cow.eat());
		System.out.println(chicken.eat());
		System.out.println(pig.eat());


		System.out.println();

		Pig pig1 = new Pig();
		Pig pig2 = new Pig();

		System.out.println(pig1);
		System.out.println(pig2);

		if(pig1.equals(pig2)) {
			System.out.println("The pigs are the same!");
		} else {
			System.out.println("The pigs are very different!");
		}
	}
}