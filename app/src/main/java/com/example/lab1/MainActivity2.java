package com.example.lab1;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {
    private EditText login;
    private EditText mail;
    private EditText passOne;
    private EditText passTwo;
    DBHelper dbHelper;
    final String LOG_TAG = "MyLogs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        dbHelper = new DBHelper(this);
    }

    public void goToAuth(View v) {
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

    public void startNewAc() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public boolean CheckExist(String mail, String login) {
        int i = 0;
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Log.d(LOG_TAG, "---Rows in mytable---");
        Cursor c = db.query("mytable", null, null, null, null, null, null);
        if (c.moveToFirst()) {
            int loginColIndex = c.getColumnIndex("login");
            int mailColIndex = c.getColumnIndex("mail");
            do {
                if (c.getString(loginColIndex).equals(login) || c.getString(mailColIndex).equals(mail)) {
                    i = i + 1;
                }
            } while (c.moveToNext());
        } else
            Log.d(LOG_TAG, "0 ROWS");
        c.close();
        if (i == 0) return true;
        else return false;

    }

    public void SignUpCheck(View v) {
        ContentValues cv = new ContentValues();
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        login = (EditText) findViewById(R.id.editTextTextPersonName);
        mail = (EditText) findViewById(R.id.editTextTextPersonName4);
        passOne = (EditText) findViewById(R.id.editTextTextPassword);
        passTwo = (EditText) findViewById(R.id.editTextTextPassword3);

        Toast toast;
        if ((login.length() == 0) || (mail.length() == 0) || (passOne.length() == 0) || (passTwo.length() == 0)) {
            toast = Toast.makeText(this, "Введены не все данные", Toast.LENGTH_LONG);
        } else {
            if (passOne.getText().toString().equals(passTwo.getText().toString())) {
                if (CheckExist(mail.getText().toString(), login.getText().toString())) {
                    Log.d(LOG_TAG, "---Insert in my table---");
                    cv.put("login", login.getText().toString());
                    cv.put("mail", mail.getText().toString());
                    cv.put("pass", passOne.getText().toString());
                    cv.put("col", 0);
                    long rowID = db.insert("mytable", null, cv);
                    Log.d(LOG_TAG, "---ROW inserted---,ID = " + rowID);
                    toast = Toast.makeText(this, "Регистрация прошла успешно", Toast.LENGTH_LONG);
                    startNewAc();
                } else {
                    toast = Toast.makeText(this, "Логин или почта повторяются", Toast.LENGTH_LONG);
                }
            } else toast = Toast.makeText(this, "Пароли на совпадают", Toast.LENGTH_LONG);
        }
        toast.show();
    }
}