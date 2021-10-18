package com.puc.cmfback.service;

import com.puc.cmfback.exception.errors.NegocioException;
import com.puc.cmfback.model.dto.NotificacaoDTO;
import com.puc.cmfback.repository.NotificacaoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class NotificacaoService {

    @Autowired
    private NotificacaoRepository repository;

//    public CategoriaDTO buscarCategoriaPorNome(String nome) {
//
//        var categoria = repository.findByNome(nome);
//
//        if (!categoria.isPresent())
//            throw new NegocioException("Categoria não encontrada", BAD_REQUEST);
//
//        return CategoriaMapper.INSTANCE.entityToDto(categoria.get());
//    }

    public String criarNotificacao(NotificacaoDTO notificacaoDTO) {

        repository.criarNotificacao(notificacaoDTO.getDataLembrete(), notificacaoDTO.getIdConta());

        return "Notificação criada com sucesso";
    }

//    public List<NotificacaoDTO> buscarNotificacaoPorConta(Integer idConta) {
//        var notificacao = repository.findById(idConta);
//        if (notificacao.isPresent()) {
//            repository.findAllByConta(notificacao.get().getConta());
//            return null;
//        } else {
//            throw new NegocioException("Nenhuma notificacao tem o id: " + idConta, HttpStatus.NOT_FOUND);
//        }
//    }

//    public void atualizarCategoria(CategoriaDTO categoriaDTO) {
//        try {
//            var categoria = CategoriaMapper.INSTANCE.dtoToEntity(categoriaDTO);
//            repository.save(categoria);
//        } catch (Exception e) {
//            throw new NegocioException("Erro ao atualizar categoria", BAD_REQUEST);
//        }
//    }
//
//    private void validarCategoriaJaCadastrada(String nome) {
//        var categoria = repository.findByNome(nome);
//
//        if (categoria.isPresent())
//            throw new NegocioException("Categoria já cadastrada", BAD_REQUEST);
//    }
//
//    public void deletarCategoriaPorId(Integer id) {
//        repository.deleteById(id);
//    }
}