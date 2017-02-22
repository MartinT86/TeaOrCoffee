package com.martin.teaorcoffee;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class ViewDrinksActivity extends AppCompatActivity {

    private ArrayList<DrinkChoice> _drinks;
    private int _baseButtonId = 1000;
    private int _baseRowId = 2000;
    int _idInt = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_drinks);

        Intent intent = getIntent();
        _drinks = intent.getParcelableArrayListExtra(MainActivity.EXTRA_DRINKS);

        DisplayDrinks();
    }

    View.OnClickListener removeClickListener(final Button button)  {
        return new View.OnClickListener() {
            public void onClick(View v) {

                int buttonId = v.getId();
                String buttonIdString = Integer.toString(buttonId);
                String layoutIdString = "2" + buttonIdString.substring(1);

                LinearLayout row = (LinearLayout) findViewById(Integer.parseInt(layoutIdString));
                LinearLayout layout = (LinearLayout) findViewById(R.id.activity_view_drinks_list);

                layout.removeView(row);
            }
        };
    }


    private void DisplayDrinks() {
        ViewGroup layout = (ViewGroup) findViewById(R.id.activity_view_drinks_list);

        for(DrinkChoice drinkChoice : _drinks){
            LinearLayout linearLayout = new LinearLayout(this);
            linearLayout.setOrientation(LinearLayout.HORIZONTAL);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1f);
            linearLayout.setLayoutParams(params);
            String rowIdString = _baseRowId + "" + _idInt;
            linearLayout.setId(Integer.parseInt(rowIdString));

            TextView textView = new TextView(this);
            textView.setTextSize(25);
            textView.setText(drinkChoice.Message());
            LinearLayout.LayoutParams textViewParams = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1f);
            textView.setLayoutParams(textViewParams);

            Button button = new Button(this);
            LinearLayout.LayoutParams buttonParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            buttonParams.gravity = Gravity.CENTER_VERTICAL;
            button.setLayoutParams(buttonParams);
            button.setText("Remove");
            String buttonIdString = _baseButtonId + "" + _idInt;
            button.setId(Integer.parseInt(buttonIdString));
            button.setOnClickListener(removeClickListener(button));

            linearLayout.addView(textView);
            linearLayout.addView(button);

            layout.addView(linearLayout);

            _idInt++;
        }
    }
}
