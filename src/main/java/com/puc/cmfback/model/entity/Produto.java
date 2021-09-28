package com.puc.cmfback.model.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Table(name = "produto")
@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProduto", unique = true, nullable = false)
    private Long idProduto;

    private String nome;

    private Integer quantidade;

    @JsonManagedReference
    @OneToMany(mappedBy = "produto", targetEntity = Movimentacao.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Movimentacao> movimentacao = new HashSet<>();


}
