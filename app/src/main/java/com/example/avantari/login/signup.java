package com.example.avantari.login;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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
        editor.apply();
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
                if (repass.getText().toString().isEmpty() || !pass.getText().toString().equals(repass.getText().toString())) {
                    repass.setError("Password Does Not match");
                    return;
                }
                editor.putString("fname1", fname.getText().toString());
                editor.putString("lname1", lname.getText().toString());
                editor.putString("email", email.getText().toString());
                editor.putString("pass", pass.getText().toString());
                editor.commit();


                Intent details = new Intent(signup.this, Details.class);
                startActivity(details);

                // String s=sharedPreferences.getString("email","");
                // Log.d("signup",s);
                // lname.setText(s);



            }
        });
    }


}
