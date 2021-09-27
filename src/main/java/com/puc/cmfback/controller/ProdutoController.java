package com.puc.cmfback.controller;

import com.puc.cmfback.model.dto.LoginDTO;
import com.puc.cmfback.model.dto.ProdutoDTO;
import com.puc.cmfback.model.dto.UsuarioDTO;
import com.puc.cmfback.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping(value = "cadastrar")
    public ResponseEntity<ProdutoDTO> criarProduto(@RequestBody ProdutoDTO produtoDTO) {
        var resposta = produtoService.criarProduto(produtoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(resposta);
    }
}
