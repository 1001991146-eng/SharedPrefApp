package com.example.sharedprefapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RegisterActivity extends AppCompatActivity {

    private MyDB myDB;
    private EditText etSUName, etSUPass;

    public void init() {
        myDB = new MyDB(this);
        etSUName = findViewById(R.id.etSUName);
        etSUPass = findViewById(R.id.etSUPass);
    }
    public void performRegister(View view)
    {
        String uName = etSUName.getText().toString();
        String uPAss = etSUPass.getText().toString();
        // יצירת מופע של בסיס הנתונים על מנת לגשת אליו
        myDB = new MyDB();
        myDB.saveUserName(uName);
        myDB.savePassword(uPAss);
        Intent intent=new Intent(RegisterActivity.this,MainActivity.class);
        startActivity(intent);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);

        init();


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}