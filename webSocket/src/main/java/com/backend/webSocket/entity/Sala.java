package com.backend.webSocket.entity;


import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;
import org.hibernate.validator.constraints.UUID;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Sala {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @UuidGenerator
    @Column(nullable = false, unique = true, updatable = false)
    private UUID uuid;

    @OneToMany
    private List<Long> idUsuarios = new ArrayList<>();

    @OneToMany
    private List<Mensagem> mensagens = new ArrayList<>();

    public void adicionarUsuario(Long idUsuario) {
        idUsuarios.add(idUsuario);
    }




    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public List<Long> getIdUsuarios() {
        return idUsuarios;
    }

    public void setIdUsuarios(List<Long> idUsuarios) {
        this.idUsuarios = idUsuarios;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Mensagem> getMensagens() {
        return mensagens;
    }

    public void setMensagens(List<Mensagem> mensagens) {
        this.mensagens = mensagens;
    }
}
