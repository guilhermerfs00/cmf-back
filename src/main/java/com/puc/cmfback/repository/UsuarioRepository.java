package com.puc.cmfback.repository;


import com.puc.cmfback.model.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    Optional<Usuario> findByEmail(String email);

    @Transactional
    void deleteByEmail(String email);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Usuario (email, nome, senha) VALUES (:email, :nome, :senha)", nativeQuery = true)
    void criarUsuario(@Param("email") String email, @Param("nome") String nome, @Param("senha") String senha);
}
