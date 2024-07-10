package com.example.ps37329_asm_and102.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {

    public DbHelper(Context context) {
        super(context, "PS37329ASM", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String qNguoiDung = "CREATE TABLE NGUOIDUNG(tendangnhap TEXT PRIMARY KEY, matkhau TEXT, hoten TEXT) ";
        db.execSQL(qNguoiDung);
        String qSanPham = "CREATE TABLE SANPHAM(masp INTEGER PRIMARY KEY AUTOINCREMENT, tensp TEXT, giaban INTEGER, soluong INTEGER) ";
        db.execSQL(qSanPham);

        String dNguoiDung = "INSERT INTO NGUOIDUNG VALUES('toanpt', '123', 'Phạm Thanh Toàn'), ('datnt', '123', 'Nguyễn Thành Đạt')";
        db.execSQL(dNguoiDung);

        String dSanPham = "INSERT INTO SANPHAM VALUES(1, 'Bánh', 5000, 30),(2, 'Kẹo', 2000, 40), (3, 'Kem', 10000, 20), (4, 'Sữa', 15000, 10)";
        db.execSQL(dSanPham);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion){
            db.execSQL("DROP TABLE IF EXISTS NGUOIDUNG");
            db.execSQL("DROP TABLE IF EXISTS SANPHAM");
            onCreate(db);
        }
    }
}
