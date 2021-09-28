package com.puc.cmfback.model.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.*;

@Table(name = "usuario")
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Usuario {

    @Id
    private String email;

    private String nome;

    private String senha;

    @JsonManagedReference
    @OneToMany(mappedBy = "usuario", targetEntity = Movimentacao.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Movimentacao> movimentacao = new HashSet<>();
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCriacao;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAtualizacao;
}
