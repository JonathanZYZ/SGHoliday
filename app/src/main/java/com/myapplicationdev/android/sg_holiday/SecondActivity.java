package com.myapplicationdev.android.sg_holiday;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    ListView lv;
    TextView tvCategory;
    ArrayList<Holiday> al;

    ArrayAdapter<Holiday> aa;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        lv = (ListView) this.findViewById(R.id.lvHoliday);
        tvCategory = (TextView) findViewById(R.id.tvCategory);

        Intent intent = getIntent();
        int text = intent.getIntExtra("Category", 0);




        al = new ArrayList<Holiday>();

        if(text == 0){
            tvCategory.setText("Secular");

            al.add(new Holiday("new-year","New Year's Day", "1 January 2021"));
            al.add(new Holiday("labour-day","Labour Day", "1 May 2021"));
        }
        else if(text == 1){
            tvCategory.setText("Ethnic & Religion");
            al.add(new Holiday("cny","Chinese New Year", "12-13 February 2021"));
            al.add(new Holiday("good-friday","Good Friday", "2 April 2021"));
        }

        aa = new HolidayAdapter(this,R.layout.row2,al);
        lv.setAdapter(aa);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Holiday pressed = al.get(position);
                Toast.makeText(SecondActivity.this,
                        ""+pressed.getHoliday()+" Date: "+pressed.getDate(), Toast.LENGTH_LONG)
                        .show();
            }
        });

    }
}
