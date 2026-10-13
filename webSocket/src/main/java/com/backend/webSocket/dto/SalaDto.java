package com.backend.webSocket.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class SalaDto {


    private List<Long> idUsuarios = new ArrayList<>();

    public List<Long> getIdUsuarios() {
        return idUsuarios;
    }

    public void setIdUsuarios(List<Long> idUsuarios) {
        this.idUsuarios = idUsuarios;
    }
}
