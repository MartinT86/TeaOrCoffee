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
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public DrinkChoice _drinkChoice;
    public ArrayList<DrinkChoice> _drinks;
    public final static String EXTRA_DRINKS = "TeaOrCoffee.DRINKS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _drinkChoice = new DrinkChoice();
        _drinks = new ArrayList<DrinkChoice>();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public void setTea(View view) {
        _drinkChoice.Type = "Tea";
        DisplayCurrentDrink();
    }

    public void setCoffee(View view) {
        _drinkChoice.Type = "Coffee";
        DisplayCurrentDrink();
    }

    public void setMilk(View view) {
        _drinkChoice.Milk = true;
        DisplayCurrentDrink();
    }

    public void setNoMilk(View view) {
        _drinkChoice.Milk = false;
        DisplayCurrentDrink();
    }

    private void DisplayCurrentDrink() {
        TextView textView = (TextView) findViewById(R.id.current_drink_message);
        textView.setText(_drinkChoice.Message());
    }

    public void setNoSugar(View view){
        _drinkChoice.Sugars = 0;
        DisplayCurrentDrink();
    }

    public void setOneSugar(View view){
        _drinkChoice.Sugars = 1;
        DisplayCurrentDrink();
    }

    public void setTwoSugar(View view){
        _drinkChoice.Sugars = 2;
        DisplayCurrentDrink();
    }

    public void addCurrentDrink(View view){
        if(_drinkChoice.Type != null && _drinkChoice.Sugars != null && _drinkChoice.Milk != null) {
            _drinks.add(_drinkChoice);
            TextView textView = (TextView) findViewById(R.id.drink_count_message);
            textView.setText(_drinks.size() + " drinks");
            _drinkChoice = new DrinkChoice();
            DisplayCurrentDrink();
        }
    }

    public void viewDrinks(View view){
        Intent intent = new Intent(this, ViewDrinksActivity.class);
        intent.putParcelableArrayListExtra(EXTRA_DRINKS, _drinks);
        startActivity(intent);

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
