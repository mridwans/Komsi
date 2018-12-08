package com.example.user.komsi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import android.widget.AdapterView;
import android.widget.Toast;

public class EventActivity extends AppCompatActivity {

    TextView mTvDateResult;
    TextView tvTimeResult;
    Button mbtnAddSub;
    Button mbtnListFile;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        mbtnAddSub = (Button)findViewById(R.id.btnAddSub);

        mbtnAddSub.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick (View v){
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(EventActivity.this);
                View mView = getLayoutInflater().inflate(R.layout.activity_add_subfolder, null);
                final EditText mNamaSubFold = (EditText) mView.findViewById(R.id.etNamaSubFold);
                Button mbtnTambahSub = (Button) mView.findViewById(R.id.btnTambahSub);
                mbtnTambahSub.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (!mNamaSubFold.getText().toString().isEmpty()) {
                            Toast.makeText(EventActivity.this,
                                    R.string.sukses_msg, Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(EventActivity.this, ListItemActivity.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(EventActivity.this,
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
