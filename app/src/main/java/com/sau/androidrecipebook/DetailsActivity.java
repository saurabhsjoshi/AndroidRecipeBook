package com.sau.androidrecipebook;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.sau.androidrecipebook.model.Recipe;

/**
 * Created by saurabh on 2017-03-11.
 */

public class DetailsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        final Toolbar toolbar = (Toolbar) findViewById(R.id.MyToolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapse_toolbar);

        Recipe r = getIntent().getParcelableExtra("recipe");

        collapsingToolbar.setTitle(r.getRecipeName());
        ((TextView) findViewById(R.id.txt_directions)).setText(r.getDirections());
        ((TextView) findViewById(R.id.txt_description)).setText(r.getDescription());
        ((TextView) findViewById(R.id.txt_duration)).setText("Duration: " + r.getDuration());

        ((TextView) findViewById(R.id.txt_ingredients)).setText(r.getIngredients());
        ((ImageView) findViewById(R.id.bgheader)).setImageDrawable(ResourcesCompat.getDrawable(getResources(), r.getFullImagePath(),null));

        collapsingToolbar.setCollapsedTitleTextColor(Color.WHITE);
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                supportFinishAfterTransition();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
