package com.udacity.gradle.builditbigger;

import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by Zane on 25/06/2018.
 */

public class LaunchJokeDisplayLibrary {

    @Rule
    public ActivityTestRule<MainActivity> mMainActivityTestRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void onClickShowJokeAndDisplayJokeFromLibrary() {
        onView(withId(R.id.btn_tell_joke)).perform(click());
        onView(withId(R.id.tv_joke)).check(matches(isDisplayed()));
    }

}
