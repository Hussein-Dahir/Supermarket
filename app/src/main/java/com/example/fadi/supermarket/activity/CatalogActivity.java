package com.example.fadi.supermarket.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;

import com.example.fadi.supermarket.R;

public class CatalogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalog);

        ImageButton meat = (ImageButton) findViewById(R.id.catalogMeat);
        ImageButton food = (ImageButton) findViewById(R.id.catalogFood);
        ImageButton nonfood = (ImageButton) findViewById(R.id.catalogNonFood);
        ImageButton bread = (ImageButton) findViewById(R.id.catalogBread);

        meat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ListItemsActivity.class);
                intent.putExtra("type" , "meat");
                startActivity(intent);
            }
        });

        food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ListItemsActivity.class);
                intent.putExtra("type" , "food");
                startActivity(intent);
            }
        });

        nonfood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ListItemsActivity.class);
                intent.putExtra("type" , "nonfood");
                startActivity(intent);
            }
        });

        bread.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ListItemsActivity.class);
                intent.putExtra("type" , "bread");
                startActivity(intent);
            }
        });
    }

}
