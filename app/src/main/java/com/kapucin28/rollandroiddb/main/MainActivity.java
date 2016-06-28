package com.kapucin28.rollandroiddb.main;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;

import com.kapucin28.rollandroiddb.R;
import com.kapucin28.rollandroidbd.input.AddPersonAlert;
import com.kapucin28.rollandroidbd.input.RemovePersonAlert;

import java.io.File;
import java.util.Set;
import java.util.TreeSet;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener,
        AddPersonAlert.SendResults, RemovePersonAlert.SendResult{

    // SQL variables & constants--------------------------------------------------------------------
    private Cursor cursor;
    private SQLiteDatabase sqLiteDatabase = null;
    private final String databaseName = "SQL DB";
    private final String tableName = "sql";
    private int idColumn, nameColumn, emailColumn, phoneColumn;
    private String name, email, phone, id, personDetails;
    private File file;
    //----------------------------------------------------------------------------------------------

    // DB content variables-------------------------------------------------------------------------
    private Set<String> list = new TreeSet<>();
    private TextView textView;
    private String idSQL;
    //----------------------------------------------------------------------------------------------
    
    // Calling classes variables--------------------------------------------------------------------
    private AddPersonAlert addPersonAlert;
    private RemovePersonAlert removePersonAlert;
    //----------------------------------------------------------------------------------------------

    // Drawer variables-----------------------------------------------------------------------------
    private Toolbar toolbar;
    private DrawerLayout drawer;
    private ActionBarDrawerToggle toggle;
    private NavigationView navigationView;
    private Menu navMenu;
    private MenuItem item1, item2, item3, item4, item5, item6, item7;

    private boolean addNavItem = true;
    private boolean removeNavItem = true;
    private boolean refreshNavItem = true;
    private boolean clearNavItem = true;
    private boolean createNavItem = false;
    private boolean deleteNavItem = true;
    private boolean exitNavItem = true;
    //----------------------------------------------------------------------------------------------

    // OnCreate method------------------------------------------------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_drawer);

        drawer = (DrawerLayout) findViewById(R.id.activity_main_drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.navigation_view);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        textView = (TextView) findViewById(R.id.text_view_db);

        createStartup();
        displayStartup();
        toolbarSetup();
        drawerSetup();
        navigationSetup();
        startupMenuItemsStatus();
    }
    //----------------------------------------------------------------------------------------------

    // Toolbar setup method-------------------------------------------------------------------------
    private void toolbarSetup() {
        setSupportActionBar(toolbar);
    }
    //----------------------------------------------------------------------------------------------

    // Drawer items status at startup---------------------------------------------------------------
    private void startupMenuItemsStatus() {
        navMenu = navigationView.getMenu();
        item1 = navMenu.findItem(R.id.add_person_drawer_item).setEnabled(addNavItem);
        item2 = navMenu.findItem(R.id.remove_person_drawer_item).setEnabled(removeNavItem);
        item3 = navMenu.findItem(R.id.refresh_text_view).setEnabled(refreshNavItem);
        item4 = navMenu.findItem(R.id.clear_DB_drawer_item).setEnabled(clearNavItem);
        item5 = navMenu.findItem(R.id.create_DB_drawer_item).setEnabled(createNavItem);
        item6 = navMenu.findItem(R.id.delete_DB_drawer_item).setEnabled(deleteNavItem);
        item7 = navMenu.findItem(R.id.exit_app).setEnabled(exitNavItem);
    }
    //----------------------------------------------------------------------------------------------
}
