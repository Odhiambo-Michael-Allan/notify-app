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
import org.junit.After
import org.junit.Before
import org.junit.Test

class TaskFragmentTest {

    private lateinit var activityScenario: ActivityScenario<MainActivity>

    @Before
    fun setup() {
        activityScenario = ActivityScenario.launch( MainActivity::class.java )
    }

    @After
    fun cleanup() {
        activityScenario.close()
    }

    // Displayed Views..

    @Test
    fun whenUserNavigatesToTasksFragment_thePinMenuIsDisplayed() {
        onView( withId( R.id.nav_tasks ) ).perform( click() )
        activityScenario.onActivity {
            with ( it.findViewById<MaterialToolbar>( R.id.toolbar ) ) {
                val pinMenu = menu.findItem( R.id.pin_menu )
                assertThat( pinMenu.isVisible, `is`( true ) )
            }
        }
    }

    @Test
    fun whenUserNavigatesToTasksFragment_theReminderIconIsDisplayed() {
        onView( withId( R.id.nav_tasks ) ).perform( click() )
        activityScenario.onActivity {
            with( it.findViewById<MaterialToolbar>( R.id.toolbar ) ) {
                val reminderMenu = menu.findItem( R.id.reminder_menu )
                assertThat( reminderMenu.isVisible, `is`( true ) )
            }
        }
    }

    @Test
    fun whenUserNavigatesToTasksFragment_theArchiveIconIsDisplayed() {
        onView( withId( R.id.nav_tasks ) ).perform( click() )
        activityScenario.onActivity {
            with ( it.findViewById<MaterialToolbar>( R.id.toolbar ) ) {
                val archiveMenu = menu.findItem( R.id.archive_menu )
                assertThat( archiveMenu.isVisible, `is`( true ) )
            }
        }
    }

    @Test
    fun whenUserNavigatesToTasksFragment_theAddMediaContentMenuIsDisplayed() {
        onView( withId( R.id.nav_tasks ) ).perform( click() )
        onView( withId( R.id.add_media_content_menu ) ).check( matches( isDisplayed() ) )
    }

    @Test
    fun whenUserNavigatesToTasksFragment_theBackgroundColorPaletteIsDisplayed() {
        onView( withId( R.id.nav_tasks ) ).perform( click() )
        onView( withId( R.id.background_color_palette_menu ) ).check( matches( isDisplayed() ) )
    }

    @Test
    fun whenUserNavigatesToTasksFragment_theEditedTextViewIsDisplayed() {
        onView( withId( R.id.nav_tasks ) ).perform( click() )
        onView( withId( R.id.last_edited_text_view ) ).check( matches( isDisplayed() ) )
    }

    @Test
    fun whenUserNavigatesToTasksFragment_theTasksFragmentBottomAppBarIsDisplayed() {
        onView( withId( R.id.nav_tasks ) ).perform( click() )
        onView( withId( R.id.fragment_tasks_bottom_app_bar ) ).check( matches( isDisplayed() ) )
    }

    // Hidden Views..

    @Test
    fun whenUserNavigatesToTasksFragment_theAddNoteFabIsHidden() {
        onView( withId( R.id.nav_tasks ) ).perform( click() )
        onView( withId( R.id.add_note_fab ) ).check( matches( not( isDisplayed() ) ) )
    }

    @Test
    fun whenUserNavigatesToTasksFragment_theMainActivityBottomAppBarIsHidden() {
        onView( withId( R.id.nav_tasks ) ).perform( click() )
        onView( withId( R.id.bottom_app_bar ) ).check( matches( not( isDisplayed() ) ) )
    }


}