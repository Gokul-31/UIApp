package com.example.uiapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.view.ViewCompat;
import androidx.viewpager.widget.PagerAdapter;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

public class ViewPagerAdapter extends PagerAdapter {

    ArrayList<Movies> s;
    Context context;

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
    public Object instantiateItem(@NonNull final ViewGroup container, final int position) {

        LayoutInflater layoutInflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.card_stack,container,false);
        container.addView(view);

        TextView title=(TextView) view.findViewById(R.id.cd_title);
        TextView desc=(TextView) view.findViewById(R.id.cd_desc);
        TextView genre=(TextView) view.findViewById(R.id.cd_genre);
        TextView rating=(TextView) view.findViewById(R.id.cd_rating);
        final ImageView image=(ImageView) view.findViewById(R.id.cd_mov_vp);

        final ConstraintLayout constraintLayout=(ConstraintLayout)view.findViewById(R.id.trans_layout);

        title.setText(context.getResources().getString(s.get(position).getName()));
        desc.setText(context.getResources().getString(s.get(position).getDesc()));
        genre.setText(context.getResources().getString(s.get(position).getGenre()));
        rating.setText(context.getResources().getString(s.get(position).getRating()));
        image.setImageResource(s.get(position).getImageId());

        view.setOnTouchListener(new OnSwipeTouchListener(context){
            @Override
            public void onSwipeBottom() {
                Log.i(TAG, "onSwipeBottom");
                //do the transition
                Intent intent= new Intent(context,Movie.class);
                intent.putExtra("obj",s.get(position));
                ActivityOptionsCompat options=ActivityOptionsCompat.makeSceneTransitionAnimation((Activity) context,constraintLayout, ViewCompat.getTransitionName(constraintLayout));
                context.startActivity(intent,options.toBundle());
            }
        });
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
