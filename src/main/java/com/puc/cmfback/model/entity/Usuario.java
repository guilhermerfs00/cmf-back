package com.puc.cmfback.model.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Table(name = "usuario")
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

    @Id
    private String email;

    private String nome;

    private String senha;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCriacao;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAtualizacao;
}
