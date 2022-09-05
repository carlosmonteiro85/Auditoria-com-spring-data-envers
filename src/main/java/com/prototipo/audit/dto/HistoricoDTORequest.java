package com.prototipo.audit.dto;

import java.math.BigDecimal;

import com.prototipo.audit.model.Produto;

import lombok.Data;

@Data
public class HistoricoDTORequest {
	private String nome;
	private String descricao;
	private BigDecimal preco;
	
	// este metodo pode ser implementado um model mapper
	public Produto toModel() {
		Produto produto = new Produto();
		produto.setDescricao(descricao);
		produto.setNome(nome);
		produto.setPreco(preco);
		return produto;
	}
	
	public void copy(HistoricoDTORequest produtoDTO, Produto produto) {
		produto.setDescricao(produtoDTO.getDescricao());
		produto.setNome(produtoDTO.getNome());
		produto.setPreco(produtoDTO.getPreco());
	}
}
