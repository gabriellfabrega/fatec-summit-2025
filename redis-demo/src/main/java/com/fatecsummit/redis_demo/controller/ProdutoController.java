package com.fatecsummit.redis_demo.controller;

import com.fatecsummit.redis_demo.domain.Produto;
import com.fatecsummit.redis_demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    ProductService service;


    @GetMapping("/{uuid}")
    public String buscar(@PathVariable UUID uuid){
        return service.getProduct(uuid);
    }

    @GetMapping
    public List<Produto> listar(){
        return service.listar();
    }


}
