package com.menic;


import com.kioja.menic.R;
import com.menic.view.InicioActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class MenicActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        testarConectividade();
        setupHandlerCloseSplash(); //Colocar time para carregar toda estrutura e testar wifi.
        
    }
    
    
    private void testarConectividade(){
    	//Toast e testes.
    }
    
    
    
    private void setupHandlerCloseSplash() {
		Runnable runnable = new Runnable() {

			@Override
			public void run() {
				startActivity(new Intent(getApplication(), InicioActivity.class));
		
				 finish();
			}
		};

		new Handler().postDelayed(runnable, 3000);
	}
    
    
    
    
    
}