package com.example.administrator.study;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 2018/1/26 0026.
 */

public class SqlLiteHelper extends SQLiteOpenHelper {
    public SqlLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, "test.db", factory, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE person (_id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR, age SMALLINT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
