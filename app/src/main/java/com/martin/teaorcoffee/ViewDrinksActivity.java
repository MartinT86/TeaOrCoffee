package com.martin.teaorcoffee;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class ViewDrinksActivity extends AppCompatActivity {

    private ArrayList<DrinkChoice> _drinks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_drinks);

        Intent intent = getIntent();
        _drinks = intent.getParcelableArrayListExtra(MainActivity.EXTRA_DRINKS);

        DisplayDrinks();
    }

    public void removeDrink(View view){
        int buttonId = view.getId();
    }

    private void DisplayDrinks() {

        ViewGroup layout = (ViewGroup) findViewById(R.id.activity_view_drinks_list);

        for(DrinkChoice drinkChoice : _drinks){
            LinearLayout linearLayout = new LinearLayout(this);
            linearLayout.setOrientation(LinearLayout.HORIZONTAL);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1f);
            linearLayout.setLayoutParams(params);

            TextView textView = new TextView(this);
            textView.setTextSize(30);
            textView.setText(drinkChoice.Message());
            LinearLayout.LayoutParams textViewParams = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1f);
            textView.setLayoutParams(textViewParams);

            Button button = new Button(this);
            LinearLayout.LayoutParams buttonParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            buttonParams.gravity = Gravity.CENTER_VERTICAL;
            button.setLayoutParams(buttonParams);
            button.setText("Remove");

            linearLayout.addView(textView);
            linearLayout.addView(button);

            layout.addView(linearLayout);
        }
    }
}
