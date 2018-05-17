package com.example.fadi.supermarket.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.fadi.supermarket.R;

public class CouponDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coupon_details);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String description = intent.getStringExtra("description");

        TextView nameTextView = (TextView) findViewById(R.id.nameTextView);
        TextView descriptionTextView = (TextView) findViewById(R.id.descTextView);

        nameTextView.setText(name);
        descriptionTextView.setText(description);
    }
}
