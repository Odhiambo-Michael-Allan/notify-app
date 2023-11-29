package com.odesa.notify.ui.remindersFragment

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withContentDescription
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.odesa.notify.MainActivity
import com.odesa.notify.R
import com.odesa.notify.getToolbarNavigationContentDescription
import org.junit.Assert.*
import org.junit.Test

class RemindersFragmentTest {

    @Test
    fun userCanNavigateToAddEditNoteFragmentFromReminderFragment() {
        val activityScenario = ActivityScenario.launch( MainActivity::class.java )
        // Open navigation view
        Espresso.onView(
            ViewMatchers.withContentDescription(
                activityScenario.getToolbarNavigationContentDescription()
            )
        ).perform(ViewActions.click())
        // Click on reminder menu to navigate to the reminders fragment
        Espresso.onView(ViewMatchers.withId(R.id.nav_reminder))
            .perform(ViewActions.click())
        // Click on the add note fab to add a new note with a reminder
        Espresso.onView(ViewMatchers.withId(R.id.add_note_fab))
            .perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.add_edit_note_fragment))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        activityScenario.close()
    }

    @Test
    fun userCanNavigateToTasksFragmentFromRemindersFragment() {
        val activityScenario = ActivityScenario.launch( MainActivity::class.java )
        onView(
            withContentDescription(
                activityScenario.getToolbarNavigationContentDescription()
            )
        ).perform( click() )
        onView( withId(R.id.nav_reminder ) )
            .perform( click() )
        onView( withId( R.id.nav_tasks ) )
            .perform( click() )
         onView( withId( R.id.task_fragment ) )
            .check( matches( isDisplayed() ) )
        activityScenario.close()
    }

    @Test
    fun userCanNavigateToSearchFragmentFromRemindersFragment() {
        val activityScenario = ActivityScenario.launch( MainActivity::class.java )
        onView(
            withContentDescription(
                activityScenario.getToolbarNavigationContentDescription()
            )
        ).perform( click() )
        onView( withId(R.id.nav_reminder ) )
            .perform( click() )
        onView( withContentDescription( R.string.search ) )
            .perform( click() )
        onView( withId( R.id.search_fragment ) )
            .check( matches( isDisplayed() ) )
        activityScenario.close()
    }
}