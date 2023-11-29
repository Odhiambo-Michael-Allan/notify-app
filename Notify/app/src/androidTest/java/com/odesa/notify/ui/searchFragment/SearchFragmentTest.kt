package com.odesa.notify.ui.searchFragment

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withContentDescription
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.google.android.material.appbar.MaterialToolbar
import com.odesa.notify.MainActivity
import com.odesa.notify.R
import com.odesa.notify.getToolbarNavigationContentDescription
import org.hamcrest.Matchers
import org.hamcrest.Matchers.`is`
import org.junit.Test
import org.hamcrest.MatcherAssert.assertThat

class SearchFragmentTest {

    @Test
    fun whenUserNavigatesToTheSearchFragment_theSearchMenuAndOptionsMenuAreHidden() {
        val activityScenario = ActivityScenario.launch( MainActivity::class.java )
        onView( withContentDescription( R.string.search ) )
            .perform( click() )
        activityScenario.onActivity {
            it.findViewById<MaterialToolbar>( R.id.toolbar ).apply {
                val searchMenu = menu.findItem( R.id.search_menu )
                assertThat( searchMenu.isVisible, `is`( false ) )
                val editMenu = menu.findItem( R.id.edit_menu )
                assertThat( editMenu.isVisible, `is`( false ) )
                val viewMenu = menu.findItem( R.id.view_menu )
                assertThat( viewMenu.isVisible, `is`( false ) )
                val sortMenu = menu.findItem( R.id.sort_menu )
                assertThat( sortMenu.isVisible, `is`( false ) )
                val emptyTrashMenu = menu.findItem( R.id.empty_trash_menu )
                assertThat( emptyTrashMenu.isVisible, `is`( false ) )
            }
        }
        activityScenario.close()
    }
}