package com.example.uiapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    ViewPagerAdapter adapter;
    ArrayList<Movies> movies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewPager=(ViewPager)findViewById(R.id.viewPager);

        movies=new ArrayList<>();
        initDummies();


        adapter=new ViewPagerAdapter(movies,this);
        viewPager.setPageTransformer(true, new ViewPagerStack());
        viewPager.setAdapter(adapter);
    }

    private void initDummies() {
        movies.add(new Movies(R.drawable.hb1,R.string.m1_title,R.string.m1_genre,R.string.m1_desc,R.string.m1_rating));
        movies.add(new Movies(R.drawable.nusm,R.string.m2_title,R.string.m2_genre,R.string.m2_desc,R.string.m2_rating));
        movies.add(new Movies(R.drawable.o11,R.string.m3_title,R.string.m3_genre,R.string.m3_desc,R.string.m3_rating));

    }

    private class ViewPagerStack implements ViewPager.PageTransformer{
        @Override
        public void transformPage(@NonNull View page, float position) {
            if(position>=0){
                // TODO: 29-08-2020 learn and change this
                page.setScaleX(0.7f-0.05f*position);
                page.setScaleY(0.7f);

                page.setTranslationX(-page.getWidth()*position);
                page.setTranslationY(-30*position);
            }
        }
    }
}