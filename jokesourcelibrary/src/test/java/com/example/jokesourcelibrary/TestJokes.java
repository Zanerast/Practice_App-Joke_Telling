package com.example.jokesourcelibrary;


import com.example.jokesourcelibrary.FunnyJokes;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestJokes {

    FunnyJokes funnyJokes;
    String joke;

    @Before
    public void setUpJokes() {
        funnyJokes = new FunnyJokes();
        joke = funnyJokes.getJoke();
    }

    @Test
    public void testJoke() {
        Assert.assertNotNull(joke);
    }

}
