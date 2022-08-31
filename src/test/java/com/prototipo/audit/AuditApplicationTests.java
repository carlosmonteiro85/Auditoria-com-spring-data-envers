//package com.prototipo.audit;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//import static org.junit.jupiter.api.Assertions.assertNull;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//import java.math.BigDecimal;
//import java.util.List;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import com.prototipo.audit.model.HistoricoAlteracaoProduto;
//import com.prototipo.audit.model.Produto;
//import com.prototipo.audit.repository.HistoricoAlteracaoRepository;
//import com.prototipo.audit.repository.ProdutoRepository;
//
//@SpringBootTest
//public class AuditApplicationTests {
//
//	@Autowired
//	private ProdutoRepository repository;
//	@Autowired
//	private HistoricoAlteracaoRepository historycoRepository;
//	private Produto produto;
//	
//	@Test
//	public void asdf() {
//		repository.save(produto);
//		assertNotNull(produto.getId());
//	}
//	
//	@Test
//	public void qwerty() {
//		repository.save(produto);
//		
//		Produto prudutoAtualizado = repository.findById(produto.getId()).orElse(new Produto());
//		prudutoAtualizado.setDescricao("Descrição atualizada");
//		prudutoAtualizado.setNome("Nome atualizado");
//		prudutoAtualizado.setPreco(new BigDecimal(10));
//		repository.save(prudutoAtualizado);
//		
//		prudutoAtualizado.setDescricao("Descrição atualizada 2");
//		prudutoAtualizado.setNome("Nome atualizado 2 ");
//		prudutoAtualizado.setPreco(new BigDecimal(12));
//		repository.save(prudutoAtualizado);
//		
//		prudutoAtualizado.setDescricao("Descrição atualizada 3");
//		prudutoAtualizado.setNome("Nome atualizado 3 ");
//		prudutoAtualizado.setPreco(new BigDecimal(13));
//		repository.save(prudutoAtualizado);
//		
//		Produto prudutoGet = repository.findById(produto.getId()).orElse(new Produto());
//
//		assertEquals(produto.getId(), prudutoAtualizado.getId());
//		assertEquals(prudutoGet, prudutoAtualizado);
//	}
//	
//	@Test
//	public void zxcv() {
//		repository.save(produto);
//		Produto prudutoGet = repository.findById(produto.getId()).orElse(new Produto());
//		repository.delete(prudutoGet);
//		
//		Produto asdf = repository.findById(prudutoGet.getId()).orElse(new Produto());
//		
//		assertNull(asdf.getId());
//	}
//	
//	@BeforeEach
//	private void criarProduto() {
//		produto = new Produto();
//		produto.setDescricao("descrição produto");
//		produto.setNome("Nome Produto");
//	}
//	
//	@Test
//	public void asas() {
//		repository.save(produto);
//
//		List<HistoricoAlteracaoProduto> historicos= historycoRepository.findAll();
//		System.out.println(historicos);
//		
//		assertTrue(historicos.size() > 0);
//	}
//
//}
