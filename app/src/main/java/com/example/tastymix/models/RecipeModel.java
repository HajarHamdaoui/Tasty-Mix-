package com.example.tastymix.models;

import java.util.ArrayList;

public class RecipeModel {
    private int imageId;
    private String title;
    private String category;

    private ArrayList<String> mIngredients;
    private ArrayList<String> mSteps;
    private RatingModel mRecipeRating;

    public int getImageId() {
        return imageId;
    }

    public String getCategory() {
        return category;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setIngredients(ArrayList<String> ingredients) {
        mIngredients = ingredients;
    }

    public void setSteps(ArrayList<String> steps) {
        mSteps = steps;
    }

    public void setRecipeRating(RatingModel recipeRating) {
        mRecipeRating = recipeRating;
    }

    public String getTitle() {
        return title;
    }

    public ArrayList<String> getIngredients() {
        return mIngredients;
    }

    public ArrayList<String> getSteps() {
        return mSteps;
    }

    public RatingModel getRecipeRating() {
        return mRecipeRating;
    }
}

