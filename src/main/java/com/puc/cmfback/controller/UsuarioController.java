package com.puc.cmfback.controller;

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
    private UsuarioService service;

    @GetMapping(value = "/buscar-por-email/{email}")
    @CrossOrigin(origins = "http://localhost:8100")
    public ResponseEntity<UsuarioDTO> buscarUsuarioPorEmail(@RequestParam String email) {
        var resposta = service.buscarUsuarioPorEmail(email);
        return ResponseEntity.ok().body(resposta);
    }

    @GetMapping(value = "/buscar-todos")
    @CrossOrigin(origins = "http://localhost:8100")
    public ResponseEntity<List<UsuarioDTO>> buscarTodosOsUsuarios() {
        var resposta = service.buscarTodosOsUsuarios();
        return ResponseEntity.ok().body(resposta);
    }

    @PostMapping(value = "/cadastrar")
    @CrossOrigin(origins = "http://localhost:8100")
    public ResponseEntity<UsuarioDTO> criarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        var resposta = service.criarUsuario(usuarioDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(resposta);
    }

    @PutMapping(value = "/atualizar")
    @CrossOrigin(origins = "http://localhost:8100")
    public ResponseEntity<UsuarioDTO> atualizarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        service.atualizarUsuario(usuarioDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioDTO);
    }

    @DeleteMapping(value = "/deletar/{email}")
    @CrossOrigin(origins = "http://localhost:8100")
    public ResponseEntity.BodyBuilder deletarUsuarioPorId(@RequestParam String email) {
        service.deletarUsuarioPorEmail(email);
        return ResponseEntity.ok();
    }

    @PostMapping(value = "/login")
    @CrossOrigin(origins = "http://localhost:8100")
    public ResponseEntity<Boolean> login(@RequestHeader String email, @RequestHeader String senha) {
        var resposta = service.login(email, senha);
        return ResponseEntity.ok().body(resposta);
    }
}
