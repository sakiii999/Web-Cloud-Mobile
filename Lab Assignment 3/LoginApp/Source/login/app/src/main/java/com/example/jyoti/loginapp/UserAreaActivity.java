package com.example.jyoti.loginapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

public class UserAreaActivity extends AppCompatActivity {
    LoginButton bFacebook;
    CallbackManager callbackManager;
    TextView txtStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_user_area);
        final EditText etUserName = (EditText) findViewById(R.id.etUserName);
        final EditText etPassword = (EditText) findViewById(R.id.etPassword);
        final Button bLogin = (Button) findViewById(R.id.bLogin);
        initializeControls();
        loginWithFb();
    }

    private void initializeControls(){
        callbackManager = CallbackManager.Factory.create();
        txtStatus = (TextView)findViewById(R.id.txtStatus);
        bFacebook = (LoginButton) findViewById(R.id.bFacebook);

    }

    private void loginWithFb(){
        LoginManager.getInstance().registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                txtStatus.setText("Signed In \n"+loginResult.getAccessToken());
            }

            @Override
            public void onCancel() {
                txtStatus.setText("Sign In Cancel \n");
            }

            @Override
            public void onError(FacebookException error) {
                txtStatus.setText("Sign In Error:"+error.getMessage());
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode,int resultCode, Intent data)
    {
        callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }
}
