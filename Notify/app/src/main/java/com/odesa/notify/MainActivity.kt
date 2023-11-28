package com.odesa.notify

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.odesa.notify.databinding.ActivityMainBinding
import com.odesa.notify.utils.Event


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var appBarConfiguration: AppBarConfiguration

    private val _fabClicked = MutableLiveData<Event<Boolean>>()
    private val _tasksMenuClicked = MutableLiveData<Event<Boolean>>()
    private val fabClicked: LiveData<Event<Boolean>>
        get() = _fabClicked
    private val tasksMenuClicked
        get() = _tasksMenuClicked

    override fun onCreate( savedInstanceState: Bundle? ) {
        enableEdgeToEdge()
        super.onCreate( savedInstanceState )
        binding = ActivityMainBinding.inflate( layoutInflater )
        setContentView( binding.root )
        setSupportActionBar( binding.toolbar )
        setupAppBar()
        setupAddNoteFab()
        setupTasksMenu()
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

    override fun onSupportNavigateUp(): Boolean {
        return findNavController( R.id.nav_host_fragment ).navigateUp( appBarConfiguration ) ||
                super.onSupportNavigateUp()
    }

    override fun onCreateOptionsMenu( menu: Menu? ): Boolean {
        menuInflater.inflate( R.menu.top_app_bar_menu, menu )
        return true
    }

    fun getFabStatus(): LiveData<Event<Boolean>> = fabClicked

    fun getTasksMenuItemStatus() = tasksMenuClicked
}
