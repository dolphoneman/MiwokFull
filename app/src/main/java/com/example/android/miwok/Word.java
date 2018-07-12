package com.example.android.miwok;

import android.media.Image;

public class Word {

    //Default translation string for the word
    private String mDefaultTranslation;

    //Miwok translation string for the word
    private String mMiwokTranslation;

    //Icon image of the word
    private int mImageResourseID = NO_IMAGE_PROVIDED;

    private static final int NO_IMAGE_PROVIDED = -1;

    //Audio resource ID for the word
    private int mAudioResourceID;

    //Create a new Word object
    public Word(String defaultTranslation, String miwokTranslation, int audioResourceID){
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mAudioResourceID = audioResourceID;
    }

    //Create a new Word object with an image
    public Word(String defaultTranslation, String miwokTranslation, int imageResourseID, int audioResourceID){
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mImageResourseID = imageResourseID;
        mAudioResourceID = audioResourceID;
    }

    //Get the default translation of the word
    public String getDefaultTranslation(){
        return mDefaultTranslation;
    }

    //Get the Miwok translation of the word

    public String getMiwokTranslation() {
        return mMiwokTranslation;
    }

    //Get the image for the word
    public int getImageResourseID () { return mImageResourseID;}

    //Returns whether or not there is an image for this word
    public boolean hasImage(){
        return mImageResourseID != NO_IMAGE_PROVIDED;
    }

    public int getAudioResourceID() { return mAudioResourceID;}
}
