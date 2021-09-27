package com.puc.cmfback.repository;


import com.puc.cmfback.model.entity.Produto;
import com.puc.cmfback.model.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
