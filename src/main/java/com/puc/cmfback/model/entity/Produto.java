package com.puc.cmfback.model.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Table(name = "produto")
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduto;

    private String nome;

    private Integer quantidade;

    @JsonManagedReference
    @OneToMany(mappedBy = "produto", targetEntity = Movimentacao.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Movimentacao> movimentacao = new HashSet<>();


}
