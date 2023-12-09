package com.example.tastymix.models;

import java.util.ArrayList;

public class UserModel {
    protected String mUsername;
    protected String mGmail;
    protected String mPassword;
    protected ArrayList<RecipeModel> mSavedRecipes;
    public UserModel(){

    }

    public UserModel(String username, String gmail, String password) {
        mUsername = username;
        mGmail = gmail;
        mPassword = password;
    }

    public String getUsername() {
        return mUsername;
    }

    public String getGmail() {
        return mGmail;
    }

    public String getPassword() {
        return mPassword;
    }

    public ArrayList<RecipeModel> getSavedRecipees() {
        return mSavedRecipes;
    }

    public void setUsername(String username) {
        mUsername = username;
    }

    public void setGmail(String gmail) {
        mGmail = gmail;
    }

    public void setPassword(String password) {
        mPassword = password;
    }

    public void setSavedRecipees(ArrayList<RecipeModel> savedRecipees) {
        mSavedRecipes = savedRecipees;
    }
}
