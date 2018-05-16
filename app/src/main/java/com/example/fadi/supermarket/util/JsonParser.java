package com.example.fadi.supermarket.util;

import com.example.fadi.supermarket.model.Offer;
import com.example.fadi.supermarket.model.Product;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonParser {

    public static ArrayList<Product> parseProductsJson(String json) {
        ArrayList<Product> products = new ArrayList<>();

        if (json == null) {
            return products;
        }

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

    public static ArrayList<Offer> parseOffersJson(String json) {
        ArrayList<Offer> offers = new ArrayList<>();

        if (json == null) {
            return offers;
        }

        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray jsonArray = jsonObject.getJSONArray("foodlist");

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonOfferObject = (JSONObject) jsonArray.get(i);
                Offer offer = new Offer();

                JSONArray jsonItemList = jsonObject.getJSONArray("itemlist");

                StringBuilder itemListSB = new StringBuilder();
                for (int j = 0; j < jsonItemList.length(); j++) {
                    String item = (String) jsonItemList.get(j);
                    itemListSB.append(item + " + ");
                }

                offer.setPrice(jsonOfferObject.getDouble("price"));
                offer.setItemList(itemListSB.toString());

                offers.add(offer);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return offers;
    }

}
