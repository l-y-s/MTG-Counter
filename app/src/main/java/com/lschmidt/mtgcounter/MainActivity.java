package com.lschmidt.mtgcounter;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import java.util.*;
import android.support.annotation.NonNull;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    int counter = 20;
    boolean backButtonPressedTwice = false;

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
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()){
            case R.id.action_twoPlayer:
                switchTwoPlayer();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
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

    public void switchTwoPlayer(){
        Intent intent = new Intent(this, TwoPlayer.class);
        startActivity(intent);
        finish();
    }

    public void onBackPressed(){
        new AlertDialog.Builder(this)
                .setMessage("Do you want to exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })
                .setNegativeButton("No", null)
                .show();
    }
}
