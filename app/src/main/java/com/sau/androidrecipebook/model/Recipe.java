package com.sau.androidrecipebook.model;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

import com.sau.androidrecipebook.R;

/**
 * Created by saurabh on 2017-03-09.
 */

public class Recipe implements Parcelable, Comparable<Recipe> {
    private String recipeName = "";
    private int imagePath = 0;
    private int fullImagePath = 0;
    private String ingredients = "";
    private String directions = "";
    private String description = "";
    private String duration = "";


    private Recipe(String recipeName, String ingredients, String directions, String description, String duration, int imagePath, int fullImagePath) {
        this.recipeName = recipeName;
        this.imagePath  = imagePath;
        this.fullImagePath = fullImagePath;
        this.ingredients = ingredients;
        this.directions = directions;
        this.description = description;
        this.duration = duration;
    }

    private Recipe(Parcel parcel) {
        this(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt());
    }

    public static Recipe[] getRecipesFromRes(Context context, Resources res) {
        String[] recipeNames = res.getStringArray(R.array.recipe_list);
        String[] recipePics = res.getStringArray(R.array.recipe_pics);
        String[] recipeIngreds = res.getStringArray(R.array.recipe_ingredients);
        String[] recipeDirections =  res.getStringArray(R.array.recipe_directions);
        String[] recipeDescription  =res.getStringArray(R.array.recipe_description);
        String[] recipeDuration = res.getStringArray(R.array.recipe_duration);

        Recipe[] recipes = new Recipe[recipeNames.length];
        for(int i = 0; i < recipeNames.length; i++)
            recipes[i] = new Recipe(recipeNames[i],
                    recipeIngreds[i],
                    recipeDirections[i],
                    recipeDescription[i],
                    recipeDuration[i],
                    res.getIdentifier(recipePics[i]+"_thumb", "drawable", context.getPackageName()),
                    res.getIdentifier(recipePics[i]+"_full", "drawable", context.getPackageName()));

        return recipes;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public int getImagePath() {
        return imagePath;
    }

    public String getIngredients() {
        return ingredients;
    }

    public String getDirections() {
        return directions;
    }

    public int getFullImagePath() {
        return fullImagePath;
    }

    public String getDescription() {
        return description;
    }

    public String getDuration() {
        return duration;
    }

    @Override
    public int compareTo(@NonNull Recipe recipe) {
        return this.getRecipeName().compareTo(recipe.getRecipeName());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(recipeName);
        parcel.writeString(ingredients);
        parcel.writeString(directions);
        parcel.writeString(description);
        parcel.writeString(duration);
        parcel.writeInt(imagePath);
        parcel.writeInt(fullImagePath);
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator<Recipe>() {
        @Override
        public Recipe createFromParcel(Parcel parcel) {
            return new Recipe(parcel);
        }

        @Override
        public Recipe[] newArray(int i) {
            return new Recipe[i];
        }
    };
}
