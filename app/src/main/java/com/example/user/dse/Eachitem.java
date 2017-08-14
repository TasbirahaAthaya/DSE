package com.example.user.dse;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class Eachitem extends AppCompatActivity {
    Button watch;
    TextView ltp,chng,sym,vol;

    String passltp,w;
    String passvolume;
    String passchng;
    String passsym;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eachitem);

        watch=(Button)findViewById(R.id.watchlist);

        ltp=(TextView)findViewById(R.id.getltp);
        vol=(TextView)findViewById(R.id.getvol);
        chng=(TextView)findViewById(R.id.getchng);
        sym=(TextView)findViewById(R.id.item);

        passltp = getIntent().getStringExtra("ltp");
        passvolume= getIntent().getStringExtra("volume");
        passchng = getIntent().getStringExtra("change");
        passsym = getIntent().getStringExtra("symbol");

        ltp.setText(passltp);
        vol.setText(passvolume);
        chng.setText(passchng);
        sym.setText(passsym);

        w= (String) watch.getText();
    }
    public void watchlist(View v)
    {

        if((v.getId() == R.id.watchlist) && w.equals("ADD TO WATCHLIST"))
        {
            watch.setText("REMOVE FROM WATCHLIST");
            w = (String)watch.getText();

           /* // Create object of SharedPreferences.
            SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
            //now get Editor
            SharedPreferences.Editor editor = sharedPref.edit();
            //put your value
            editor.putString("symbol",passsym);
            editor.putString("ltp",passltp);
            editor.putString("volume",passvolume);
            editor.putString("change",passchng);
            Log.e("m",passsym);

            //commits your edits
            editor.commit();*/
            WatchlistTemplate wt= new WatchlistTemplate();
            wt.setW_sym(passsym);
            wt.setW_ltp(passltp);
            wt.setW_vol(passvolume);
            wt.setW_chng(passchng);

            MyDBQuery obj = new MyDBQuery(getApplicationContext());
            obj.addNew(wt);


        }
        else if((v.getId() == R.id.watchlist) && w.equals("REMOVE FROM WATCHLIST"))
            watch.setText("ADD TO WATCHLIST");
            w = (String)watch.getText();


       // Intent i = new Intent(Eachitem.this, Watchlist.class);
        //startActivity(i);
    }
}
