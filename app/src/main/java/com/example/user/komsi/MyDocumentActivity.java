package com.example.user.komsi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MyDocumentActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private MyDocumentAdapter adapter;
    private ArrayList<MyDocument> MyDocumentArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_document);

        addData();
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        adapter = new MyDocumentAdapter(MyDocumentArrayList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MyDocumentActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
    void addData() {
        MyDocumentArrayList= new ArrayList<>();
        MyDocumentArrayList.add(new MyDocument( "file hasil rapat" ));
        MyDocumentArrayList.add(new MyDocument( "file dokumentasi" ));
        MyDocumentArrayList.add(new MyDocument( "file rundown" ));
        MyDocumentArrayList.add(new MyDocument( "file hasil rapat" ));
        MyDocumentArrayList.add(new MyDocument( "file hasil rapat" ));
        MyDocumentArrayList.add(new MyDocument( "file hasil rapat" ));
        MyDocumentArrayList.add(new MyDocument( "file hasil rapat" ));

    }
}
