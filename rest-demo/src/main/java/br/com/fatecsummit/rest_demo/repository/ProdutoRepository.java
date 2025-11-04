package br.com.fatecsummit.rest_demo.repository;

import br.com.fatecsummit.rest_demo.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProdutoRepository extends JpaRepository<Produto, UUID> {
}
