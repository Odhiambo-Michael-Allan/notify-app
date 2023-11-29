package com.odesa.notify.ui.notesFragment

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import com.odesa.notify.MainActivity
import com.odesa.notify.R
import org.junit.Assert.*
import org.junit.Test

class NotesFragmentTest {

    @Test
    fun whenMainActivityStartsUp_theNotesFragmentIsDisplayed() {
        val activityScenario = ActivityScenario.launch( MainActivity::class.java )
        Espresso.onView(ViewMatchers.withId(R.id.notes_fragment))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        activityScenario.close()
    }

    @Test
    fun userCanNavigateToAddEditNoteFragmentFromNotesFragment() {
        val activityScenario = ActivityScenario.launch( MainActivity::class.java )
        Espresso.onView(ViewMatchers.withId(R.id.add_note_fab))
            .perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.add_edit_note_fragment))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        activityScenario.close()
    }

    @Test
    fun userCanNavigateToTasksFragmentFromNotesFragment() {
        val activityScenario = ActivityScenario.launch( MainActivity::class.java )
        Espresso.onView(ViewMatchers.withId(R.id.nav_tasks))
            .perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.task_fragment))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        activityScenario.close()
    }
}