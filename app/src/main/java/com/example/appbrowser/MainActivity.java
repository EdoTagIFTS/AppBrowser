package com.example.appbrowser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    ListAdapter adp;
    ListView listaSitiView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listaSitiView = (ListView) findViewById(R.id.listaSiti);
        HashMap<Item, String> siti = new HashMap<>();
        siti.put(new Item("Google", R.drawable.google_logo), "https://www.google.com");
        siti.put(new Item("StackOverflow", R.drawable.stack_overflow_logo), "https://stackoverflow.com/");
        siti.put(new Item("Java Docs", R.drawable.java_logo), "https://docs.oracle.com/en/java/");
        int[] imgSiti = new int[siti.size()];
        String[] nomiSiti = new String[siti.size()];
        int i = 0;
        for(Item item : siti.keySet()){
            nomiSiti[i] = item.getName();
            imgSiti[i] = item.getImg();
            i++;
        }

        adp = new ListAdapter(MainActivity.this, nomiSiti, imgSiti);
        listaSitiView.setAdapter(adp);

        listaSitiView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String url = siti.get(new Item(nomiSiti[position], imgSiti[position]));
                Log.d("URL_CLICKED", "URL: " + url);
                startActivity(new Intent(MainActivity.this, WebActivity.class).putExtra("URL", url));
            }
        });
    }
}