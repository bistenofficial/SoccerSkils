package com.example.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {
private TextView log;
private TextView pas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        log = (TextView) findViewById(R.id.textView3);
        pas= (TextView) findViewById(R.id.textView5);
        String txtlog = getIntent().getStringExtra("login");
        String txtpas = getIntent().getStringExtra("pass");
        log.setText(log.getText().toString()+" "+txtlog);
        pas.setText(pas.getText().toString()+" "+txtpas);
    }
    public void goToAuth1(View v)
    {
        switch (v.getId()) {
            case R.id.button2:
                Intent intent = new Intent(this,MainActivity.class);
                startActivity(intent);

                break;
            default:
                break;
        }
    }
}