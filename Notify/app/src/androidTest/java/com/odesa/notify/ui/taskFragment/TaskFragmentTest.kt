package com.odesa.notify.ui.taskFragment

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.assertThat
import androidx.test.espresso.matcher.ViewMatchers.hasFocus
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.google.android.material.appbar.MaterialToolbar
import com.odesa.notify.MainActivity
import com.odesa.notify.R
import org.hamcrest.Matcher
import org.hamcrest.Matchers.`is`
import org.hamcrest.Matchers.not
import org.hamcrest.TypeSafeMatcher
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.hamcrest.Description

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

    @Test
    fun whenUserNavigatesToTasksFragment_theMoreOptionsMenuIsDisplayed() {
        onView( withId( R.id.nav_tasks ) ).perform( click() )
        onView( withId( R.id.more_options_menu ) ).check( matches( isDisplayed() ) )
    }

    @Test
    fun whenUserClicksOnTheMoresOptionsMenu_theMoreOptionsBottomSheetIsDisplayed() {
        onView( withId( R.id.nav_tasks ) ).perform( click() )
        onView( withId( R.id.more_options_menu ) ).perform( click() )
    }

    @Test
    fun whenUserClicksOnTheMoreOptionsMenu_theMoreOptionsModalBottomSheetIsDisplayed() {
        onView( withId( R.id.nav_tasks ) ).perform( click() )
        onView( withId( R.id.more_options_menu ) ).perform( click() )
        onView( withId( R.id.more_options_modal_bottom_sheet ) ).check( matches( isDisplayed() ) )
    }

    @Test
    fun whenUserClicksOnTheMoreOptionsMenu_theMoreOptionsAreDisplayed() {
        onView( withId( R.id.nav_tasks ) ).perform( click() )
        onView( withId( R.id.more_options_menu ) ).perform( click() )
        onView( withId( R.id.delete_text_view ) ).check( matches( isDisplayed() ) )
        onView( withId( R.id.make_copy_text_view ) ).check( matches( isDisplayed() ) )
        onView( withId( R.id.share_text_view ) ).check( matches( isDisplayed() ) )
        onView( withId( R.id.labels_text_view ) ).check( matches( isDisplayed() ) )
        onView( withId( R.id.help_and_feedback_text_view ) ).check( matches( isDisplayed() ) )
    }

    @Test
    fun whenUserClicksOnTheAddMediaContentMenu_theMediaOptionsAreDisplayed() {
        onView( withId( R.id.nav_tasks ) ).perform( click() )
        onView( withId( R.id.add_media_content_menu ) ).perform( click() )
        onView( withId( R.id.take_photo_text_view ) ).check( matches( isDisplayed() ) )
        onView( withId( R.id.add_image_text_view ) ).check( matches( isDisplayed() ) )
        onView( withId( R.id.add_drawing_text_view ) ).check( matches( isDisplayed() ) )
        onView( withId( R.id.recording_text_view ) ).check( matches( isDisplayed() ) )
    }

    @Test
    fun whenUserClicksOnTheBackgroundColorPaletteMenu_theListOfColorsIsDisplayed() {
        onView( withId( R.id.nav_tasks ) ).perform( click() )
        onView( withId( R.id.background_color_palette_menu ) ).perform( click() )
        onView( withId( R.id.background_color_recyclerview ) ).check( matches( isDisplayed() ) )
    }

    @Test
    fun whenUserNavigatesToTheTasksFragment_theTitleToolbarIsDisplayed() {
        onView( withId( R.id.nav_tasks ) ).perform( click() )
        onView( withId( R.id.fragment_tasks_top_app_bar ) ).check( matches( isDisplayed() ) )
    }

    @Test
    fun whenUserNavigatesToTheTasksFragment_theHideCheckboxesMenuIsDisplayed() {
        onView( withId( R.id.nav_tasks ) ).perform( click() )
        activityScenario.onActivity {
            val toolbar = it.findViewById<MaterialToolbar>( R.id.fragment_tasks_top_app_bar )
            assertThat( toolbar.menu.findItem( R.id.hide_checkboxes_menu ).isVisible,
                `is`( true ) )
        }
    }

    @Test
    fun whenUserNavigatesToTheTasksFragment_theTaskCheckboxIsDisplayed() {
        onView( withId( R.id.nav_tasks ) ).perform( click() )
        onView( withId( R.id.task_checkbox ) ).check( matches( isDisplayed() ) )
    }

    @Test
    fun whenUserNavigatesToTheTasksFragmentToCreateNewTask_theDefaultTaskItemEditTextHasFocusAndKeyboard() {
        onView( withId( R.id.nav_tasks ) ).perform( click() )
        onView( withId( R.id.task_description_edittext ) ).check( matches( hasFocus() ) )
        onView( withId( R.id.task_description_edittext ) ).check( matches( isKeyboardDisplayed() ) )
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

    // Custom Matcher to check if the soft keyboard is displayed
    private fun isKeyboardDisplayed(): Matcher<View> {
        return object : TypeSafeMatcher<View>() {
            override fun matchesSafely( item: View ): Boolean {
                val imm = item.context.getSystemService(
                    Context.INPUT_METHOD_SERVICE) as InputMethodManager
                return imm.isActive( item )
            }

            override fun describeTo( description: Description ) {
                description.appendText( "soft keyboard is displayed" )
            }
        }
    }


}