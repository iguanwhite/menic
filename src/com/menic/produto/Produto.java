package com.menic.produto;
import java.util.List;

import com.menic.opcao.Opcao;

public class Produto {
	
	private Long idProduto;
	private Long codigoProduto;
	private boolean disponivel;
	private String nome;
	private int tipo; // 1- Bebida | 2 - Entrada | 3 - Prato | 4 - Outros
	private byte[] imagem;
	private String preco;
	private int calorias;
	private String info; // Informações Gerais, Ingredientes, Opcoes de entrega (Opcoes) - Quantidade servida, prato para x pessoas.
	private String peso; //200g
	private int porcao;
	private List<Opcao> opcoes;
	private boolean inteiro; // É servido inteiro, ou em pratos
	//private String[] opcoes; // Sem gelo, sem acucar //sem salada // prato// a palito // copos 
 
	 
	
	
	
	

	public Produto() {
		// TODO Auto-generated constructor stub
	}

	public Produto(Long codigoProduto, boolean disponivel, String nome,
			int tipo, byte[] imagem, String preco, int calorias, String info) {
		super();
		this.codigoProduto = codigoProduto;
		this.disponivel = disponivel;
		this.nome = nome;
		this.tipo = tipo;
		this.imagem = imagem;
		this.preco = preco;
		this.calorias = calorias;
		this.info = info;
	}

	public Long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}

	public Long getCodigoProduto() {
		return codigoProduto;
	}

	public void setCodigoProduto(Long codigoProduto) {
		this.codigoProduto = codigoProduto;
	}

	public boolean isDisponivel() {
		return disponivel;
	}

	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public byte[] getImagem() {
		return imagem;
	}

	public void setImagem(byte[] imagem) {
		this.imagem = imagem;
	}

	public String getPreco() {
		return preco;
	}

	public void setPreco(String preco) {
		this.preco = preco;
	}

	public int getCalorias() {
		return calorias;
	}

	public void setCalorias(int calorias) {
		this.calorias = calorias;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getPeso() {
		return peso;
	}

	public void setPeso(String peso) {
		this.peso = peso;
	}

	public int getPorcao() {
		return porcao;
	}

	public void setPorcao(int porcao) {
		this.porcao = porcao;
	}

	public List<Opcao> getOpcoes() {
		return opcoes;
	}

	public void setOpcoes(List<Opcao> opcoes) {
		this.opcoes = opcoes;
	}
	
	public boolean isInteiro() {
		return inteiro;
	}

	public void setInteiro(boolean inteiro) {
		this.inteiro = inteiro;
	}
	
	

//	public String[] getOpcoes() {
//		return opcoes;
//	}
//
//	public void setOpcoes(String[] opcoes) {
//		this.opcoes = opcoes;
//	}
//	
	
	
	
	
	
	
	
	
	

}
