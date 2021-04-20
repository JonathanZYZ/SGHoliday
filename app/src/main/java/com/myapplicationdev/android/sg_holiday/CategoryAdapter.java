package com.myapplicationdev.android.sg_holiday;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CategoryAdapter extends ArrayAdapter<Category> {
    private ArrayList<Category> category;
    private Context context;
    private TextView tvCategory;

    public CategoryAdapter(Context context, int resource, ArrayList<Category> objects){
        super(context, resource, objects);

        category = objects;
        this.context = context;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.row1, parent, false);


        tvCategory = (TextView) rowView.findViewById(R.id.tvCategory);




        Category currentYear = category.get(position);
        if (currentYear.getCategory().equals("Secular")){
            tvCategory.setText("Secular");
        }else if (currentYear.getCategory().equals("Ethnic & Religion")){
            tvCategory.setText("Ethnic & Religion");
        }



        return rowView;
    }
}
