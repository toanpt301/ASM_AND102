package com.example.ps37329_asm_and102.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.ps37329_asm_and102.database.DbHelper;

public class NguoiDungDAO {
    private DbHelper dbHelper;

    public NguoiDungDAO(Context context) {
        dbHelper = new DbHelper(context);
    }

    //login
    public boolean CheckLogin(String username, String password){
        SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();

        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM NGUOIDUNG WHERE tendangnhap = ? AND matkhau = ?", new String[]{username, password});


        // return cursor.getCount() > 0
        if(cursor.getCount() > 0){
            return true;
        }
        return false;
    }

    //register
    public boolean Register(String username, String password, String hoten){
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("tendangnhap", username);
        contentValues.put("matkhau", password);
        contentValues.put("hoten", hoten);

        long check = sqLiteDatabase.insert("NGUOIDUNG", null, contentValues);


        // return check != -1
        if(check != -1){
            return true;
        }
        return false;
    }


    //forgot
    public String ForgotPassword(String email){
        SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT matkhau FROM NGUOIDUNG WHERE tendangnhap = ?", new String[]{email});
        if (cursor.getCount() > 0){
            cursor.moveToFirst();
            return cursor.getString(0);
        } else {
            return "";
        }
    }
}
