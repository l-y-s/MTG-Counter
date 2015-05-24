package com.lschmidt.mtgcounter;

import android.support.annotation.NonNull;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import java.util.*;
import android.support.annotation.NonNull;


public class MainActivity extends ActionBarActivity {

    int counter = 20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView life = (TextView) findViewById(R.id.life);
        life.setText(Integer.toString(counter));

    }

    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);

        outState.putInt("currentLife", counter);
    }

    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);

        counter = savedInstanceState.getInt("currentLife");
        final TextView life = (TextView) findViewById(R.id.life);
        life.setText((Integer.toString(counter)));
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

    public void decrement(View view) {
        counter--;
        final TextView life = (TextView) findViewById(R.id.life);
        life.setText(Integer.toString(counter));
    }

    public void increment(View view) {
        counter++;
        final TextView life = (TextView) findViewById(R.id.life);
        life.setText(Integer.toString(counter));
    }

    public void decrement5 (View view) {
        counter = counter - 5;
        final TextView life = (TextView) findViewById(R.id.life);
        life.setText(Integer.toString(counter));
    }

    public void increment5(View view) {
        counter = counter + 5;
        final TextView life = (TextView) findViewById(R.id.life);
        life.setText(Integer.toString(counter));
    }
}
