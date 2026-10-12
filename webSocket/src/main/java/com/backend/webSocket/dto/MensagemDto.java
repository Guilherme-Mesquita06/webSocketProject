package com.backend.webSocket.dto;

import com.backend.webSocket.entity.Usuario;

import java.time.Instant;

public class MensagemDto {

    private Usuario usuarioRemetente;
    private String conteudo;
    private Instant criadoEm = Instant.now();



    public Usuario getUsuarioRemetente() {
        return usuarioRemetente;
    }

    public void setUsuarioRemetente(Usuario usuarioRemetente) {
        this.usuarioRemetente = usuarioRemetente;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public Instant getCriadoEm() {
        return criadoEm;
    }

    public void setCriadoEm(Instant criadoEm) {
        this.criadoEm = criadoEm;
    }
}
