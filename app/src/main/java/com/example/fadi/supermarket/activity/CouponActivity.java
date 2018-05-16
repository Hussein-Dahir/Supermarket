package com.example.fadi.supermarket.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.fadi.supermarket.R;
import com.example.fadi.supermarket.adapter.CouponAdapter;
import com.example.fadi.supermarket.adapter.OfferAdapter;
import com.example.fadi.supermarket.async.task.AsyncResponse;
import com.example.fadi.supermarket.async.task.GetDataAsyncTaskRunner;
import com.example.fadi.supermarket.model.Coupon;
import com.example.fadi.supermarket.model.Offer;
import com.example.fadi.supermarket.other.Constants;
import com.example.fadi.supermarket.util.JsonParser;

import java.util.ArrayList;

public class CouponActivity extends AppCompatActivity implements AsyncResponse {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_items);

        this.getData();
    }

    public void getData() {
        GetDataAsyncTaskRunner asyncTaskRunner = new GetDataAsyncTaskRunner(this);
        asyncTaskRunner.execute(Constants.GET_COUPONS_URL);
    }

    public void processData(Object data) {

        String jsonString = (String) data;

        ArrayList<Coupon> coupons = JsonParser.parseCouponsJson(jsonString);

        ListView listView = (ListView) findViewById(R.id.items_list);

        CouponAdapter couponAdapter = new CouponAdapter(this, coupons);

        listView.setAdapter(couponAdapter);
    }
}