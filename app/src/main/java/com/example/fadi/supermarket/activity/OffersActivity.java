package com.example.fadi.supermarket.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.fadi.supermarket.R;
import com.example.fadi.supermarket.adapter.OfferAdapter;
import com.example.fadi.supermarket.async.task.AsyncResponse;
import com.example.fadi.supermarket.async.task.GetDataAsyncTaskRunner;
import com.example.fadi.supermarket.model.Offer;
import com.example.fadi.supermarket.other.Constants;
import com.example.fadi.supermarket.util.JsonParser;

import java.util.ArrayList;

public class OffersActivity extends AppCompatActivity implements AsyncResponse {
    final GridLayout gridLayout = (GridLayout)findViewById(R.id.gridLayoutList);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_list);
        gridLayout.setColumnCount(2);
        this.getData();
    }

    public void getData() {
        GetDataAsyncTaskRunner asyncTaskRunner = new GetDataAsyncTaskRunner(this);
        asyncTaskRunner.execute(Constants.GET_OFFERS_URL);
    }

    public void processData(Object data) {

        String jsonString = (String) data;

        ArrayList<Offer> offers = JsonParser.parseOffersJson(jsonString);

        ListView listView = (ListView) findViewById(R.id.items_list);
        int total = 10;
        int column = 3;
        int row = total / column;
        gridLayout.setColumnCount(column);
        gridLayout.setRowCount(row + 1);
        for (int i = 0, c = 0, r = 0; i < total; i++, c++) {
            if (c == column) {
                c = 0;
                r++;
            }

            GridLayout.Spec rowSpan = GridLayout.spec(GridLayout.UNDEFINED, 1);
            GridLayout.Spec colspan = GridLayout.spec(GridLayout.UNDEFINED, 1);
            if (r == 0 && c == 0) {
                Log.e("", "spec");
                colspan = GridLayout.spec(GridLayout.UNDEFINED, 2);
                rowSpan = GridLayout.spec(GridLayout.UNDEFINED, 2);
            }
            GridLayout.LayoutParams gridParam = new GridLayout.LayoutParams(
                    rowSpan, colspan);
            


        }
        OfferAdapter offerAdapter = new OfferAdapter(this, offers);
        listView.setAdapter(offerAdapter);
    }
}
