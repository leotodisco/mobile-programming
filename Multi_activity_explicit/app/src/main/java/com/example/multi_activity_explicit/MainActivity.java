package com.example.multi_activity_explicit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openInstagram(View v) {
        String url = "https://www.instagram.com/";
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url));

        startActivity(i);

    }
}