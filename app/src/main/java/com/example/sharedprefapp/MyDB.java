package com.example.sharedprefapp;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.SharedPreferences;

public class MyDB {
    private static SharedPreferences sp;
    private static SharedPreferences.Editor speEdit;
    private static Context cnt;

    public MyDB(Context context){
        cnt = context;
        sp = cnt.getSharedPreferences("User Details", MODE_PRIVATE);
        speEdit = sp.edit();
    }

    MyDB(){

    }

    public void saveUserName(String userName){
        speEdit.putString("UserName", userName);
        speEdit.commit();
    }

    public void savePassword(String password){
        speEdit.putString("Password", password);
        speEdit.commit();
    }

    public String getUserName(){
        return sp.getString("UserName", "No name");
    }

    public String getPassword(){
        return sp.getString("Password", "No password");
    }
}
