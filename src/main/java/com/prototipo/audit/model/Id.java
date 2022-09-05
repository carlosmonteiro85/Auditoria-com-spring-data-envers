package com.prototipo.audit.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;

/*
 * Objeto criado com finalidade de realizar a chave composta da tabela de auditoria
 * */
@Embeddable
@Data
public class Id implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Long id;
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "rev", referencedColumnName = "rev")
	private UsuarioRevEntity rev;

}
