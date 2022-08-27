package com.example.quranapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView =findViewById(R.id.FullSurah);

        QDH Surah=new QDH();
        int[] ssp=Surah.SSP;
        String[] SurahNames=Surah.urduSurahNames;
        ArrayAdapter<String> view=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_expandable_list_item_1,SurahNames);
        listView.setAdapter(view);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                int start=ssp[i];
                int end=ssp[i+1];
                Intent intent=new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("start",start);
                intent.putExtra("end",end);
                startActivity(intent);
            }
        });
    }
}