package com.puc.cmfback.service;

import com.puc.cmfback.exception.errors.UsuarioException;
import com.puc.cmfback.model.dto.LoginDTO;
import com.puc.cmfback.model.dto.ProdutoDTO;
import com.puc.cmfback.model.dto.UsuarioDTO;
import com.puc.cmfback.model.mapper.ProdutoMapper;
import com.puc.cmfback.model.mapper.UsuarioMapper;
import com.puc.cmfback.repository.ProdutoRepository;
import com.puc.cmfback.repository.UsuarioRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Objects.isNull;
import static java.util.stream.Collectors.toList;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;


@Service
@Slf4j
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    public ProdutoDTO criarProduto(ProdutoDTO produtoDTO) {
        try {
            var produto = ProdutoMapper.INSTANCE.dtoToEntity(produtoDTO);
            produto = repository.save(produto);
            return ProdutoMapper.INSTANCE.entityToDto(produto);
        } catch (Exception e) {
            throw new UsuarioException("Erro ao salvar produto: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}