package com.puc.cmfback.service;

import com.puc.cmfback.exception.errors.UsuarioException;
import com.puc.cmfback.model.dto.MovimentacaoDTO;
import com.puc.cmfback.model.entity.Movimentacao;
import com.puc.cmfback.model.mapper.MovimentacaoMapper;
import com.puc.cmfback.repository.MovimentacaoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

import static java.util.Objects.isNull;
import static java.util.stream.Collectors.toList;
import static org.springframework.http.HttpStatus.NO_CONTENT;


@Service
@Slf4j
public class MovimentacaoService {

    public static final String NENHUMA_MOVIMENTACAO_ENCONTRADA = "Nenhuma movimentacao encontrada";

    @Autowired
    private MovimentacaoRepository repository;

    public MovimentacaoDTO criarMovimentacao(MovimentacaoDTO movimentacaoDTO) {
        try {
            repository.criarMovimentacao(movimentacaoDTO.getOrdem().toString(), movimentacaoDTO.getTipoMovimentacao().toString(),
                    movimentacaoDTO.getValor(), movimentacaoDTO.getIdProduto(), movimentacaoDTO.getIdUsuario(), LocalDate.now());

            return movimentacaoDTO;
        } catch (Exception e) {
            throw new UsuarioException("Erro ao salvar produto", HttpStatus.BAD_REQUEST);
        }
    }

    public List<MovimentacaoDTO> buscarMovimentacaoPorData(LocalDate dataInicial, LocalDate dataFinal) {
        var movimentacoes = repository.findAllByDataCriacaoBetween(dataInicial, dataFinal);

        if (isNull(movimentacoes) || movimentacoes.isEmpty()) {
            throw new UsuarioException(NENHUMA_MOVIMENTACAO_ENCONTRADA, NO_CONTENT);
        }

        return buscarIdsTipoMovimentacao(movimentacoes);
    }

    public List<MovimentacaoDTO> buscarMovimentacaoPorTipoMovimentacao(String tipoMovimentacaoEnum) {
        var movimentacoes = repository.findAllByTipoMovimentacao(tipoMovimentacaoEnum);

        if (isNull(movimentacoes) || movimentacoes.isEmpty()) {
            throw new UsuarioException(NENHUMA_MOVIMENTACAO_ENCONTRADA, NO_CONTENT);
        }
        return buscarIdsTipoMovimentacao(movimentacoes);
    }

    public List<MovimentacaoDTO> buscarMovimentacaoPorTipoOrdem(String ordemEnum) {
        var movimentacoes = repository.findAllByOrdem(ordemEnum);

        if (isNull(movimentacoes) || movimentacoes.isEmpty()) {
            throw new UsuarioException(NENHUMA_MOVIMENTACAO_ENCONTRADA, NO_CONTENT);
        }

        return buscarIdsTipoMovimentacao(movimentacoes);
    }

    private List<MovimentacaoDTO> buscarIdsTipoMovimentacao(List<Movimentacao> movimentacoes) {
        return movimentacoes.stream().map(movimentacao -> {
            var movimentacaoDTO = MovimentacaoMapper.INSTANCE.entityToDto(movimentacao);

            movimentacaoDTO.setIdProduto(movimentacao.getProduto().getIdProduto());
            movimentacaoDTO.setIdUsuario(movimentacao.getUsuario().getIdUsuario());

            return movimentacaoDTO;
        }).collect(toList());
    }
}