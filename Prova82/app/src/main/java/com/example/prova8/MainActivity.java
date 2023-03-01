package com.example.prova8;

import static java.lang.Thread.sleep;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    ListView lw;
    ArrayAdapter<String> adapter;
    List<String> list;
    Drawable d;
    ImageView img;
    ProgressBar pb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pb = findViewById(R.id.progress_bar);

        lw = (ListView) findViewById(R.id.lista);
        list = List.of("1", "2", "3", "4", "6", "7", "8", "9");
        d = getResources().getDrawable(R.drawable.im);

        adapter = new ArrayAdapter<>(this, R.layout.elemento, list);
        lw.setAdapter(adapter);
        lw.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        mostraImmagine();
                    }
                }
        );
        img = (ImageView) findViewById(R.id.immagine);
    }


    public void mostraImmagine() {
        new ImgShower().execute();
    }




    class ImgShower extends AsyncTask<String, Integer, Drawable> {

        @Override
        protected void onPreExecute() {
            pb.setVisibility(ProgressBar.VISIBLE);
        }

        @Override
        protected void onPostExecute(Drawable drawable) {
            pb.setVisibility(ProgressBar.INVISIBLE);
            setProgress(0);
            img.setImageDrawable(d);
        }


        @Override
        protected Drawable doInBackground(String... strings) {
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            publishProgress(100);
            return d;
        }
    }
}

