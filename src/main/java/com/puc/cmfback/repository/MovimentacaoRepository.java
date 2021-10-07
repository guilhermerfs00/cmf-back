package com.puc.cmfback.repository;


import com.puc.cmfback.model.entity.Movimentacao;
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
public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Integer> {

    List<Movimentacao> findAllByDataCriacaoBetween(LocalDate startDate, LocalDate endDate);

    List<Movimentacao> findAllByTipoMovimentacao(String tipoMovimentacao);

    List<Movimentacao> findAllByOrdem(String oredem);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Movimentacao (ordem, tipo_movimentacao, valor, id_produto, id_usuario, data_criacao) " +
            " VALUES (:ordem, :tipoMovimentacao, :valor, :idProduto, :idUsuario, :dataCriacao)", nativeQuery = true)
    void criarMovimentacaoComProduto(@Param("ordem") String ordem, @Param("tipoMovimentacao") String tipoMovimentacao,
                                     @Param("valor") BigDecimal valor, @Param("idProduto") Integer idProduto,
                                     @Param("idUsuario") Integer idUsuario, @Param("dataCriacao") LocalDate dataCriacao);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Movimentacao (ordem, tipo_movimentacao, valor, id_produto, id_usuario, data_criacao) " +
            " VALUES (:ordem, :tipoMovimentacao, :valor, null, :idUsuario, :dataCriacao)", nativeQuery = true)
    void criarMovimentacaoSemProduto(@Param("ordem") String ordem, @Param("tipoMovimentacao") String tipoMovimentacao,
                                     @Param("valor") BigDecimal valor, @Param("idUsuario") Integer idUsuario, @Param("dataCriacao") LocalDate dataCriacao);
}
