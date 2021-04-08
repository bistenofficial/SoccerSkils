package com.example.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void goToSignUp(View v)
    {
        switch (v.getId()) {
            case R.id.textViewSignup:
                Intent intent = new Intent(this,MainActivity2.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}