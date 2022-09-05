package com.prototipo.audit.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.DiffBuilder;
import org.apache.commons.lang3.builder.DiffResult;
import org.apache.commons.lang3.builder.Diffable;
import org.apache.commons.lang3.builder.ToStringStyle;

import lombok.Data;

/*
 * Tabela criada pelo Envers ao realizar alteração em produto
 * Essa classe possui chave composta, que é anotada pelo @EmbeddedId
 * essa chave composta é formada pelo id da entidade que foi alterada e pelo objeto de revisão
 * utilizado a interface Diffable<?> e implementado seu método diff que tem a finalizada de comparar
 * o objeto antigo e atual, listando suas diferenças
 * */
@Entity
@Table(name = "produto_audit")
@Data
public class ProdutoAudit implements Diffable<ProdutoAudit> {
	
	@EmbeddedId
	private Id id;
	@Column(name = "revtype")
	private Integer revtype;
	@Column(name = "nome")
	private String nome;
	@Column(name = "descricao")
	private String descricao;
	@Column(name = "preco")
	private BigDecimal preco;
	
	@Override
	public DiffResult<ProdutoAudit> diff(ProdutoAudit updatedEmp) {
  		return new DiffBuilder<ProdutoAudit>(this, updatedEmp,   ToStringStyle.SHORT_PREFIX_STYLE)
  				.append("nome", this.nome, updatedEmp.nome)
  				.append("descricao", this.descricao, updatedEmp.descricao)
  				.append("preco", this.preco, updatedEmp.preco)
  				.build();
  	}
}
