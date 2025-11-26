package com.confiar.prueba.infrastructure.adapters;

import com.confiar.prueba.domain.model.client.Client;
import com.confiar.prueba.domain.model.client.ClientRepository;
import com.confiar.prueba.infrastructure.entryPoints.dto.mapper.ClientMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@RequiredArgsConstructor
@Component
public class ClientRepositoryImpl implements ClientRepository {
    private final ClientRepositoryJpa repo;
    private  final ClientMapper mapper;

    @Override
    public Client save(Client client) {
        return mapper.toDomain(
                repo.save(
                        mapper.toEntity(client)
                )
        );
    }

    @Override
    public Optional<Client> findById(Long id) {
        return repo.findById(id).map(mapper::toDomain);
    }
}
