package it.unisa.mp.playmusicservice;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class Client extends Activity {
	Intent musicPlayService;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		musicPlayService = new Intent(getApplicationContext(), it.unisa.mp.playmusicservice.MusicPlayService.class);
	}
	
	public void startService(View v) {
		Log.d("DEBUG","Starting Music Service");
		/**
		 * questo metodo chiama automaticamente il metodo di start del service.
		 */
		startService(musicPlayService);
	}

	public void stopService(View v) {
		Log.d("DEBUG","Stopping Music Service");
		stopService(musicPlayService);
	}

}
