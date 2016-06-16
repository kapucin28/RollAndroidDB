package com.kapucin28.rollandroiddb.main;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.kapucin28.rollandroiddb.R;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    // SQL variables & constants--------------------------------------------------------------------
    private Cursor cursor;
    private SQLiteDatabase sqLiteDatabase = null;
    private final String databaseName = "SQL DB";
    private final String tableName = "sql";
    private int idColumn, nameColumn, emailColumn, phoneColumn;
    private String name, email, phone, id, personDetails;
    private File file;
    //----------------------------------------------------------------------------------------------

    // OnCreate method------------------------------------------------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_layout);
    }
    //----------------------------------------------------------------------------------------------
}
