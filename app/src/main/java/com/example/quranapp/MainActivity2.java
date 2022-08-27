package com.example.quranapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.islamiculoom.tasreefapp.Common.QuranData.QuranArabicText;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        listView=findViewById(R.id.FullSurah);

        Intent intent=getIntent();
        int start=intent.getIntExtra("start",0);
        int end=intent.getIntExtra("end",0);

        QuranArabicText Surah=new QuranArabicText();
        String[] Ayat=Surah.QuranArabicText;

        ArrayList<String> Quran=new ArrayList<>();

        for (int i=start-1;i<end-1;i++){
            Quran.add(Ayat[i]);
        }

        ArrayAdapter<String> view=new ArrayAdapter<String>(MainActivity2.this, android.R.layout.simple_expandable_list_item_1,Quran);
        listView.setAdapter(view);
    }
}