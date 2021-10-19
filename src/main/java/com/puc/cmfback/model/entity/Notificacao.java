package com.puc.cmfback.model.entity;

import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDateTime;

@Table(name = "notificacao")
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Notificacao {

    @Id
    private Integer idNotificacao;

    @Column(name = "data_lembrete")
    private LocalDateTime dataLembrete;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_conta")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Conta conta;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_usuario")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Usuario usuario;
}
