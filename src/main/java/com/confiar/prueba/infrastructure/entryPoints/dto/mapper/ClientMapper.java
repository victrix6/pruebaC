package com.confiar.prueba.infrastructure.entryPoints.dto.mapper;

import com.confiar.prueba.domain.model.client.Client;
import com.confiar.prueba.infrastructure.adapters.entities.ClientEntity;
import com.confiar.prueba.infrastructure.entryPoints.dto.client.ClientRequest;
import com.confiar.prueba.infrastructure.entryPoints.dto.client.ClientResponse;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class ClientMapper {
    public Client toDomain(ClientRequest request) {
        return Client.builder()
                .nit(request.getNit())
                .name(request.getName())
                .build();
    }

    public Client toDomain(ClientEntity entity) {
        return Client.builder()
                .id(entity.getId())
                .nit(entity.getNit())
                .name(entity.getName())
                .createdAt(LocalDate.parse(entity.getCreationDate()))
                .build();
    }

    public ClientResponse toResponse(Client client) {
        return ClientResponse.builder()
                .nit(client.getNit())
                .name(client.getName())
                .entryDate(client.getCreatedAt().toString())
                .build();
    }

    public ClientEntity toEntity(Client client) {
        ClientEntity entity = new ClientEntity();
        entity.setNit(client.getNit());
        entity.setName(client.getName());
        entity.setCreationDate(client.getCreatedAt().toString());
        return entity;
    }
}
