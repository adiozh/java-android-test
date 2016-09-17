package com.example.setiadidarmawan.kantin;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;

import com.example.setiadidarmawan.kantin.configurasi.RequestHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Setiadi Darmawan on 15-Sep-16.
 */
public class Lihat extends AppCompatActivity implements ListView.OnItemClickListener {
    String JSON_STRING;
    Button lihat;
    ListView listview;
    Spinner sjenis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lihat_menu);
        listview = (ListView)findViewById(R.id.listView);
        listview.setOnItemClickListener(this);

        sjenis = (Spinner)findViewById(R.id.spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.jenis_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        sjenis.setAdapter(adapter);

        lihat = (Button)findViewById(R.id.lihat);
        lihat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getJSON();
            }
        });
    }
    public void tampil() {
        JSONObject jsonObject = null;
        ArrayList<HashMap<String,String>> list = new ArrayList<HashMap<String, String>>();
        try {
            jsonObject = new JSONObject(JSON_STRING);
            JSONArray result = jsonObject.getJSONArray(Config.TAG_JSON_ARRAY);
            //get data
            for (int i = 0; i < result.length(); i++) {
                JSONObject jo = result.getJSONObject(i);
                String id = jo.getString(Config.TAG_ID);
                String nama = jo.getString(Config.TAG_NAME);
                String harga = jo.getString(Config.TAG_HARGA);
                String jenis = jo.getString(Config.TAG_JENIS);

                HashMap<String, String> menu = new HashMap<>();
                menu.put(Config.TAG_ID, id);
                menu.put(Config.TAG_NAME, nama);
                menu.put(Config.TAG_HARGA, harga);
                menu.put(Config.TAG_JENIS, jenis);
                list.add(menu);
            }
        }catch (JSONException e){
            //e.printStackTrace();
            Log.e("JSON Parser", "Error parsing data " + e.toString());
        }
        ListAdapter adapter = new SimpleAdapter(
        Lihat.this, list, R.layout.list_view,
                new String[]{Config.TAG_ID, Config.TAG_NAME,Config.TAG_HARGA,Config.TAG_JENIS},
                new int[]{R.id.id, R.id.nama, R.id.harga, R.id.jenis});
        listview.setAdapter(adapter);
    }

    public void getJSON(){
        class GetJSON extends AsyncTask<Void, Void, String> {
            ProgressDialog loading;

            @Override
            public void onPreExecute(){
                super.onPreExecute();
                loading = ProgressDialog.show(Lihat.this,"Processing","Loading...",false,false);
            }
            public void onPostExecute(String s){
                super.onPostExecute(s);
                loading.dismiss();
                JSON_STRING = s;
                tampil();
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();

                String s = rh.sendGetRequest("http://setiadidarmawan.xyz/server/viewdata.php?jenis="+sjenis.getSelectedItem().toString());
                return s;
            }
        }
        GetJSON apalah = new GetJSON();
        apalah.execute();
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent apa = new Intent(Lihat.this, Detail.class);
        HashMap<String,String> map =(HashMap)parent.getItemAtPosition(position);
        String menuid = map.get(Config.TAG_ID).toString();
        apa.putExtra(Config.MENU_ID,menuid);
        startActivity(apa);
    }
}
