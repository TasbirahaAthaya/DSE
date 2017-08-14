package com.example.user.dse;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Allitems extends AppCompatActivity {

    ListView mylist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allitems);

        mylist=(ListView) findViewById(R.id.allitems);
        fetchingData();

    }




    void fetchingData(){


        String myURL = "http://10.0.3.2/allitem.php";

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(myURL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                final String[] symbol = new String[response.length()];
                final String[] volume = new String[response.length()];
                final String[] ltp = new String[response.length()];
                final String[] change = new String[response.length()];

                for (int i =0; i < response.length(); i++){

                    try {

                        JSONObject jsonObject = (JSONObject) response.get(i);
                        symbol[i] = jsonObject.getString("symbol");
                        volume[i] = jsonObject.getString("volume");
                        ltp[i] = jsonObject.getString("ltp");
                        change[i] = jsonObject.getString("change");

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }


                }

                MyCustomAdapter myAdap= new MyCustomAdapter(Allitems.this, symbol, volume,ltp,change);
                mylist.setAdapter(myAdap);
                mylist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent intent = new Intent(Allitems.this, Eachitem.class);
                        intent.putExtra("symbol", symbol[position]);
                        intent.putExtra("volume", volume[position]);
                        intent.putExtra("ltp", ltp[position]);
                        intent.putExtra("change", change[position]);

                        startActivity(intent);

                    }
                });


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
