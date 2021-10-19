package com.puc.cmfback.model.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NotificacaoDTO {

    private Integer idNotificacao;

    @NotEmpty
    private LocalDateTime dataLembrete;

    @NotEmpty
    private Integer idConta;

    @NotEmpty
    private Integer idUsuario;

}
