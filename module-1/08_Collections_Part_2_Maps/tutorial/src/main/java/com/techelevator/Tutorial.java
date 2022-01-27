package com.techelevator;

import java.util.HashMap;
import java.util.Map;

public class Tutorial {
	

    public static void main(String[] args) {

        // Step One: Declare a Map
        Map<String, String> projects = new HashMap<String, String>();
    	
    	// Step Two: Add items to a Map
        projects.put("Ada", "Inventing Computer Programing");
        projects.put("Grace", "COBOL");
        projects.put("Margaret", "Apollo Guidance Computer");
        projects.put("Adele", "Graphiacal User Interface");

        projects.remove("Grace");

    	// Step Three: Loop through a Map
        for (Map.Entry<String, String> project : projects.entrySet()) {
            System.out.println("The key " + project.getKey() + " is linked to the value " + project.getValue());
        }
    }

}
