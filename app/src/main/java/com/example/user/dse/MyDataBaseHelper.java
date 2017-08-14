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
    private static final String TABLE_NAME = "List";
    // table column
    private static final String Column_Id = "id";
    private static final String Column_Symbol = "symbol";
    private static final String Column_Ltp = "ltp";
    private static final String Column_Volume = "volume";
    private static final String Column_Change = "change";


    // constructor
    public MyDataBaseHelper(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String creating_table = "CREATE TABLE "+TABLE_NAME+" ( "
                + Column_Id + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + Column_Symbol + " TEXT, "
                + Column_Ltp + " TEXT, "
                + Column_Volume + " TEXT, "
                + Column_Change + " TEXT "
                + " )";
        Log.e("msg:................. ",creating_table);

        db.execSQL(creating_table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

		this.onCreate(db);

    }


    void addNew(WatchlistTemplate myTemp) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(Column_Symbol, myTemp.getW_sym());
        values.put(Column_Ltp,myTemp.getW_ltp());
        values.put(Column_Volume,myTemp.getW_vol());
        values.put(Column_Change,myTemp.getW_chng());

        db.insert(TABLE_NAME, null, values);

        db.close();

    }


    // for reading data

    public List<WatchlistTemplate> getAllDataFromTable(){

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor res = db.rawQuery("select * from "+TABLE_NAME+";", null);

        res.moveToFirst();

    /*    String[] sym = new String[res.getCount()];
        String[] ltp = new String[res.getCount()];
        String[] vol = new String[res.getCount()];
        String[] chg = new String[res.getCount()];
*/
        List<WatchlistTemplate> watch = new ArrayList<>();

        if(res.moveToFirst()) {
            WatchlistTemplate temp= new WatchlistTemplate();

            int i=0;

            do {

             //   sym[i] =  res.getString(res.getColumnIndex(Column_Symbol));
                temp.setW_sym(res.getString(res.getColumnIndex(Column_Symbol)));
                temp.setW_ltp(res.getString(res.getColumnIndex(Column_Ltp)));
                temp.setW_vol(res.getString(res.getColumnIndex(Column_Volume)));
                temp.setW_chng(res.getString(res.getColumnIndex(Column_Change)));
                watch.add(temp);

                i = i +1;

            } while(res.moveToNext());

        }

        return watch;

    }



}
