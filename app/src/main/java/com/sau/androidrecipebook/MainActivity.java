package com.sau.androidrecipebook;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.sau.androidrecipebook.adapter.RecipeListAdapter;
import com.sau.androidrecipebook.model.Recipe;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private static RecipeListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listView);
        final Recipe[] recipes = Recipe.getRecipesFromRes(getApplicationContext(), getResources());

        //Sort the data
        Arrays.sort(recipes);

        adapter = new RecipeListAdapter(getApplicationContext(), recipes);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
                intent.putExtra("recipe", recipes[i]);
                ImageView img = (ImageView)view.findViewById(R.id.img_pic);
                ActivityOptions options = ActivityOptions
                        .makeSceneTransitionAnimation(MainActivity.this, img, "imgTransition");
                startActivity(intent, options.toBundle());

            }
        });
    }
}
