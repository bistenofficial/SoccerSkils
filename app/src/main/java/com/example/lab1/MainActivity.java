package com.example.lab1;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText login;
    private EditText pass;
    DBHelper dbHelper;
    final String LOG_TAG = "MyLogs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login = (EditText) findViewById(R.id.editTextTextPersonName);
        pass = (EditText) findViewById(R.id.editTextTextPassword);
        dbHelper = new DBHelper(this);
    }


    public void goToSignUp(View v) {
        switch (v.getId()) {
            case R.id.textViewSignup:
                Intent intent = new Intent(this, MainActivity2.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }

    public void goDoneAuth(View v) {
        Toast toast;
        switch (v.getId()) {
            case R.id.button:
                SQLiteDatabase db = dbHelper.getReadableDatabase();
                ContentValues cv = new ContentValues();
                SQLiteDatabase dbWrite = dbHelper.getWritableDatabase();
                Cursor c = db.rawQuery("select * from mytable where login = ? and pass = ?", new String[]{login.getText().toString(), pass.getText().toString()});
                if (c.getCount() > 0) {
                    c.moveToFirst();
                    int enterCountColIndex = c.getColumnIndex("col");
                    int enterCount = c.getInt(enterCountColIndex)+1;
                    cv.put("col", enterCount);
                    String name = login.getText().toString();
                    dbWrite.update("mytable", cv, "login = ?", new String[]{name});
                    Intent intent = new Intent(this, MainActivity3.class);
                    intent.putExtra("login", login.getText().toString());
                    intent.putExtra("pass", pass.getText().toString());
                    intent.putExtra("EC", String.valueOf(enterCount));
                    startActivity(intent);
                    toast = Toast.makeText(this, "Вы вошли в аккаунт " + login.getText().toString(), Toast.LENGTH_LONG);
                } else {
                    toast = Toast.makeText(this, "Логин или пароль не правильный", Toast.LENGTH_LONG);
                }
                c.close();
                toast.show();
                break;
            default:
                break;
        }
    }
}