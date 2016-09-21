package com.menic.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

import com.menic.adapter.LazyAdapter;
import com.kioja.menic.R;
import com.menic.produto.Produto;
import com.menic.opcao.Opcao;
import com.menic.util.ProdutoUtil;

//import com.velp.iphan.view.ListaPessoasActivity.PessoaAdapter;

public class PaginaActivity extends ListActivity {

	// XML node keys
	static final String NOME = "nome"; // parent node
	static final String CALORIAS = "calorias";
	static final String PRECO = "preco";

	ListView list;
	LazyAdapter adapter;

	List produtosTemp;

	/** Called when the activity is first created. */
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pagina);

		ImageView direita = (ImageView) findViewById(R.id.buttonDireita);

		criarListaTeste();

		PaginaAdapter adapter = new PaginaAdapter();
		setListAdapter(adapter);

		direita.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				acessarPagina();

			}
		});

		// aplicarAdapter(true);
	}

	private void acessarPagina() {
		startActivity(new Intent(getApplication(), PreDetalheActivity.class));
		finish();
	}

	private void criarListaTeste() {
		// TODO OBS: Apenas disponiveis
		// Métodos separados (Pesquisar Entradas, Pratos da Casa, Bebidas)
		// Lista de uma família só; RN.findBebidas (Apenas disponiveis) (por
		// exemplo).

		produtosTemp = new ArrayList();

		Produto heineken = new Produto();
		heineken.setNome("Cerveja Heineken 600ml");
		heineken.setCalorias(500);
		heineken.setCodigoProduto(1l);
		heineken.setDisponivel(true);
		heineken.setTipo(1);
		heineken.setPreco("5.00");
		heineken.setPeso("600ml");
		heineken.setPorcao(4);
		heineken.setInteiro(false);
		
		Opcao copos = new Opcao();
		copos.setNome("Copos");
		
		
		
		Opcao gelo = new Opcao();
		gelo.setNome("Gelo");
		
		
		Opcao gelimao = new Opcao();
		gelimao.setNome("Gelo/Limão");
		
		
		Opcao limao = new Opcao();
		limao.setNome("Limão");
		
		
		
		List<Opcao> opcoes = new ArrayList();
		opcoes.add(copos);
		opcoes.add(gelo);
		opcoes.add(gelimao);
		opcoes.add(limao);
		
		heineken.setOpcoes(opcoes);
		
		
		//heineken.setImagem()
		//
		produtosTemp.add(heineken);

		Produto bud = new Produto();
		bud.setNome("Cerveja Budweiser 600ml");
		bud.setCalorias(510);
		bud.setCodigoProduto(1l);
		bud.setDisponivel(true);
		bud.setTipo(1);
		bud.setPreco("5.00");
		bud.setPeso("600ml");
		bud.setPorcao(4);
		
		//
		produtosTemp.add(bud);

		Produto extra = new Produto();
		extra.setNome("Cerveja Brahma Extra 600ml");
		extra.setCalorias(510);
		extra.setCodigoProduto(1l);
		extra.setDisponivel(true);
		extra.setTipo(1);
		extra.setPreco("5.00");
		extra.setPeso("600ml");
		extra.setPorcao(4);
		//
		
		//
		produtosTemp.add(extra);

		Produto quil = new Produto();
		quil.setNome("Cerveja Quilmes 1l");
		quil.setCalorias(510);
		quil.setCodigoProduto(1l);
		quil.setDisponivel(true);
		quil.setTipo(1);
		quil.setPreco("5.50");
		quil.setPeso("600ml");
		quil.setPorcao(4);
		//
		produtosTemp.add(quil);

		Produto gui = new Produto();
		gui.setNome("Cerveja Guinness 600ml");
		gui.setCalorias(510);
		gui.setCodigoProduto(1l);
		gui.setDisponivel(true);
		gui.setTipo(1);
		gui.setPreco("9.50");
		gui.setPeso("600ml");
		gui.setPorcao(4);
		//
		produtosTemp.add(gui);

	}

