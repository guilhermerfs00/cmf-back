package com.puc.cmfback.service;

import com.puc.cmfback.exception.errors.UsuarioException;
import com.puc.cmfback.model.dto.MovimentacaoDTO;
import com.puc.cmfback.model.mapper.MovimentacaoMapper;
import com.puc.cmfback.repository.MovimentacaoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class MovimentacaoService {

    @Autowired
    private MovimentacaoRepository repository;

    public MovimentacaoDTO criarMovimentacao(MovimentacaoDTO movimentacaoDTO) {
        try {
            var movimentacao = MovimentacaoMapper.dtoToEntity(movimentacaoDTO);
            movimentacao = repository.save(movimentacao);
            return MovimentacaoMapper.entityToDto(movimentacao);
        } catch (Exception e) {
            throw new UsuarioException("Erro ao salvar produto: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}