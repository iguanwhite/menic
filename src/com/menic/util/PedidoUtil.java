package com.menic.util;

import java.util.ArrayList;
import java.util.List;

import com.menic.opcao.Opcao;
import com.menic.view.OpcoesActivity;



public class PedidoUtil {
	
	private static PedidoUtil instance;
	private String quantidadePedido;// 2 - 3
	private String descricaoPedido; // Pizzas Calabrezas/Frango Médias. - Cervejas Bohemia 500Ml .
	private static List<Opcao> opcoesPedido; //  com 4 pratos -  com 5 copos

	
	
	
	public static PedidoUtil getInstance() {
		if (instance == null) {
			instance = new PedidoUtil();
			opcoesPedido = new ArrayList<Opcao>();
		}

		return instance;
	}




	public String getDescricaoPedido() {
		return descricaoPedido;
	}




	public void setDescricaoPedido(String descricaoPedido) {
		this.descricaoPedido = descricaoPedido;
	}




	public String getQuantidadePedido() {
		return quantidadePedido;
	}




	public void setQuantidadePedido(String quantidadePedido) {
		this.quantidadePedido = quantidadePedido;
	}




	public List<Opcao> getOpcoesPedido() {
		return opcoesPedido;
	}




	public void setOpcoesPedido(List<Opcao> opcoesPedido) {
		this.opcoesPedido = opcoesPedido;
	}
	
	

	
	
	
	
	
	
	

}
