package com.example.fadi.supermarket.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.fadi.supermarket.R;

public class OfferDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offer_details);

        Intent intent = getIntent();
        String itemList = intent.getStringExtra("itemList");
        String price = intent.getStringExtra("price");

        TextView offerItemsTextView = (TextView) findViewById(R.id.offerItemsTextView);
        TextView offerPriceTextView = (TextView) findViewById(R.id.offerPriceTextView);

        offerItemsTextView.setText(itemList);
        offerPriceTextView.setText(price);
    }
}
