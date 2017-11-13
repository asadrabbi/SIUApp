package com.example.asad.siuapp.Home.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.shobojit.siuapp.R;

import java.util.ArrayList;

/**
 * Created by SHOBOJIT on 12/18/2016.
 */

public class ArrayAdap extends ArrayAdapter<String> {
    private Context context;
    private ArrayList<String> date;
    private ArrayList<String>notice;

    public ArrayAdap(Context c, ArrayList<String> date, ArrayList<String> notice) {
        super(c, R.layout.noticelist, R.id.nm,notice);
        this.context = c;
        this.date = date;
        this.notice = notice;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row= inflater.inflate(R.layout.noticelist, null, true);
        TextView d = (TextView) row.findViewById(R.id.nd);
        TextView n = (TextView) row.findViewById(R.id.nm);
        d.setText(date.get(position));
        n.setText(notice.get(position));
        return row;
    }
}