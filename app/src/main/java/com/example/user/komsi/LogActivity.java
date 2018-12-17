package com.example.user.komsi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.user.komsi.adapter.LogAdapter;
import com.example.user.komsi.model.Log;

import java.util.ArrayList;

public class LogActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private LogAdapter adapter;
    private ArrayList<Log> logArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);

        addData();
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        adapter = new LogAdapter(logArrayList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(LogActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    void addData() {
        logArrayList = new ArrayList<>();
        logArrayList.add(new Log("Trias", "menambahkan file ke folder x", "12/12/2018", "12.56"));
        logArrayList.add(new Log("Trias", "menambahkan file ke folder x", "12/12/2018", "12.56"));
        logArrayList.add(new Log("Trias", "menambahkan file ke folder x", "12/12/2018", "12.56"));
        logArrayList.add(new Log("Trias", "menambahkan file ke folder x", "12/12/2018", "12.56"));
        logArrayList.add(new Log("Trias", "menambahkan file ke folder x", "12/12/2018", "12.56"));
        logArrayList.add(new Log("Trias", "menambahkan file ke folder x", "12/12/2018", "12.56"));
        logArrayList.add(new Log("Trias", "menambahkan file ke folder x", "12/12/2018", "12.56"));
        logArrayList.add(new Log("Trias", "menambahkan file ke folder x", "12/12/2018", "12.56"));
        logArrayList.add(new Log("Trias", "menambahkan file ke folder x", "12/12/2018", "12.56"));

    }
}
