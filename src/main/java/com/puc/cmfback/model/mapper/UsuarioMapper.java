package com.puc.cmfback.model.mapper;

import com.puc.cmfback.model.dto.ProdutoDTO;
import com.puc.cmfback.model.dto.UsuarioDTO;
import com.puc.cmfback.model.entity.Produto;
import com.puc.cmfback.model.entity.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.BeanUtils;

import static java.util.Objects.isNull;

@Mapper
public interface UsuarioMapper {

    UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);

    UsuarioDTO entityToDto(Usuario usuario);

    Usuario dtoToEntity(UsuarioDTO usuarioDTO);
}