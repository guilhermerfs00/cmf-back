package com.puc.cmfback.controller;

import com.puc.cmfback.model.dto.NotificacaoDTO;
import com.puc.cmfback.service.NotificacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/notificacao")
public class NotificacaoController {

    @Autowired
    private NotificacaoService service;

    @PostMapping(value = "/cadastrar")
    public ResponseEntity<String> criarCategoria(@RequestBody NotificacaoDTO categoriaDTO) {
        var resposta = service.criarNotificacao(categoriaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(resposta);
    }
//
//    @GetMapping(value = "/buscar-por-conta/{idConta}")
//    public ResponseEntity<NotificacaoDTO> buscarNotificacaoPorConta(@RequestParam Integer idConta) {
//        var resposta = service.buscarNotificacaoPorConta(idConta);
//        return ResponseEntity.ok().body(resposta);
//    }
//
//    @DeleteMapping(value = "/deletar/{id}")
//    public ResponseEntity.BodyBuilder deletarCategoriaPorId(@RequestParam Integer id) {
//        service.deletarCategoriaPorId(id);
//        return ResponseEntity.ok();
//    }
}