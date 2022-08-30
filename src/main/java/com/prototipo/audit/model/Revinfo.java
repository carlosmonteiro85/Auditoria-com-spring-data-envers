package com.prototipo.audit.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "revinfo")
public class Revinfo {
	
	@Id
	private Long rev;
	private Long revtstmp;

}
