package com.fitmetracker.fitme;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockActivity;

public class StatsActivity extends SherlockActivity implements ActionBar.OnNavigationListener {

	private String[] itemsMenu;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainscreen_activity);
        
        itemsMenu = getResources().getStringArray(R.array.dropdownList);
        
        Context context = getSupportActionBar().getThemedContext();
        ArrayAdapter<CharSequence> list = ArrayAdapter.createFromResource(context, R.array.dropdownList, R.layout.sherlock_spinner_dropdown_item);
        
        getSupportActionBar().setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);
        getSupportActionBar().setListNavigationCallbacks(list,  this);
        getSupportActionBar().setTitle("FitMe Stats");  
    }

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mainscreen_activity, menu);
        return true;
    }*/

    public boolean onNavigationItemSelected(int itemPosition, long itemId) {
		// When tap on an item, it takes you to the Activity
		if(itemPosition == 0){
			
			// Creates the new intent that will take you to the Home screen
			Intent i = new Intent(getApplicationContext(), MainScreenActivity.class);
			startActivity(i);
			return true;
		} else if(itemPosition == 1){
			// Doesn't do anything as the user is already in the stats screen
			
			return false;
			
		} else if(itemPosition == 2){
			// Creates the new intent that will take you to the Option Screen
			Intent i = new Intent(getApplicationContext(), OptionsActivity.class);
			startActivity(i);
			return true;
		}
		else
			return false;
	}
}

