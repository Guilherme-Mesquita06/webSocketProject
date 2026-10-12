package chat.com.estudoChatComLogin.controller;

import chat.com.estudoChatComLogin.dto.UsuarioDto;
import chat.com.estudoChatComLogin.entity.Usuario;
import chat.com.estudoChatComLogin.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    private UsuarioDto toResponse(Usuario usuario) {
        UsuarioDto dto = new UsuarioDto();
        dto.setIdUsuario(usuario.getUuid());
        dto.setNome(usuario.getNome());
        dto.setEmail(usuario.getEmail());
        return dto; // senha nunca volta na resposta
    }
}


