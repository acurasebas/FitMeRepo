package com.fitmetracker.fitme;

import java.util.Locale;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockActivity;
import android.speech.tts.TextToSpeech;
import android.widget.Button;
import android.app.Activity;


public class MainScreenActivity extends SherlockActivity implements ActionBar.OnNavigationListener, TextToSpeech.OnInitListener {

	private String[] itemsMenu;
	private TextToSpeech tts;
	private Button btnSpeak;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainscreen_activity);
        
        tts = new TextToSpeech(this, this);
        btnSpeak = (Button) findViewById(R.id.btnSpeak); // ACORDARSE DE BORRAR EL BOTON!!
        
        btnSpeak.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				speakOut();
				
			}
		});
        
        itemsMenu = getResources().getStringArray(R.array.dropdownListMain);
        
        Context context = getSupportActionBar().getThemedContext();
        ArrayAdapter<CharSequence> list = ArrayAdapter.createFromResource(context, R.array.dropdownListMain, R.layout.sherlock_spinner_dropdown_item);
        
        getSupportActionBar().setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);
        getSupportActionBar().setListNavigationCallbacks(list,  this);
        getSupportActionBar().setTitle("FitMe Home"); 
    }

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mainscreen_activity, menu);
        return true;
    }*/

	public boolean onNavigationItemSelected(int itemPosition, long itemId) {
		// When tap on an item, it takes you to the Activity
		if(itemPosition == 0){
			// Doesn't do anything as the user is already in the home screen
			return true;
		} else if(itemPosition == 1){
			// Creates the new intent that will take you to the Stats screen
			Intent i = new Intent(getApplicationContext(), StatsActivity.class);
			
			startActivity(i);
			finish();
			return true;
			
		} else if(itemPosition == 2){
			// Creates the new intent that will take you to the Option Screen
			Intent i = new Intent(getApplicationContext(), OptionsActivity.class);
			
			startActivity(i);
			finish();
			return true;
		}
		else
			return false;
	}

	public void onInit(int status) {
		if(status == TextToSpeech.SUCCESS){
			int result = tts.setLanguage(Locale.US);
			if(result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED){
				Log.e("TTS", "This language is not supported");
			} else{
				btnSpeak.setEnabled(true);
				speakOut();
			} }
			else{
				Log.e("TTS", "Initialization Failed!");
			}
		
		
	}
	
	@Override
	public void onDestroy(){
		if(tts != null){
			tts.stop();
			tts.shutdown();
		}
		super.onDestroy();
	}
	
	private void speakOut(){
		tts.speak("Attention!,  high beat rate!", TextToSpeech.QUEUE_FLUSH, null);
	}
	
	
}
