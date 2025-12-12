package com.example.sharedprefapp;

import static android.widget.Toast.LENGTH_LONG;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private MyDB myDB;
    private EditText etUName, etPass;

    public void init() {
        myDB = new MyDB(this);
        etUName = findViewById(R.id.etUName);
        etPass = findViewById(R.id.etPass);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        init();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void register(View v)
    {
        Intent intent=new Intent(MainActivity.this, RegisterActivity.class);
        startActivity(intent);
    }
    public void login(View v) {
// לקיחת המידע המוקלד על ידי המשתמש.ת לשדות שם משתמש וסיסמה
        String uName = etUName.getText().toString();
        String uPAss = etPass.getText().toString();
// יצירת מופע של בסיס הנתונים על מנת לגשת אליו
        myDB = new MyDB();
//בדיקת הערכים שהוקלדו אל מול מה שמאוכסן בבסיס הנתונים
        if (uName.equals(myDB.getUserName()) && uPAss.equals(myDB.getPassword())) {
            Intent gameIntent = new Intent(this, GameActivity.class);
            startActivity(gameIntent);
        }
        else {
            if (!uName.equals(myDB.getUserName())) {
                etUName.setError("Username not found");
                Toast.makeText(this, "Username not found", LENGTH_LONG).show();
            }
            else {
                etPass.setError("Wrong password");
                Toast.makeText(this, "Wrong password", LENGTH_LONG).show();

            }
        }
    }

}