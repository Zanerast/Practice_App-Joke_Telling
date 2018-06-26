package com.example.jokedisplaylibrary;

import android.support.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;


public class DefaultJokeDisplayed {

    @Rule
    public ActivityTestRule<JokeActivity> mJokeActivityTestRule =
            new ActivityTestRule<>(JokeActivity.class);

    @Test
    public void checkJokeDisplayed(){
        String joke = getInstrumentation().getTargetContext().getResources().getString(R.string.funny_joke);
        onView(withId(R.id.tv_joke)).check(matches(withText(joke)));

    }
}
