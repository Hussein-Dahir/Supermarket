package com.example.fadi.supermarket.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.fadi.supermarket.R;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ImageView catalogButton = (ImageView)findViewById(R.id.catalog);
        ImageView couponsButton = (ImageView)findViewById(R.id.coupon);
        ImageView contactsButton = (ImageView)findViewById(R.id.contact);
        ImageView brandsButton = (ImageView)findViewById(R.id.brands);
        ImageView bestOffersButton = (ImageView)findViewById(R.id.bestOff);
        ImageView aboutButton = (ImageView)findViewById(R.id.aboutUs);
        ImageView newArrButton = (ImageView)findViewById(R.id.newArr);
        ImageView saleButton = (ImageView)findViewById(R.id.sale);


        bestOffersButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent offersIntent = new Intent(getApplicationContext(), OffersActivity.class);
                startActivity(offersIntent);
            }
        });

        catalogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent catalogIntent = new Intent(getApplicationContext(), CatalogActivity.class);
                startActivity(catalogIntent);
            }
        });

        couponsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent couponIntent = new Intent(getApplicationContext(), CouponActivity.class);
                startActivity(couponIntent);
            }
        });

        aboutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent couponIntent = new Intent(getApplicationContext(), AboutUsActivity.class);
                startActivity(couponIntent);
            }
        });


    }
}
