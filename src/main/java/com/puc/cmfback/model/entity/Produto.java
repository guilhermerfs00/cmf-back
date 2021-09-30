package com.puc.cmfback.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Table(name = "produto")
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Produto {

    @Id
    private Integer idProduto;

    @Column(name = "nome", unique = true)
    private String nome;

    @Column(name = "quantidade")
    private Integer quantidade;
}
