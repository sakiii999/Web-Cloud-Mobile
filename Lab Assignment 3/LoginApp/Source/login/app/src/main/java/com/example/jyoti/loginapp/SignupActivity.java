package com.example.jyoti.loginapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
public class SignupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

    //Setting variables for widgets
    final EditText etName = (EditText) findViewById(R.id.etName);
    final EditText etUserName = (EditText) findViewById(R.id.etUserName);
    final EditText etPassword = (EditText) findViewById(R.id.etPassword);
    final Button bSignup = (Button) findViewById(R.id.bSignupHere);

    //Sign Up Button Functioning
        bSignup.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent SignupIntent = new Intent(SignupActivity.this, loggedActivity.class);
            SignupActivity.this.startActivity(SignupIntent);
        }
    });
}
}