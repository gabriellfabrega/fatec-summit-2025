package com.fatecsummit.redis_demo.service;

import com.fatecsummit.redis_demo.domain.Produto;
import com.fatecsummit.redis_demo.exception.EntidadeNaoEncontradaException;
import com.fatecsummit.redis_demo.repository.ProdutoRepository;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductService {

    private final StringRedisTemplate redisTemplate;
    private final ProdutoRepository repository;

    public ProductService(StringRedisTemplate redisTemplate, ProdutoRepository repository) {
        this.redisTemplate = redisTemplate;
        this.repository = repository;
    }

    public String getProduct(UUID id) {
        // 1. Tenta buscar no cache
        String key = "product:" + id;
        String cached = redisTemplate.opsForValue().get(key);

        if (cached != null) {
            System.out.println(">> [CACHE] Retornando produto do Redis");
            return cached;
        }

        // 2. Simula busca lenta no banco
        System.out.println(">> [DB] Buscando produto no banco...");
        try {
            Thread.sleep(5000);
        }
            catch (InterruptedException ignored) {}

        Produto produto = buscar(id);
        redisTemplate.opsForValue().set(key, produto.toString());

        return produto.toString();
    }

    public List<Produto> listar(){
        return repository.findAll();
    }

    public Produto buscar(UUID uuid){
        return repository.findById(uuid)
                .orElseThrow(() -> new EntidadeNaoEncontradaException() {
                });
    }

}
