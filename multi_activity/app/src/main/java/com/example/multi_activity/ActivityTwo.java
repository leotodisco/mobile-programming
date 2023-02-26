package com.example.multi_activity;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;

/**
 * Activity base
 * Ogni activity deve essere indicata nel file AndroidManifest.xml
 */
public class ActivityTwo extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);
    }



}
