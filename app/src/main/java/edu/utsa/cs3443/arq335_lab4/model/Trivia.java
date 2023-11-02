package edu.utsa.cs3443.arq335_lab4.model;

import android.app.Activity;
import android.content.res.AssetManager;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.SecureRandom;
import java.util.Scanner;

public class Trivia {
    private String question;
    private String option1;
    private String option2;
    private String option3;

//    private String[] options = new String[3];

    private String descriptionAnswer = "";

    //Do we need to identify which answer is the correct one?
    private String correctAnswer;

    public Trivia(String question, String option1, String option2, String option3, String descriptionAnswer) {
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.descriptionAnswer = descriptionAnswer;
    }
    public Trivia() {
        System.out.println("Explicit default constructor");
    }
    //TODO: Create the setters and getters for all the instance variables

    //loadTrivia: This method will take in an Activity (MainActivity) from input as an argument, it reads the file and stores
    //one piece of trivia from that file.

    /**
     * @param: Activity activity
     * @return: Trivia object
     * loadTrivia: This method takes in an Activity from input as an argument, it reads the file
     * and stores 1 piece of trivia from that file.
     */

    public Trivia loadTrivia(Activity activity) {
        //Get an instance of AssetManager
        //Read the file in asset folder using InputStream
        //How many lines are in this file, the number of lines are equivalent to the number of trivia questions
        //Randomly select from a random number smaller or equal to the number of lines
        //Create an object of trivia from that line's information
        //Return the object

        AssetManager manager = activity.getAssets();
        Scanner scanner;

        try {
            InputStream input = manager.open("trivia.csv");
            scanner = new Scanner(input);
            int counter = 0;
            while(scanner.hasNext()) {
                counter++;
            }
            System.out.println("Number of lines: " + counter);
            //Randomly select a number from 1 to counter
            SecureRandom sRandom = new SecureRandom();
            int lineNumber = sRandom.nextInt(counter) + 1;

            int j = 1;
            String line = "";
            while(j<lineNumber) {
                line = scanner.nextLine();
            }
            //when the loop is over, I am standing right by the line that I want to return
            line = scanner.nextLine();
            String[] lineSplit = line.trim().split(",");
            this.question = lineSplit[0].trim();
            this.option1 = lineSplit[1].trim();
            this.option2 = lineSplit[2].trim();
            this.option3 = lineSplit[3].trim();
            this.descriptionAnswer = lineSplit[4];
            //From index 4 forward, we have the descriptionAnswer
            for(int k = 4; k < lineSplit.length; k++) {
                this.descriptionAnswer = this.descriptionAnswer + "," + lineSplit[k];
            }
            return (this);
        } catch(FileNotFoundException e) {
            System.err.println("File not found");
        } catch(IOException e) {
            System.err.println("IO exception, which is a superclass of FileNotFoundException");
        }
        return this;
    }
    private void identifyCorrectAnswer() {
        //takes all the options and checks if the description contains any of the options,
        //if so, that option becomes the correct answers
    }
}
