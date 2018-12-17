package com.example.user.komsi;

import android.content.Intent;
import android.graphics.Canvas;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.user.komsi.adapter.ItemAdapter;
import com.example.user.komsi.model.Item;

import java.util.ArrayList;

//private final LinkedList<String> mWordList = new LinkedList<>();
//private int mCount = 0;



public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private RecyclerView recyclerView;
    private ItemAdapter adapter;
    private ArrayList<Item> itemArrayList;
    SwipeController swipeController = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(getApplicationContext(),AddFolderActivity.class);
                //startActivity(intent);
                /*Snackbar.make(view, "HAHAHAHHAA...", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/

                //Tambah event
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainActivity.this);
                View mView = getLayoutInflater().inflate(R.layout.tambah_folder,null);
                final EditText mNamaFolder = (EditText) mView.findViewById(R.id.etNamaFold);
                Button mSubmit = (Button) mView.findViewById(R.id.btnTambah);

                mSubmit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(!mNamaFolder.getText().toString().isEmpty()){
                            Toast.makeText(MainActivity.this,
                                    R.string.sukses_msg, Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(MainActivity.this,AddEventActivity.class);
                            startActivity(intent);
                        }else {
                            Toast.makeText(MainActivity.this,
                                    R.string.kosong_msg, Toast.LENGTH_SHORT).show();
                        }
                    }
                });

                mBuilder.setView(mView);
                AlertDialog dialog = mBuilder.create();
                dialog.show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        //recyclerview
        addData();
        recyclerView =(RecyclerView) findViewById(R.id.recycler_view);
        adapter=new ItemAdapter(itemArrayList);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);


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

    void addData(){
        itemArrayList=new ArrayList<>();
        itemArrayList.add(new Item("Folder 1","12/11/2018","Budi","13.03"));
        itemArrayList.add(new Item("Folder 2","12/11/2018","Budi","13.03"));
        itemArrayList.add(new Item("Folder 3","12/11/2018","Budi","13.03"));
        itemArrayList.add(new Item("Folder 4","12/11/2018","Budi","13.03"));
        itemArrayList.add(new Item("Folder 5","12/11/2018","Budi","13.03"));
        itemArrayList.add(new Item("Folder 6","12/11/2018","Budi","13.03"));
        itemArrayList.add(new Item("Folder 1","12/11/2018","Budi","13.03"));
        itemArrayList.add(new Item("Folder 2","12/11/2018","Budi","13.03"));
        itemArrayList.add(new Item("Folder 3","12/11/2018","Budi","13.03"));
        itemArrayList.add(new Item("Folder 4","12/11/2018","Budi","13.03"));
        itemArrayList.add(new Item("Folder 5","12/11/2018","Budi","13.03"));
        itemArrayList.add(new Item("Folder 6","12/11/2018","Budi","13.03"));

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_mydocuments) {
            Intent intent = new Intent(MainActivity.this,MyDocumentActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_datauser) {
            Intent intent = new Intent(MainActivity.this,DataUserActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_search) {
            Intent intent = new Intent(MainActivity.this,SearchActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_log) {
            Intent intent = new Intent(MainActivity.this, LogActivity.class);
            startActivity(intent);
        }else if (id == R.id.nav_logout) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
