package com.odesa.notify.ui.trashFragment

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
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
import org.hamcrest.Matchers
import org.hamcrest.Matchers.`is`
import org.hamcrest.Matchers.not
import org.junit.Test

class TrashFragmentTest {

    @Test
    fun whenUserNavigatesToTheTrashFragment_theBottomAppBarIsHidden() {
        val activityScenario = ActivityScenario.launch( MainActivity::class.java )
        onView(
            withContentDescription(
                activityScenario.getToolbarNavigationContentDescription()
            )
        ).perform( click() )
        onView( withId( R.id.nav_trash ) )
            .perform( click() )
        onView( withId( R.id.bottom_app_bar ) )
            .check( matches( not( isDisplayed() ) ) )
        activityScenario.close()
    }

    @Test
    fun whenUserNavigatesToTheTrashFragment_theFabIsHidden() {
        val activityScenario = ActivityScenario.launch( MainActivity::class.java )
        onView(
            withContentDescription(
                activityScenario.getToolbarNavigationContentDescription()
            )
        ).perform( click() )
        onView( withId( R.id.nav_archive ) )
            .perform( click() )
        onView( withId( R.id.add_note_fab ) )
            .check( matches( not( isDisplayed() ) ) )
        activityScenario.close()
    }

    @Test
    fun whenUserNavigatesToTheTrashFragment_allMenusAreHiddenExceptEmptyTrashMenu() {
        val activityScenario = ActivityScenario.launch( MainActivity::class.java )
        onView(
            withContentDescription(
                activityScenario.getToolbarNavigationContentDescription()
            )
        ).perform( click() )
        onView( withId( R.id.nav_trash ) )
            .perform( click() )
        activityScenario.onActivity {
            it.findViewById<MaterialToolbar>( R.id.toolbar ).apply {
                val searchMenu = menu.findItem( R.id.search_menu )
                assertThat(searchMenu.isVisible, `is`( false ) )
                val editMenu = menu.findItem( R.id.edit_menu )
                assertThat( editMenu.isVisible, `is`( false ) )
                val viewMenu = menu.findItem( R.id.view_menu )
                assertThat( viewMenu.isVisible, `is`( false ) )
                val sortMenu = menu.findItem( R.id.sort_menu )
                assertThat( sortMenu.isVisible, `is`( false ) )
                val emptyTrashMenu = menu.findItem( R.id.empty_trash_menu )
                assertThat( emptyTrashMenu.isVisible, `is`( true ) )
            }

        }
        activityScenario.close()
    }

}