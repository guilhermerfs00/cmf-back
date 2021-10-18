package com.puc.cmfback.repository;


import com.puc.cmfback.model.entity.Categoria;
import com.puc.cmfback.model.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

    Optional<Categoria> findByNome(String nome);

    @Transactional
    void deleteByNome(String nome);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Categoria (nome, ordem) VALUES (:nome, :ordem)", nativeQuery = true)
    void criarCategoria(@Param("nome") String nome, @Param("ordem") String ordem);
}
