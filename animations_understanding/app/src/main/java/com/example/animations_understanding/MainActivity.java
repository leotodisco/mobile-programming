package com.example.animations_understanding;

import static android.widget.Toast.LENGTH_LONG;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

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

        /**
         * SETTIAMO LISTENER PER FARE UN EVENTO QUANDO TERMINA L'ANIMAZIONE
         */
        a.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Toast.makeText(getApplicationContext(), "animazione finita", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
}