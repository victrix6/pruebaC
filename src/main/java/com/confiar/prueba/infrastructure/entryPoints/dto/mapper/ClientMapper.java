package com.confiar.prueba.infrastructure.entryPoints.dto.mapper;

import com.confiar.prueba.domain.model.client.Client;
import com.confiar.prueba.infrastructure.entryPoints.dto.client.ClientRequest;
import com.confiar.prueba.infrastructure.entryPoints.dto.client.ClientResponse;
import org.springframework.stereotype.Component;

@Component
public class ClientMapper {
    public Client toDomain(ClientRequest request) {
        return Client.builder()
                .nit(request.getNit())
                .name(request.getName())
                .build();
    }

    public ClientResponse toResponse(Client client) {
        return ClientResponse.builder()
                .nit(client.getNit())
                .name(client.getName())
                .entryDate(client.getCreatedAt().toString())
                .build();
    }
}
