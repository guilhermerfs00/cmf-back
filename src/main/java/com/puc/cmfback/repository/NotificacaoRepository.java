package com.puc.cmfback.repository;


import com.puc.cmfback.model.entity.Conta;
import com.puc.cmfback.model.entity.Movimentacao;
import com.puc.cmfback.model.entity.Notificacao;
import com.puc.cmfback.model.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface NotificacaoRepository extends JpaRepository<Notificacao, Integer> {


    List<Notificacao> findAllByConta(Conta conta);

    List<Notificacao> findAllByUsuario(Usuario usuario);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Notificacao (data_lembrete, id_conta, id_usuario) VALUES (:dataLembrete, :idConta, :idUsuario)", nativeQuery = true)
    void criarNotificacao(@Param("dataLembrete") LocalDateTime dataLembrete, @Param("idConta") Integer idConta, @Param("idUsuario") Integer idUsuario);
}
