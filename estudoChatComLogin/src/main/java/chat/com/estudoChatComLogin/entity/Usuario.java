package chat.com.estudoChatComLogin.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.annotations.UuidGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @UuidGenerator
    @Column(nullable = false, unique = true, updatable = false)
    private UUID uuid;


    @NotBlank
    @Column(nullable = false, length = 100)
    private String nome;

    @Email
    @NotBlank
    @Column(nullable = false, unique = true, length = 150)
    private String email;

    @NotBlank
    @Column(nullable = false)
    private String senha;

    @OneToMany(mappedBy = "usuario1")
    private List<Chat> salasComoUsuario1 = new ArrayList<>();

    @OneToMany(mappedBy = "usuario2")
    private List<Chat> salasComoUsuario2 = new ArrayList<>();

    public Usuario() {
    }

    public Usuario(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public List<Chat> getSalasComoUsuario1() {
        return salasComoUsuario1;
    }

    public List<Chat> getSalasComoUsuario2() {
        return salasComoUsuario2;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setSalasComoUsuario1(List<Chat> salasComoUsuario1) {
        this.salasComoUsuario1 = salasComoUsuario1;
    }

    public void setSalasComoUsuario2(List<Chat> salasComoUsuario2) {
        this.salasComoUsuario2 = salasComoUsuario2;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }
}
