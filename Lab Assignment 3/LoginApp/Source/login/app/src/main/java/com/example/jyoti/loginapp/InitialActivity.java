package com.example.jyoti.loginapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

public class InitialActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initial);
        //Add variables for widgets
        final Button bSocialloginHere = (Button) findViewById(R.id.bSocialoginHere);
        final Button bSignupHere = (Button) findViewById(R.id.bSignupHere);
        final Button bLoginHere=(Button) findViewById(R.id.bLoginHere);

        //Manual Login Button
        bLoginHere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginIntent = new Intent(InitialActivity.this, LoginActivity.class);
                InitialActivity.this.startActivity(loginIntent);
            }
        });

        //Social Login button functioning
        bSocialloginHere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent SocialloginIntent = new Intent(InitialActivity.this, UserAreaActivity.class);
                InitialActivity.this.startActivity(SocialloginIntent);
            }
        });

        //Sign Up button functioning
        bSignupHere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(InitialActivity.this, SignupActivity.class);
                InitialActivity.this.startActivity(registerIntent);
            }
        });
    }
}