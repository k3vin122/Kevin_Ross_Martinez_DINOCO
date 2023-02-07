package com.iacc.kevin_ross_martinez_dinoco.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NOMBRE = "dinoco.db";
    public static final String TABLE_PRODUCTOS = "t_productos";


    public DbHelper(@Nullable Context context) {
        super(context, DATABASE_NOMBRE, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_PRODUCTOS + "(" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT," +
            " nombre TEXT NOT NULL," +
            " planta TEXT NOT NULL," +
            " cantidad TEXT NOT NULL," +
            " fecha TEXT NOT NULL)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(" DROP TABLE " + TABLE_PRODUCTOS);
        onCreate(sqLiteDatabase);
    }
}
