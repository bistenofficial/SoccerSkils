package com.example.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Objects;

public class MainActivity2 extends AppCompatActivity {
private EditText login;
private EditText mail;
private EditText passOne;
private EditText passTwo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }
    public void goToAuth(View v)
    {
        switch (v.getId()) {
            case R.id.btnBack:
                startNewAc();
                break;
            case R.id.button2:
                startNewAc();
                break;
            default:
                break;
        }
    }
    public void startNewAc()
    {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
    public void SignUpCheck(View v)
    {
    login = (EditText) findViewById(R.id.editTextTextPersonName);
    mail = (EditText) findViewById(R.id.editTextTextPersonName4);
    passOne = (EditText) findViewById(R.id.editTextTextPassword);
    passTwo = (EditText) findViewById(R.id.editTextTextPassword3);
    Toast toast;
    if ((login.length()==0)||(mail.length()==0)||(passOne.length()==0)||(passTwo.length()==0))
    {
        toast = Toast.makeText(this, "Введены не все данные", Toast.LENGTH_LONG);
    }
    else
        toast = Toast.makeText(this, "Регистрация прошла успешно", Toast.LENGTH_LONG);
    toast.show();
        startNewAc();
    }
}