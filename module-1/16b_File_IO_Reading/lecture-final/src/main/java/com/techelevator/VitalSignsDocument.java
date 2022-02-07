package com.techelevator;

import java.util.List;

public class VitalSignsDocument extends Document {

    @Override
    public List<String> getQuestions() {
        return List.of("What is your blood pressure?", "What is your height?");
    }
}
