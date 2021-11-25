package com.misiontic.holamundo05.listviews;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.misiontic.holamundo05.R;
import com.misiontic.holamundo05.model.Persona;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ContactListViewAdapter extends ArrayAdapter<Persona> {

    ArrayList<Persona> list;
    Context context;

    public ContactListViewAdapter(Context context, ArrayList<Persona> items) {
        super(context, R.layout.contact_list_row, items);
        this.context = context;
        list = items;
    }

    public View getView (int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.contact_list_row, null);
        }

        TextView tvContactName = convertView.findViewById(R.id.tvContactName);
        TextView tvPhone = convertView.findViewById(R.id.tvContactPhone);

        String fullname = list.get(position).getNombres() + " " + list.get(position).getApellidos();

        tvContactName.setText(fullname);
        tvPhone.setText(list.get(position).getTelefono());

        return convertView;

    }

}
