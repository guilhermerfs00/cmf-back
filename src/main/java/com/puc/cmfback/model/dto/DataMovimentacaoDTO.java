package com.puc.cmfback.model.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DataMovimentacaoDTO {

    @NotEmpty
    private LocalDate dataInicio;

    @NotEmpty
    private LocalDate dataFim;

}
