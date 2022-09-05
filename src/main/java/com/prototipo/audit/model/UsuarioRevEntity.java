package com.prototipo.audit.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.envers.RevisionEntity;
import org.hibernate.envers.RevisionNumber;
import org.hibernate.envers.RevisionTimestamp;

import lombok.Data;

/*
 * Tabela global criada pelo Envers que será usada pelas outras 
 * tabelas de auditoria
 * possue o numero de revisão (rev), data da alteração (timestampe) e 
 * usuario, (obtido pelo usuario logado, se refere ao usuário responsavel pela alteração(spring secutity) )
 * */
@Data
@Entity
@Table(name = "usuario_rev_entity")
@RevisionEntity(UsuarioListener.class)
public class UsuarioRevEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@RevisionNumber
	private Long rev;
	
	@RevisionTimestamp
	private Long timestemp;
	
	private String usuario;

}
