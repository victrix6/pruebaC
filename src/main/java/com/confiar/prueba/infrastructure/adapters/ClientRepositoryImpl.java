package com.confiar.prueba.infrastructure.adapters;

import com.confiar.prueba.domain.model.client.Client;
import com.confiar.prueba.domain.model.client.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ClientRepositoryImpl implements ClientRepository {
    private final ClientRepositoryJpa repo;

    @Override
    public Client save(Client client) {
        return repo.save(client);
    }
}
