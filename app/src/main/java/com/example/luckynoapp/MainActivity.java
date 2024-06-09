package com.example.luckynoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button btn;
    TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt=findViewById(R.id.textview);
        btn=findViewById(R.id.btn);
        editText=findViewById(R.id.edit_text);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName=editText.getText().toString();
                //explicit intent
                Intent intent = new Intent(
                        getApplicationContext(),
                        MainActivity2.class
                );
                //passing the name to second activity
                intent.putExtra("name",userName);
                startActivity(intent);
            }


        });

    }


}