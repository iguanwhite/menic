package com.menic.view;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.kioja.menic.R;
import com.menic.adapter.LazyAdapter;
import com.menic.opcao.Opcao;
import com.menic.util.PedidoUtil;
import com.menic.util.ProdutoUtil;

public class OpcoesActivity extends Activity {

	Button concluir, detalhe;

	ListView list;
	LazyAdapter adapter;
	List<Opcao> opcoes, opcoesConfirmadas;
	// opcoesFeitas;

	TextView labelOpcao1, labelOpcao2, labelOpcao3, labelOpcao4, labelOpcao5;
	EditText fieldQuantidade1, fieldQuantidade2, fieldQuantidade3,
			fieldQuantidade4, fieldQuantidade5;

	/** Called when the activity is first created. */

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.opcoes2);

		opcoes = ProdutoUtil.getInstance().getCurrentProduto().getOpcoes();
		opcoesConfirmadas = new ArrayList<Opcao>();

		montarEstrutura();

		// OpcoesAdapter adapter = new OpcoesAdapter();
		// setListAdapter(adapter);

		Button visualizarPedido = (Button) findViewById(R.id.buttonVisualizarNovoPedido);

		visualizarPedido.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				
				if(isValidBeforeSave()){
					PedidoUtil.getInstance().setOpcoesPedido(opcoesConfirmadas);
					acessarConfirma();	
				}
				

			}
		});

		// mostrarTextoDetalhe();

	}
	
	private boolean isValidBeforeSave(){
		
		if(fieldQuantidade1.getText().toString().equals("") &&
			fieldQuantidade2.getText().toString().equals("") &&
			fieldQuantidade3.getText().toString().equals("") &&
			fieldQuantidade4.getText().toString().equals("") &&
			fieldQuantidade5.getText().toString().equals("")){
			
			
			AlertDialog alertDialog = new AlertDialog.Builder(
						OpcoesActivity.this).create();
				alertDialog.setTitle("Opções");
				alertDialog.setMessage("Preencha ao menos uma (1) opção para concluir o pedido!");
				alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {
						return;
					}
				});
				
				alertDialog.show();
				return false;
			
		}else{
			
			if(fieldQuantidade1.getText().toString().length() >0){
				salvarOpcao(1);
			}if(fieldQuantidade2.getText().toString().length() >0){
				salvarOpcao(2);
			}if(fieldQuantidade3.getText().toString().length() >0){
				salvarOpcao(3);
			}if(fieldQuantidade4.getText().toString().length() >0){
				salvarOpcao(4);
			}if(fieldQuantidade5.getText().toString().length() >0){
				salvarOpcao(5);
			}
		}
		
		
		return true;
	}
	
	
	private void salvarOpcao(Integer indice){
		Opcao a = new Opcao();
		
		if(indice == 1){
			a.setNome(labelOpcao1.getText().toString());
			a.setQuantidade(Integer.valueOf(fieldQuantidade1.getText().toString()));
			
		}else if(indice == 2){
			a.setNome(labelOpcao2.getText().toString());
			a.setQuantidade(Integer.valueOf(fieldQuantidade2.getText().toString()));
		}else if(indice == 3){
			a.setNome(labelOpcao3.getText().toString());
			a.setQuantidade(Integer.valueOf(fieldQuantidade3.getText().toString()));
			
		}else if(indice == 4){
			a.setNome(labelOpcao4.getText().toString());
			a.setQuantidade(Integer.valueOf(fieldQuantidade4.getText().toString()));
			
		}else if(indice == 5){
			a.setNome(labelOpcao5.getText().toString());
			a.setQuantidade(Integer.valueOf(fieldQuantidade5.getText().toString()));
			
		}
		
		
		opcoesConfirmadas.add(a);
		
		
		
	}

	private void montarEstrutura() {
		
		labelOpcao1 = (TextView) findViewById(R.id.labelOpcao1);
		labelOpcao2 = (TextView) findViewById(R.id.labelOpcao2);
		labelOpcao3 = (TextView) findViewById(R.id.labelOpcao3);
		labelOpcao4 = (TextView) findViewById(R.id.labelOpcao4);
		labelOpcao5 = (TextView) findViewById(R.id.labelOpcao5);
		
		
		fieldQuantidade1 = (EditText) findViewById(R.id.fieldQuantidade1);
		fieldQuantidade2 = (EditText) findViewById(R.id.fieldQuantidade2);
		fieldQuantidade3 = (EditText) findViewById(R.id.fieldQuantidade3);
		fieldQuantidade4 = (EditText) findViewById(R.id.fieldQuantidade4);
		fieldQuantidade5 = (EditText) findViewById(R.id.fieldQuantidade5);
		
		
		
		
		
		
		int tam = opcoes.size();

		if (tam == 1) {
			Opcao o1 = opcoes.get(0);

			labelOpcao1.setVisibility(View.VISIBLE);
			labelOpcao1.setText(o1.getNome());
			fieldQuantidade1.setVisibility(View.VISIBLE);
			//fieldQuantidade1.setText(o1.getQuantidade().toString());

		} else if (tam == 2) {
			Opcao o1 = opcoes.get(0);

			labelOpcao1.setVisibility(View.VISIBLE);
			labelOpcao1.setText(o1.getNome());
			fieldQuantidade1.setVisibility(View.VISIBLE);
		//	fieldQuantidade1.setText(o1.getQuantidade().toString());

			Opcao o2 = opcoes.get(1);

			labelOpcao2.setVisibility(View.VISIBLE);
			labelOpcao2.setText(o2.getNome());
			fieldQuantidade2.setVisibility(View.VISIBLE);
	//		fieldQuantidade2.setText(o2.getQuantidade().toString());

		}else if (tam == 3) {
			Opcao o1 = opcoes.get(0);

			labelOpcao1.setVisibility(View.VISIBLE);
			labelOpcao1.setText(o1.getNome());
			fieldQuantidade1.setVisibility(View.VISIBLE);
		//	fieldQuantidade1.setText(o1.getQuantidade().toString());

			Opcao o2 = opcoes.get(1);

			labelOpcao2.setVisibility(View.VISIBLE);
			labelOpcao2.setText(o2.getNome());
			fieldQuantidade2.setVisibility(View.VISIBLE);
		//	fieldQuantidade2.setText(o2.getQuantidade().toString());
			
			Opcao o3 = opcoes.get(2);

			labelOpcao3.setVisibility(View.VISIBLE);
			labelOpcao3.setText(o3.getNome());
			fieldQuantidade3.setVisibility(View.VISIBLE);
	//		fieldQuantidade3.setText(o3.getQuantidade().toString());
			
			
			
		}else if (tam == 4) {
			
			Opcao o1 = opcoes.get(0);

			labelOpcao1.setVisibility(View.VISIBLE);
			labelOpcao1.setText(o1.getNome());
			fieldQuantidade1.setVisibility(View.VISIBLE);
		//	fieldQuantidade1.setText(o1.getQuantidade().toString());

			Opcao o2 = opcoes.get(1);

			labelOpcao2.setVisibility(View.VISIBLE);
			labelOpcao2.setText(o2.getNome());
			fieldQuantidade2.setVisibility(View.VISIBLE);
	//		fieldQuantidade2.setText(o2.getQuantidade().toString());
			
			Opcao o3 = opcoes.get(2);

			labelOpcao3.setVisibility(View.VISIBLE);
			labelOpcao3.setText(o3.getNome());
			fieldQuantidade3.setVisibility(View.VISIBLE);
	//		fieldQuantidade3.setText(o3.getQuantidade().toString());
			
			Opcao o4 = opcoes.get(3);

			labelOpcao4.setVisibility(View.VISIBLE);
			labelOpcao4.setText(o4.getNome());
			fieldQuantidade4.setVisibility(View.VISIBLE);
	//		fieldQuantidade4.setText(o4.getQuantidade().toString());
			
			
			
		}else if (tam == 5) {
			
			Opcao o1 = opcoes.get(0);

			labelOpcao1.setVisibility(View.VISIBLE);
			labelOpcao1.setText(o1.getNome());
			fieldQuantidade1.setVisibility(View.VISIBLE);
	//		fieldQuantidade1.setText(o1.getQuantidade().toString());

			Opcao o2 = opcoes.get(1);

			labelOpcao2.setVisibility(View.VISIBLE);
			labelOpcao2.setText(o2.getNome());
			fieldQuantidade2.setVisibility(View.VISIBLE);
		//	fieldQuantidade2.setText(o2.getQuantidade().toString());
			
			Opcao o3 = opcoes.get(2);

			labelOpcao3.setVisibility(View.VISIBLE);
			labelOpcao3.setText(o3.getNome());
			fieldQuantidade3.setVisibility(View.VISIBLE);
	//		fieldQuantidade3.setText(o3.getQuantidade().toString());
			
			Opcao o4 = opcoes.get(3);

			labelOpcao4.setVisibility(View.VISIBLE);
			labelOpcao4.setText(o4.getNome());
			fieldQuantidade4.setVisibility(View.VISIBLE);
	//		fieldQuantidade4.setText(o4.getQuantidade().toString());
			
			Opcao o5 = opcoes.get(4);

			labelOpcao5.setVisibility(View.VISIBLE);
			labelOpcao5.setText(o5.getNome());
			fieldQuantidade5.setVisibility(View.VISIBLE);
	//		fieldQuantidade5.setText(o5.getQuantidade().toString());
			
			
			
		}

	}

	// private void concluirPedido() {
	// int qnt = getListView().getCount();
	// TextView nome;
	// EditText qtd;
	//
	// for (int x = 0; x < qnt; x++) {
	// View view = getListView().getChildAt(x);
	// nome = (TextView) view.findViewById(R.id.nomeOpcao);
	// qtd = (EditText) view.findViewById(R.id.fieldQuantidadeOpcoes);
	//
	// Integer intQuantidade = 0;
	// if (qtd != null) {
	// intQuantidade = Integer.valueOf(qtd.getText().toString());
	// }
	//
	// String stNome = nome.getText().toString();
	//
	// List<String> opcoesSelecionadas =(List<String>)
	// PedidoUtil.getInstance().getOpcoesPedido();
	//
	// opcoesSelecionadas.add(qtd + " " + stNome);
	//
	// PedidoUtil.getInstance().setOpcoesPedido(opcoesSelecionadas);
	//
	// // Opcao o = new Opcao();
	// // o.setNome(stNome);
	// // o.setQuantidade(intQuantidade);
	// //
	// // opcoesFeitas.add(o);
	//
	// }
	//
	// armazenarPedido();
	// acessarConfirma();
	//
	//
	//
	//
	//
	// }

	private void acessarConfirma() {
		startActivity(new Intent(getApplication(), ConfirmaActivity.class));
		finish();
	}

	private void armazenarPedido() {

		// TODO - proximo passo. incluir " com: borda catupiry e 4 pratos" HTML
		// BONITAO.
		// Ex; Confirma o seguinte pedido?
		// ....................................................
		// ....................................................
		// ....................................................
		// Botao Sim - Nao Voltar, (Com os campos devidamente preenchidos);

		// TODO - ContaUtil. Armazenar pedido.
		// TODO - Caixa de texto (Pedido 1 -Confirmado com sucesso)
		// ok - Visualizar Pedidos

		// TODO - Melhorar mostrar pedidos feitos.. Lista (Painel amarelo com
		// letras pretas pequenas HTML) com quantidade e valor E TEMPO GASTO e
		// Contando. Colocar Status (EM ANDAMENTO, ENTREGUE)
		// A caminho.. - Realizado.

		// (Cancelado) no botao garcom rapido.

		// TODO - Conta
		//

		// TODO - Caso seja Pizza, fazer lista com check box para criar pizza.
		// Metade Calabreza/ Metade Bacon. e Na lista de pizzas, opcao criar.
	}

	// class OpcoesAdapter extends ArrayAdapter<Opcao> {
	//
	// OpcoesAdapter() {
	// super(OpcoesActivity.this, R.layout.rowlayoutlistaopcoes,
	// R.id.nomeOpcao, opcoes);
	// }
	//
	// public View getView(int position, View convertView, ViewGroup parent) {
	//
	// View v = convertView;
	//
	// // If convertView is null create a new view, else use convert view
	// if (v == null) {
	// v = ((LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE))
	// .inflate(R.layout.rowlayoutlistaopcoes, null);
	//
	// } else {
	// v = super.getView(position, convertView, parent);
	// }
	//
	// TextView nome = (TextView) v.findViewById(R.id.nomeOpcao);
	// EditText qtd = (EditText) v
	// .findViewById(R.id.fieldQuantidadeOpcoes);
	//
	//
	//
	// // TODO.
	// // Pegar a posicao da mensagem na lista e atualizar.
	// final Opcao opcao = (Opcao) opcoes.get(position);
	//
	// nome.setText(opcao.getNome());
	// if(opcao.getQuantidade() == null) {
	//
	// qtd.setText(String.valueOf(""));
	// }else{
	// qtd.setText(String.valueOf(opcao.getQuantidade()));
	// }
	//
	//
	//
	//
	//
	// // list = getListView();
	// //
	// // // Click event for single list row
	// // list.setOnItemClickListener(new OnItemClickListener() {
	// //
	// // @Override
	// // public void onItemClick(AdapterView<?> parent, View view,
	// // int position, long id) {
	// // final Produto p = (Produto) produtosTemp.get(position);
	// //
	// // ProdutoUtil.getInstance().setCurrentProduto(p);
	// // acessarPagina();
	// // }
	// // });
	//
	// return v;
	//
	// }
	//
	// }

}