package com.example.contentprovoderdemo;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Contacts;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getName();
    String name = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void relation(View view) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                ContentResolver contentResolver = getContentResolver();
                Uri contentUri = Contacts.People.CONTENT_URI;
                String[] pro = {Contacts.People._ID, Contacts.People.NAME, Contacts.People.NUMBER};
                // 设置查询条件，这里我把selection和selectionArgs参数都设为null，表示查询全部数据
                String selection = null;
                String[] selectionArgs = null;
                if (!"".equals(name)) {
                    selection = Contacts.People.NAME + "=?";
                    selectionArgs = new String[]{name};
                }
                Cursor cursor = contentResolver.query(contentUri, pro, selection, selectionArgs, Contacts.People._ID);
                Log.i("test", cursor.getCount() + "");
                if (cursor.moveToFirst()) {
                    for (int i = 0; i < cursor.getCount(); i++) {
                        cursor.moveToPosition(i);
//                        Log.i(TAG, String.valueOf(cursor.getColumnIndexOrThrow(Contacts.People.NAME)));
//                        Log.i(TAG, String.valueOf(cursor.getColumnIndexOrThrow(Contacts.People.NUMBER)));
                        Log.i(TAG, cursor.getString(cursor.getColumnIndexOrThrow(Contacts.People.NAME)));
                    }
                }
            }
        }).start();

    }

    public void delete(View view) {
        ContentResolver contentResolver = getContentResolver();
        Uri contentUri = Contacts.People.CONTENT_URI;
        String where = Contacts.People.NAME + "=?";
        String[] selectionArgs = new String[]{"深圳市华达正科技有限公司"};
        contentResolver.delete(contentUri, where, selectionArgs);
    }
}
