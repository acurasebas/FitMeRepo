package com.fitmetracker.fitme;

import android.content.Context;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockActivity;

public class MainScreenActivity extends SherlockActivity implements ActionBar.OnNavigationListener {

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
        getSupportActionBar().setTitle("Workout"); // PROBAFiwehgjoqnhiorp
    }

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mainscreen_activity, menu);
        return true;
    }*/

	public boolean onNavigationItemSelected(int itemPosition, long itemId) {
		// TODO Auto-generated method stub
		return false;
	}
}
