package com.menic.conta;

import java.util.Date;
import java.util.List;

import com.menic.pedido.Pedido;

public class Conta {
	
	private Long idConta;
	private Long codConta;
	private int mesa;
	private int quantidadeClientes; // (Verificar - Campo apenas no servidor)
	private int status; // 1 - Aberta | 2- Encerrada | 3 - Cancelada.
	private Date dataHoraAbertura;
	private Date dataHoraCancelamento;
	private Date dataHoraEncerramento;
	private int motivoCancelamento;
	private float valorGeralPedidos;
	private float valorCouverPessoa;
	private List<Pedido> listaPedidos;
	
	
	public Long getIdConta() {
		return idConta;
	}
	public void setIdConta(Long idConta) {
		this.idConta = idConta;
	}
	public Long getCodConta() {
		return codConta;
	}
	public void setCodConta(Long codConta) {
		this.codConta = codConta;
	}
	public int getMesa() {
		return mesa;
	}
	public void setMesa(int mesa) {
		this.mesa = mesa;
	}
	public int getQuantidadeClientes() {
		return quantidadeClientes;
	}
	public void setQuantidadeClientes(int quantidadeClientes) {
		this.quantidadeClientes = quantidadeClientes;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Date getDataHoraAbertura() {
		return dataHoraAbertura;
	}
	public void setDataHoraAbertura(Date dataHoraAbertura) {
		this.dataHoraAbertura = dataHoraAbertura;
	}
	public Date getDataHoraCancelamento() {
		return dataHoraCancelamento;
	}
	public void setDataHoraCancelamento(Date dataHoraCancelamento) {
		this.dataHoraCancelamento = dataHoraCancelamento;
	}
	public Date getDataHoraEncerramento() {
		return dataHoraEncerramento;
	}
	public void setDataHoraEncerramento(Date dataHoraEncerramento) {
		this.dataHoraEncerramento = dataHoraEncerramento;
	}
	public int getMotivoCancelamento() {
		return motivoCancelamento;
	}
	public void setMotivoCancelamento(int motivoCancelamento) {
		this.motivoCancelamento = motivoCancelamento;
	}
	public float getValorGeralPedidos() {
		return valorGeralPedidos;
	}
	public void setValorGeralPedidos(float valorGeralPedidos) {
		this.valorGeralPedidos = valorGeralPedidos;
	}
	public float getValorCouverPessoa() {
		return valorCouverPessoa;
	}
	public void setValorCouverPessoa(float valorCouverPessoa) {
		this.valorCouverPessoa = valorCouverPessoa;
	}
	public List<Pedido> getListaPedidos() {
		return listaPedidos;
	}
	public void setListaPedidos(List<Pedido> listaPedidos) {
		this.listaPedidos = listaPedidos;
	}
	
	
  
	
	
	
	

}
