package com.odesa.notify

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.doesNotHaveFocus
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.odesa.notify.utils.Event
import org.junit.Assert.*
import org.junit.Test
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.`is`

class MainActivityTest {

    @Test
    fun whenAddNoteFabIsClicked_mainActivitySendsNotificationToObservers() {
        val activityScenario = ActivityScenario.launch( MainActivity::class.java )
        var receivedFabClickNotification = Event( false )
        onView( withId( R.id.add_note_fab ) )
            .perform( click() )
        activityScenario.onActivity {
            receivedFabClickNotification = it.getFabStatus().getOrAwaitValue()
        }
        assertThat( receivedFabClickNotification.peekContent(), `is`( true ) )
        activityScenario.close()
    }
}