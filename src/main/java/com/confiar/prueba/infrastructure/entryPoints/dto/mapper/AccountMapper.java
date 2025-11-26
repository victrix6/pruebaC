package com.confiar.prueba.infrastructure.entryPoints.dto.mapper;

import com.confiar.prueba.domain.model.account.Account;
import com.confiar.prueba.domain.model.client.Client;
import com.confiar.prueba.infrastructure.adapters.entities.ClientEntity;
import com.confiar.prueba.infrastructure.entryPoints.dto.account.AccountRequest;
import com.confiar.prueba.infrastructure.entryPoints.dto.client.ClientResponse;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
@Component
public class AccountMapper {
    public Account toDomain(AccountRequest request) {
            Client client = Client.builder()
                    .nit(request.getNit())
                    .build();
            return Account.builder()
                    .client(client)
                    .balance(request.getBalance())
                    .build();
        }
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
