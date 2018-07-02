package com.example.jokesourcelibrary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class FunnyJokesSource {



    public static String getJoke(){


        String jokeOne = "A man walks into a bar. \nOuch.";
        String jokeTwo = "Helium walks into a bar. " +
                "\nHe orders a drink and wonders why his parents decided to give him such an unusual name, " +
                "as he can never find it on personalized souvenirs. Plus, baristas never, ever get it right.";
        String jokeThree = "Knock knock." +
                "\nWho is there?" +
                "\nTo." +
                "\nTo who?" +
                "\nNo, to whom.";
        String jokeFour = "A horse walks into a bar. " +
                "\nSeveral of the patrons quickly get up and leave, realizing the potential danger in the situation.";
        String jokeFive = "What did the farmer say after he lost his tractor? " +
                "\nWhere is my tractor?";

        List<String> jokesList = Arrays.asList(jokeOne, jokeTwo, jokeThree, jokeFour, jokeFive);

        Random rand = new Random();
        int jokeNumber = rand.nextInt(jokesList.size());

        String joke;
        joke = jokesList.get(jokeNumber);

        return joke;
    }
}
