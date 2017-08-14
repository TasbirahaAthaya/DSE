package com.example.user.dse;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class Watchlist extends AppCompatActivity {

    ListView mylist;
    List<WatchlistTemplate> w;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watchlist);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        MyDBQuery mydb = new MyDBQuery(this);
        mylist=(ListView)findViewById(R.id.watch);
        mydb.open();
        w = mydb.getAll();
        mydb.close();
        ArrayAdapter<WatchlistTemplate> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, w);
        mylist.setAdapter(adapter);


/*
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        String sym1 = sharedPref.getString("symbol", "Not Available");
        String vol1 = sharedPref.getString("volume", "Not Available");
        String ltp1 = sharedPref.getString("ltp", "Not Available");
        String change1 = sharedPref.getString("change", "Not Available");

        Log.e("sym",sym1);
*/




/*

        MyCustomAdapter1 myAdap= new MyCustomAdapter1(Watchlist.this, "a", "b","c","d");
        mylist.setAdapter(myAdap);
        mylist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                */
/*Intent intent = new Intent(Allitems.this, Eachitem.class);
                intent.putExtra("symbol", symbol[position]);
                intent.putExtra("volume", volume[position]);
                intent.putExtra("ltp", ltp[position]);
                intent.putExtra("change", change[position]);

                startActivity(intent);
*//*

            }
        });
*/


    }

}
