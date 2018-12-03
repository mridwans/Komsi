package com.example.user.komsi;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;

import java.util.ArrayList;

public class DataUserActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private DataUserAdapter adapter;
    private ArrayList<DataUserModel> dataUserModelArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_user);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        addData();

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        adapter = new DataUserAdapter(dataUserModelArrayList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(DataUserActivity.this);

        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(adapter);
    }

    void addData(){
        dataUserModelArrayList = new ArrayList<>();
        dataUserModelArrayList.add(new DataUserModel("Dimas Maulana", "1414370309", "123456789","1414370309","1214378098","1214378098"));
        dataUserModelArrayList.add(new DataUserModel("Fadly Yonk", "1214234560", "987654321","1214234560","1214378098","1214378098"));
        dataUserModelArrayList.add(new DataUserModel("Ariyandi Nugraha", "1214230345", "987648765","1214230345","1214378098","1214378098"));
        dataUserModelArrayList.add(new DataUserModel("Aham Siswana", "1214378098", "098758124","1214378098","1214230345","1214230345"));
    }

    //swipe
    SwipeController swipeController = new SwipeController();
    ItemTouchHelper touchHelper = new ItemTouchHelper(swipeController);
    touchHelper.attachToRecyclerView(recyclerView);

}
