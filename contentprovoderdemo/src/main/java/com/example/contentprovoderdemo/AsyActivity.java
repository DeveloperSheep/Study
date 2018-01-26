package com.example.contentprovoderdemo;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class AsyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asy);

        new MyAsytask().execute("danger");

    }
    class MyAsytask extends AsyncTask<String,Void,Boolean>{

        public MyAsytask() {
            super();
        }

        @Override
        protected Boolean doInBackground(String... strings) {
            Log.i("test","doInBackground msg=="+strings[0]);
            return false;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(Boolean b) {
            super.onPostExecute(b);
            Log.i("test","onPostExecute ==="+b);
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }
    }
}
