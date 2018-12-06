package com.example.user.komsi;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddSubfolderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_subfolder);

        Button mTambahSub = (Button) findViewById(R.id.btnTambah);

        /*mTambahSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(AddSubfolderActivity.this);
                View mView = getLayoutInflater().inflate(R.layout.activity_add_subfolder,null);
                final EditText mNamaSubFolder = (EditText) mView.findViewById(R.id.etNamaSubFold);
                Button mSubmitsub = (Button) mView.findViewById(R.id.btnTambahSub);*/

             /*   mSubmitsub.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(!mNamaSubFolder.getText().toString().isEmpty()){
                            Toast.makeText(AddSubfolderActivity.this,
                                    R.string.sukses_msg, Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(AddSubfolderActivity.this,
                                    R.string.kosong_msg, Toast.LENGTH_SHORT).show();
                        }
                    }
                });*/

               /* mBuilder.setView(mView);
                AlertDialog dialog = mBuilder.create();
                dialog.show();*/
    }



}


