package com.menic.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.menic.conta.Conta;
import com.menic.pedido.Pedido;

public class ContaUtil {
	private static ContaUtil instance;
	private static Conta currentConta;
	private static List<Pedido> pedidosEmAndamento, pedidosConcluidos;
	public int PEDIDO_EM_ANDAMENTO = 1, PEDIDO_CONCLUIDO = 2,
			PEDIDO_CANCELADO = 3;
	private static String displayPedidosEmAndamento;
	private static String displayConta;

	// Verificar desempenho, sem pesquisa (visto que nao houve mudancas).
	// Busca estatica direta. Seja das infos de pedidos e da propria conta.

	// Comentar e organizar codigo.

	public static ContaUtil getInstance() {
		if (instance == null) {
			instance = new ContaUtil();
		}

		return instance;
	}

	public void criarNovaConta() {
		currentConta = new Conta();
		pedidosEmAndamento = new ArrayList<Pedido>();
		pedidosConcluidos = new ArrayList<Pedido>();
		displayPedidosEmAndamento = "Nenhum pedido em andamento.";
		displayConta = "Nenhum item adicionado.  Valor R$ 0,00"; // Arrumar HTML
																	// bonito

	}

	public Conta getCurrentConta() {
		return currentConta;
	}

	// Pedidos em Andamento (Métodos de Visualização)
	// ---------------------------------------------------------------------------------------

	public String getDisplayPedidosEmAndamento() {
		return displayPedidosEmAndamento;
	}

	public String refreshDisplayPedidosEmAndamento() {
		if (!getListPedidosEmAndamento().isEmpty()) {
			displayPedidosEmAndamento = getListPedidosEmAndamento().size()
					+ "  pedido(s) em andamento.";

		} else {
			displayPedidosEmAndamento = "Nenhum pedido em andamento.";
		}

		return displayPedidosEmAndamento;
	}

	private List<Pedido> getListPedidosEmAndamento() {
		pedidosEmAndamento = new ArrayList<Pedido>();
		List<Pedido> todosPedidos = currentConta.getListaPedidos();

		for (Pedido pedido : todosPedidos) {
			if (pedido.getStatus() == PEDIDO_EM_ANDAMENTO) {
				pedidosEmAndamento.add(pedido);
			}

		}

		return pedidosEmAndamento;
	}

	// --------------------------------------------------------Métodos de
	// inserção/ remoção.

	public void addPedidoEmAndamento() {
		pedidosEmAndamento.add(construirPedidoAtual());

	}

	private Pedido construirPedidoAtual(){
		Pedido pedido = new Pedido();
		pedido.setDataHoraAbertura(new Date());
		
		return pedido;
		//pedido.setProduto(PedidoUtil.getInstance().g)
		
		
	}

	public void removerPedidoEmAndamento(Pedido pedidoEmAndamento) {

		if (pedidosEmAndamento.contains(pedidoEmAndamento)) {

			pedidosEmAndamento.remove(pedidoEmAndamento);
		}

	}

	// Pedidos Concluidos - Visualizar Conta. (Métodos de Visualização)

	public String getDisplayPedidosConcluidos() {

		return displayConta;

	}

	public String refreshDisplayPedidosConcluidos() {
		if (!getListPedidosConcluidos().isEmpty()) {
			displayConta = getListPedidosConcluidos().size() + "  Valor:";

		} else {
			displayConta = "Nenhum item adicionado.  Valor R$ 0,00"; // Arrumar
																		// HTML
																		// bonito
		}

		return displayConta;
	}

	private List<Pedido> getListPedidosConcluidos() {
		pedidosConcluidos = new ArrayList<Pedido>();
		List<Pedido> todosPedidos = currentConta.getListaPedidos();

		for (Pedido pedido : todosPedidos) {
			if (pedido.getStatus() == PEDIDO_CONCLUIDO) {
				pedidosConcluidos.add(pedido);
			}
		}

		return pedidosConcluidos;
	}

	// --------------------------------------------------------Métodos de
	// inserção/ remoção.

	public void addPedidoConcluido(Pedido pedidoConcluido) {

		pedidosConcluidos.add(pedidoConcluido);

	}

}
