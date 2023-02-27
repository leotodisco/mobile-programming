package com.example.aynctasks;

import static java.lang.Thread.sleep;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int counter;
    private TextView viewCounter;
    private ImageView img;
    private ProgressBar p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img = findViewById(R.id.image);
        viewCounter = findViewById(R.id.contatore_view);
        p = findViewById(R.id.progress_bar);

        counter = 0;
    }

    /**
     * incrementa il contatore.
     * @param v
     */
    public void counterButtonPressed(View v) {
        counter++;
        viewCounter.setText(""+counter);
    }

    /**
     * metodo che viene attivato quando si clicca sul pulsante "click"
     * @param v il bottone
     */
    public void loadImage(View v) {
        int id = R.drawable.image1;
        new LoadImageTask().execute(id);
    }

    /**
     * classe che estende un asyncTask.
     * I parametri sono Integer -> il tipo di parametro che si passa all'executor.
     *                  Integer -> tipo per il progress
     *                  Bitmap -> il risultato
     */
    class LoadImageTask extends AsyncTask<Integer, Integer, Bitmap> {

        /**
         * metodo che si esegue prima del task vero e proprio.
         */
        @Override
        protected void onPreExecute() {
            p.setVisibility(ProgressBar.VISIBLE);
        }

        /**
         * @param bitmap è del tipo di ritorno.
         *               In questo caso è Bitmap.
         */
        @Override
        protected void onPostExecute(Bitmap bitmap) {
            p.setVisibility(ProgressBar.INVISIBLE);
            p.setProgress(0);
            img.setImageBitmap(bitmap);
        }

        /**
         *
         * @param values array
         */
        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
        }

        /**
         *
         * @param integers è l'array dei parametri.
         * @return il tipo che sarà il risultato, stesso del parametro.
         */
        @Override
        protected Bitmap doInBackground(Integer... integers) {
            Bitmap tmp = BitmapFactory.decodeResource(getResources(), R.drawable.image1);

            for (int i = 1; i < 11; i++) {
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                publishProgress(i * 10);
            }

            return tmp;
        }
    }
}