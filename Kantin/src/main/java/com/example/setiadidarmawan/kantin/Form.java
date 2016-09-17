package com.example.setiadidarmawan.kantin;

import android.app.ProgressDialog;
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

/**
 * Created by Setiadi Darmawan on 15-Sep-16.
 */
public class Form extends AppCompatActivity {
    Button tambah;
    EditText nama, harga;
    Spinner jenis;
    String data_json;
    TextView jdl;
    String ganti;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form_tambah);
        nama = (EditText)findViewById(R.id.nama);
        harga = (EditText)findViewById(R.id.harga);
        jdl = (TextView)findViewById(R.id.judul);
        jenis = (Spinner)findViewById(R.id.jenis);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.jenis_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        jenis.setAdapter(adapter);

        tambah = (Button)findViewById(R.id.button3);
        tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getJSON();
            }
        });
    }

    public void getJSON(){
        class GetJSON extends AsyncTask<Void, Void, String>{
            ProgressDialog loading;

            @Override
            public void onPreExecute(){
                super.onPreExecute();
                loading = ProgressDialog.show(Form.this,"Processing","Loading...",false,false);
            }
            public void onPostExecute(String s){
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(Form.this, s, Toast.LENGTH_LONG).show();
                //data_json = s;
                //getdata();
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                ganti = nama.getText().toString();
                ganti = ganti.replaceAll(" ","%20");
                String s = rh.sendGetRequest("http://setiadidarmawan.xyz/server/tambah.php?nama="+ganti+"&harga="+harga.getText().toString()+"&jenis="+jenis.getSelectedItem().toString());
                return s;
            }
        }
        GetJSON apalah = new GetJSON();
        apalah.execute();
    }


}

