package com.fitmetracker.fitme;

import android.content.Context;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockActivity;

public class LoginActivity2 extends SherlockActivity implements
		ActionBar.OnNavigationListener {

	private TextView prueba;
	private String[] itemsMenu;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.loginactivity); // comment here Edited prueba
												// sebastian

		prueba = (TextView) findViewById(R.id.Texto);
		itemsMenu = getResources().getStringArray(R.array.menuPrueba);

		Context context = getSupportActionBar().getThemedContext();
		ArrayAdapter<CharSequence> list = ArrayAdapter.createFromResource(
				context, R.array.menuPrueba, R.layout.sherlock_spinner_item);

		getSupportActionBar().setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);
		getSupportActionBar().setListNavigationCallbacks(list, this);

	}

	public boolean onNavigationItemSelected(int itemPosition, long itemId) {
		prueba.setText("Seleccionado: " + itemsMenu[itemPosition]);
		return true;
	}

	/*
	 * @Override public boolean onCreateOptionsMenu(Menu menu) {
	 * getMenuInflater().inflate(R.menu.loginactivity, menu); return true; }
	 */
}