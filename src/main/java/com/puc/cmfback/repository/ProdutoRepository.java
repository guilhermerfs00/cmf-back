package com.puc.cmfback.repository;


import com.puc.cmfback.model.entity.Produto;
import com.puc.cmfback.model.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

    Produto findByNome(String nome);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Produto (nome, quantidade) VALUES (:nome, :quantidade)", nativeQuery = true)
    Integer criarProduto(@Param("nome") String nome, @Param("quantidade") Integer quantidade);


    List<Produto> findByNomeStartingWith(String nome);
}
