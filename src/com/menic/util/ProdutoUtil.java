package com.menic.util;


import com.menic.produto.Produto;

public class ProdutoUtil {
	
	private static ProdutoUtil instance;
	private static Produto currentProduto;
	
	
	
	public static ProdutoUtil getInstance() {
		if (instance == null) {
			instance = new ProdutoUtil();
		}

		return instance;
	}


	public  Produto getCurrentProduto() {
		return currentProduto;
	}


	public void setCurrentProduto(Produto currentProduto) {
		ProdutoUtil.currentProduto = currentProduto;
	}
	
	
	
	
	

}
