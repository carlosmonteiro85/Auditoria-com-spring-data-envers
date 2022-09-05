package com.prototipo.audit.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class HistoricoDTOResponse {
	private String responsavel;
	private LocalDateTime dataAlteracao;
	private LocalDateTime dataVigescia;
	private String justificativa;
	private String campo;
	private String valorAnterior;
	private String valorAtual;
}
