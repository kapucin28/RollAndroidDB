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
import com.qdv8.sqldbcreator.input.AddPersonAlert;
import com.qdv8.sqldbcreator.input.RemovePersonAlert;

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

    // OnCreate method------------------------------------------------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_layout);
    }
    //----------------------------------------------------------------------------------------------
}
