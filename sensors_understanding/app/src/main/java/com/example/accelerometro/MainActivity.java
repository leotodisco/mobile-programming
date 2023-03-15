package com.example.accelerometro;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends Activity implements SensorEventListener {
    private static final int INTERVALLO = 250;
    private static final String TAG = "DEBUG";
    private final float UPDATE_WEIGHT = 0.85f;


    private TextView textViewX;
    private TextView textViewY;
    private TextView textViewZ;
    private TextView textViewXmedia;
    private TextView textViewYmedia;
    private TextView textViewZmedia;
    private TextView textViewXvariazione;
    private TextView textViewYvariazione;
    private TextView textViewZvariazione;

    private SensorManager sensorManager;
    private Sensor accelerometer;

    private long lastUpdate;

    private float mediaX = 0, mediaY = 0, mediaZ = 0;
    private boolean first_update = true;

    private ImageView imageViewPanariello;
    private TextView textViewNumero;

    private Animation animRotate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewX = (TextView) findViewById(R.id.textViewX);
        textViewY = (TextView) findViewById(R.id.textViewY);
        textViewZ = (TextView) findViewById(R.id.textViewZ);
        textViewXmedia = (TextView) findViewById(R.id.textViewXmedia);
        textViewYmedia = (TextView) findViewById(R.id.textViewYmedia);
        textViewZmedia = (TextView) findViewById(R.id.textViewZmedia);
        textViewXvariazione = (TextView) findViewById(R.id.textViewXvariazione);
        textViewYvariazione = (TextView) findViewById(R.id.textViewYvariazione);
        textViewZvariazione = (TextView) findViewById(R.id.textViewZvariazione);

        imageViewPanariello = (ImageView) findViewById(R.id.imageViewPanariello);
        textViewNumero = (TextView) findViewById(R.id.textViewNumero);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        accelerometer =	sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        if (accelerometer == null) {
            Log.e("ERROR","Non ho trovato l'accelerometro!!!");
            finish();
        }

        animRotate = AnimationUtils.loadAnimation(this, R.anim.rotate);
        animRotate.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                // TODO Auto-generated method stub
            }
            @Override
            public void onAnimationRepeat(Animation animation) {
                // TODO Auto-generated method stub
            }
            @Override
            public void onAnimationEnd(Animation animation) {
                genera_numero_casuale();
            }
        });

        //setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

    }


    // Register listener
    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this, accelerometer,SensorManager.SENSOR_DELAY_UI);
        lastUpdate = 0;
    }

    // Unregister listener
    @Override
    protected void onPause() {
        sensorManager.unregisterListener(this);
        super.onPause();
    }

    // Process new reading
    @Override
    public void onSensorChanged(SensorEvent event) {

        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {

            long now = System.currentTimeMillis();

            if (now - lastUpdate > INTERVALLO) {
                float x,y,z;
                x = event.values[0];
                y = event.values[1];
                z = event.values[2];


                textViewX.setText(String.format("%7.4f", x));
                textViewY.setText(String.format("%7.4f", y));
                textViewZ.setText(String.format("%7.4f", z));

                aggiorna_media(x,y,z);

                textViewXmedia.setText(String.format("%7.4f", mediaX));
                textViewYmedia.setText(String.format("%7.4f", mediaY));
                textViewZmedia.setText(String.format("%7.4f", mediaZ));

                float varX, varY, varZ;
                varX = x-mediaX;
                varY = y-mediaY;
                varZ = z-mediaZ;

                textViewXvariazione.setText(String.format("%7.4f", varX));
                textViewYvariazione.setText(String.format("%7.4f", varY));
                textViewZvariazione.setText(String.format("%7.4f", varZ));

                lastUpdate = now;

                float total = Math.abs(varX)+Math.abs(varY)+Math.abs(varZ);

                Log.d(TAG,"total = "+total);


                if (total > 1) {
                    final int NUM_VERSIONI_MISCHIA = 8;
                    Random rand = new Random();
                    int numeroCasuale = rand.nextInt(NUM_VERSIONI_MISCHIA)+1;
                    Log.d("DEBUG","Numero casuale = "+numeroCasuale);
                    String filename = "";
                    filename = String.format("panariello_mischia_%d",numeroCasuale);
                    MediaPlayer mp = MediaPlayer.create(this, getResources().getIdentifier(filename, "raw", getPackageName()));
                    if (mp != null) mp.start();
                }
                if (total > 4) {
                    Log.d("DEBUG","Animazione!");
                    textViewNumero.setText("");
                    imageViewPanariello.setImageResource(R.drawable.panariello);
                    imageViewPanariello.startAnimation(animRotate);
                }
            }
        }
    }

    public void lanciaAnimazione(View v) {
        final int NUM_VERSIONI_MISCHIA = 8;
        Random rand = new Random();
        int numeroCasuale = rand.nextInt(NUM_VERSIONI_MISCHIA)+1;
        Log.d("DEBUG","Numero casuale = "+numeroCasuale);
        String filename = "";
        filename = String.format("panariello_mischia_%d",numeroCasuale);
        MediaPlayer mp = MediaPlayer.create(this, getResources().getIdentifier(filename, "raw", getPackageName()));
        if (mp != null) mp.start();
        Log.d("DEBUG","Lancia Animazione!");
        textViewNumero.setText("");
        imageViewPanariello.setImageResource(R.drawable.panariello);
        imageViewPanariello.startAnimation(animRotate);
    }

    private void aggiorna_media(float x, float y, float z) {
        if (first_update) {
            mediaX = x;
            mediaY = y;
            mediaZ = z;
            first_update = false;
        } else {
            mediaX = UPDATE_WEIGHT*x+(1-UPDATE_WEIGHT)*mediaX;
            mediaY = UPDATE_WEIGHT*y+(1-UPDATE_WEIGHT)*mediaY;
            mediaZ = UPDATE_WEIGHT*z+(1-UPDATE_WEIGHT)*mediaZ;
        }
        return;
    }

    private void genera_numero_casuale() {
        Random rand = new Random();
        int numeroCasuale = rand.nextInt(90)+1;
        Log.d("DEBUG","Numero casuale = "+numeroCasuale);
        imageViewPanariello.setImageResource(0);
        textViewNumero.setText(""+numeroCasuale);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        // non ci serve fare niente, dobbiamo scriverlo perchè questo metodo
        // è richiesto dall'implementazione di SensorEventListener
    }
}
