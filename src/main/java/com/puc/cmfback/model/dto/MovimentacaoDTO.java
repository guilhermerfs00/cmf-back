package com.puc.cmfback.model.dto;


import com.puc.cmfback.model.enums.OrdemEnum;
import com.puc.cmfback.model.enums.TipoMovimentacaoEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MovimentacaoDTO {

    private OrdemEnum ordem;

    private TipoMovimentacaoEnum tipoMovimentacao;

    private BigDecimal valor;

    private Long idUsuario;

    private Long IdProduto;

}
