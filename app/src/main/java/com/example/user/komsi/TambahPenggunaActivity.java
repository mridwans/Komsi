package com.example.user.komsi;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class TambahPenggunaActivity extends AppCompatActivity {

    RelativeLayout relativeLayout2, relativeLayout3, relativeLayout4, relativeLayout5, relativeLayout6, relativeLayout7;

    private Button mbtnSubmit ;
    EditText txtPassword, txtCPassword, txtName, txtNIP, txtEmail, txtPhone;

    Handler handler = new Handler();

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            /*relativeLayout1.setVisibility(View.VISIBLE);*/
            relativeLayout2.setVisibility(View.VISIBLE);
            relativeLayout3.setVisibility(View.VISIBLE);
            relativeLayout4.setVisibility(View.VISIBLE);
            relativeLayout5.setVisibility(View.VISIBLE);
            relativeLayout6.setVisibility(View.VISIBLE);
            relativeLayout7.setVisibility(View.VISIBLE);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_pengguna);

        /*relativeLayout1 = (RelativeLayout) findViewById(R.id.relativeLayout1);*/
        relativeLayout2 = (RelativeLayout) findViewById(R.id.relativeLayout2);
        relativeLayout3 = (RelativeLayout) findViewById(R.id.relativeLayout3);
        relativeLayout4 = (RelativeLayout) findViewById(R.id.relativeLayout4);
        relativeLayout5 = (RelativeLayout) findViewById(R.id.relativeLayout5);
        relativeLayout6 = (RelativeLayout) findViewById(R.id.relativeLayout6);
        relativeLayout7 = (RelativeLayout) findViewById(R.id.relativeLayout7);

        handler.postDelayed(runnable, 2000); //2000 is the timeout for the splash

        mbtnSubmit = (Button)findViewById(R.id.btnSubmit);
        /*txtUsername = (EditText) findViewById(R.id.txtUsername);*/
        txtPassword = (EditText) findViewById(R.id.txtPassword);
        txtCPassword = (EditText) findViewById(R.id.txtCPassword);
        txtName = (EditText) findViewById(R.id.txtName);
        txtNIP = (EditText) findViewById(R.id.txtNIP);
        txtEmail = (EditText) findViewById(R.id.txtEmail);
        txtPhone = (EditText) findViewById(R.id.txtPhone);


        /*mbtnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TambahPenggunaActivity.this,DataUserActivity.class);
                startActivity(intent);
            }
        });
    }*/
        mbtnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Submit();
            }
        });
    }

    private void Submit(){
        String url="http://ridwan.rirfanuddin.id/api_baru/public/api/register";
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    String success = jsonObject.getString("success");
                    if (response.trim().equals("success")){
                        Toast.makeText(getApplicationContext(),"User Berhasil Ditambahkan", Toast.LENGTH_LONG).show();
                    }else {
                        Toast.makeText(getApplicationContext(),"User Berhasil Ditambahkan", Toast.LENGTH_LONG).show();
                        Intent intent= new Intent(TambahPenggunaActivity.this,DataUserActivity.class);
                        startActivity(intent);
                    }
                    Intent intent = new Intent(TambahPenggunaActivity.this,DataUserActivity.class);
                    startActivity(intent);
                }catch (JSONException e){
                    e.printStackTrace();
                    Toast.makeText(TambahPenggunaActivity.this,"Register error " + e.toString(),Toast.LENGTH_LONG).show();

                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //Toast.makeText(getApplicationContext(),"error "+ error.toString(), Toast.LENGTH_LONG).show();
                Toast.makeText(TambahPenggunaActivity.this,"Register error " + error.toString(),Toast.LENGTH_LONG).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<>();
                /*params.put("username", txtUsername.getText().toString().trim());*/
                params.put("password",txtPassword.getText().toString().trim());
                params.put("c_password",txtCPassword.getText().toString().trim());
                params.put("name", txtName.getText().toString().trim());
                params.put("nip",txtNIP.getText().toString().trim());
                params.put("email",txtEmail.getText().toString().trim());
                params.put("phone", txtPhone.getText().toString().trim());
                //return super.getParams();
                return params;
            }
        };

        requestQueue.add(stringRequest);
    }
}
