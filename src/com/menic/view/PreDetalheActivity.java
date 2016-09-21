package com.menic.view;

import java.util.ArrayList;
import java.util.List;

import com.kioja.menic.R;
import com.kioja.menic.R.layout;
import com.menic.MenicActivity;
import com.menic.produto.Produto;
import com.menic.util.PedidoUtil;
import com.menic.util.ProdutoUtil;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class PreDetalheActivity extends Activity {

	Button descricao, detalhe, info, pedir;

	ImageView imagemProduto;
	Dialog dialog;

	Produto produto;

	List<String> responsaveis;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.predetalhe);

		descricao = (Button) findViewById(R.id.buttonDescricao);
		descricao.getBackground().setAlpha(100);

		detalhe = (Button) findViewById(R.id.buttonDetalhes);
		detalhe.setVisibility(View.INVISIBLE);

		responsaveis = new ArrayList<String>();
		responsaveis.add("2 Copos se");
		responsaveis.add("22");

		info = (Button) findViewById(R.id.buttonInfo);
		info.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				subirDetalhe();
			}
		});

		pedir = (Button) findViewById(R.id.buttonPedir);
		pedir.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// abrirListaTeste();

				// set up dialog
				dialog = new Dialog(PreDetalheActivity.this);
				dialog.setContentView(R.layout.dialogpedir);
				dialog.setTitle("Informe a quantidade do pedido");
				dialog.setCancelable(true);

				final Button b = (Button) dialog
						.findViewById(R.id.buttonOpcoesDeEntrega);
				b.setOnClickListener(new View.OnClickListener() {

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						final EditText quantidade;
						String qtd = "0";

						try {
							quantidade = (EditText) dialog
									.findViewById(R.id.fieldQuantidade);
							qtd = quantidade.getText().toString();
						} catch (Exception e) {
							// TODO: handle exception
						}

						if (qtd.length() > 0 && !qtd.equals("0")) {
							armazenaPedido(qtd);
							dialog.dismiss();
							abrirListaTeste();
						} else {

							AlertDialog alertDialog = new AlertDialog.Builder(
									PreDetalheActivity.this).create();
							alertDialog.setTitle("Gerar Pedido.");
							alertDialog
									.setMessage("Informe a quantidade do seu pedido antes de prosseguir.");
							alertDialog.setButton("OK",
									new DialogInterface.OnClickListener() {
										public void onClick(
												DialogInterface dialog,
												int which) {
											return;
										}
									});
						}

					}
				});

				dialog.show();
			}
		});

		imagemProduto = (ImageView) findViewById(R.id.imagemProduto);

		produto = ProdutoUtil.getInstance().getCurrentProduto();

		mostrarImagem();
		mostrarTextoDescricao();
		mostrarTextoDetalhe();

	}

	private void armazenaPedido(String qtd) {

		PedidoUtil.getInstance().setDescricaoPedido(
				ProdutoUtil.getInstance().getCurrentProduto().getNome());
		PedidoUtil.getInstance().setQuantidadePedido(qtd);
		// TODO - proximo passo. incluir " com: borda catupiry e 4 pratos" HTML
		// BONITAO. (no final - conta..)

	}

	private void abrirListaTeste() {
		startActivity(new Intent(getApplication(), OpcoesActivity.class));
		finish();

	}

	private void criar(Spinner s0) {
		ArrayAdapter<String> adapter0 = new ArrayAdapter<String>(this,
				R.layout.textspinner, responsaveis);
		adapter0.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

		s0.setAdapter(adapter0);

	}

	private void mostrarImagem() {
		// TODO
		// Evidente que isso sera do banco de dados.. byte[] para Bitmap etc..

		if (produto.getNome().contains("Heineken")) {

			imagemProduto.setImageDrawable(getResources().getDrawable(
					R.drawable.heineken));

		} else if (produto.getNome().contains("Extra")) {
			imagemProduto.setImageDrawable(getResources().getDrawable(
					R.drawable.bextra));
		}
	}

	private void mostrarTextoDescricao() {
		descricao.setText(produto.getNome() + " - R$" + produto.getPreco());
	}

	private void mostrarTextoDetalhe() {
		detalhe.setText(Html.fromHtml(construirTextoDetalhe()));
	}

	private String construirTextoDetalhe() {

		return "<b>Quantidade:</b> "
				+ produto.getPeso()
				+ "<br> "
				+ "<b>Porção:</b> "
				+ (produto.getPorcao() == 1 ? "Individual" : produto
						.getPorcao() + " pessoas") + "<br> "
				+ "<b>Informação Nutricional:</b>" + " "
				+ produto.getCalorias() + "cal <br> " + "<b>Valor:</b> R$ "
				+ produto.getPreco();

	}

	private void subirDetalhe() {

		if (detalhe.getVisibility() == View.VISIBLE) {
			detalhe.setVisibility(View.INVISIBLE);
		} else {
			detalhe.setVisibility(View.VISIBLE);
		}

	}

}