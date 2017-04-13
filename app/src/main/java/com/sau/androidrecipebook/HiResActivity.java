package com.sau.androidrecipebook;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.sau.androidrecipebook.model.Recipe;

/**
 * Created by saurabh on 2017-03-19.
 */

public class HiResActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hires);
        Recipe r = getIntent().getParcelableExtra("recipe");
        setTitle(r.getRecipeName());

        ImageView imgPic = (ImageView) findViewById(R.id.img_pic);

        imgPic.setImageDrawable(ResourcesCompat.getDrawable(getResources(), r.getFullImagePath(),null));
        imgPic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
