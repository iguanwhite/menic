package com.menic.pedido;

import java.util.Date;

import com.menic.conta.Conta;
import com.menic.produto.Produto;

public class Pedido {
	
	private Long idPedido;
	private Long codPedido;
	private Date dataHoraAbertura;
	private int motivoCancelamento; // 1 - Desfazer (Continuar Pedido) | 2 - Alteração Item | 3- Insatisfação 
	private Date dataHoraEntrega;
	private Date dataHoraCancelamento;
	private Produto produto;
	private int quantidade;
	private int status; // 1 - Em andamento | 2- Concluído | 3- Cancelado
	
	
	public Long getIdPedido() {
		return idPedido;
	}
	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
	}
	public Long getCodPedido() {
		return codPedido;
	}
	public void setCodPedido(Long codPedido) {
		this.codPedido = codPedido;
	}
	public Date getDataHoraAbertura() {
		return dataHoraAbertura;
	}
	public void setDataHoraAbertura(Date dataHoraAbertura) {
		this.dataHoraAbertura = dataHoraAbertura;
	}
	public int getMotivoCancelamento() {
		return motivoCancelamento;
	}
	public void setMotivoCancelamento(int motivoCancelamento) {
		this.motivoCancelamento = motivoCancelamento;
	}
	public Date getDataHoraEntrega() {
		return dataHoraEntrega;
	}
	public void setDataHoraEntrega(Date dataHoraEntrega) {
		this.dataHoraEntrega = dataHoraEntrega;
	}
	public Date getDataHoraCancelamento() {
		return dataHoraCancelamento;
	}
	public void setDataHoraCancelamento(Date dataHoraCancelamento) {
		this.dataHoraCancelamento = dataHoraCancelamento;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	
	
	
	

}
