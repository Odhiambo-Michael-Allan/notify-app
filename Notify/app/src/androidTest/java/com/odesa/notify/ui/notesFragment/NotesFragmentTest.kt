package com.odesa.notify.ui.notesFragment

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
import org.junit.Assert.*
import org.junit.Test

class NotesFragmentTest {

    @Test
    fun whenMainActivityStartsUp_theNotesFragmentIsDisplayed() {
        val activityScenario = ActivityScenario.launch( MainActivity::class.java )
        onView( withId( R.id.notes_fragment ) )
            .check( matches( isDisplayed() ) )
        activityScenario.close()
    }

    @Test
    fun userCanNavigateToAddEditNoteFragmentFromNotesFragment() {
        val activityScenario = ActivityScenario.launch( MainActivity::class.java )
        onView( withId( R.id.add_note_fab ) )
            .perform( click() )
        onView( withId( R.id.add_edit_note_fragment ) )
            .check( matches( isDisplayed() ) )
        activityScenario.close()
    }

    @Test
    fun userCanNavigateToTasksFragmentFromNotesFragment() {
        val activityScenario = ActivityScenario.launch( MainActivity::class.java )
        onView( withId( R.id.nav_tasks ) )
            .perform( click() )
        onView( withId( R.id.task_fragment ) )
            .check( matches( isDisplayed() ) )
        activityScenario.close()
    }

    @Test
    fun userCanNavigateToSearchFragmentFromNotesFragment() {
        val activityScenario = ActivityScenario.launch( MainActivity::class.java )
        onView( withContentDescription( R.string.search ) )
            .perform( click() )
        onView( withId( R.id.search_fragment ) )
            .check( matches( isDisplayed() ) )
        activityScenario.close()
    }
}