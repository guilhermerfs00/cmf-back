package com.puc.cmfback.controller;

import com.puc.cmfback.model.dto.MovimentacaoDTO;
import com.puc.cmfback.model.dto.ProdutoDTO;
import com.puc.cmfback.service.MovimentacaoService;
import com.puc.cmfback.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/movimentacao")
public class MovimentacaoController {

    @Autowired
    private MovimentacaoService service;

    @PostMapping(value = "cadastrar")
    public ResponseEntity<MovimentacaoDTO> criarMovimentacao(@RequestBody MovimentacaoDTO movimentacaoDTO) {
        var resposta = service.criarMovimentacao(movimentacaoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(resposta);
    }
}
