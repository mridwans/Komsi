package com.example.user.komsi;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;


import java.util.Calendar;

public class SearchActivity extends AppCompatActivity {

    Calendar mClndr;
    DatePickerDialog dpd;
    TextView mTvDateResultStart;
    Button mBtDatePickerStart;

    TextView mTvDateResultEnd;
    Button mBtDatePickerEnd;
    Button mBtnCancel;
    Button mBtnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        mTvDateResultStart = findViewById(R.id.tv_dtresult_start);
        mBtDatePickerStart = findViewById(R.id.bt_startdate);


        mBtDatePickerStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mClndr = Calendar.getInstance();
                int day = mClndr.get(Calendar.DAY_OF_MONTH);
                int month = mClndr.get(Calendar.MONTH);
                int year = mClndr.get(Calendar.YEAR);

                dpd = new DatePickerDialog(SearchActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int mYear, int mMonth, int mDay) {
                        mTvDateResultStart.setText(mDay + "/" + (mMonth+1) + "/" + mYear);
                    }
                }, year, month, day);
                dpd.show();
            }
        });

        mTvDateResultEnd = findViewById(R.id.tv_dtresult_end);
        mBtDatePickerEnd = findViewById(R.id.bt_enddate);


        mBtDatePickerEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mClndr = Calendar.getInstance();
                int day = mClndr.get(Calendar.DAY_OF_MONTH);
                int month = mClndr.get(Calendar.MONTH);
                int year = mClndr.get(Calendar.YEAR);

                dpd = new DatePickerDialog(SearchActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int mYear, int mMonth, int mDay) {
                        mTvDateResultEnd.setText(mDay + "/" + (mMonth+1) + "/" + mYear);
                    }
                }, year, month, day);
                dpd.show();
            }
        });

        mBtnCancel = (Button)findViewById(R.id.btnCancel);

        mBtnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SearchActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

        mBtnSubmit = (Button)findViewById(R.id.btnSubmit);

        mBtnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SearchActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });

    }
}
