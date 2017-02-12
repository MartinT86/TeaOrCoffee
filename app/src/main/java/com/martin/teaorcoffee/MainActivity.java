package com.martin.teaorcoffee;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public DrinkChoice _drinkChoice;
    public String _drinkMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _drinkChoice = new DrinkChoice();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void setTea(View view) {
        _drinkChoice.Type = "Tea";
        AddToMessage(_drinkChoice.Type);
        DisplayCurrentDrink();
    }

    private void AddToMessage(String stringToAdd) {
        if (_drinkMessage == null)
            _drinkMessage = stringToAdd;
        else
        _drinkMessage += stringToAdd;
    }

    public void setCoffee(View view) {
        _drinkChoice.Type = "Coffee";
        AddToMessage(_drinkChoice.Type);
        DisplayCurrentDrink();
    }

    public void setMilk(View view) {
        _drinkChoice.Milk = true;
        AddToMessage(" with milk");
        DisplayCurrentDrink();
    }

    public void setNoMilk(View view) {
        _drinkChoice.Milk = false;
        AddToMessage(" with no milk");
        DisplayCurrentDrink();
    }

    private void DisplayCurrentDrink() {
        TextView textView = (TextView) findViewById(R.id.current_drink_message);
        textView.setText(_drinkMessage);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
