package com.confiar.prueba.infrastructure.adapters;

import com.confiar.prueba.domain.model.client.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepositoryJpa extends JpaRepository<Client, Long> {
}
