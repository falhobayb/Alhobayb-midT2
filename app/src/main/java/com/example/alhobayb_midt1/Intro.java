package com.example.alhobayb_midt1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Intro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DBHelper dbHelper = new DBHelper(this);
        setContentView(R.layout.activity_intro);
        setTitle("This is Activity1");

        Button go2 = findViewById(R.id.btn_go_3act1);
        Button go3 = findViewById(R.id.btn_go_3act2);

        Button add = findViewById(R.id.buttonAdd);

        EditText inp_id = findViewById(R.id.inp_id);
        EditText inp_fname = findViewById(R.id.inp_fname);
        EditText inp_email = findViewById(R.id.inp_email);
        EditText inp_phone = findViewById(R.id.inp_phone);
        EditText inp_pid = findViewById(R.id.inp_pid);


        TextView txt = findViewById(R.id.textView3);


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHelper.insert(inp_id.getText().toString(), inp_fname.getText().toString(), inp_email.getText().toString(), inp_phone.getText().toString(), inp_pid.getText().toString());
            }
        });

        go2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intro.this,MainActivity2.class));
            }
        });
        go3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intro.this,MainActivity3.class));
            }
        });


    }
}
