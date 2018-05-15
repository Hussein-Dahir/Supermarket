package com.example.fadi.supermarket.util;

import com.example.fadi.supermarket.model.Product;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonParser {

    public static ArrayList<Product> parseProductsJson(String json) {
        ArrayList<Product> products = new ArrayList<>();
        try {

            JSONObject jsonObject = new JSONObject(json);
            JSONArray jsonArray = jsonObject.getJSONArray("foodlist");

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonProductObject = (JSONObject) jsonArray.get(i);
                Product product = new Product();
                product.setName(jsonProductObject.getString("name"));
                product.setPrice(jsonProductObject.getDouble("price"));
                products.add(product);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return products;
    }
}
