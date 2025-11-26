package com.confiar.prueba.domain.usecases;

import com.confiar.prueba.domain.model.client.Client;
import com.confiar.prueba.domain.model.client.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ClientUseCase {
    private final ClientRepository clientRepository;

    public Client saveClient(Client client) {
//        if (clientRepository.findByNit(client.getNit())) {
//            throw new BusinessException("Cliente ya existe");
//        }
        if (client.getCreatedAt() == null) {
            client.setCreatedAt(java.time.LocalDate.now());
        }
        return clientRepository.save(client);
    }

    public Optional<Client> getClientById(Long id) {
        return clientRepository.findById(id);
    }
}

