package com.example.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText login;
    private EditText pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login = (EditText) findViewById(R.id.editTextTextPersonName);
        pass= (EditText) findViewById(R.id.editTextTextPassword);
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
    public void goDoneAuth(View v)
    {
        switch (v.getId()) {
            case R.id.button:
                Intent intent = new Intent(this,MainActivity3.class);
                intent.putExtra("login",login.getText().toString());
                intent.putExtra("pass",pass.getText().toString());
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}