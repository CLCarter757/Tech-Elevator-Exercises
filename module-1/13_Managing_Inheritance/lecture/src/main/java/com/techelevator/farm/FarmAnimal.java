package com.techelevator.farm;

import java.util.Objects;

public abstract class FarmAnimal implements Singable {
	private String name;
	private String sound;
	private boolean isAsleep;

	public FarmAnimal(String name, String sound) {
		this.name = name;
		this.sound = sound;
	}

	public String getName( ) {
		return name;
	}
	public final String getSound( ) {
		if (isAsleep) {
			return "Zzzzzzz....";
		}
		return sound;
	}

	public void sleep() {
		isAsleep = true;
	}
	public void awake() {
		isAsleep = false;
	}

	public abstract String eat();	//no body bc abstract

	@Override
	public String toString() {
		return getName() + " " + getSound();
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) {
			return false;
		} else if (this == obj) {
			return true;
		} else if (!(obj instanceof FarmAnimal)) {
			return false;
		}
		FarmAnimal other = ((FarmAnimal)obj);

		return getName().equals(other.getName()) && getSound().equals(other.getSound());
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, sound);
	}
}