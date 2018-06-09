package com.deman.jerrett.password_validator;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainViewTests {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule =
            new ActivityTestRule(MainActivity.class);

    @Test
    public void validationFailTest() {
        // input an invalid pass
        onView(withId(R.id.inputField)).perform(typeText("Password"), closeSoftKeyboard());

        // check that validation fails
        onView(withId(R.id.validateButton)).perform(click());
        onView(withId(R.id.resultField)).check(matches(withText("Password is not string enough.")));
    }

    @Test
    public void validationPassTest() {
        // input an valid pass
        onView(withId(R.id.inputField)).perform(typeText("MargaretThatcherIs100&10%Sexy"), closeSoftKeyboard());

        // check that validation passes
        onView(withId(R.id.validateButton)).perform(click());
        onView(withId(R.id.resultField)).check(matches(withText("Password is strong.")));
    }
}
