package com.myapplicationdev.android.sg_holiday;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class HolidayAdapter extends ArrayAdapter<Holiday> {
    private Context context;
    private ArrayList<Holiday> holiday;
    private TextView tvHoliday, tvDate;
    private ImageView ivPhoto;
    public HolidayAdapter(Context context,int resource,ArrayList<Holiday> objects){
        super(context,resource,objects);
        holiday = objects;
        this.context=context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.row2, parent, false);

        tvHoliday = (TextView) rowView.findViewById(R.id.tvHoliday);

        ivPhoto = (ImageView) rowView.findViewById(R.id.ivProg);

        tvDate = (TextView) rowView.findViewById(R.id.tvDate);


        Holiday currentHoliday = holiday.get(position);

        tvHoliday.setText(currentHoliday.getHoliday());

        if(currentHoliday.isPhoto() == "new-year") {
            ivPhoto.setImageResource(R.drawable.newyear);
            tvDate.setText("1 January 2021");
        }
        else if(currentHoliday.isPhoto() == "labour-day") {
            ivPhoto.setImageResource(R.drawable.labourday);
            tvDate.setText("1 May 2021");
        }
        else if(currentHoliday.isPhoto() == "cny") {
            ivPhoto.setImageResource(R.drawable.cny);
            tvDate.setText("12-13 February 2021");
        }
        else if(currentHoliday.isPhoto() == "good-friday") {
            ivPhoto.setImageResource(R.drawable.goodfriday);
            tvDate.setText("2 April 2021");
        }

        return rowView;
    }
}
