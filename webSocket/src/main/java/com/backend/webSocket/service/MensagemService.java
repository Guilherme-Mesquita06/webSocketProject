package com.backend.webSocket.service;


import com.backend.webSocket.dto.MensagemDto;
import com.backend.webSocket.entity.Mensagem;
import com.backend.webSocket.repository.MensagemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MensagemService {
    private final MensagemRepository mensagemRepository;

    public MensagemService(MensagemRepository mensagemRepository) {
        this.mensagemRepository = mensagemRepository;
    }

    public Mensagem cadastrar(MensagemDto mensagemDto){
        Mensagem mensagem = new Mensagem();
        mensagem.setIdSala(mensagemDto.getIdSala());
        mensagem.setUsuarioRemetente(mensagemDto.getUsuarioRemetente());
        mensagem.setConteudo(mensagemDto.getConteudo());
        mensagem.setCriadoEm(mensagemDto.getCriadoEm());

         return mensagemRepository.save(mensagem);
    }

    public List<Mensagem> listarMensagemOrderDesc(Long idSala){

        return mensagemRepository.findAllBySalaIdOrderByCriadoEmDesc(idSala);
    }
}
