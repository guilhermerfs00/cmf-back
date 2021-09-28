package com.puc.cmfback.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Table(name = "movimentacao")
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Movimentacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idMovimentacao", unique = true, nullable = false)
    private Long idMovimentacao;

    private BigDecimal valor;

    private String tipoMovimentacao;

    private String ordem;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "id_produto")
    private Produto produto;
}
