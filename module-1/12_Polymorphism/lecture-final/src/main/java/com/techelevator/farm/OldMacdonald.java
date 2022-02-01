package com.techelevator.farm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class OldMacdonald {
	public static void main(String[] args) {
		Pig wilbur = new Pig("Wilbur");
		Singable[] farmAnimals = new Singable[] { new Cow(), new Chicken(), wilbur, new Tractor("Johnny Deere") };

		singOldMacDonald(farmAnimals);

		Chicken myChicken = new Chicken();

		myChicken.getName();
		myChicken.getSound();
		myChicken.layEgg();

		FarmAnimal myChicken2 = new Chicken();
		myChicken2.getName();
		myChicken2.getSound();
//		myChicken2.layEgg();


		List<String> names = new ArrayList<>();
		ArrayList<String> otherNames = new ArrayList<>();


		reverse(names);
		reverse(otherNames);



		Tractor cub = new Tractor("Cubby Cadet");
		Sellable babe = new Pig("Babe");
		Sellable egg = new Egg();

		List<Sellable> sellableThings = new ArrayList<>();
		sellableThings.add(cub);
		sellableThings.add(babe);
		sellableThings.add(egg);
	}

	public static void reverse(List<String> strings) {

	}

	public static void singOldMacDonald(Singable[] singables) {
		for (Singable singable : singables) {
			String name = singable.getName();
			String sound = singable.getSound();

			// If Singable is a chicken, lay egg
			if(singable instanceof Chicken) {
				Chicken singableAsChicken = (Chicken) singable;
				singableAsChicken.layEgg();

				((Chicken) singable).layEgg();
			}

			System.out.println("Old MacDonald had a farm, ee, ay, ee, ay, oh!");
			System.out.println("And on his farm he had a " + name + ", ee, ay, ee, ay, oh!");
			System.out.println("With a " + sound + " " + sound + " here");
			System.out.println("And a " + sound + " " + sound + " there");
			System.out.println("Here a " + sound + " there a " + sound + " everywhere a " + sound + " " + sound);
			System.out.println();
		}
	}
}