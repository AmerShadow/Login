package com.example.avantari.login;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private String TAG = MainActivity.class.getSimpleName();
    Button login,signup;
    TextView id,pass;
    String myId;
    String myPass;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setIds();
        setEvents();
    }


    private void setIds(){
        login=findViewById(R.id.login);
        signup=findViewById(R.id.signup);
        id=(TextView)findViewById(R.id.id1);
        pass=(TextView)findViewById(R.id.pass);
        sharedPreferences=getSharedPreferences("com.example.avantari.sharedPreferences", Context.MODE_PRIVATE);
        editor=sharedPreferences.edit();
        myId = sharedPreferences.getString("email", "");
        Log.d(TAG, "my ID:" + myId);
        myPass = sharedPreferences.getString("pass", "");
        Log.d(TAG, "my Pass:" + myPass);
    }

    private void setEvents(){
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG,"Call to signup");
                Intent a=new Intent(MainActivity.this,signup.class);
                startActivity(a);
                finish();




            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(id.getText().toString().isEmpty())
                {
                    id.setError("Please enter Email");
                    return;
                }
                else
                {
                    if (!id.getText().toString().equalsIgnoreCase(myId))
                    {
                        id.setError("Invalid Email");
                        return;
                    }
                }
                if(pass.getText().toString().isEmpty())
                {
                    pass.setError("Please Enter password");
                    return;
                }
                else
                {
                    if (!pass.getText().toString().equals(myPass))
                    {
                        pass.setError("Invalid Password");
                        return;
                    }
                }

                Intent details=new Intent(MainActivity.this,Details.class);
                startActivity(details);
                finish();



            }
        });
    }
}
