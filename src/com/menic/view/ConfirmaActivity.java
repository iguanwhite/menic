package com.menic.view;


import java.util.List;

import com.kioja.menic.R;
import com.menic.MenicActivity;
import com.menic.opcao.Opcao;
import com.menic.util.ContaUtil;
import com.menic.util.PedidoUtil;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;





public class ConfirmaActivity extends Activity {
	
	Button detalhe, confirmar;
	
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.confirma);
        
        detalhe = (Button) findViewById(R.id.buttonDetalhesFinal);
        
        confirmar = (Button) findViewById(R.id.buttonConfirmarPedido);
      confirmar.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				if(enviarBalcao()){

					ContaUtil.getInstance().addPedidoEmAndamento();
					
					
					Toast.makeText(getApplicationContext(),
							"Pedido enviado com sucesso! Fique à vontade para novos pedidos enquanto já preparamos este!", Toast.LENGTH_LONG).show();
				
					acessarInicio();	
				}
				
				
			}
		});
        
        
        
//        ImageView bebidas = (ImageView) findViewById(R.id.buttonbebidas);
//        bebidas.setOnClickListener(new View.OnClickListener() {
//			
//			@Override
//			public void onClick(View v) {
//				acessarPagina();
//				
//			}
//		});
      
        
        mostrarTextoDetalhe();
        
        
        
        
      
     }
    
	private void mostrarTextoDetalhe() {
	detalhe.setText(Html.fromHtml(construirTextoDetalhe()));
}

private String construirTextoDetalhe() {
	List<Opcao> opcoes = PedidoUtil.getInstance().getOpcoesPedido();
	String descricao =  PedidoUtil.getInstance().getDescricaoPedido();
	String qtd =  PedidoUtil.getInstance().getQuantidadePedido();
	
	

String texto =  "<br> "
			+ descricao
			+ "<br><br> "
			+ "<b>Quantidade: </b>" + qtd
			+ "<br><br> ";

String ops = "";

if(opcoes != null && opcoes.size() >0){
	texto += "<b>Acompanha: </b>";
	
	for(Opcao o: opcoes){
		texto += o.getQuantidade() + " " +   o.getNome() + "<br>";
	}
}
			

return texto;
			
			

}
    
   
    
    private void acessarPreDetalhe(){
    	startActivity(new Intent(getApplication(),PreDetalheActivity.class));
    	finish();
    }
    
    
    
    private boolean enviarBalcao() {
		//TODO - Criar Balcao Util Com conectividade. 
		// Apenas se enviar corretamente confirma o pedido e volta pra tela principal.
		return true;

	}
	
	
	 private void acessarPagina(){
	    	startActivity(new Intent(getApplication(),PaginaActivity.class));
	    	finish();
	    }
	 
	 
	 
	 private void acessarInicio(){
	    	startActivity(new Intent(getApplication(),InicioActivity.class));
	    	finish();
	    }


    
    
    
    
    
}