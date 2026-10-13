package com.backend.webSocket.controller;


import com.backend.webSocket.dto.SalaDto;
import com.backend.webSocket.entity.Sala;
import com.backend.webSocket.service.SalaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/salas")
public class SalaController {

    private SalaService service;

    public SalaController(SalaService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Sala> save(@RequestBody SalaDto sala) {

        if(sala.getIdUsuarios().size()< 2){
            return ResponseEntity.badRequest().build();
        }

        Sala salaEntidade = service.criarSala(sala);

        if(salaEntidade == null){
            return ResponseEntity.noContent().build();
        }

        return  ResponseEntity.ok(salaEntidade);


    }


}
