package com.example.user.komsi;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddFolderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tambah_folder);

        Button mShow = (Button) findViewById(R.id.btnShow);
        mShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(AddFolderActivity.this);
                View mView = getLayoutInflater().inflate(R.layout.tambah_folder,null);
                final EditText mNamaFolder = (EditText) mView.findViewById(R.id.etNamaFold);
                Button mSubmit = (Button) mView.findViewById(R.id.btnTambah);

                mSubmit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(!mNamaFolder.getText().toString().isEmpty()){
                            Toast.makeText(AddFolderActivity.this,
                                    R.string.sukses_msg, Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(AddFolderActivity.this,AddEventActivity.class);
                            startActivity(intent);
                        }else {
                            Toast.makeText(AddFolderActivity.this,
                                    R.string.kosong_msg, Toast.LENGTH_SHORT).show();
                        }
                    }
                });

                mBuilder.setView(mView);
                AlertDialog dialog = mBuilder.create();
                dialog.show();


            }
        });
    }
}
