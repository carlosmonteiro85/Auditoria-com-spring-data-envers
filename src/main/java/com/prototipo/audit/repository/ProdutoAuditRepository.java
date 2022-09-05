package com.prototipo.audit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.prototipo.audit.model.ProdutoAudit;

@Repository
public interface ProdutoAuditRepository extends JpaRepository<ProdutoAudit, Long>{

	@Query(value = "SELECT * FROM PRODUTO_AUDIT WHERE ID = :idEntity ORDER BY REV", nativeQuery = true)
	List<ProdutoAudit> findHistorico(@Param("idEntity") Long idEntity);
}
