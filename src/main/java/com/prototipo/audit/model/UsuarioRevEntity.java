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

@Data
@Entity
@Table(name = "usuario_rev_entity")
@RevisionEntity(UsuarioListener.class)
public class UsuarioRevEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@RevisionNumber
	private Long id;
	
	@RevisionTimestamp
	private Long timestemp;
	
	private String usuario;

}
