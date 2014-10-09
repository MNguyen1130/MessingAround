package com.mnguyen1130.messingaround;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyAdapter extends ArrayAdapter<String> {


    public MyAdapter(Context context, String[] values) {
        super(context, R.layout.row_layout_2, values);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());

        View view = inflater.inflate(R.layout.row_layout_2, parent, false);

        String tvShow = getItem(position);

        TextView textView = (TextView) view.findViewById(R.id.textView1);

        textView.setText(tvShow);

        ImageView imageView = (ImageView) view.findViewById(R.id.imageView1);

        imageView.setImageResource(R.drawable.dot);

        return view;
    }
}
