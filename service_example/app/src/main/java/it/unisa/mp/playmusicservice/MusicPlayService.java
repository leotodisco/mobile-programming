package it.unisa.mp.playmusicservice;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class MusicPlayService extends Service {
	MediaPlayer mp;
	int service_id;
	
	public void onCreate() {
		super.onCreate();
		Log.d("DEBUG","MusicPlayService created");
		
		mp = MediaPlayer.create(this, getResources().getIdentifier("per_elisa_beethoven", "raw", getPackageName()));
		}	


	@Override
	public int onStartCommand(Intent i, int flags, int id) {
		Toast.makeText(this, "metodo start", Toast.LENGTH_SHORT).show();
		Log.d("DEBUG","Service playing music ...");
		if (mp != null) {
			service_id = id;
			if (mp.isPlaying()) {
				mp.seekTo(0);
			}
			else {
				mp.start();
			}
		}
		//Non fa ripartire automaticamente il servizio se viene fermato
		return START_NOT_STICKY;
	}
	
	@Override
	public void onDestroy() {
		if (mp != null) {
			mp.start();
			mp.release();
		}
	}




	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}
