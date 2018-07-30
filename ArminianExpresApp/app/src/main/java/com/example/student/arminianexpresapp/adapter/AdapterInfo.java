package com.example.student.arminianexpresapp.adapter;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.student.arminianexpresapp.R;
import com.example.student.arminianexpresapp.activity.InfoActivity;
import com.example.student.arminianexpresapp.custom.CustomDialogViewPager;


public class AdapterInfo extends RecyclerView.Adapter<AdapterInfo.ImageHolder> {

    private Context context;
    private int[] images;
    private final int positionMod;


    public AdapterInfo(Context context, int[] a, int positionMod) {
        this.context = context;
        this.images = a;
        this.positionMod = positionMod;

    }

    @NonNull
    @Override
    public ImageHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_image, parent, false);
        return new ImageHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ImageHolder holder, final int position) {
        holder.imageView.setImageResource(images[position]);
        holder.itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                CustomDialogViewPager cdvp = new CustomDialogViewPager(context, positionMod, position);
                final android.app.FragmentManager fragmentManager =
                        ((InfoActivity) context).getFragmentManager();
                cdvp.show(fragmentManager, "My Dialog");
            }
        });
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    public class ImageHolder extends RecyclerView.ViewHolder {
        ImageView imageView;

        public ImageHolder(final View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_rec);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ImageView mainImage = ((InfoActivity) context).findViewById(R.id.image_info);
                    mainImage.setImageDrawable(imageView.getDrawable());
                }
            });
        }
    }
}
