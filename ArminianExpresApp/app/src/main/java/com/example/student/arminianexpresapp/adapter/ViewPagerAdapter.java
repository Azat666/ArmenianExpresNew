package com.example.student.arminianexpresapp.adapter;

import android.content.Context;

import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.student.arminianexpresapp.R;


public class ViewPagerAdapter extends PagerAdapter {

    private Context context;
    private int[] imagearray;

    public ViewPagerAdapter(Context context, int[] imagearray) {
        this.context = context;
        this.imagearray = imagearray;
    }

    @Override
    public int getCount() {
        return imagearray.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        final View view = LayoutInflater.from(context).
                inflate(R.layout.image_item, container, false);
        ImageView imageView = view.findViewById(R.id.image_item_pager);
        imageView.setImageResource(imagearray[position]);
        container.addView(view);
        return view;
    }

}
