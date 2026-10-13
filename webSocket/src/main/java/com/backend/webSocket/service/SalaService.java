package com.backend.webSocket.service;


import com.backend.webSocket.dto.SalaDto;
import com.backend.webSocket.dto.UsuarioDto;
import com.backend.webSocket.entity.Sala;
import com.backend.webSocket.entity.Usuario;
import com.backend.webSocket.repository.SalaRepository;
import com.backend.webSocket.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalaService {

 private SalaRepository repository;
 private UsuarioRepository usuarioRepository;

    public SalaService(SalaRepository repository, UsuarioRepository usuarioRepository) {
        this.repository = repository;
        this.usuarioRepository = usuarioRepository;
    }


    public Sala criarSala(SalaDto dto) {
        List<Long> ids = dto.getIdUsuarios().stream().distinct().toList();

        if (ids.size() < 2) {
            throw new IllegalArgumentException("A sala precisa de ao menos 2 usuários distintos.");
        }
        for (Long id : ids) {
            if (!usuarioRepository.existsById(id)) {
                throw new IllegalArgumentException("Usuário não encontrado: " + id);
            }
        }

        Sala sala = new Sala();
        ids.forEach(sala::adicionarUsuario);
        return repository.save(sala);
    }
}
