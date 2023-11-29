package com.odesa.notify

import android.app.Activity
import android.view.Gravity
import androidx.appcompat.widget.Toolbar
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.DrawerMatchers
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withContentDescription
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.odesa.notify.utils.Event
import org.junit.Test
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.`is`
import org.hamcrest.Matchers.not

class MainActivityTest {

    @Test
    fun whenMainActivityStartsUp_theNavigationDrawerIsClosed() {
        val activityScenario = ActivityScenario.launch( MainActivity::class.java )
        onView( withId( R.id.drawer_layout ) )
            .check( matches(DrawerMatchers.isClosed(Gravity.START)) )
        activityScenario.close()
    }

    @Test
    fun whenDrawerIconIsClicked_theNavigationDrawerIsOpened() {
        val activityScenario = ActivityScenario.launch( MainActivity::class.java )
        onView(
            ViewMatchers.withContentDescription(
                activityScenario.getToolbarNavigationContentDescription()
            )
        ).perform( click() )
        // Check that the drawer is open.
        onView( withId( R.id.drawer_layout ) )
            .check( matches(DrawerMatchers.isOpen(Gravity.START)) )
        activityScenario.close()
    }

    @Test
    fun whenAddNoteFabIsClicked_mainActivitySendsNotificationToObservers() {
        val activityScenario = ActivityScenario.launch( MainActivity::class.java )
        var receivedFabClickNotification = Event( false )
        onView( withId( R.id.add_note_fab ) )
            .perform( click() )
        activityScenario.onActivity {
            receivedFabClickNotification = it.fabClicked.getOrAwaitValue()
        }
        assertThat( receivedFabClickNotification.peekContent(), `is`( true ) )
        activityScenario.close()
    }

    @Test
    fun whenUserNavigatesToArchiveFragment_thenToTrashFragment_theBottomAppBarShouldNotBeVisible() {
        val activityScenario = ActivityScenario.launch( MainActivity::class.java )
        onView(
            withContentDescription(
                activityScenario.getToolbarNavigationContentDescription()
            ) ).perform( click() )
        onView( withId( R.id.nav_archive ) ).perform( click() )
        onView( withId( R.id.bottom_app_bar ) ).check( matches( not( isDisplayed() ) ) )

        onView( withContentDescription( activityScenario.getToolbarNavigationContentDescription() ) )
            .perform( click() )
        onView( withId( R.id.nav_trash ) ).perform( click() )
        onView( withId( R.id.bottom_app_bar ) ).check( matches( not( isDisplayed() ) ) )
        activityScenario.close()
    }

    @Test
    fun whenUserNavigatesToArchiveFragment_thenToNotesFragment_theBottomAppBarShouldBeVisible() {
        val activityScenario = ActivityScenario.launch( MainActivity::class.java )
        onView(
            withContentDescription(
                activityScenario.getToolbarNavigationContentDescription()
            ) ).perform( click() )
        onView( withId( R.id.nav_archive ) ).perform( click() )
        onView( withId( R.id.bottom_app_bar ) ).check( matches( not( isDisplayed() ) ) )

        onView( withContentDescription( activityScenario.getToolbarNavigationContentDescription() ) )
            .perform( click() )
        onView( withId( R.id.nav_notes ) ).perform( click() )
        onView( withId( R.id.bottom_app_bar ) ).check( matches( isDisplayed() ) )
        onView( withId( R.id.add_note_fab ) ).check( matches( isDisplayed() ) )
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