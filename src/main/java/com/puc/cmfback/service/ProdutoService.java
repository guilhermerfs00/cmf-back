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
import java.util.Objects;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
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
            validarNomeProdutoJaExistente(produtoDTO.getNome());

            var produto = ProdutoMapper.INSTANCE.dtoToEntity(produtoDTO);

            produto.setIdProduto(null);
            repository.criarProduto(produto.getNome(), produto.getQuantidade());
            produto = repository.findByNome(produto.getNome());

            return ProdutoMapper.INSTANCE.entityToDto(produto);
        } catch (Exception e) {
            throw new UsuarioException("Erro ao salvar produto: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    public List<ProdutoDTO> buscarTodos() {
        try {
            var produtos = repository.findAll();

            return produtos.stream().map(ProdutoMapper.INSTANCE::entityToDto).collect(toList());
        } catch (Exception e) {
            throw new UsuarioException("Erro ao buscar todos os usuários", NOT_FOUND);
        }
    }

    public ProdutoDTO buscarProdutoPorId(Integer id) {
        var produto = repository.findById(id);

        if (isNull(produto) || !produto.isPresent()) {
            throw new UsuarioException("Produto não encontrado", NOT_FOUND);
        }

        return ProdutoMapper.INSTANCE.entityToDto(produto.get());
    }

    public List<ProdutoDTO> buscarProdutoPorNome(String nome) {
        var produtos = repository.findByNomeStartingWith(nome);

        if (isNull(produtos)) {
            throw new UsuarioException("Nenhum produto encontrado com esse nome", NOT_FOUND);
        }

        return produtos.stream().map(ProdutoMapper.INSTANCE::entityToDto).collect(toList());
    }

    public void atualizarProduto(ProdutoDTO produtoDTO) {
        try {
            var produto = ProdutoMapper.INSTANCE.dtoToEntity(produtoDTO);
            repository.save(produto);
        } catch (Exception e) {
            throw new UsuarioException("Erro ao atualizar produto", BAD_REQUEST);
        }
    }

    public void deletarProdutoPorId(Integer id) {
        repository.deleteById(id);
    }

    private void validarNomeProdutoJaExistente(String nome) {
        var produto = repository.findByNome(nome);

        if (nonNull(produto))
            throw new UsuarioException("Produto já cadastrado", BAD_REQUEST);
    }

}