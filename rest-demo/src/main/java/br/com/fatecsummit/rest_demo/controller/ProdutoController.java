package br.com.fatecsummit.rest_demo.controller;

import br.com.fatecsummit.rest_demo.domain.Produto;
import br.com.fatecsummit.rest_demo.dto.ProdutoInputDto;
import br.com.fatecsummit.rest_demo.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    ProdutoService service;

    @PostMapping
    public ResponseEntity<Produto> inserir(@RequestBody ProdutoInputDto input){
        Produto produto = service.inserir(input);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(produto);
    }

    @PutMapping("/{uuid}")
    public ResponseEntity<Produto> alterar(@PathVariable UUID uuid, @RequestBody ProdutoInputDto input){
        Produto produto = service.alterar(uuid,input);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(produto);
    }

    @GetMapping
    public ResponseEntity<List<Produto>> listar(){
        List<Produto> produtos = service.listar();
        return ResponseEntity.ok(produtos);
    }

    @GetMapping("/{uuid}")
    public Produto buscar(@PathVariable UUID uuid){
        return service.buscar(uuid);
    }

    @DeleteMapping("/{uuid}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable UUID uuid){
        service.excluir(uuid);
    }


}
