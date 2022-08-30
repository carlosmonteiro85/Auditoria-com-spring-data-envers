package com.prototipo.audit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prototipo.audit.model.HistoricoAlteracaoProduto;

public interface HistoricoAlteracaoRepository extends JpaRepository<HistoricoAlteracaoProduto, Long>{
}
