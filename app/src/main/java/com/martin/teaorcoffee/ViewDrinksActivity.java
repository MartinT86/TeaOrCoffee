package com.martin.teaorcoffee;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class ViewDrinksActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_drinks);

        Intent intent = getIntent();
        ArrayList<DrinkChoice> drinks = intent.getParcelableArrayListExtra(MainActivity.EXTRA_DRINKS);
        ViewGroup layout = (ViewGroup) findViewById(R.id.activity_view_drinks_list);

        for(DrinkChoice drinkChoice : drinks){
            TextView textView = new TextView(this);
            textView.setTextSize(40);

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1f);
            textView.setLayoutParams(params);

            textView.setText(drinkChoice.Message());


            layout.addView(textView);

        }
    }
}
