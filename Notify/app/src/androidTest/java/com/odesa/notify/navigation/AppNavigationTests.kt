package com.odesa.notify.navigation

import android.app.Activity
import android.view.Gravity
import androidx.appcompat.widget.Toolbar
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.DrawerMatchers.isClosed
import androidx.test.espresso.contrib.DrawerMatchers.isOpen
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withContentDescription
import com.odesa.notify.MainActivity
import org.junit.Test
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.odesa.notify.R
import org.hamcrest.Matchers.not

class AppNavigationTests {

    @Test
    fun whenMainActivityStartsUp_theNavigationDrawerIsClosed() {
        val activityScenario = ActivityScenario.launch( MainActivity::class.java )
        onView( withId( R.id.drawer_layout ) )
            .check( matches( isClosed( Gravity.START ) ) )
        activityScenario.close()
    }

    @Test
    fun whenDrawerIconIsClicked_theNavigationDrawerIsOpened() {
        val activityScenario = ActivityScenario.launch( MainActivity::class.java )
        onView( withContentDescription(
            activityScenario.getToolbarNavigationContentDescription()
        ) ).perform( click() )
        // Check that the drawer is open.
        onView( withId( R.id.drawer_layout ) )
            .check( matches( isOpen( Gravity.START ) ) )
        activityScenario.close()
    }

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
    fun userCanNavigateToAddEditNoteFragmentFromReminderFragment() {
        val activityScenario = ActivityScenario.launch( MainActivity::class.java )
        // Open navigation view
        onView( withContentDescription(
            activityScenario.getToolbarNavigationContentDescription()
        ) ).perform( click() )
        // Click on reminder menu to navigate to the reminders fragment
        onView( withId( R.id.nav_reminder ) )
            .perform( click() )
        // Click on the add note fab to add a new note with a reminder
        onView( withId( R.id.add_note_fab ) )
            .perform( click() )
        onView( withId( R.id.add_edit_note_fragment ) )
            .check( matches( isDisplayed() ) )
        activityScenario.close()
    }

    @Test
    fun whenUserNavigatesToTheArchiveFragment_theBottomAppBarIsHidden() {
        val activityScenario = ActivityScenario.launch( MainActivity::class.java )
        onView( withContentDescription(
            activityScenario.getToolbarNavigationContentDescription()
        ) ).perform( click() )
        onView( withId( R.id.nav_archive ) )
            .perform( click() )
        onView( withId( R.id.bottom_app_bar ) )
            .check( matches( not( isDisplayed() ) ) )
        activityScenario.close()
    }

    @Test
    fun whenUserNavigatesToTheArchiveFragment_theFabIsHidden() {
        val activityScenario = ActivityScenario.launch( MainActivity::class.java )
        onView( withContentDescription(
            activityScenario.getToolbarNavigationContentDescription()
        ) ).perform( click() )
        onView( withId( R.id.nav_archive ) )
            .perform( click() )
        onView( withId( R.id.add_note_fab ) )
            .check( matches( not( isDisplayed() ) ) )
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
}

/**
 * The following extension function uses the toolbar's getNavigationContentDescription to get the
 * content description for this icon
 */
fun <T : Activity> ActivityScenario<T>.getToolbarNavigationContentDescription()
        : String {
    var description = ""
    onActivity {
        description =
            it.findViewById<Toolbar>( R.id.toolbar ).navigationContentDescription as String
    }
    return description
}