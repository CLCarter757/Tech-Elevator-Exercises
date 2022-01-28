package com.techelevator;

import javax.swing.plaf.synth.ColorType;

public class HomeworkAssignment {

    private int earnedMarks;
    private int possibleMarks;
    private String submitterName;

    public HomeworkAssignment(int possibleMarks, String submitterName) {
        this.possibleMarks = possibleMarks;
        this.submitterName = submitterName;
    }

    public int getEarnedMarks(){
        return earnedMarks;
    }
    public void setEarnedMarks(int earnedMarks) {
        this.earnedMarks = earnedMarks;
    }
    public int getPossibleMarks() {
        return possibleMarks;
    }
    public String getSubmitterName() {
        return submitterName;
    }

    public String getLetterGrade() {
        if ((double) earnedMarks/possibleMarks >= .90) {
            return "A";
        } else if ((double) earnedMarks/possibleMarks >= .80) {
            return "B";
        } else if ((double) earnedMarks/possibleMarks >= .70) {
            return "C";
        } else if ((double) earnedMarks/possibleMarks >= .60) {
            return "D";
        } else {
            return "F";
        }

    }

}
