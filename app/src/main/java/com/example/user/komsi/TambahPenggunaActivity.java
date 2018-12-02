package com.example.user.komsi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TambahPenggunaActivity extends AppCompatActivity {

    private Button mbtnSubmit ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_pengguna);

        mbtnSubmit = (Button)findViewById(R.id.btnSubmit);

        mbtnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),AddFolderActivity.class);
                startActivity(intent);
            }
        });
    }
}
