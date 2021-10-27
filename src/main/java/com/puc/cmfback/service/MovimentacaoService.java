package com.puc.cmfback.service;

import com.puc.cmfback.exception.errors.NegocioException;
import com.puc.cmfback.model.dto.MovimentacaoDTO;
import com.puc.cmfback.model.entity.Movimentacao;
import com.puc.cmfback.model.mapper.MovimentacaoMapper;
import com.puc.cmfback.repository.CategoriaRepository;
import com.puc.cmfback.repository.MovimentacaoRepository;
import com.puc.cmfback.repository.ProdutoRepository;
import com.puc.cmfback.repository.UsuarioRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

import static java.util.Objects.isNull;
import static java.util.stream.Collectors.toList;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.NO_CONTENT;


@Service
@Slf4j
public class MovimentacaoService {

    public static final String NENHUMA_MOVIMENTACAO_ENCONTRADA = "Nenhuma movimentacao encontrada";

    @Autowired
    private MovimentacaoRepository movimentacaoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    public MovimentacaoDTO criarMovimentacao(MovimentacaoDTO movimentacaoDTO) {
        var usuario = usuarioRepository.findById(movimentacaoDTO.getIdUsuario());

        if (!usuario.isPresent())
            throw new NegocioException("Usuario não encontrado", NOT_FOUND);

        var categoria = categoriaRepository.findById(movimentacaoDTO.getIdCategoria());

        if (!categoria.isPresent())
            throw new NegocioException("Categoria não encontrada", NOT_FOUND);

        var produto = produtoRepository.findById(movimentacaoDTO.getIdProduto());

        if (!produto.isPresent())
            throw new NegocioException("Produto não encontrado", NOT_FOUND);

        var movimentacao = MovimentacaoMapper.INSTANCE.dtoToEntity(movimentacaoDTO);
        movimentacao.setUsuario(usuario.get());
        movimentacao.setProduto(produto.get());
        movimentacao.setCategoria(categoria.get());

        movimentacao = movimentacaoRepository.save(movimentacao);

        movimentacaoDTO = MovimentacaoMapper.INSTANCE.entityToDto(movimentacao);
        movimentacaoDTO.setIdUsuario(movimentacao.getUsuario().getIdUsuario());
        movimentacaoDTO.setIdProduto(movimentacao.getProduto().getIdProduto());
        movimentacaoDTO.setIdCategoria(movimentacao.getCategoria().getIdCategoria());

        return movimentacaoDTO;
    }

    public List<MovimentacaoDTO> buscarMovimentacaoPorData(LocalDate dataInicial, LocalDate dataFinal) {
        var movimentacoes = movimentacaoRepository.findAllByDataCriacaoBetween(dataInicial, dataFinal);

        if (isNull(movimentacoes) || movimentacoes.isEmpty()) {
            throw new NegocioException(NENHUMA_MOVIMENTACAO_ENCONTRADA, NO_CONTENT);
        }

        return buscarIdsTipoMovimentacao(movimentacoes);
    }

    public List<MovimentacaoDTO> buscarMovimentacaoPorTipoMovimentacao(String tipoMovimentacaoEnum) {
        var movimentacoes = movimentacaoRepository.findAllByTipoMovimentacao(tipoMovimentacaoEnum);

        if (isNull(movimentacoes) || movimentacoes.isEmpty()) {
            throw new NegocioException(NENHUMA_MOVIMENTACAO_ENCONTRADA, NO_CONTENT);
        }
        return buscarIdsTipoMovimentacao(movimentacoes);
    }

    public List<MovimentacaoDTO> buscarMovimentacaoPorTipoOrdem(String ordemEnum) {
        var movimentacoes = movimentacaoRepository.findAllByOrdem(ordemEnum);

        if (isNull(movimentacoes) || movimentacoes.isEmpty()) {
            throw new NegocioException(NENHUMA_MOVIMENTACAO_ENCONTRADA, NO_CONTENT);
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