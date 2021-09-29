package com.puc.cmfback.model.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DataMovimentacaoDTO {

    private LocalDate dataInicio;
    private LocalDate dataFim;

}
