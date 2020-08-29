package com.example.uiapp;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.viewpager.widget.PagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter2 extends PagerAdapter {

    List<Integer> s;
    Context context;


    public ViewPagerAdapter2(int a,int b, int c, Context context) {
        s=new ArrayList<>();
        s.add(a);
        s.add(b);
        s.add(c);
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
        View view=layoutInflater.inflate(R.layout.mov_vid,container,false);
        container.addView(view);

        if (position==0||position==2){
            ImageView img= (ImageView) view.findViewById(R.id.img_view);
            img.setImageResource(s.get(position));
        }else{
            VideoView videoView=(VideoView) view.findViewById(R.id.vid_view);
            String videoPath="android.resource://"+context.getPackageName()+"/"+ s.get(position);
            Uri uri=Uri.parse(videoPath);
            videoView.setVideoURI(uri);

            MediaController mediaController= new MediaController(context);
            videoView.setMediaController(mediaController);

            mediaController.setAnchorView(videoView);
        }
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
