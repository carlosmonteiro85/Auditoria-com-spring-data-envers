package com.prototipo.audit.util;

import java.util.List;

import org.apache.commons.lang3.builder.DiffResult;
import org.apache.commons.lang3.builder.Diffable;

import com.prototipo.audit.dto.HistoricoDTOResponse;
import com.prototipo.audit.model.UsuarioRevEntity;

public class Diff {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void gerarHistorico(final Diffable objetoAntigo, final Diffable objetoNovo, UsuarioRevEntity rev,
			List<HistoricoDTOResponse> relatorioDeAlteração) {
		try {
			DiffResult<?> diffResult = objetoAntigo.diff(objetoNovo);

			for (org.apache.commons.lang3.builder.Diff<?> diff : diffResult) {

				HistoricoDTOResponse historicoAlteracaoDTO = new HistoricoDTOResponse();

					historicoAlteracaoDTO.setCampo(diff.getFieldName());
					historicoAlteracaoDTO.setValorAnterior(diff.getLeft().toString());
					historicoAlteracaoDTO.setValorAtual(diff.getRight().toString());
					historicoAlteracaoDTO.setDataAlteracao(Utils.converterTimestampData(rev.getTimestemp()));
					historicoAlteracaoDTO.setDataVigescia(null);
					historicoAlteracaoDTO.setJustificativa("jostificativa");
					historicoAlteracaoDTO.setResponsavel(rev.getUsuario().toString());
					
					relatorioDeAlteração.add(historicoAlteracaoDTO);
			}

		} catch (Exception e) {
			e.getMessage();
		}
	}
}
