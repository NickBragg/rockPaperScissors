package com.example.patrick.rockpaperscissors;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Date;
import java.util.Random;


public class Result extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Intent intent = getIntent();
        String userChoice = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        String computerChoice = ComputerChoice();

        TextView textView = (TextView)findViewById(R.id.txtMessage);

        textView.setText(CompareChoices(userChoice,computerChoice));

    }
    private String CompareChoices(String user,String computer)
    {
        if(user == computer)
        {
            return "It's a tie";
        }
        else if (user == "rock"){
            if(computer == "scissors")
            {
                return "Computer chose scissors. You win!";
            }
            else
            {
                return "Computer chose paper. You lost!";
            }
        }
        else  if (user == "paper")
        {
            if(computer == "rock")
            {
                return "Computer chose rock. You win!";
            }
            else
            {
                return "Computer chose scissors. You lost!";
            }
        }
        else
        {
            if(computer == "rock"){
                return "Computer chose rock. You win!";
            }
            else
            {
                return "Computer chose paper. You lost!";
            }
        }
    }
    private String ComputerChoice()
    {
        ImageView imageView = (ImageView)findViewById(R.id.imageResult);

        Random random = new Random(new Date().getTime()+1);
        int randomNum = random.nextInt(3);
        switch (randomNum) {
            case 0:
                imageView.setImageResource(R.drawable.rock);
                return "rock";
            case 1:
                imageView.setImageResource(R.drawable.paper);
                return "paper";
            default:
                imageView.setImageResource(R.drawable.scissors);
                return "scissors";
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.result, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