//	public void aplicarAdapter(boolean preenchido) {
//
//		if (preenchido) {
//
//			ArrayList<HashMap<String, String>> listaProdutos = new ArrayList<HashMap<String, String>>();
//
//			HashMap<String, String> heineken = new HashMap<String, String>();
//			heineken.put(NOME, "Heineken");
//			heineken.put(CALORIAS, "500");
//			heineken.put(PRECO, "R$ 5.00");
//
//			listaProdutos.add(heineken);
//
//			// list=(ListView)findViewById(R.id.listProdutos);
//			list = getListView();
//
//			// Getting adapter by passing xml data ArrayList
//			adapter = new LazyAdapter(this, listaProdutos);
//			list.setAdapter(adapter);
//
//			// Click event for single list row
//			list.setOnItemClickListener(new OnItemClickListener() {
//
//				@Override
//				public void onItemClick(AdapterView<?> parent, View view,
//						int position, long id) {
//
//				}
//			});
//
//			// PaginaAdapter adapter = new PaginaAdapter();
//			// setListAdapter(adapter);
//		} else {
//			// TODO - Lista vazia
//			// PessoaAdapter2 adapter2 = new PessoaAdapter2();
//			// setListAdapter(adapter2);
//		}
//
//	}

	// TODO
	// Adapter Antigo.. Será que ainda será utilizado???

	class PaginaAdapter extends ArrayAdapter<String> {

		PaginaAdapter() {
			super(PaginaActivity.this, R.layout.rowlayoutlistaprodutos,
					R.id.nomeProduto, produtosTemp);
		}

		public View getView(int position, View convertView, ViewGroup parent) {

			View v = convertView;

			// If convertView is null create a new view, else use convert view
			if (v == null) {
				v = ((LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE))
						.inflate(R.layout.rowlayoutlistaprodutos, null);

			} else {
				v = super.getView(position, convertView, parent);
			}

			ImageView imagem = (ImageView) v.findViewById(R.id.imagemProduto);
			TextView nome = (TextView) v.findViewById(R.id.nomeProduto);
			TextView preco = (TextView) v.findViewById(R.id.precoProduto);
			ImageView pedir = (ImageView) v.findViewById(R.id.pedirProduto);

			// TODO.
			// Pegar a posicao da mensagem na lista e atualizar.
			final Produto produto = (Produto) produtosTemp.get(position);

			nome.setText(produto.getNome());
			preco.setText("R$ " + produto.getPreco());

			// text2.setText(bem.getDesEndereco());

			list = getListView();

			// Click event for single list row
			list.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> parent, View view,
						int position, long id) {
					final Produto p = (Produto) produtosTemp.get(position);
					
					ProdutoUtil.getInstance().setCurrentProduto(p);
					acessarPagina();
				}
			});

			return v;

		}

	}
	//

	// TODO
	// Lista vazia. Criar.

	// class BemAdapter3 extends ArrayAdapter<String> {
	//
	// BemAdapter3() {
	// super(ListaBensActivity.this,
	// R.layout.rowlayoutlistabens, R.id.text2,
	// mensagensTemp3);
	// }
	//
	//
	//
	// public View getView(int position, View convertView, ViewGroup parent) {
	//
	// View v = convertView;
	//
	// //If convertView is null create a new view, else use convert view
	// if(v==null){
	// v =((LayoutInflater)
	// getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.rowlayoutlistabens,null);
	//
	// }else{
	// v = super.getView(position, convertView, parent);
	// }
	//
	// TextView titulo = (TextView) v.findViewById(R.id.text1);
	// TextView text2 = (TextView) v.findViewById(R.id.text2);
	//
	// // TODO.
	// // Pegar a posicao da mensagem na lista e atualizar.
	// Bem bem = (Bem) mensagensTemp3
	// .get(position);
	//
	// titulo.setText("Nenhum Bem Cadastrado.");
	//
	// return v;
	//
	// }
	//
	// }

}