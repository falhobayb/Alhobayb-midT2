package com.example.alhobayb_midt1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DBHelper dbHelper=new DBHelper(this);
        setTitle("This is Activity2");
        setContentView(R.layout.activity_main2);

        Button go1=findViewById(R.id.btn_go_3act1);
        Button go3=findViewById(R.id.btn_go_3act2);

        Button search=findViewById(R.id.button);

        EditText input=findViewById(R.id.input);

        TextView txt = findViewById(R.id.textView4);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor c=dbHelper.getSpecificResult(input.getText().toString());

                txt.setText("Match Found: "+ c);

            }
        });

        go1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity2.this,Intro.class));
            }
        });
        go3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity2.this,MainActivity3.class));
            }
        });

    }
}