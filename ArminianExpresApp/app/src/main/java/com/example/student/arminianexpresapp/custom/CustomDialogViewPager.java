package com.example.student.arminianexpresapp.custom;

import android.annotation.SuppressLint;
import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.student.arminianexpresapp.R;
import com.example.student.arminianexpresapp.adapter.ViewPagerAdapter;
import com.example.student.arminianexpresapp.proviader.UserProvider;


@SuppressLint("ValidFragment")
public class CustomDialogViewPager extends DialogFragment {

    private Context context;
    private int position;
    private int dataPosition;


    @SuppressLint("ValidFragment")
    public CustomDialogViewPager(Context context, int position, int dataPosition) {
        this.context = context;
        this.position = position;
        this.dataPosition = dataPosition;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.layout_view_pager, container, false);
        final ViewPager viewPager = rootView.findViewById(R.id.view_pager);
        final ViewPagerAdapter adapter = new ViewPagerAdapter(context, UserProvider.list.get(position).getImageId());
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(dataPosition);
        return rootView;
    }
}




