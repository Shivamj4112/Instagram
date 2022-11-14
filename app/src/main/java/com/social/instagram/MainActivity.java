package com.social.instagram;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.social.instagram.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    int[] images = new int[] {R.drawable.storyimg_1,R.drawable.storyimg_2,R.drawable.storyimg_3,R.drawable.storyimg_4};
    String[] name = new String[] {"Denish_james","Peter_45","Kelvin_rj21","___Marr__ry"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        LinearLayoutManager manager1 = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        RecycleStory adapter1 = new RecycleStory(this,images);
        binding.storyRecycle.setLayoutManager(manager1);
        binding.storyRecycle.setAdapter(adapter1);


        LinearLayoutManager manager2 = new LinearLayoutManager(this);
        Recyclepost adapter2 = new Recyclepost(this,images,name);
        binding.postRecycle.setLayoutManager(manager2);
        binding.postRecycle.setAdapter(adapter2);


    }


}