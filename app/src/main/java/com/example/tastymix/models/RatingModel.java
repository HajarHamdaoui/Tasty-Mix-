package com.example.tastymix.models;

import com.example.tastymix.AppFunctions;

public class RatingModel {
    private int mUsersCounter;
    private double mStarsAverage;
    private double mStarsCounter;
    private boolean isEmpty;

    public RatingModel() {
       mStarsCounter=0;
       mUsersCounter=0;
       isEmpty = true;
    }

    public void setStarsCounter()
    {
        if(mUsersCounter==0)
        {
            mStarsAverage =0;
            isEmpty=true;
        }
        else{
            mStarsAverage = AppFunctions.average(mStarsCounter/mUsersCounter);
        }

    }

    public int getUsersCounter() {
        return mUsersCounter;
    }

    public double getStarsAverage() {
        return mStarsAverage;
    }

    public double getStarsCounter() {
        return mStarsCounter;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public void setUsersCounter(int usersCounter) {
        mUsersCounter = usersCounter;
    }

    public void setStarsAverage(double starsAverage) {
        mStarsAverage = starsAverage;
    }

    public void setStarsCounter(int starsCounter) {
        mStarsCounter = starsCounter;
    }

    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }
    public void addRating(double starsCounter ){
        mStarsCounter = mStarsCounter+ starsCounter;
        mUsersCounter++;
    }


}
