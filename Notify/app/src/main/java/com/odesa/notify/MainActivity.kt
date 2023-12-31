package com.odesa.notify

import android.app.Activity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.core.view.isVisible
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.odesa.notify.databinding.ActivityMainBinding
import com.odesa.notify.utils.Event
import timber.log.Timber


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var appBarConfiguration: AppBarConfiguration

    private val _fabClicked = MutableLiveData<Event<Boolean>>()
    private val _tasksMenuClicked = MutableLiveData<Event<Boolean>>()
    private val _searchMenuClicked = MutableLiveData<Event<Boolean>>()
    val fabClicked
        get() = _fabClicked
    val tasksMenuClicked
        get() = _tasksMenuClicked
    val searchMenuClicked
        get() = _searchMenuClicked

    override fun onCreate( savedInstanceState: Bundle? ) {
        enableEdgeToEdge()
        super.onCreate( savedInstanceState )
        binding = ActivityMainBinding.inflate( layoutInflater )
        setContentView( binding.root )
        setSupportActionBar( binding.toolbar )
        setupAppBar()
        setupAddNoteFab()
        setupTasksMenu()
        setupNavControllerListener()
    }

    private fun setupAppBar() {
        val navController: NavController = findNavController( R.id.nav_host_fragment )
        appBarConfiguration = AppBarConfiguration.Builder( R.id.nav_notes, R.id.nav_reminder,
            R.id.nav_archive, R.id.nav_trash )
            .setOpenableLayout( binding.drawerLayout )
            .build()
        setupActionBarWithNavController( navController, appBarConfiguration )
        binding.navigationDrawer.setupWithNavController( navController )
    }

    private fun setupAddNoteFab() {
        binding.addNoteFab.setOnClickListener {
            _fabClicked.value = Event( true )
        }
    }

    private fun setupTasksMenu() {
        binding.bottomAppBar.menu.findItem( R.id.nav_tasks ).setOnMenuItemClickListener {
            _tasksMenuClicked.value = Event( true )
            true
        }
    }

    private fun setupSearchMenu() {
        binding.toolbar.menu.findItem( R.id.search_menu ).setOnMenuItemClickListener {
            Timber.d( "Search Menu Clicked. Sending notification to observers" )
            _searchMenuClicked.value = Event( true )
            true
        }
    }

    private fun setupNavControllerListener() {
        findNavController( R.id.nav_host_fragment ).addOnDestinationChangedListener { _, destination, _ ->
            configureActivityViewsDependingOn( destination.id )
        }
    }

    private fun configureActivityViewsDependingOn( destinationId: Int ) {
        when ( destinationId ) {
            R.id.nav_notes -> configureNotesFragmentViews()
            R.id.nav_reminder -> configureReminderFragmentViews()
            R.id.nav_archive -> configureArchiveFragmentViews()
            R.id.nav_trash -> configureTrashFragmentViews()
            R.id.nav_settings -> configureSettingsFragmentViews()
            R.id.nav_search -> configureSearchFragmentViews()
            R.id.nav_tasks -> configureTasksFragmentViews()
        }
    }

    private fun configureNotesFragmentViews() {
        showAllViews()
    }

    private fun configureReminderFragmentViews() {
        showAllViews()
    }

    private fun showAllViews() {
        hideBottomAppBar( false )
    }

    private fun configureTrashFragmentViews() {
        hideBottomAppBar( true )
    }

    private fun configureArchiveFragmentViews() {
        hideBottomAppBar( true )
    }

    private fun configureSettingsFragmentViews() {
        hideBottomAppBar( true )
    }

    private fun configureSearchFragmentViews() {
        hideBottomAppBar( true )
    }

    private fun configureTasksFragmentViews() {
        hideFab( true )
        binding.bottomAppBar.isVisible = false
    }

    private fun hideBottomAppBar( hide: Boolean ) {
        if ( hide ) {
            binding.bottomAppBar.visibility = View.GONE
            hideFab( true )
        } else {
            binding.bottomAppBar.visibility = View.VISIBLE
            hideFab( false )
        }
    }

    private fun hideFab( hide: Boolean ) {
        if ( hide )
            binding.addNoteFab.visibility = View.GONE
        else
            binding.addNoteFab.visibility = View.VISIBLE
    }




    override fun onSupportNavigateUp(): Boolean {
        return findNavController( R.id.nav_host_fragment ).navigateUp( appBarConfiguration ) ||
                super.onSupportNavigateUp()
    }

    override fun onCreateOptionsMenu( menu: Menu? ): Boolean {
        menuInflater.inflate( R.menu.top_app_bar_menu, menu )
        setupSearchMenu()
        return true
    }

}

//const val TASK_LIST_ITEM_VIEW = Activity.RESULT_FIRST_USER + 1
//const val TASK_LIST_ITEM = Activity.RESULT_FIRST_USER + 2
//const val EDIT_RESULT_OK = Activity.RESULT_FIRST_USER + 3