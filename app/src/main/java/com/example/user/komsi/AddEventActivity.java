package com.example.user.komsi;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.text.format.DateFormat;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.TextView;


import java.util.Calendar;



import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

public class AddEventActivity extends AppCompatActivity {

    Calendar mClndr;
    DatePickerDialog dpd;
    TextView mTvDateResult;
    Button mBtDatePicker;
    private TextView tvTimeResult;
    private Button btTimePicker;
    private TimePickerDialog timePickerDialog;
    private Button mbtnSubmit;
    private Button mbtnAddSub;

    private Spinner spinner1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);

        mTvDateResult = findViewById(R.id.tv_dateresult);
        mBtDatePicker = findViewById(R.id.bt_datepicker);


        mBtDatePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mClndr = Calendar.getInstance();
                int day = mClndr.get(Calendar.DAY_OF_MONTH);
                int month = mClndr.get(Calendar.MONTH);
                int year = mClndr.get(Calendar.YEAR);

                dpd = new DatePickerDialog(AddEventActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int mYear, int mMonth, int mDay) {
                        mTvDateResult.setText(mDay + "/" + (mMonth+1) + "/" + mYear);
                    }
                }, year, month, day);
                dpd.show();
            }
        });

        tvTimeResult = (TextView) findViewById(R.id.tv_timeresult);
        btTimePicker = (Button) findViewById(R.id.bt_timepicker);
        btTimePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTimeDialog();
            }
        });

        spinner1 = (Spinner) findViewById(R.id.spinner);
        spinner1.setOnItemSelectedListener(new ItemSelectedListener());

        mbtnSubmit = (Button)findViewById(R.id.btnSubmit);

        mbtnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddEventActivity.this,AddSubfolderActivity.class);
                startActivity(intent);
            }
        });

        mbtnAddSub = (Button)findViewById(R.id.btnAddSub);

        mbtnAddSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(AddEventActivity.this);
                View mView = getLayoutInflater().inflate(R.layout.activity_add_subfolder,null);
                final EditText mNamaSubFold = (EditText) mView.findViewById(R.id.etNamaSubFold);
                Button mbtnTambahSub = (Button) mView.findViewById(R.id.btnTambahSub);
                mbtnTambahSub.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(!mNamaSubFold.getText().toString().isEmpty()){
                            Toast.makeText(AddEventActivity.this,
                                    R.string.sukses_msg, Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(AddEventActivity.this, ListItemActivity.class);
                            startActivity(intent);
                        }else {
                            Toast.makeText(AddEventActivity.this,
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

    private void showTimeDialog() {

        /**
         * Calendar untuk mendapatkan waktu saat ini
         */
        Calendar calendar = Calendar.getInstance();

        /**
         * Initialize TimePicker Dialog
         */
        timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                /**
                 * Method ini dipanggil saat kita selesai memilih waktu di DatePicker
                 */
                tvTimeResult.setText("Waktu dipilih = "+hourOfDay+":"+minute);
            }
        },
                /**
                 * Tampilkan jam saat ini ketika TimePicker pertama kali dibuka
                 */
                calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE),

                /**
                 * Cek apakah format waktu menggunakan 24-hour format
                 */
                DateFormat.is24HourFormat(this));

        timePickerDialog.show();
    }

    public class ItemSelectedListener implements AdapterView.OnItemSelectedListener {

        //get strings of first item
        String firstItem = String.valueOf(spinner1.getSelectedItem());

        public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
            if (firstItem.equals(String.valueOf(spinner1.getSelectedItem()))) {
                // ToDo when first item is selected
            } else {
                Toast.makeText(parent.getContext(),
                        "Kamu telah memilih : " + parent.getItemAtPosition(pos).toString(),
                        Toast.LENGTH_LONG).show();
                // Todo when item is selected by the user
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> arg) {

        }

    }

}
