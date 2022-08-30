package com.prototipo.audit.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "produto_audit")
@Data
public class HistoricoAlteracaoProduto {
	@Id
	private Long id;
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "rev", referencedColumnName = "rev")
	private Revinfo rev;
	private Integer revtype;
	private String nome;
	private String descricao;
}
