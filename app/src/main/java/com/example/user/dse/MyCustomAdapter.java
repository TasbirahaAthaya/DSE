package com.example.user.dse;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Response;
import com.example.user.dse.R;

import org.json.JSONArray;

/**
 * Created by DELL on 06-Feb-16.
 */
public class MyCustomAdapter extends BaseAdapter {

    String[] sym;
    String[] vol;
    String[] ltp;
    String[] chng;
    Response.Listener<JSONArray> mContext;
    Context c;

    public static LayoutInflater inflater=null;

    public MyCustomAdapter(Allitems mainac, String[] symbol, String[] volume, String[] Ltp, String[] Chng){

        sym=symbol;
        vol=volume;
        ltp=Ltp;
        chng=Chng;
        c=mainac;
        inflater=(LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return sym.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class MyHolder{
        TextView sym,vol,ltp,chng;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        MyHolder myh= new MyHolder();
        View myview;

        myview = inflater.inflate(R.layout.custom_layout_item, null);
        myh.sym=(TextView)myview.findViewById(R.id.symbol);
        myh.vol=(TextView) myview.findViewById(R.id.volume);
        myh.ltp=(TextView) myview.findViewById(R.id.ltp);
        myh.chng=(TextView) myview.findViewById(R.id.change);

        myh.sym.setText(sym[position]);
        myh.vol.setText(vol[position]);
        myh.ltp.setText(ltp[position]);
        myh.chng.setText(chng[position]);

        /*myview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ct,"Clicked on "+names[position],Toast.LENGTH_LONG).show();

            }
        });*/

        return myview;
    }
}
