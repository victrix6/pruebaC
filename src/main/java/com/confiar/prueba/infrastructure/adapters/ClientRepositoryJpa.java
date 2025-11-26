package com.confiar.prueba.infrastructure.adapters;

import com.confiar.prueba.domain.model.client.Client;
import com.confiar.prueba.infrastructure.adapters.entities.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepositoryJpa extends JpaRepository<ClientEntity, Long> {
}
