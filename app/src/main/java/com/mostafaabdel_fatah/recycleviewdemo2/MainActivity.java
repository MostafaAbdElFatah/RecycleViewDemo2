package com.mostafaabdel_fatah.recycleviewdemo2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    String[] countries ,capital;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<ListProvider> arrayList = new ArrayList<ListProvider>();
    int[] flags = {R.drawable.saudi_arabia , R.drawable.algeria , R.drawable.the_comoros
            , R.drawable.djibouti , R.drawable.egypt , R.drawable.libya ,R.drawable.mauritania
            , R.drawable.morocco , R.drawable.somalia ,R.drawable.sudan, R.drawable.tunisia
            , R.drawable.bahrain ,R.drawable.iraq , R.drawable.palestine , R.drawable.jordan
            , R.drawable.kuwait , R.drawable.lebanon , R.drawable.oman,R.drawable.qatar
            , R.drawable.syria , R.drawable.the_united_arab_emirates ,R.drawable.yemen };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        countries = getResources().getStringArray(R.array.Countries);
        capital = getResources().getStringArray(R.array.Capital_Cities);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        for (int i = 0 ; i < countries.length ; i++){
            arrayList.add(new ListProvider(flags[i],countries[i],capital[i]));
        }
        adapter = new RecyclerViewAdapter(arrayList);
        recyclerView.setAdapter(adapter);

    }
}
