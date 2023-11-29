package com.odesa.notify.ui.archiveFragment

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
import com.odesa.notify.getToolbarNavigationContentDescription
import org.hamcrest.Matchers
import org.hamcrest.Matchers.not
import org.junit.Assert.*
import org.junit.Test

class ArchiveFragmentTest {

    @Test
    fun whenUserNavigatesToTheArchiveFragment_theBottomAppBarIsHidden() {
        val activityScenario = ActivityScenario.launch( MainActivity::class.java )
        onView(
            withContentDescription(
                activityScenario.getToolbarNavigationContentDescription()
            )
        ).perform( click() )
        onView( withId( R.id.nav_archive ) )
            .perform( click() )
        onView( withId( R.id.bottom_app_bar ) )
            .check( matches( not( isDisplayed() ) ) )
        activityScenario.close()
    }

    @Test
    fun whenUserNavigatesToTheArchiveFragment_theFabIsHidden() {
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
    fun userCanNavigateToSearchFragmentFromArchiveFragment() {
        val activityScenario = ActivityScenario.launch( MainActivity::class.java )
        onView(
            withContentDescription(
                activityScenario.getToolbarNavigationContentDescription()
            )
        ).perform( click() )
        onView( withId( R.id.nav_archive ) )
            .perform( click() )
        onView( withContentDescription( R.string.search ) )
            .perform( click() )
         onView( withId( R.id.search_fragment ) )
            .check( matches( isDisplayed() ) )
        activityScenario.close()
    }

}