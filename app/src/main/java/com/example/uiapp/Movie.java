package com.example.uiapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.transition.Fade;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

public class Movie extends AppCompatActivity {

    ViewPager viewPager2;
    ViewPagerAdapter2 adapter2;

//    int imageId;
//    int name;
//    int genre;
//    int desc;
//    int rating;
//    int img2Id=0;
//    int img3Id=0;

    Movies m;

    TextView nameT;
    TextView genreT;
    TextView descT;
    TextView ratingT;

    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);

        viewPager2=findViewById(R.id.cd_mov_vp);
        nameT=findViewById(R.id.cd_mov_title);
        genreT=findViewById(R.id.cd_mov_genre);
        descT=findViewById(R.id.cd_mov_desc);
        ratingT=findViewById(R.id.cd_mov_rating);
        tabLayout=findViewById(R.id.cd_tab);

        Intent am = getIntent();
        m= (Movies) am.getSerializableExtra("obj");

//        name=am.getIntExtra("name",0);
//        genre=am.getIntExtra("genre",0);
//        desc=am.getIntExtra("desc",0);
//        rating=am.getIntExtra("rating",0);
//        imageId=am.getIntExtra("img1",0);
//        img2Id=am.getIntExtra("img2",0);
//        img3Id=am.getIntExtra("img3",0);

        nameT.setText(getResources().getString(m.getName()));
        ratingT.setText(getResources().getString(m.getRating()));
        descT.setText(getResources().getString(m.getDesc()));
        genreT.setText(getResources().getString(m.getGenre()));



        adapter2=new ViewPagerAdapter2(m.getImageId(),m.getImg2Id(),m.getImg3Id(),this);
        viewPager2.setAdapter(adapter2);
        tabLayout.setupWithViewPager(viewPager2);

    }
}