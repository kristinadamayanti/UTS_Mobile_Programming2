package com.kristina.kuis;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONObject;

public class TampilAll extends AppCompatActivity implements ListView.OnItemClickListener {

    private ListView listView;

    private String JSON_STRING;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampil_all);

        listView = (ListView) findViewById(R.id.listView);
        listView.setOnItemClickListener(this);
        getJSON();
    }

    private void getJSON() {
        class GetJSON extends AsyncTask<Void, Void, String> {

            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(TampilAll.this, "Mengambil Data", "Mohon Tunggu...", false, false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                JSON_STRING = s;
                showEmployee();
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequest(Konfigurasi.URL_GET_ALL);
                return s;
            }
        }
        GetJSON gj = new GetJSON();
        gj.execute();
    }


    private void showEmployee() {
        JSONObject jsonObject = null;
        ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
        try {
            jsonObject = new JSONObject(JSON_STRING);
            JSONArray result = jsonObject.getJSONArray(Konfigurasi.TAG_JSON_ARRAY);

            for (int i = 0; i < result.length(); i++) {
                JSONObject jo = result.getJSONObject(i);
                String id = jo.getString(Konfigurasi.TAG_ID);
                String name = jo.getString(Konfigurasi.TAG_NAMA);

                HashMap<String, String> employees = new HashMap<>();
                employees.put(Konfigurasi.TAG_ID, id);
                employees.put(Konfigurasi.TAG_NAMA, name);
                list.add(employees);
            }

        } catch (JSONException e) {
            e.printStackTrace();

            ListAdapter adapter = new SimpleAdapter(
                    TampilAll.this, list, R.layout.list_item,
                    new String[]{Konfigurasi.TAG_ID, Konfigurasi.TAG_NAMA},
                    new int[]{R.id.id, R.id.name});

            listView.setAdapter(adapter);
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent intent = new Intent(this, TampilActivity.class);
        HashMap<String,String>map = (HashMap)adapterView.getItemAtPosition(i);
        String empId = map.get(Konfigurasi.TAG_ID).toString();
        intent.putExtra(Konfigurasi.EMP_ID,empId);
        startActivity(intent);
    }
}
