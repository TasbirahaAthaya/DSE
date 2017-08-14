package com.example.user.dse;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    TextView t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11;
    public MyDBQuery mydb;

    String dsex_val="";
    String dsex_per="";
    String ds30_val="";
    String ds30_per="";
    String TT="";
    String TV="";
    String Tval="";
    String adv="";
    String dec="";
    String un="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        t1=(TextView) findViewById(R.id.Dsex);
        t2=(TextView) findViewById(R.id.Dsexval);
        t3=(TextView) findViewById(R.id.Dsexper);
        t4=(TextView) findViewById(R.id.Ds30val);
        t5=(TextView) findViewById(R.id.Ds30per);
        t6=(TextView) findViewById(R.id.Tradeval);
        t7=(TextView) findViewById(R.id.Tvolval);
        t8=(TextView) findViewById(R.id.Tkval);
        t9=(TextView) findViewById(R.id.Advval);
        t10=(TextView) findViewById(R.id.Decval);
        t11=(TextView) findViewById(R.id.Unval);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        fetchingData();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.items) {
            // Handle the camera action
            Intent i= new Intent(MainActivity.this,Allitems.class);
            startActivity(i);

        }
        else if (id == R.id.nav_gallery)
        {
            Intent i= new Intent(MainActivity.this,Watchlist.class);
            startActivity(i);

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    void fetchingData(){


        String myURL = "http://10.0.3.2/json.php";

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(myURL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {


                for (int i =0; i < response.length(); i++) {
                    try {

                        JSONObject jsonObject = (JSONObject) response.get(i);
                        dsex_val = jsonObject.getString("DSEXval");
                        Log.i("Message: ",dsex_val);
                        dsex_per = jsonObject.getString("DSEXper");
                        ds30_val = jsonObject.getString("DS30val");
                        ds30_per = jsonObject.getString("DS30per");
                        TT = jsonObject.getString("TT");
                        TV = jsonObject.getString("TV");
                        Tval = jsonObject.getString("Tval");
                        adv = jsonObject.getString("Adv");
                        dec = jsonObject.getString("Dec");
                        un = jsonObject.getString("Un");

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                t2.setText(dsex_val);
                t3.setText(dsex_per);
                t4.setText(ds30_val);
                t5.setText(ds30_per);
                t6.setText(TT);
                t7.setText(TV);
                t8.setText(Tval);
                t9.setText(adv);
                t10.setText(dec);
                t11.setText(un);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d("Volley Log", error);
            }
        });


        com.example.user.dse.AppController.getInstance().addToRequestQueue(jsonArrayRequest);
     //   Toast.makeText(getApplicationContext(), "Data Loaded Successfully!", Toast.LENGTH_SHORT).show();

    }
}
