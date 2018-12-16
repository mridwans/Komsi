package com.example.user.komsi;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
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

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {

    RelativeLayout rellay1, rellay2;

    Button btnLogin;
    EditText txtEmail, txtPassword;

    Handler handler = new Handler();

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            rellay1.setVisibility(View.VISIBLE);
            rellay2.setVisibility(View.VISIBLE);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        rellay1 = (RelativeLayout) findViewById(R.id.rellay1);
        rellay2 = (RelativeLayout) findViewById(R.id.rellay2);

        handler.postDelayed(runnable, 2000); //2000 is the timeout for the splash

/*        btnLogin.findViewById(R.id.btnLogin);
        username.findViewById(R.id.username);
        password.findViewById(R.id.password);*/

        btnLogin = (Button) findViewById(R.id.btnLogin);
        txtEmail = (EditText) findViewById(R.id.txtEmail);
        txtPassword = (EditText) findViewById(R.id.txtPassword);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Login();
            }
        });
    }

    private void Login(){
        String url="http://ridwan.rirfanuddin.id/api_baru/public/api/login";
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.trim().equals("success")){
                    Toast.makeText(getApplicationContext(),"Login Berhasil", Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(getApplicationContext(),"Login Berhasil", Toast.LENGTH_LONG).show();
                    Intent intent= new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(intent);
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),"error "+ error.toString(), Toast.LENGTH_LONG).show();

            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<>();
                params.put("email", txtEmail.getText().toString().trim());
                params.put("password",txtPassword.getText().toString().trim());
                //return super.getParams();
                return params;
            }
        };
        requestQueue.add(stringRequest);
    }

    /*private void login(){
        StringRequest request = new StringRequest(Request.Method.POST, "http://ridwan.rirfanuddin.id/public/api/login",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        if(response.contains("success")){


                            *//*Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                            startActivity(intent);*//*

                        }else {
                            Toast.makeText(getApplicationContext(),
                                    "Email atau Password salah", Toast.LENGTH_SHORT).show();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<>();
                params.put("email",username.getText().toString());
                params.put("password",password.getText().toString());
                return params;
                //return super.getParams();
            }
        };

        Volley.newRequestQueue(this).add(request);
    }*/

    /*public void loginClick( View view){
        Intent lintent= new Intent(LoginActivity.this, MainActivity.class);
        startActivity(lintent);
    }*/
}
