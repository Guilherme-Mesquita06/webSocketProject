package com.backend.webSocket.service;


import com.backend.webSocket.dto.UsuarioDto;
import com.backend.webSocket.entity.Usuario;
import com.backend.webSocket.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario cadastrar(UsuarioDto dto) {
        Usuario usuario = new Usuario(dto.getNome(), dto.getEmail(), dto.getSenha());
        return usuarioRepository.save(usuario);
    }

    public Optional<Usuario> login(String email, String senha) {
        return usuarioRepository.findByEmailAndSenha(email, senha);
    }
}


