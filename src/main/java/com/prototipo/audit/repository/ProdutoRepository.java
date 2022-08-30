package com.prototipo.audit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.history.RevisionRepository;

import com.prototipo.audit.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> , RevisionRepository<Produto, Long, Long>{
}
