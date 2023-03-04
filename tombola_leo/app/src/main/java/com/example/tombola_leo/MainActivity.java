package com.example.tombola_leo;

import android.app.Activity;
import android.app.Fragment;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

public class MainActivity extends Activity {
    private final int NUM_CARTELLE = 1;

    public static final int[][] numeri_nelle_cartelle = {
            {1, 21, 31, 56, 70, 14, 39, 44, 79, 82, 6, 27, 49, 65}, //prima cartella
            {2, 35, 57, 61, 80, 2, 29, 45, 63, 84, 3, 11, 37, 58},
            {3, 22, 46, 51, 75, 10, 23, 54, 78, 90, 8, 12, 36, 55},
            {4, 38, 52, 62, 83, 1, 20, 40, 53, 86, 18, 26, 42, 64},
            {5, 30, 59, 71, 88, 7, 24, 43, 66, 74, 19, 32, 48, 69},
            {6, 33, 41, 67, 76, 16, 34, 47, 68, 81, 9, 25, 50, 77},
            {7, 30, 40, 62, 82, 18, 31, 51, 68, 72, 4, 23, 56, 78},
            {8, 22, 45, 61, 85, 5, 10, 33, 52, 79, 15, 38, 53, 67},
            {9, 32, 57, 71, 80, 7, 27, 41, 63, 84, 11, 29, 44, 58},
            {10, 24, 43, 69, 86, 6, 26, 35, 59, 75, 17, 37, 46, 76},
            {11, 12, 34, 54, 73, 13, 25, 49, 55, 60, 19, 39, 65, 77},
            {9999, 21, 42, 50, 70, 16, 28, 47, 64, 81, 9, 36, 48, 66},
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        Fragment c = new Cartella();
        ((Cartella) c).setNumeri(numeri_nelle_cartelle[1]);
        int id = getResources().getIdentifier("frameCartella0", "id", getPackageName());
        ft.add(id++, c, null);

        ft.commit();
    }
}