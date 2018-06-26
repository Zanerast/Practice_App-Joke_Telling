package com.example.jokesourcelibrary;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class FunnyJokes {

    public static ArrayList<String> jokesArrayList;

    public static String getJoke(){
        jokesArrayList = new ArrayList<>();

        String jokeOne = "A man walks into a bar. \n“Ouch.”";
        String jokeTwo = "Helium walks into a bar. " +
                "\nHe orders a drink and wonders why his parents decided to give him such an unusual name, " +
                "as he can never find it on personalized souvenirs. Plus, baristas never, ever get it right.";
        String jokeThree = "Knock knock." +
                "\nWho’s there?" +
                "\nTo." +
                "\nTo who?" +
                "No, “to whom.”";
        String jokeFour = "A horse walks into a bar. " +
                "\nSeveral of the patrons quickly get up and leave, realizing the potential danger in the situation.";
        String jokeFive = "What did the farmer say after he lost his tractor? " +
                "\n“Where’s my tractor?";

        Collections.addAll(jokesArrayList, jokeOne, jokeTwo, jokeThree, jokeFour, jokeFive);

        Random rand = new Random();
        int jokeNumber = rand.nextInt(jokesArrayList.size());

        String joke;
        joke = jokesArrayList.get(jokeNumber);

        return joke;
    }
}
