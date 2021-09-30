package com.puc.cmfback.controller;

import com.puc.cmfback.model.dto.ProdutoDTO;
import com.puc.cmfback.model.dto.UsuarioDTO;
import com.puc.cmfback.model.entity.Produto;
import com.puc.cmfback.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @GetMapping(value = "/buscar-por-id/{id}")
    @CrossOrigin(origins = "http://localhost:8100")
    public ResponseEntity<ProdutoDTO> buscarUsuarioPorEmail(@RequestParam Integer id) {
        var resposta = service.buscarProdutoPorId(id);
        return ResponseEntity.status(HttpStatus.OK).body(resposta);
    }

    @GetMapping(value = "/buscar-todos")
    @CrossOrigin(origins = "http://localhost:8100")
    public ResponseEntity<List<ProdutoDTO>> buscarTodosOsUsuarios() {
        var resposta = service.buscarTodos();
        return ResponseEntity.ok().body(resposta);
    }

    @GetMapping(value = "/buscar-por-nome/{nome}")
    @CrossOrigin(origins = "http://localhost:8100")
    public ResponseEntity<List<ProdutoDTO>> buscarProdutosProNome(@RequestParam String nome) {
        var resposta = service.buscarProdutoPorNome(nome);
        return ResponseEntity.ok().body(resposta);
    }

    @PostMapping(value = "/cadastrar")
    @CrossOrigin(origins = "http://localhost:8100")
    public ResponseEntity<ProdutoDTO> criarProduto(@RequestBody ProdutoDTO produtoDTO) {
        var resposta = service.criarProduto(produtoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(resposta);
    }

    @PutMapping(value = "/atualizar")
    @CrossOrigin(origins = "http://localhost:8100")
    public ResponseEntity<ProdutoDTO> atualizarUsuario(@RequestBody ProdutoDTO produtoDTO) {
        service.atualizarProduto(produtoDTO);
        return ResponseEntity.status(HttpStatus.OK).body(produtoDTO);
    }

    @DeleteMapping(value = "/deletar/{id}")
    @CrossOrigin(origins = "http://localhost:8100")
    public ResponseEntity.BodyBuilder deletarUsuarioPorId(@RequestParam Integer id) {
        service.deletarProdutoPorId(id);
        return ResponseEntity.ok();
    }
}
