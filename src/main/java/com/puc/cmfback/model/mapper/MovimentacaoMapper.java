package com.puc.cmfback.model.mapper;

import com.puc.cmfback.model.dto.MovimentacaoDTO;
import com.puc.cmfback.model.dto.ProdutoDTO;
import com.puc.cmfback.model.dto.UsuarioDTO;
import com.puc.cmfback.model.entity.Movimentacao;
import com.puc.cmfback.model.entity.Produto;
import com.puc.cmfback.model.entity.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.BeanUtils;

import static java.util.Objects.isNull;

@Mapper
public interface MovimentacaoMapper {
    MovimentacaoMapper INSTANCE = Mappers.getMapper(MovimentacaoMapper.class);

    MovimentacaoDTO entityToDto(Movimentacao movimentacao);

    Movimentacao dtoToEntity(MovimentacaoDTO movimentacaoDTO);
}