package com.application.web.repository;

import com.application.web.model.Usuario;
import com.application.web.projection.IdEmailUsuarioProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query("SELECT id as id, email as email FROM Usuario")
    List<IdEmailUsuarioProjection> findAll2();

}
