package com.puc.cmfback.service;

import com.puc.cmfback.exception.errors.NegocioException;
import com.puc.cmfback.model.dto.CategoriaDTO;
import com.puc.cmfback.model.dto.ProdutoDTO;
import com.puc.cmfback.model.mapper.CategoriaMapper;
import com.puc.cmfback.model.mapper.ProdutoMapper;
import com.puc.cmfback.repository.CategoriaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Service
@Slf4j
public class CategoriaService {

    @Autowired
    private CategoriaRepository repository;

    public CategoriaDTO buscarCategoriaPorNome(String nome) {

        var categoria = repository.findByNome(nome);

        if (!categoria.isPresent())
            throw new NegocioException("Categoria não encontrada", BAD_REQUEST);

        return CategoriaMapper.INSTANCE.entityToDto(categoria.get());
    }

    public CategoriaDTO criarCategoria(CategoriaDTO categoriaDTO) {
        validarCategoriaJaCadastrada(categoriaDTO.getNome());

        repository.criarCategoria(categoriaDTO.getNome(), categoriaDTO.getOrdem().toString());

        var categoria = repository.findByNome(categoriaDTO.getNome()).get();

        return CategoriaMapper.INSTANCE.entityToDto(categoria);
    }

    public void atualizarCategoria(CategoriaDTO categoriaDTO) {
        try {
            var categoria = CategoriaMapper.INSTANCE.dtoToEntity(categoriaDTO);
            repository.save(categoria);
        } catch (Exception e) {
            throw new NegocioException("Erro ao atualizar categoria", BAD_REQUEST);
        }
    }

    private void validarCategoriaJaCadastrada(String nome) {
        var categoria = repository.findByNome(nome);

        if (categoria.isPresent())
            throw new NegocioException("Categoria já cadastrada", BAD_REQUEST);
    }

    public void deletarCategoriaPorId(Integer id) {
        repository.deleteById(id);
    }
}