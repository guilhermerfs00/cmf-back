package com.puc.cmfback.repository;


import com.puc.cmfback.model.entity.Conta;
import com.puc.cmfback.model.entity.Notificacao;
import com.puc.cmfback.model.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Integer> {


    List<Conta> findAllByUsuario(Usuario usuario);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Conta (tipo_conta, data_vencimento, valor_conta, receber_notif, id_usuario) " +
            " VALUES (:tipoConta, :dataVencimento, :valorConta, :receberNotif, :idUsuario )", nativeQuery = true)
    void criarConta(@Param("tipoConta") String tipoConta, @Param("dataVencimento") LocalDate dataVencimento,
                    @Param("valorConta") BigDecimal valorConta, @Param("receberNotif") Boolean receberNotif, @Param("idUsuario") Integer idUsuario);
}
