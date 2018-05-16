package com.example.fadi.supermarket.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.fadi.supermarket.R;
import com.example.fadi.supermarket.adapter.OfferAdapter;
import com.example.fadi.supermarket.adapter.ProductAdapter;
import com.example.fadi.supermarket.async.task.AsyncResponse;
import com.example.fadi.supermarket.async.task.GetDataAsyncTaskRunner;
import com.example.fadi.supermarket.model.Offer;
import com.example.fadi.supermarket.model.Product;
import com.example.fadi.supermarket.other.Constants;
import com.example.fadi.supermarket.util.JsonParser;

import java.util.ArrayList;

public class OffersActivity extends AppCompatActivity implements AsyncResponse {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_items);

        this.getData();
    }

    public void getData() {
        GetDataAsyncTaskRunner asyncTaskRunner = new GetDataAsyncTaskRunner(this);
        asyncTaskRunner.execute(Constants.GET_OFFERS_URL);
    }

    public void processData(Object data) {

        String jsonString = (String) data;

        ArrayList<Offer> offers = JsonParser.parseOffersJson(jsonString);

        ListView listView = (ListView) findViewById(R.id.products_list);

        OfferAdapter offerAdapter = new OfferAdapter(this, offers);

        listView.setAdapter(offerAdapter);
    }
}
