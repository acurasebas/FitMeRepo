package com.fitmetracker.fitme;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class RegisterActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register_activity);

		Button buttonCreateNewAccount = (Button) findViewById(R.id.btnRegisterRegister);

		// Listening to the Register Button

		buttonCreateNewAccount.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				// Switching to the Register Screen
				Intent i = new Intent(getApplicationContext(),
						MainScreenActivity.class);
				startActivity(i);

			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.register_activity, menu);
		return true;
	}
}
