package com.backend.webSocket.controller;


import com.backend.webSocket.dto.UsuarioDto;
import com.backend.webSocket.entity.Usuario;
import com.backend.webSocket.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collector;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<UsuarioDto> cadastrar(@RequestBody UsuarioDto dto) {
        Usuario salvo = usuarioService.cadastrar(dto);
        return ResponseEntity.status(201).body(toResponse(salvo));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UsuarioDto dto) {
        return usuarioService.login(dto.getEmail(), dto.getSenha())
                .<ResponseEntity<?>>map(u -> ResponseEntity.ok(toResponse(u)))
                .orElse(ResponseEntity.status(401).body("E-mail ou senha inválidos."));
    }

    @GetMapping
    public ResponseEntity<List<UsuarioDto>> listarUsuarios() {

        List<Usuario> usuarios = usuarioService.listarUsuarios();
        List<UsuarioDto> dtos = usuarios.stream().map(this::toResponse).toList();

        return ResponseEntity.status(200).body(dtos);
    }

    private UsuarioDto toResponse(Usuario usuario) {
        UsuarioDto dto = new UsuarioDto();
        dto.setIdUsuario(usuario.getUuid());
        dto.setNome(usuario.getNome());
        dto.setEmail(usuario.getEmail());
        return dto; // senha nunca volta na resposta
    }
}


