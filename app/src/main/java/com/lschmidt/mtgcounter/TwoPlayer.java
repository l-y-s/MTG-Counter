package com.lschmidt.mtgcounter;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;


public class TwoPlayer extends ActionBarActivity {

    int counter1 = 20;
    int counter2 = 20;
    boolean backButtonPressedTwice = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_player);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
    }

    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);

        outState.putInt("playerOneLife", counter1);
        outState.putInt("playerTwoLife", counter2);
    }

    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);

        counter1 = savedInstanceState.getInt("playerOneLife");
        counter2 = savedInstanceState.getInt("playerTwoLife");
        final TextView life1 = (TextView) findViewById(R.id.life1);
        final TextView life2 = (TextView) findViewById(R.id.life2);
        life1.setText((Integer.toString(counter1)));
        life2.setText(Integer.toString(counter2));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_two_player, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()){
            case R.id.action_onePlayer:
                switchOnePlayer();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void decrementLife1 (View view){
        counter1--;
        final TextView life1 = (TextView) findViewById(R.id.life1);
        life1.setText(Integer.toString(counter1));
    }

    public void decrement5Life1 (View view){
        counter1 = counter1 - 5;
        final TextView life1 = (TextView) findViewById(R.id.life1);
        life1.setText(Integer.toString(counter1));
    }

    public void decrementLife2 (View view){
        counter2--;
        final TextView life2 = (TextView) findViewById(R.id.life2);
        life2.setText(Integer.toString(counter2));
    }

    public void decrement5Life2 (View view){
        counter2 = counter2 - 5;
        final TextView life2 = (TextView) findViewById(R.id.life2);
        life2.setText(Integer.toString(counter2));
    }

    public void incrementLife1 (View view){
        counter1++;
        final TextView life1 = (TextView) findViewById(R.id.life1);
        life1.setText(Integer.toString(counter1));
    }

    public void increment5Life1 (View view){
        counter1 = counter1 + 5;
        final TextView life1 = (TextView) findViewById(R.id.life1);
        life1.setText(Integer.toString(counter1));
    }

    public void incrementLife2 (View view){
        counter2++;
        final TextView life2 = (TextView) findViewById(R.id.life2);
        life2.setText(Integer.toString(counter2));
    }

    public void increment5Life2 (View view) {
        counter2 = counter2 + 5;
        final TextView life2 = (TextView) findViewById(R.id.life2);
        life2.setText(Integer.toString(counter2));
    }

    public void switchOnePlayer() {
        Intent intent = new Intent(this, MainActivity.class);
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
