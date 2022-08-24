package com.example.a613j;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;

import br.com.simplepass.loadingbutton.customViews.CircularProgressButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final CircularProgressButton upload = findViewById(R.id.imgBtnTest0);
        AsyncTask<String, Integer, String> task = new AsyncTask<String, Integer, String>() {
            @Override
            protected String doInBackground(String... strings) {
                for (int i = 0; i <= 100; i++) {
                    publishProgress(i);
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                return "yes";
            }

            @Override
            protected void onProgressUpdate(Integer... values) {
                upload.setProgress(values[0]);
                super.onProgressUpdate(values);
            }

            @Override
            protected void onPostExecute(String s) {
                if (s.equals("yes")) {
                    upload.doneLoadingAnimation(Color.parseColor("#ffffff"), BitmapFactory.decodeResource(getResources(), R.drawable.ic_baseline_cloud_upload_24));
                }
                super.onPostExecute(s);
            }
        };
        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                upload.startAnimation();
               // task.execute();
            }
        });
    }
}