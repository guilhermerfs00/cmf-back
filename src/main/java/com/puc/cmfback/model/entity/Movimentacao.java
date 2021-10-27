package com.puc.cmfback.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Table(name = "movimentacao")
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Movimentacao implements Serializable {

    @Id
    @GeneratedValue(generator = "movimentacao_generator")
    @SequenceGenerator(name = "movimentacao_generator", sequenceName = "movimentacao_sequence")
    private Integer idMovimentacao;

    private BigDecimal valor;

    private String tipoMovimentacao;

    private String ordem;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_produto")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Produto produto;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_usuario")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_categoria")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Categoria categoria;

    private LocalDate dataCriacao;
}
