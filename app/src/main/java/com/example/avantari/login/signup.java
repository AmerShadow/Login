package com.example.avantari.login;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class signup extends MainActivity {

    EditText fname, lname, email, pass, repass;
    Button sign;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        setId();
        action();
    }

    private void setId() {
        sign = findViewById(R.id.signup);
        fname = (EditText) findViewById(R.id.fname);
        lname = (EditText) findViewById(R.id.lname);
        email = findViewById(R.id.email);
        pass = findViewById(R.id.pass);
        repass = findViewById(R.id.repass);
        sharedPreferences=getSharedPreferences("com.example.avantari.sharedPreferences", Context.MODE_PRIVATE);
        editor=sharedPreferences.edit();
    }

    private boolean validation() {
        if (fname == null || lname == null || email == null || pass == null || repass == null) {

        }
        return true;
    }

    private void action() {
        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(fname.getText().toString().isEmpty()){
                    fname.setError("Please Enter your first name");
                    return;
                }
                else {
                    if(fname.getText().toString().contains("1")){
                        fname.setError("Name does not contains numbers");
                        return;
                    }

                }


                if(lname.getText().toString().isEmpty()){
                    lname.setError("Please Enter your  last name");
                    return;
                }
                if(email.getText().toString().isEmpty()){
                    email.setError("Please Enter your email address");
                    return;
                }
                else {
                    if(!email.getText().toString().contains("@"))
                    {
                        email.setError("Your email is not valid");
                        return;

                    }
                }
                if(pass.getText().toString().isEmpty()){
                    pass.setError("Please Set password first");
                    return;
                }
                if(repass.getText().toString().isEmpty()){
                    repass.setError("Please confirm  your password");
                    return;
                }
                editor




            }
        });
    }


}
