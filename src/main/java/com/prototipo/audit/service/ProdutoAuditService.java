package com.prototipo.audit.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.prototipo.audit.dto.HistoricoDTOResponse;
import com.prototipo.audit.model.ProdutoAudit;
import com.prototipo.audit.model.UsuarioRevEntity;
import com.prototipo.audit.repository.ProdutoAuditRepository;
import com.prototipo.audit.util.Diff;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProdutoAuditService {
	
	private final ProdutoAuditRepository repository;
	private final static Integer UPDATE = 1;
	
	/*
	 * Cria uma lista de DTO de historico de alteração
	 * @ProdutoAudit tabela criada pelo que registra as alterações sofridas
	 * */
	public List<HistoricoDTOResponse> buscarHistorico(Long id){
		
		List<ProdutoAudit> historicosBD = repository.findHistorico(id);
		
		List<HistoricoDTOResponse> relatorioAlteracao = new ArrayList<>();
		
		for (int i = 0; historicosBD.size() > i; i++ ) {
			ProdutoAudit historicoAtual = historicosBD.get(i);
			
			Integer acaoHistorico = historicoAtual.getRevtype();
			UsuarioRevEntity revisao = historicoAtual.getId().getRev();
			
			if(acaoHistorico == UPDATE) {
				ProdutoAudit historicoAnterior = historicosBD.get(i - 1);
				// Compara e registra a diferença dos campos que sofreram alteração na lista relatorioAlteracao
				new Diff().gerarHistorico(historicoAnterior, historicoAtual, revisao, relatorioAlteracao);
			}
		}
		return relatorioAlteracao;
	}
}
