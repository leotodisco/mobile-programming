package com.example.animations_understanding;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView iv;
    Drawable d;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv = (ImageView) findViewById(R.id.image_view);
        d = getResources().getDrawable(R.drawable.image);
        iv.setImageDrawable(d);

        /**
         * andiamo a prendere l'animazione dal file xml.
         * nell'identifier i parametri sono:
         * nome_file_xml - nome_cartella - getPackageName()
         */
        Animation a = AnimationUtils.loadAnimation(getApplicationContext(), getResources().getIdentifier("anim1", "anim", getPackageName()));
        a.setStartOffset(100);

        /**
         * settiamo animazione sulla ImageView.
         */
        iv.setAnimation(a);
    }
}