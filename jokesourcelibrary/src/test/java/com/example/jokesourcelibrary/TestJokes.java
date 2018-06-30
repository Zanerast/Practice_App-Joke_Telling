package com.example.jokesourcelibrary;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestJokes {

    FunnyJokesSource funnyJokesSource;
    String joke;

    @Before
    public void setUpJokes() {
        funnyJokesSource = new FunnyJokesSource();
        joke = funnyJokesSource.getJoke();
    }

    @Test
    public void testJoke() {
        Assert.assertNotNull(joke);
    }

}
