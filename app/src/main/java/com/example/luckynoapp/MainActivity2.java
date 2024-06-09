package com.example.luckynoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity2 extends AppCompatActivity {

    TextView lucky_num_txt, textview2;
    Button share_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        textview2=findViewById(R.id.textview2);
        lucky_num_txt=findViewById(R.id.lucky_num_txt);
        share_btn=findViewById(R.id.share_btn);

        //REceiving the data from main Activity
        Intent i=getIntent();
        String userName=i.getStringExtra("name");
        //Generate Random Number
        int random_num=generateRandomNumber();
        lucky_num_txt.setText(""+random_num);
        share_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShareData(userName,random_num);
            }
        });
    }

    public void ShareData(String username, int randomNum) {
        //Implicit Intent
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");
        i.putExtra(Intent.EXTRA_SUBJECT,username+"got lucky today!");
        i.putExtra(Intent.EXTRA_TEXT,"His lucky number is :"+randomNum);
        startActivity(Intent.createChooser(i,"Choose a Platform"));

    }
    public int generateRandomNumber(){
        Random random=new Random();
        int upper_limit=1000;
        int randomNumberGenerated= random.nextInt(upper_limit);
        return randomNumberGenerated;
    }
}

