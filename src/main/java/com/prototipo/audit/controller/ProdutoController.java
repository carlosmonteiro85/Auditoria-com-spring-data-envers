package com.prototipo.audit.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prototipo.audit.dto.HistoricoDTOResponse;
import com.prototipo.audit.dto.ProdutoDTORequest;
import com.prototipo.audit.model.Produto;
import com.prototipo.audit.model.ProdutoAudit;
import com.prototipo.audit.service.ProdutoAuditService;
import com.prototipo.audit.service.ProdutoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("produto")
@RequiredArgsConstructor
public class ProdutoController {

	private final ProdutoService service;
	private final ProdutoAuditService produtoAuditservice;

	@PostMapping
	public ResponseEntity<Produto> saveUnidade(@RequestBody ProdutoDTORequest request) {
		Produto produto = request.toModel();
		try {
			service.save(produto);
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(produto);
	}

	@PutMapping(path = "update/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Produto> update(@PathVariable Long id, @RequestBody ProdutoDTORequest request) {
		try {
			Produto produto = service.findById(id);
			request.copy(request, produto);
			service.save(produto);
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	@GetMapping(params = { "page", "size" }, value = "filter")
	public ResponseEntity<List<ProdutoAudit>> findPaginated(
			@RequestParam(value = "page", defaultValue = "0", required = false) int page, 
			@RequestParam(value = "size", defaultValue = "10", required = false) int size,
			@RequestParam(value = "sortBy", defaultValue = "id", required = false) String sortBy,
			@RequestParam(value = "sortDir", defaultValue = "desc", required = false) String sortDir,
			@RequestParam(value = "id", required = true) Long id,
			@RequestParam(value = "nome", required = false) String nome,
			@RequestParam(value = "descricao", required = false) String descricao,
			@RequestParam(value = "preco",  required = false) BigDecimal preco) {
		
		List<ProdutoAudit> historico = null;
		
		try {
			historico = service.getAllUnidadesComFiltro(page, size, sortBy, sortDir, id, nome, descricao, preco );
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	    return ResponseEntity.ok(historico);
	}
	
	@GetMapping(path = "historico/{idProduto}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<HistoricoDTOResponse> buscarHistoricoAlteracao(@PathVariable Long idProduto) {
		return produtoAuditservice.buscarHistorico(idProduto);
	}
}
