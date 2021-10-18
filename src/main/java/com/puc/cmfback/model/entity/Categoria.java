package com.puc.cmfback.model.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "categoria")
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Categoria {

    @Id
    private Integer idCategoria;

    @Column(name = "nome", unique = true)
    private String nome;

    @Column(name = "ordem")
    private String ordem;
}
