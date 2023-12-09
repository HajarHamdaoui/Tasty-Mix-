package com.example.tastymix.models;

import java.util.ArrayList;

public class CookerModel extends UserModel{
    private String mCertificate;
    private String mSpeciality;
    private String mExperienceYears;
    private ArrayList<RecipeModel> mCookerRecipes;

    public String getCertificate() {
        return mCertificate;
    }

    public ArrayList<RecipeModel> getCookerRecipes() {
        return mCookerRecipes;
    }

    public void setCookerRecipes(ArrayList<RecipeModel> cookerRecipes) {
        mCookerRecipes = cookerRecipes;
    }

    public String getSpeciality() {
        return mSpeciality;
    }

    public String getExperienceYears() {
        return mExperienceYears;
    }

    public void setCertificate(String certificate) {
        mCertificate = certificate;
    }

    public void setSpeciality(String speciality) {
        mSpeciality = speciality;
    }

    public void setExperienceYears(String experienceYears) {
        mExperienceYears = experienceYears;
    }
}
