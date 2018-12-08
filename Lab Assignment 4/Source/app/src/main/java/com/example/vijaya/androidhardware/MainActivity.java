package com.example.vijaya.androidhardware;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button button_news,button_photo,button_record,button_storage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button_news=(Button)findViewById(R.id.main_btn_news);
        button_photo=(Button)findViewById(R.id.main_btn_photo);
        button_record=(Button)findViewById(R.id.main_btn_record);
        button_storage=(Button)findViewById(R.id.main_btn_storage);

    }
    public void onNewsClick(View v) {
        //This code redirects to the news activity.
        Intent redirect = new Intent(MainActivity.this, NewsActivity.class);
        startActivity(redirect);
    }
    public void onPhotoClick(View v) {
        //This code redirects to the camera activity.
        Intent redirect = new Intent(MainActivity.this, CameraActivity.class);
        startActivity(redirect);
    }
    public void onAudioClick(View v){
        //This code redirects to the Audio Activity
        Intent redirect = new Intent(MainActivity.this, AudioRecordingActivity.class);
        startActivity(redirect);
    }
    public void onStorageClick(View v){
        //This code redirects to the Storage Activity
        Intent redirect = new Intent(MainActivity.this, StorageActivity.class);
        startActivity(redirect);
    }
}
