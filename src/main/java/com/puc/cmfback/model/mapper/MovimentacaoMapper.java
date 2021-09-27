package com.puc.cmfback.model.mapper;

import com.puc.cmfback.model.dto.MovimentacaoDTO;
import com.puc.cmfback.model.dto.ProdutoDTO;
import com.puc.cmfback.model.entity.Movimentacao;
import com.puc.cmfback.model.entity.Produto;
import org.springframework.beans.BeanUtils;

import static java.util.Objects.isNull;

public class MovimentacaoMapper {

    public static MovimentacaoDTO entityToDto(Movimentacao movimentacao) {
        MovimentacaoDTO movimentacaoDTO = new MovimentacaoDTO();
        if (!isNull(movimentacao)) {
            BeanUtils.copyProperties(movimentacao, movimentacaoDTO);
        }
        return movimentacaoDTO;
    }

    public static Movimentacao dtoToEntity(MovimentacaoDTO movimentacaoDTO) {
        Movimentacao movimentacao = new Movimentacao();
        if (!isNull(movimentacaoDTO)) {
            BeanUtils.copyProperties(movimentacaoDTO, movimentacao);
        }
        return movimentacao;
    }
}