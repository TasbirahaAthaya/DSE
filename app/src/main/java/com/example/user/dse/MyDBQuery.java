<<<<<<< HEAD
package com.example.user.dse;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 8/14/2017.
 */
public class MyDBQuery {

    public static final String LOGTAG = "SYS";

    SQLiteOpenHelper dbhandler;
    SQLiteDatabase database;

    private static final String[] allColumns = {
            MyDataBaseHelper.Column_Id,
            MyDataBaseHelper.Column_Symbol,
            MyDataBaseHelper.Column_Ltp,
            MyDataBaseHelper.Column_Volume,
            MyDataBaseHelper.Column_Change
    };

    public MyDBQuery(Context context){
        dbhandler = new MyDataBaseHelper(context);
    }

    public void open(){
        Log.i(LOGTAG,"Database Opened");
        database = dbhandler.getWritableDatabase();


    }
    public void close(){
        Log.i(LOGTAG, "Database Closed");
        dbhandler.close();

    }
    public WatchlistTemplate addNew(WatchlistTemplate myTemp){
        ContentValues values = new ContentValues();
        database = dbhandler.getWritableDatabase();

        values.put(MyDataBaseHelper.Column_Symbol, myTemp.getW_sym());
        values.put(MyDataBaseHelper.Column_Ltp,myTemp.getW_ltp());
        values.put(MyDataBaseHelper.Column_Volume,myTemp.getW_vol());
        values.put(MyDataBaseHelper.Column_Change,myTemp.getW_chng());

        Log.e("sym:.....",myTemp.getW_sym());

        long insertid = database.insert(MyDataBaseHelper.TABLE_NAME,null,values);
        myTemp.setW_id(insertid);
        return myTemp;

    }

    // Getting single
    public WatchlistTemplate getSingle(long id) {

        Cursor cursor = database.query(MyDataBaseHelper.TABLE_NAME,allColumns,MyDataBaseHelper.Column_Id + "=?",new String[]{String.valueOf(id)},null,null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        WatchlistTemplate w = new WatchlistTemplate(Long.parseLong(cursor.getString(0)),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4));
        // return
        return w;
    }

    public List<WatchlistTemplate> getAll() {

        Cursor cursor = database.query(MyDataBaseHelper.TABLE_NAME,allColumns,null,null,null, null, null);

        List<WatchlistTemplate> wlist = new ArrayList<>();
        if(cursor.getCount() > 0){
            while(cursor.moveToNext()){
                WatchlistTemplate wt = new WatchlistTemplate();
                wt.setW_id(cursor.getLong(cursor.getColumnIndex(MyDataBaseHelper.Column_Id)));
                wt.setW_sym(cursor.getString(cursor.getColumnIndex(MyDataBaseHelper.Column_Symbol)));
                wlist.add(wt);
            }
        }
        // return All Employees
        return wlist;
    }





    /*// Deleting Employee
    public void removeEmployee(Employee employee) {

        database.delete(EmployeeDBHandler.TABLE_EMPLOYEES, EmployeeDBHandler.COLUMN_ID + "=" + employee.getEmpId(), null);
    }
*/
}
=======
package com.example.user.dse;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 8/14/2017.
 */
public class MyDBQuery {

    public static final String LOGTAG = "SYS";

    SQLiteOpenHelper dbhandler;
    SQLiteDatabase database;

    private static final String[] allColumns = {
            MyDataBaseHelper.Column_Id,
            MyDataBaseHelper.Column_Symbol,
            MyDataBaseHelper.Column_Ltp,
            MyDataBaseHelper.Column_Volume,
            MyDataBaseHelper.Column_Change
    };

    public MyDBQuery(Context context){
        dbhandler = new MyDataBaseHelper(context);
    }

    public void open(){
        Log.i(LOGTAG,"Database Opened");
        database = dbhandler.getWritableDatabase();


    }
    public void close(){
        Log.i(LOGTAG, "Database Closed");
        dbhandler.close();

    }
    public WatchlistTemplate addNew(WatchlistTemplate myTemp){
        ContentValues values = new ContentValues();
        database = dbhandler.getWritableDatabase();

        values.put(MyDataBaseHelper.Column_Symbol, myTemp.getW_sym());
        values.put(MyDataBaseHelper.Column_Ltp,myTemp.getW_ltp());
        values.put(MyDataBaseHelper.Column_Volume,myTemp.getW_vol());
        values.put(MyDataBaseHelper.Column_Change,myTemp.getW_chng());

        Log.e("sym:.....",myTemp.getW_sym());

        long insertid = database.insert(MyDataBaseHelper.TABLE_NAME,null,values);
        myTemp.setW_id(insertid);
        return myTemp;

    }

    // Getting single
    public WatchlistTemplate getSingle(long id) {

        Cursor cursor = database.query(MyDataBaseHelper.TABLE_NAME,allColumns,MyDataBaseHelper.Column_Id + "=?",new String[]{String.valueOf(id)},null,null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        WatchlistTemplate w = new WatchlistTemplate(Long.parseLong(cursor.getString(0)),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4));
        // return
        return w;
    }

    public List<WatchlistTemplate> getAll() {

        Cursor cursor = database.query(MyDataBaseHelper.TABLE_NAME,allColumns,null,null,null, null, null);

        List<WatchlistTemplate> wlist = new ArrayList<>();
        if(cursor.getCount() > 0){
            while(cursor.moveToNext()){
                WatchlistTemplate wt = new WatchlistTemplate();
                wt.setW_id(cursor.getLong(cursor.getColumnIndex(MyDataBaseHelper.Column_Id)));
                wt.setW_sym(cursor.getString(cursor.getColumnIndex(MyDataBaseHelper.Column_Symbol)));
                wlist.add(wt);
            }
        }
        // return All Employees
        return wlist;
    }





    /*// Deleting Employee
    public void removeEmployee(Employee employee) {

        database.delete(EmployeeDBHandler.TABLE_EMPLOYEES, EmployeeDBHandler.COLUMN_ID + "=" + employee.getEmpId(), null);
    }
*/
}
>>>>>>> origin/master
