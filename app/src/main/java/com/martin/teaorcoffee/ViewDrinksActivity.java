package com.martin.teaorcoffee;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class ViewDrinksActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_drinks);

        Intent intent = getIntent();
        ArrayList<DrinkChoice> drinks = intent.getParcelableArrayListExtra(MainActivity.EXTRA_DRINKS);
        int count = drinks.size();
        String countString = Integer.toString(count);

        TextView textView = new TextView(this);
        textView.setTextSize(40);
        textView.setText("I have " + countString + " drinks");

        ViewGroup layout = (ViewGroup) findViewById(R.id.activity_view_drinks);
        layout.addView(textView);

    }
}
