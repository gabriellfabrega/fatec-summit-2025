package br.com.fatecsummit.rest_demo.service;

import br.com.fatecsummit.rest_demo.domain.Produto;
import br.com.fatecsummit.rest_demo.dto.ProdutoInputDto;
import br.com.fatecsummit.rest_demo.exception.EntidadeNaoEncontradaException;
import br.com.fatecsummit.rest_demo.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProdutoService {

    @Autowired
    ProdutoRepository repository;

    public Produto inserir(ProdutoInputDto input){
        Produto produto = new Produto(
                UUID.randomUUID(),
                input.getDescricao(),
                input.getValor());
        return repository.save(produto);
    }

    public List<Produto> listar(){
        return repository.findAll();
    }

    public Produto buscar(UUID uuid){
        return repository.findById(uuid)
                .orElseThrow(() -> new EntidadeNaoEncontradaException() {
                });
    }


    public void excluir(UUID uuid) {
        Produto produto = buscar(uuid);
        repository.delete(produto);
    }

    public Produto alterar(UUID uuid, ProdutoInputDto input) {
        Produto produto = buscar(uuid);

        if (!produto.getDescricao().equals(input.getDescricao())){
            produto.setDescricao(input.getDescricao());
        }

        if (!produto.getValor().equals(input.getValor())){
            produto.setValor(input.getValor());
        }

        return repository.save(produto);

    }
}
