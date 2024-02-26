package com.android.chiploginapp

import android.view.View
import android.widget.Toast
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Root
import androidx.test.espresso.ViewAssertion
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.RootMatchers
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isClickable
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withContentDescription
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.Matcher
import org.hamcrest.Matchers
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

annotation class HappyPath
annotation class NegativePath

@RunWith(AndroidJUnit4::class)
class ChipLoginTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Before
    @Test
    fun visibleElements(){

        onView(withId(R.id.username_input)).check(matches(isDisplayed()))
        onView(withId(R.id.password_input)).check(matches(isDisplayed()))
        onView(withId(R.id.login_btn)).check(matches(isClickable()))

    }

    @After
    fun tearDown(){

        activityRule.scenario.close()
    }

    @Test
    @HappyPath
    fun successfulLogin(){

        onView(withId(R.id.username_input))
            .perform(typeText("admin"))
        onView(withId(R.id.password_input))
            .perform(typeText("user1"))
        Espresso.closeSoftKeyboard()
        onView(withId(R.id.login_btn))
            .perform(click())
        onView(withText("Login Successful")).
        inRoot(ToastMatcher().apply { matches(isDisplayed()) })
        }

    @Test
    @NegativePath
    fun failedLogin(){

        onView(withId(R.id.username_input))
            .perform(typeText("admin"))
        onView(withId(R.id.password_input))
            .perform(typeText(""))
        Espresso.closeSoftKeyboard()
        onView(withId(R.id.login_btn))
            .perform(click())
        onView(withText("Login Failed")).
        inRoot(ToastMatcher().apply { matches(isDisplayed()) })
    }

    }