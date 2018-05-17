package com.example.fadi.supermarket.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fadi.supermarket.R;
import com.example.fadi.supermarket.activity.CouponDetailsActivity;
import com.example.fadi.supermarket.model.Coupon;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class CouponAdapter extends ArrayAdapter<Coupon> {

    private Context mContext;
    private List<Coupon> couponList;

    public CouponAdapter(@NonNull Context context, ArrayList<Coupon> list) {
        super(context, 0, list);
        mContext = context;
        couponList = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;
        if (listItem == null)
            listItem = LayoutInflater.from(mContext).inflate(R.layout.single_list_item, parent, false);

        final Coupon coupon = couponList.get(position);

        ImageView imageView = (ImageView) listItem.findViewById(R.id.imageView_image);
        imageView.setImageResource(R.drawable.no_image);

        TextView textView1 = (TextView) listItem.findViewById(R.id.textView_text1);
        textView1.setText(coupon.getName());

        TextView textView2 = (TextView) listItem.findViewById(R.id.textView_text2);
        textView2.setText(coupon.getDescription());

        listItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, CouponDetailsActivity.class);
                intent.putExtra("name", coupon.getName());
                intent.putExtra("description", coupon.getDescription());
                mContext.startActivity(intent);
            }
        });

        return listItem;
    }
}