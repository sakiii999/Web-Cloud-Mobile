package com.example.karthik.myorder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ReviewActivity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);

        String order = getIntent().getStringExtra("SUMMARY");

        TextView textView = (TextView) findViewById(R.id.order_textView);
        textView.setText(order);
    }

    public void goBack(View view) {
        finish();
    }


}
