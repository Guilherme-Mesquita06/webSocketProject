package com.backend.webSocket.controller;


import com.backend.webSocket.dto.MensagemDto;
import com.backend.webSocket.entity.Mensagem;
import com.backend.webSocket.service.MensagemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/mensagens")
public class MensagemController {

private MensagemService mensagemService;

    public MensagemController(MensagemService mensagemService) {
        this.mensagemService = mensagemService;
    }

    @PostMapping
    public ResponseEntity<MensagemDto> cadastrarMensagem(@RequestBody MensagemDto mensagemDtoRequest){
        Mensagem save = mensagemService.cadastrar(mensagemDtoRequest);

        return ResponseEntity.status(201).body(toResponse(save));
    }

    @GetMapping("/{idSala}")
    public ResponseEntity<List <MensagemDto>> mensagens (@PathVariable Long idSala){
        if(idSala == null){
            return ResponseEntity.badRequest().build();
        }

       List <Mensagem>  mensagens = mensagemService.listarMensagemOrderDesc(idSala);

        List<MensagemDto> mensagemDtos = mensagens.stream().map(this::toResponse).toList();

        return ResponseEntity.ok(mensagemDtos);


    }



    public MensagemDto toResponse(Mensagem mensagem){
        MensagemDto dto = new MensagemDto();
        dto.setUsuarioRemetente(mensagem.getUsuarioRemetente());
        dto.setConteudo(mensagem.getConteudo());
        dto.setCriadoEm(mensagem.getCriadoEm());

        return dto;
    }


}
