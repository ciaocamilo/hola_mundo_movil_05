package com.misiontic.holamundo05.listviews;

import android.content.Context;
import android.widget.ArrayAdapter;

import com.misiontic.holamundo05.R;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class ContactListViewAdapter extends ArrayAdapter<String> {

    ArrayList<String> list;
    Context context;

    public ContactListViewAdapter(Context context, ArrayList<String> items) {
        super(context, R.layout.contact_list_row, items);
        this.context = context;
        list = items;
    }

}
