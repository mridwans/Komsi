package com.example.user.komsi;

import android.content.Intent;
import android.graphics.Canvas;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class ListItemActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ListItemAdapter adapter;
    private ArrayList<ListItemModel> listItemModelArrayList;
    SwipeController swipeController = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_item);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton float_add_sub = (FloatingActionButton) findViewById(R.id.float_add_sub);
        float_add_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                //        .setAction("Action", null).show();
                Intent intent = new Intent(ListItemActivity.this, AddSubfolderActivity.class);
                startActivity(intent);
            }
        });

        addData();
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        adapter = new ListItemAdapter(listItemModelArrayList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(ListItemActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

//        FloatingActionButton float_add_sub = (FloatingActionButton) findViewById(R.id.float_add_sub);
//        float_add_sub.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //Intent intent = new Intent(getApplicationContext(),AddFolderActivity.class);
//                //startActivity(intent);
//                /*Snackbar.make(view, "HAHAHAHHAA...", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();*/
//
//                //Tambah event
//                AlertDialog.Builder mBuilder = new AlertDialog.Builder(ListItemActivity.this);
//                View mView = getLayoutInflater().inflate(R.layout.tambah_folder,null);
//                final EditText mNamaFolder = (EditText) mView.findViewById(R.id.etNamaFold);
//                Button mSubmit = (Button) mView.findViewById(R.id.btnTambah);
//
//                mBuilder.setView(mView);
//                AlertDialog dialog = mBuilder.create();
//                dialog.show();
//            }
//        });

        swipeController = new SwipeController(new SwipeControllerActions() {
            @Override
            public void onRightClicked(int position) {
                adapter.dataList.remove(position);
                adapter.notifyItemRemoved(position);
                adapter.notifyItemRangeChanged(position, adapter.getItemCount());
            }
        });

        ItemTouchHelper itemTouchhelper = new ItemTouchHelper(swipeController);
        itemTouchhelper.attachToRecyclerView(recyclerView);

        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
                swipeController.onDraw(c);
            }
        });

    }

    void addData() {
        listItemModelArrayList = new ArrayList<>();
        listItemModelArrayList.add(new ListItemModel("Item 1", "Adul", "31 Desember 2018", "19.00"));
        listItemModelArrayList.add(new ListItemModel("Item 2", "Adul", "31 Desember 2018", "19.00"));
        listItemModelArrayList.add(new ListItemModel("Item 3", "Adul", "31 Desember 2018", "19.00"));
        listItemModelArrayList.add(new ListItemModel("Item 4", "Adul", "31 Desember 2018", "19.00"));
        listItemModelArrayList.add(new ListItemModel("Item 5", "Adul", "31 Desember 2018", "19.00"));
    }
}
