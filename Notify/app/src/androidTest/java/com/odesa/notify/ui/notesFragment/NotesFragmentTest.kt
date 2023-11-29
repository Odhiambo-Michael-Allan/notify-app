package com.odesa.notify.ui.notesFragment

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.assertThat
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withContentDescription
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.google.android.material.appbar.MaterialToolbar
import com.odesa.notify.MainActivity
import com.odesa.notify.R
import com.odesa.notify.getToolbarNavigationContentDescription
import org.hamcrest.Matchers.`is`
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

    @Test
    fun whenUserNavigatesToArchiveFragmentThenBackToNotesFragment_allViewsShouldBeVisible() {
        val activityScenario = ActivityScenario.launch( MainActivity::class.java )
        openNavDrawer( activityScenario )
        onView( withId( R.id.nav_archive ) ).perform( click() )
        openNavDrawer( activityScenario )
        onView( withId( R.id.nav_notes ) ).perform( click() )
        checkAllViewsArePresent( activityScenario )
        activityScenario.close()
    }

    @Test
    fun whenUserNavigatesToTrashFragmentThenBackToNotesFragment_allViewsShouldBeVisible() {
        val activityScenario = ActivityScenario.launch( MainActivity::class.java )
        openNavDrawer( activityScenario )
        onView( withId( R.id.nav_trash ) ).perform( click() )
        openNavDrawer( activityScenario )
        onView( withId( R.id.nav_notes ) ).perform( click() )
        checkAllViewsArePresent( activityScenario )
        activityScenario.close()
    }

    @Test
    fun whenUserNavigatesToSettingsFragmentThenBackToNotesFragment_allViewsShouldBeVisible() {
        val activityScenario = ActivityScenario.launch( MainActivity::class.java )
        openNavDrawer( activityScenario )
        onView( withId( R.id.nav_settings ) ).perform( click() )
        pressBack()
        checkAllViewsArePresent( activityScenario )
        activityScenario.close()
    }

    private fun openNavDrawer( activityScenario: ActivityScenario<MainActivity> ) {
        onView( withContentDescription(
            activityScenario.getToolbarNavigationContentDescription() ) )
            .perform( click() )
    }

    private fun checkAllViewsArePresent( activityScenario: ActivityScenario<MainActivity> ) {
        onView( withId( R.id.bottom_app_bar ) ).check( matches( isDisplayed() ) )
        onView( withId( R.id.add_note_fab ) ).check( matches( isDisplayed() ) )
        activityScenario.onActivity {
            with ( it.findViewById<MaterialToolbar>( R.id.toolbar ) ) {
                assertThat( menu.findItem( R.id.search_menu ).isVisible, `is`( true ) )
                assertThat( menu.findItem( R.id.edit_menu ).isVisible, `is`( true ) )
                assertThat( menu.findItem( R.id.view_menu ).isVisible, `is`( true ) )
                assertThat( menu.findItem( R.id.sort_menu ).isVisible, `is`( true ) )
            }
        }
    }
}
