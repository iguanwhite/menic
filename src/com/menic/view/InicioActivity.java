package com.menic.view;


import com.kioja.menic.R;
import com.menic.MenicActivity;
import com.menic.util.ContaUtil;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;

public class InicioActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inicio);
        
        ImageView bebidas = (ImageView) findViewById(R.id.buttonbebidas);
        bebidas.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				acessarPagina();
				
			}
		});
        
        iniciarConta();
     }
    
    private void iniciarConta(){
    	ContaUtil.getInstance().criarNovaConta();
    	
    }
    
    private void acessarPagina(){
    	startActivity(new Intent(getApplication(),PaginaActivity.class));
    	finish();
    }


    
    
    
    
    
}