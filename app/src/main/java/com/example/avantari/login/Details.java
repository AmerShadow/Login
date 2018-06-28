package com.example.avantari.login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Details extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    String fname, lname, email, pass;
    String TAG = Details.class.getSimpleName();
    Button b = findViewById(R.id.main);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        setId();
        printDetails();
    }


    private void setId() {
        sharedPreferences = getSharedPreferences("com.example.avantari.sharedPreferences", MODE_PRIVATE);
        editor = sharedPreferences.edit();

    }

    private void printDetails() {
        fname = sharedPreferences.getString("fname1", "");
        lname = sharedPreferences.getString("lname1", "");
        email = sharedPreferences.getString("email", "");
        pass = sharedPreferences.getString("pass", "");
        Log.d(TAG, "Name:" + fname);
        Log.d(TAG, "Name:" + lname);
        Log.d(TAG, "Name:" + email);
        Log.d(TAG, "Name:" + pass);
        TextView t1, t2, t3;
        t1 = findViewById(R.id.name);
        t2 = findViewById(R.id.email);
        t3 = findViewById(R.id.pass);
        t1.setText(fname + " " + lname);
        t2.setText(email);
        t3.setText(pass);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent x = new Intent(Details.this, MainActivity.class);
                startActivity(x);
                finish();
            }
        });

    }
}
