package com.example.android.musicapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ahmed on 2018-03-16.
 */

public class ItemAdapter extends ArrayAdapter<Item> {
    public ItemAdapter(Activity context, ArrayList<Item> items) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;

        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.selection_item, parent, false);
        }

        Item currentItem= (Item) getItem(position);
        TextView firstLineTextView = (TextView) listItemView.findViewById(R.id.first_line_text_view);
        firstLineTextView.setText(currentItem.getFirstLine());
        TextView secondLineTextView = (TextView) listItemView.findViewById(R.id.second_line_text_view);
        secondLineTextView.setText(currentItem.getSecondLine());

        return listItemView;
    }
}
