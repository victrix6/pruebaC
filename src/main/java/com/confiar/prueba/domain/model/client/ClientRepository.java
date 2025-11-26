package com.confiar.prueba.domain.model.client;

import java.util.Optional;

public interface ClientRepository {
    Client save(Client client);
    Optional<Client> findById(Long id);
}
