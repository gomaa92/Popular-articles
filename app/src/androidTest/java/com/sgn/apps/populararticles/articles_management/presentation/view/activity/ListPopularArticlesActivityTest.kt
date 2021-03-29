package com.sgn.apps.populararticles.articles_management.presentation.view.activity

import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.RootMatchers
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.rule.ActivityTestRule
import com.sgn.apps.populararticles.R
import junit.framework.TestCase
import org.hamcrest.Matchers
import org.junit.Rule
import org.junit.Test
import java.util.*

class ListPopularArticlesActivityTest : TestCase() {

    @get:Rule
    val activityRule = ActivityTestRule(ListPopularArticlesActivity::class.java, false, false)

    @Test
    fun appLaunchesSuccessfully() {
        // activityRule.launchActivity(null)
        ActivityScenario.launch(ListPopularArticlesActivity::class.java)
    }
    @Test
    @Throws(InterruptedException::class)
    fun testVisibilityRecyclerView() {
        Thread.sleep(1000)
        Espresso.onView(ViewMatchers.withId(R.id.listArticlesRecyclerView))
            .inRoot(
                RootMatchers.withDecorView(
                    Matchers.`is`(
                        activityRule.activity.window.decorView
                    )
                )
            )
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
    @Test
    @Throws(InterruptedException::class)
    fun testCaseForRecyclerScroll() {
        Thread.sleep(1000)
        val recyclerView =
            activityRule.activity.findViewById<RecyclerView>(R.id.listArticlesRecyclerView)
        val itemCount =
            Objects.requireNonNull(recyclerView.adapter!!).itemCount
        Espresso.onView(ViewMatchers.withId(R.id.listArticlesRecyclerView))
            .inRoot(
                RootMatchers.withDecorView(
                    Matchers.`is`(
                        activityRule.activity.window.decorView
                    )
                )
            )
            .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(itemCount - 1))
    }

    @Test
    @Throws(InterruptedException::class)
    fun testCaseForRecyclerClick() {
        Thread.sleep(1000)
        Espresso.onView(ViewMatchers.withId(R.id.listArticlesRecyclerView))
            .inRoot(
                RootMatchers.withDecorView(
                    Matchers.`is`(
                        activityRule.activity.window.decorView
                    )
                )
            )
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                    0,
                    ViewActions.click()
                )
            )
    }

    


}