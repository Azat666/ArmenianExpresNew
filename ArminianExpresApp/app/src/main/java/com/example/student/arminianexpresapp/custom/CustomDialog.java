package com.example.student.arminianexpresapp.custom;

import android.app.Activity;
import android.app.Dialog;
import android.net.Uri;
import android.os.Bundle;
import android.view.Window;
import android.widget.VideoView;

import com.example.student.arminianexpresapp.R;
import com.example.student.arminianexpresapp.proviader.UserProvider;

public class CustomDialog extends Dialog {

    private Activity c;
    private Dialog d;
    private VideoView video;
    private int position;

    public CustomDialog(final Activity a, final int position) {
        super(a);
        // TODO Auto-generated constructor stub
        this.c = a;
        this.position = position;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.custom_dialog);
        final VideoView video = findViewById(R.id.video_view);
        video.setVideoURI(Uri.parse(UserProvider.list.get(position).getVideoUrl()));
        video.start();

    }
}
