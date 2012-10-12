package com.fitmetracker.fitme;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends Activity {
	

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        
        Button buttonCreateNewAccount = (Button) findViewById(R.id.btnRegisterLogin);
        
        // Listening to the Register Button
        
        buttonCreateNewAccount.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// Switching to the Register Screen
				Intent i = new Intent(getApplicationContext(), RegisterActivity.class);
				startActivity(i);
				
			}
		});
    
       Button buttonLogin = (Button) findViewById(R.id.btnLoginLogin);
       
       // Listenting to the LogIn Button
       
       buttonLogin.setOnClickListener(new View.OnClickListener() {
		
		public void onClick(View v) {
			// Swtiching to the Main View
			Intent i = new Intent(getApplicationContext(), MainScreenActivity.class);
			startActivity(i);
			
		}
	});
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.login_activity, menu);
        return true;
    }
}
