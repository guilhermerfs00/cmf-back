package com.puc.cmfback.controller;

import com.puc.cmfback.model.dto.LoginDTO;
import com.puc.cmfback.model.dto.UsuarioDTO;
import com.puc.cmfback.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<UsuarioDTO> buscarUsuarioPorEmail(@RequestParam String email) {
        var resposta = usuarioService.buscarUsuarioPorEmail(email);
        return ResponseEntity.ok().body(resposta);
    }

    @GetMapping(value = "/buscar-todos")
    public ResponseEntity<List<UsuarioDTO>> buscarTodosOsUsuarios() {
        var resposta = usuarioService.buscarTodosOsUsuarios();
        return ResponseEntity.ok().body(resposta);
    }

    @PostMapping(value = "cadastrar")
    public ResponseEntity<UsuarioDTO> criarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        var resposta = usuarioService.criarUsuario(usuarioDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(resposta);
    }

    @PutMapping
    public ResponseEntity<UsuarioDTO> atualizarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        usuarioService.atualizarUsuario(usuarioDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioDTO);
    }

    @DeleteMapping(value = "/{email}")
    public ResponseEntity.BodyBuilder deletarUsuarioPorId(@RequestParam String email) {
        usuarioService.deletarUsuarioPorEmail(email);
        return ResponseEntity.ok();
    }

    @GetMapping(value = "/login")
    public ResponseEntity<Boolean> login(@RequestHeader String email, @RequestHeader String senha) {
        var resposta = usuarioService.login(email, senha);
        return ResponseEntity.ok().body(resposta);
    }
}
