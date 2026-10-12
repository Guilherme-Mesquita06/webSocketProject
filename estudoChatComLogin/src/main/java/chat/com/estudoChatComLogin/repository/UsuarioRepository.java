package chat.com.estudoChatComLogin.repository;

import chat.com.estudoChatComLogin.entity.Usuario;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
    Optional<Usuario> findByEmailAndSenha(String email, String senha);
}
