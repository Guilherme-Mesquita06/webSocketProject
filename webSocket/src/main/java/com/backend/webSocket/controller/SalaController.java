package com.backend.webSocket.controller;


import com.backend.webSocket.entity.Sala;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/salas")
public class SalaController {


    @PostMapping
    public Sala sala(@RequestBody Sala sala) {
        return sala;
    }


}
