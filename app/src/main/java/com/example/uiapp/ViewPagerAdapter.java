package com.example.uiapp;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.viewpager.widget.PagerAdapter;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

public class ViewPagerAdapter extends PagerAdapter {

    ArrayList<Movies> s;
    Context context;

    MotionLayout motionLayout;

    public ViewPagerAdapter(ArrayList<Movies> s, Context context) {
        this.s = s;
        this.context = context;
    }

    @Override
    public int getCount() {
        return s.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==(CardView)object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        LayoutInflater layoutInflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.card_stack,container,false);
        container.addView(view);

        TextView title=(TextView) view.findViewById(R.id.cd_title);
        TextView desc=(TextView) view.findViewById(R.id.cd_desc);
        TextView genre=(TextView) view.findViewById(R.id.cd_genre);
        TextView rating=(TextView) view.findViewById(R.id.cd_rating);
        ImageView image=(ImageView) view.findViewById(R.id.cd_img);

        title.setText(context.getResources().getString(s.get(position).getName()));
        desc.setText(context.getResources().getString(s.get(position).getDesc()));
        genre.setText(context.getResources().getString(s.get(position).getGenre()));
        rating.setText(context.getResources().getString(s.get(position).getRating()));
//        image.setBackgroundResource(s.get(position).getImageId());

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
