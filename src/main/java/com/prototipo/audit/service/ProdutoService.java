package com.prototipo.audit.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.prototipo.audit.model.Produto;
import com.prototipo.audit.model.ProdutoAudit;
import com.prototipo.audit.repository.ProdutoAuditRepository;
import com.prototipo.audit.repository.ProdutoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProdutoService {
	
	private final ProdutoAuditRepository historicoRepository;
	private final ProdutoRepository produtoRepository;
	
	public List<ProdutoAudit> getAllUnidadesComFiltro(int pageNo, int pageSize, String sortBy, String sortDir,
			Long id, String nome, String descricao, BigDecimal preco) throws Exception {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();

        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        
        if(Objects.isNull(id)) {
        	throw new Exception();
        }
        
        if(nome.isEmpty() && descricao.isEmpty() && Objects.isNull(preco)) {
        	return historicoRepository.findAll(pageable).getContent();
        }
		
        return buscaComParametrosFiltro( id, nome, descricao, preco) ;
    }
	
	private List<ProdutoAudit> buscaComParametrosFiltro(Long id, String nome, String descricao, BigDecimal preco) {
		 
		ProdutoAudit historico = new ProdutoAudit();
//		historico.setId(id);
//		historico.setNome(nome);
//		historico.setDescricao(descricao);
//		historico.setPreco(preco);
		
		ExampleMatcher parametros = ExampleMatcher.matching()
				.withStringMatcher(StringMatcher.CONTAINING);
		return historicoRepository.findAll(Example.of(historico, parametros));
	}
	
	public void save(Produto produto) {
		produtoRepository.save(produto);
	}
	
	public Produto findById(Long id) throws Exception {
		return produtoRepository.findById(id).orElseThrow(() -> new Exception());
	}
}
