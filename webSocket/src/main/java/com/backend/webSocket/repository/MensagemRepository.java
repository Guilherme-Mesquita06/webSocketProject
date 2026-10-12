package com.backend.webSocket.repository;

import com.backend.webSocket.entity.Mensagem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MensagemRepository extends JpaRepository<Mensagem, Long> {

}
