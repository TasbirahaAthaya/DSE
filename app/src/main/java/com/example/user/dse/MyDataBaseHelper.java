package com.example.user.dse;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;


public class MyDataBaseHelper extends SQLiteOpenHelper {


    private static final int DATABASE_VERSION = 1;


    // db version
    private static final String DATABASE_NAME = "Watchlist";
    // table name
    public static final String TABLE_NAME = "List";
    // table column
    public static final String Column_Id = "id";
    public static final String Column_Symbol = "symbol";
    public static final String Column_Ltp = "ltp";
    public static final String Column_Volume = "volume";
    public static final String Column_Change = "change";


    private static final String creating_table =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    Column_Id + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    Column_Symbol + " TEXT, " +
                    Column_Ltp + " TEXT, " +
                    Column_Volume + " TEXT, " +
                    Column_Change + " TEXT " +
                    ")";

    // constructor
    public MyDataBaseHelper(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(creating_table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        db.execSQL(creating_table);

    }

}
