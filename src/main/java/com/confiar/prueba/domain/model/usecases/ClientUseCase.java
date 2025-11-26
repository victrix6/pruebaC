package com.confiar.prueba.domain.model.usecases;

import com.confiar.prueba.domain.model.client.Client;
import com.confiar.prueba.domain.model.client.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ClientUseCase {
    private final ClientRepository clientRepository;

    public Client saveClient(Client client) {
//        if (clientRepository.existsByNit(client.getNit())) {
//            throw new BusinessException("Cliente ya existe");
//        }

        return clientRepository.save(client);
    }
}

