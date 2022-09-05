package com.prototipo.audit.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.prototipo.audit.model.ProdutoAudit;

@Repository
@Transactional
public class TesteRepository {
	
	@PersistenceContext
	private EntityManager manager;
	
	public List<ProdutoAudit> listar() {
		return manager.createQuery("SELECT p FROM ProdutoAudit p ", ProdutoAudit.class).getResultList();
	}

}
