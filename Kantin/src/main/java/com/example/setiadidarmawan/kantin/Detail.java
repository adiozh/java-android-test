package com.example.setiadidarmawan.kantin;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.setiadidarmawan.kantin.configurasi.RequestHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

/**
 * Created by Setiadi Darmawan on 16-Sep-16.
 */
public class Detail extends AppCompatActivity implements View.OnClickListener {
     TextView UpdateId;
     EditText UpdateName;
     EditText UpdateHarga;
     Spinner UpdateJenis;

     Button buttonUpdate;
     Button buttonDelete;
     String id;
     Spinner sjenis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form_detail);

        Intent intent = getIntent();

        id = intent.getStringExtra(Config.MENU_ID);

        UpdateId = (TextView) findViewById(R.id.id);
        UpdateName = (EditText) findViewById(R.id.nama);
        UpdateHarga = (EditText) findViewById(R.id.harga);
        UpdateJenis = (Spinner) findViewById(R.id.jenis);

        buttonUpdate = (Button) findViewById(R.id.update);
        buttonDelete = (Button) findViewById(R.id.delete);

        buttonUpdate.setOnClickListener(this);
        buttonDelete.setOnClickListener(this);

        UpdateId.setText(id);
        getMenu();
}
    public void getMenu(){
        class GetMenu extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(Detail.this, "Processing...", "Loading...", false, false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                tampilMenu(s);
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequestParam("http://setiadidarmawan.xyz/server/getbyid.php?id=",id);
                return s;
            }
        }
        GetMenu ge = new GetMenu();
        ge.execute();
    }

    public void tampilMenu(String json){
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.jenis_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        UpdateJenis.setAdapter(adapter);
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result = jsonObject.getJSONArray(Config.TAG_JSON_ARRAY);
            JSONObject c = result.getJSONObject(0);
            String nama = c.getString(Config.TAG_NAME);
            String harga = c.getString(Config.TAG_HARGA);
            String jenis = c.getString(Config.TAG_JENIS);

            UpdateName.setText(nama);
            UpdateHarga.setText(harga);
            if (!jenis.equals(null)) {

                int spinnerPosition = adapter.getPosition(jenis);
                UpdateJenis.setSelection(spinnerPosition);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void updateMenu(){
        final String nama = UpdateName.getText().toString().trim();
        final String harga = UpdateHarga.getText().toString().trim();
        final String newjenis = UpdateJenis.getSelectedItem().toString().trim();

        class UpdateMenu extends AsyncTask<Void,Void,String>{
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(Detail.this,"Updating...","Loading...",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(Detail.this, s, Toast.LENGTH_LONG).show();
            }

            @Override
            protected String doInBackground(Void... params) {
                HashMap<String,String> hashMap = new HashMap<>();
                hashMap.put(Config.KEY_ID,id);
                hashMap.put(Config.KEY_NAME,nama);
                hashMap.put(Config.KEY_HARGA,harga);
                hashMap.put(Config.KEY_JENIS, newjenis);

                RequestHandler rh = new RequestHandler();

                String s = rh.sendPostRequest("http://setiadidarmawan.xyz/server/updatemenu.php", hashMap);

                return s;
            }
        }

        UpdateMenu go = new UpdateMenu();
        go.execute();
    }

    private void deleteMenu(){
        class DeleteMenu extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(Detail.this, "Deleting...", "Wait...", false, false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(Detail.this, s, Toast.LENGTH_LONG).show();
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequestParam("http://setiadidarmawan.xyz/server/deletemenu.php?id=", id);
                return s;
            }
        }

        DeleteMenu de = new DeleteMenu();
        de.execute();
    }

    private void confirmDeleteMenu(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage("Yakin menghapus menu ini?");

        alertDialogBuilder.setPositiveButton("Yes",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        deleteMenu();
                        startActivity(new Intent(Detail.this,Lihat.class));
                    }
                });

        alertDialogBuilder.setNegativeButton("No",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {

                    }
                });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }


    @Override
    public void onClick(View v) {
        if(v == buttonUpdate){
            updateMenu();
            
            startActivity(new Intent(Detail.this, Lihat.class));
        }

        if(v == buttonDelete){
            confirmDeleteMenu();
        }
    }
}