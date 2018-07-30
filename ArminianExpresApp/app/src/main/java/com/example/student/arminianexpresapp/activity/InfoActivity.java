package com.example.student.arminianexpresapp.activity;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.student.arminianexpresapp.R;
import com.example.student.arminianexpresapp.adapter.AdapterInfo;
import com.example.student.arminianexpresapp.custom.CustomDialog;
import com.example.student.arminianexpresapp.proviader.UserProvider;

public class InfoActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ImageView image;
        final int position = getIntent().getExtras().getInt("MY_KEY");
        int[] images = UserProvider.list.get(UserProvider.position).getImageId();


        final FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!UserProvider.list.get(position).isToBasket) {
                    UserProvider.list.get(position).isToBasket = true;
                } else {
                    UserProvider.list.get(position).isToBasket = false;
                }
            }
        });

        image = findViewById(R.id.image_info);

        RecyclerView recyclerView = findViewById(R.id.rec_info);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        recyclerView.setAdapter(new AdapterInfo(this, images, UserProvider.position));
        ImageView videoImage = findViewById(R.id.image_video);
        videoImage.setImageResource(images[0]);
        RatingBar ratingBar = findViewById(R.id.rading_bar);
        image.setImageResource(UserProvider.list.get(UserProvider.position).getImageId()[0]);
        ratingBar.setRating(UserProvider.list.get(position).getReting());
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                UserProvider.list.get(position).setReting(v);
            }
        });

        TextView textView = findViewById(R.id.text_dec);
        textView.setText(UserProvider.list.get(position).getDescription());
        videoImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CustomDialog dialog = new CustomDialog(InfoActivity.this, position);
                dialog.show();
            }
        });

    }


}
