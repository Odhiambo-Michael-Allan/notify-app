package com.odesa.notify.ui.archiveFragment

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import com.odesa.notify.MainActivity
import com.odesa.notify.R
import com.odesa.notify.getToolbarNavigationContentDescription
import org.hamcrest.Matchers
import org.junit.Assert.*
import org.junit.Test

class ArchiveFragmentTest {

    @Test
    fun whenUserNavigatesToTheArchiveFragment_theBottomAppBarIsHidden() {
        val activityScenario = ActivityScenario.launch( MainActivity::class.java )
        Espresso.onView(
            ViewMatchers.withContentDescription(
                activityScenario.getToolbarNavigationContentDescription()
            )
        ).perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.nav_archive))
            .perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.bottom_app_bar))
            .check(ViewAssertions.matches(Matchers.not(ViewMatchers.isDisplayed())))
        activityScenario.close()
    }

    @Test
    fun whenUserNavigatesToTheArchiveFragment_theFabIsHidden() {
        val activityScenario = ActivityScenario.launch( MainActivity::class.java )
        Espresso.onView(
            ViewMatchers.withContentDescription(
                activityScenario.getToolbarNavigationContentDescription()
            )
        ).perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.nav_archive))
            .perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.add_note_fab))
            .check(ViewAssertions.matches(Matchers.not(ViewMatchers.isDisplayed())))
        activityScenario.close()
    }

}