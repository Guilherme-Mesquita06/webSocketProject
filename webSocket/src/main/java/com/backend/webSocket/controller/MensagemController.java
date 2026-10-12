package com.backend.webSocket.controller;


import com.backend.webSocket.dto.MensagemDto;
import com.backend.webSocket.entity.Mensagem;
import com.backend.webSocket.service.MensagemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mensagens")
public class MensagemController {

MensagemService mensagemService;

    @PostMapping
    public ResponseEntity<MensagemDto> cadastrarMensagem(@RequestBody MensagemDto mensagemDtoRequest){
        Mensagem save = mensagemService.cadastrar(mensagemDtoRequest);

        return ResponseEntity.status(201).body(toResponse(save));
    }

    public MensagemDto toResponse(Mensagem mensagem){
        MensagemDto dto = new MensagemDto();
        dto.setUsuarioRemetente(mensagem.getUsuarioRemetente());
        dto.setConteudo(mensagem.getConteudo());
        dto.setCriadoEm(mensagem.getCriadoEm());

        return dto;
    }


}
