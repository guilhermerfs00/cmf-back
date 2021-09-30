package com.puc.cmfback.model.dto;


import com.puc.cmfback.model.enums.OrdemEnum;
import com.puc.cmfback.model.enums.TipoMovimentacaoEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MovimentacaoDTO {

    private Integer idMovimentacao;

    @NotEmpty
    private OrdemEnum ordem;

    @NotEmpty
    private TipoMovimentacaoEnum tipoMovimentacao;

    @NotEmpty
    private BigDecimal valor;

    @NotEmpty
    private Integer idUsuario;

    @NotEmpty
    private Integer idProduto;

}
