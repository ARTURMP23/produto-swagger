package br.com.artur.produto_service.Controller;


import br.com.artur.produto_service.Model.Produto;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    private List<Produto> produtos = new ArrayList<>();

    @PostMapping

    public ResponseEntity<String> cadastrarProduto(@RequestBody Produto produto){
        produtos.add(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Produto Cadastrado com sucesso");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscarProduto(@PathVariable Long id){
        return produtos.stream()
                .filter(produto -> produto.getId().equals(id))
                .findFirst()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

}
