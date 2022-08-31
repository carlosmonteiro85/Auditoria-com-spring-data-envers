package com.prototipo.audit.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prototipo.audit.dto.ProdutoDTO;
import com.prototipo.audit.model.Produto;
import com.prototipo.audit.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("produto")
@RequiredArgsConstructor
public class ProdutoController {

	private final ProdutoRepository repository;

	@PostMapping
	public ResponseEntity<Produto> saveUnidade(@RequestBody ProdutoDTO request) {
		Produto produto = request.toModel();
		try {
			repository.save(produto);
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(produto);
	}

	@PutMapping(path = "update/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Produto> update(@PathVariable Long id, @RequestBody ProdutoDTO request) {
		try {
			Produto produto = repository.findById(id).orElseThrow(() -> new Exception());
			request.copy(request, produto);
			repository.save(produto);
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}
