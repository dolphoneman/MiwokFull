package com.example.android.miwok;

import android.app.Activity;

import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter <Word> {

    //**Resource ID for the background color of this list of words
    private int mColorResourceID;

    public WordAdapter(Activity context, ArrayList<Word> words, int colorResourceID) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, words);
        mColorResourceID = colorResourceID;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link AndroidFlavor} object located at this position in the list
        Word currentWord = getItem(position);

        // Find the TextView in the list_item.xml layout with the Miwok word
        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok_textView);
        // Get the Miwok word from the current Word object and
        // set this text on the name TextView
        miwokTextView.setText(currentWord.getMiwokTranslation());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView englishTextView = (TextView) listItemView.findViewById(R.id.english_textView);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        englishTextView.setText(currentWord.getDefaultTranslation());

        // Find the ImageView in the list_layout.xml with the ID play_button
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image_icon);

        if (currentWord.hasImage()) {
            //Set the ImageView to the image resource specified in the current word
            imageView.setImageResource(currentWord.getImageResourseID());

            //Make sure the view is visible
            imageView.setVisibility(View.VISIBLE);
        }
        else {
            imageView.setVisibility(View.GONE);
        }

        //Set the theme color for this list item
        View textContainer = listItemView.findViewById(R.id.text_container);
        //Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceID);
        //Set the background color of the text container View
        textContainer.setBackgroundColor(color);

        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }
}

