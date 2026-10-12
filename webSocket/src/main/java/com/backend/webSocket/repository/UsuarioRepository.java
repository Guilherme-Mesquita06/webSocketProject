package com.backend.webSocket.repository;


import com.backend.webSocket.entity.Usuario;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
    Optional<Usuario> findByEmailAndSenha(String email, String senha);
}
