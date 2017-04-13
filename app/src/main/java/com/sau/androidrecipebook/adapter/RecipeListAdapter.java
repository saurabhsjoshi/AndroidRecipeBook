package com.sau.androidrecipebook.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.res.ResourcesCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.sau.androidrecipebook.DetailsActivity;
import com.sau.androidrecipebook.HiResActivity;
import com.sau.androidrecipebook.R;
import com.sau.androidrecipebook.model.Recipe;

/**
 * Created by saurabh on 2017-03-09.
 */

public class RecipeListAdapter extends ArrayAdapter<Recipe> {

    //ViewHolder pattern to cache views in the list.
    private static class ViewHolder {
        ImageView imgPic;
        TextView txtRecipeName;
    }

    public RecipeListAdapter(Context context, Recipe[] recipes) {
        super(context, 0, recipes);
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Recipe recipe = getItem(position);

        ViewHolder viewHolder;
        final View result;

        if(convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_recipe, parent, false);
            viewHolder.txtRecipeName = (TextView) convertView.findViewById(R.id.txt_recipeName);
            viewHolder.imgPic = (ImageView) convertView.findViewById(R.id.img_pic);
            result = convertView;
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result=convertView;
        }

        viewHolder.txtRecipeName.setText(recipe.getRecipeName());
        viewHolder.txtRecipeName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getContext(), DetailsActivity.class);
                i.putExtra("recipe", getItem(position));
                getContext().startActivity(i);
            }
        });
        viewHolder.imgPic.setImageDrawable(ResourcesCompat.getDrawable(getContext().getResources(), recipe.getImagePath(),null));
        viewHolder.imgPic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getContext(), HiResActivity.class);
                i.putExtra("recipe", getItem(position));
                getContext().startActivity(i);
            }
        });
        return result;
    }
}
