package com.puc.cmfback.model.mapper;

import com.puc.cmfback.model.dto.ProdutoDTO;
import com.puc.cmfback.model.dto.UsuarioDTO;
import com.puc.cmfback.model.entity.Produto;
import com.puc.cmfback.model.entity.Usuario;
import org.springframework.beans.BeanUtils;

import static java.util.Objects.isNull;

public class ProdutoMapper {

    public static ProdutoDTO entityToDto(Produto produto) {
        ProdutoDTO produtoDTO = new ProdutoDTO();
        if (!isNull(produto)) {
            BeanUtils.copyProperties(produto, produtoDTO);
        }
        return produtoDTO;
    }

    public static Produto dtoToEntity(ProdutoDTO produtoDTO) {
        Produto produto = new Produto();
        if (!isNull(produtoDTO)) {
            BeanUtils.copyProperties(produtoDTO, produto);
        }
        return produto;
    }
}