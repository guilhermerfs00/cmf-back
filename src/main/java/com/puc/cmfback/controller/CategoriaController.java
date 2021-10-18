package com.puc.cmfback.controller;

import com.puc.cmfback.model.dto.CategoriaDTO;
import com.puc.cmfback.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService service;

    @PostMapping(value = "/cadastrar")
    public ResponseEntity<CategoriaDTO> criarCategoria(@RequestBody CategoriaDTO categoriaDTO) {
        var resposta = service.criarCategoria(categoriaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(resposta);
    }

    @PutMapping(value = "/atualizar")
    public ResponseEntity<CategoriaDTO> atualizarUsuario(@RequestBody CategoriaDTO categoriaDTO) {
        service.atualizarCategoria(categoriaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(categoriaDTO);
    }

    @GetMapping(value = "/buscar-por-nome")
    public ResponseEntity<CategoriaDTO> buscarCategoriaPorNome(@RequestParam String nome) {
        var resposta = service.buscarCategoriaPorNome(nome);
        return ResponseEntity.ok().body(resposta);
    }

    @DeleteMapping(value = "/deletar/{id}")
    public ResponseEntity.BodyBuilder deletarCategoriaPorId(@RequestParam Integer id) {
        service.deletarCategoriaPorId(id);
        return ResponseEntity.ok();
    }
}