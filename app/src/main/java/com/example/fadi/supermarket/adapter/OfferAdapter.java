package com.example.fadi.supermarket.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fadi.supermarket.R;
import com.example.fadi.supermarket.model.Offer;

import java.util.ArrayList;
import java.util.List;


public class OfferAdapter extends ArrayAdapter<Offer> {

    private Context mContext;
    private List<Offer> offersList;

    public OfferAdapter(@NonNull Context context, ArrayList<Offer> list) {
        super(context, 0, list);
        mContext = context;
        offersList = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;
        if (listItem == null)
            listItem = LayoutInflater.from(mContext).inflate(R.layout.single_list_item, parent, false);

        Offer offer = offersList.get(position);

        ImageView imageView = (ImageView) listItem.findViewById(R.id.imageView_image);
        imageView.setImageResource(R.drawable.no_image);

        TextView nameTextView = (TextView) listItem.findViewById(R.id.textView_text);
        nameTextView.setText(offer.getItemList());

        TextView priceTextView = (TextView) listItem.findViewById(R.id.textView_price);
        priceTextView.setText(offer.getPrice() + "");

        return listItem;
    }
}