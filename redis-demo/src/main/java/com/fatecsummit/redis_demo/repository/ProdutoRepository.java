package com.fatecsummit.redis_demo.repository;

import com.fatecsummit.redis_demo.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProdutoRepository extends JpaRepository<Produto, UUID> {
}
