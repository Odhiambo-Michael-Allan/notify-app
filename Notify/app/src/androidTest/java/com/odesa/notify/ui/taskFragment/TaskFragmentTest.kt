package com.odesa.notify.ui.taskFragment

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.assertThat
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.bottomappbar.BottomAppBar
import com.odesa.notify.MainActivity
import com.odesa.notify.R
import org.hamcrest.Matchers.`is`
import org.hamcrest.Matchers.not
import org.junit.Test

class TaskFragmentTest {

    @Test
    fun whenUserNavigatesToTasksFragment_theBottomAppBarIsDisplayed() {
        val activityScenario = ActivityScenario.launch( MainActivity::class.java )
        onView( withId( R.id.nav_tasks ) ).perform( click() )
        onView( withId( R.id.bottom_app_bar ) ).check( matches( isDisplayed() ) )
        activityScenario.close()
    }

    @Test
    fun whenUserNavigatesToTasksFragment_theAddNoteFabIsHidden() {
        val activityScenario = ActivityScenario.launch( MainActivity::class.java )
        onView( withId( R.id.nav_tasks ) ).perform( click() )
        onView( withId( R.id.add_note_fab ) ).check( matches( not( isDisplayed() ) ) )
        activityScenario.close()
    }

    @Test
    fun whenUserNavigatesToTasksFragment_theTasksMenuIsHidden() {
        val activityScenario = ActivityScenario.launch( MainActivity::class.java )
        onView( withId( R.id.nav_tasks ) ).perform( click() )
        activityScenario.onActivity {
            with ( it.findViewById<BottomAppBar>( R.id.bottom_app_bar ) ) {
                val tasksMenu = menu.findItem( R.id.nav_tasks )
                assertThat( tasksMenu.isVisible, `is`( false ) )
            }
        }
        activityScenario.close()
    }

    @Test
    fun whenUserNavigatesToTasksFragment_theMicrophoneMenuIsHidden() {
        val activityScenario = ActivityScenario.launch( MainActivity::class.java )
        onView( withId( R.id.nav_tasks ) ).perform( click() )
        activityScenario.onActivity {
            with( it.findViewById<BottomAppBar>( R.id.bottom_app_bar ) ) {
                val microphoneMenu = menu.findItem( R.id.microphone_menu )
                assertThat( microphoneMenu.isVisible, `is`( false ) )
            }
        }
        activityScenario.close()
    }

    @Test
    fun whenUserNavigatesToTasksFragment_thePinMenuIsDisplayed() {
        val activityScenario = ActivityScenario.launch( MainActivity::class.java )
        onView( withId( R.id.nav_tasks ) ).perform( click() )
        activityScenario.onActivity {
            with ( it.findViewById<MaterialToolbar>( R.id.toolbar ) ) {
                val pinMenu = menu.findItem( R.id.pin_menu )
                assertThat( pinMenu.isVisible, `is`( true ) )
            }
        }
        activityScenario.close()
    }

    @Test
    fun whenUserNavigatesToTasksFragment_theReminderIconIsDisplayed() {
        val activityScenario = ActivityScenario.launch( MainActivity::class.java )
        onView( withId( R.id.nav_tasks ) ).perform( click() )
        activityScenario.onActivity {
            with( it.findViewById<MaterialToolbar>( R.id.toolbar ) ) {
                val reminderMenu = menu.findItem( R.id.reminder_menu )
                assertThat( reminderMenu.isVisible, `is`( true ) )
            }
        }
        activityScenario.close()
    }

    @Test
    fun whenUserNavigatesToTasksFragment_theArchiveIconIsDisplayed() {
        val activityScenario = ActivityScenario.launch( MainActivity::class.java )
        onView( withId( R.id.nav_tasks ) ).perform( click() )
        activityScenario.onActivity {
            with ( it.findViewById<MaterialToolbar>( R.id.toolbar ) ) {
                val archiveMenu = menu.findItem( R.id.archive_menu )
                assertThat( archiveMenu.isVisible, `is`( true ) )
            }
        }
        activityScenario.close()
    }

    @Test
    fun whenUserNavigatesToTasksFragment_theAddContentIconIsDisplayed() {
        val activityScenario = ActivityScenario.launch( MainActivity::class.java )
        onView( withId( R.id.nav_tasks ) ).perform( click() )
        activityScenario.onActivity {
            with ( it.findViewById<BottomAppBar>( R.id.bottom_app_bar ) ) {
                val addContentMenu = menu.findItem( R.id.add_content_menu )
                assertThat( addContentMenu.isVisible, `is`( true ) )
            }
        }
        activityScenario.close()
    }

    @Test
    fun whenUserNavigatesToTasksFragment_theBackgroundColorPaletteIsDisplayed() {
        val activityScenario = ActivityScenario.launch( MainActivity::class.java )
        onView( withId( R.id.nav_tasks ) ).perform( click() )
        activityScenario.onActivity {
            with ( it.findViewById<BottomAppBar>( R.id.bottom_app_bar ) ) {
                val backgroundPaletteMenu = menu.findItem( R.id.background_palette_menu )
                assertThat( backgroundPaletteMenu.isVisible, `is`( true ) )
            }
        }
        activityScenario.close()
    }
}