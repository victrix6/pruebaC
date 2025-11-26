package com.confiar.prueba.infrastructure.entryPoints.dto.mapper;

import com.confiar.prueba.domain.model.account.Account;
import com.confiar.prueba.domain.model.client.Client;
import com.confiar.prueba.infrastructure.adapters.entities.AccountEntity;
import com.confiar.prueba.infrastructure.adapters.entities.ClientEntity;
import com.confiar.prueba.infrastructure.entryPoints.dto.account.AccountRequest;
import com.confiar.prueba.infrastructure.entryPoints.dto.account.AccountResponse;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
@Component
public class AccountMapper {
    public Account toDomain(AccountRequest request) {
            return Account.builder()
                    .client(Client.builder()
                            .nit(request.getNit())
                            .build())
                    .accountNumber(request.getAccountNumber())
                    .balance(request.getBalance())
                    .build();
        }


    public Account toDomain(AccountEntity entity) {
        return Account.builder()
                .id(entity.getId())
                .accountNumber(entity.getAccountNumber())
                .balance(BigDecimal.valueOf(entity.getBalance()))
                .client(Client.builder()
                        .id(entity.getClientEntity().getId())
                        .nit(entity.getClientEntity().getNit())
                        .name(entity.getClientEntity().getName())
                        .createdAt(LocalDate.parse(entity.getClientEntity().getCreationDate()))
                        .build())
                .build();
    }

    public AccountResponse toResponse(Account account) {
        return AccountResponse.builder()
                .client(Client.builder()
                        .id(account.getClient().getId())
                        .nit(account.getClient().getNit())
                        .name(account.getClient().getName())
                        .createdAt(account.getClient().getCreatedAt())
                        .build())
                .accountNumber(account.getAccountNumber())
                .balance(account.getBalance())
                .build();
    }

    public AccountEntity toEntity(Account account) {
        return AccountEntity.builder()
                .clientEntity(ClientEntity.builder()
                        .name(account.getClient().getName())
                        .nit(account.getClient().getNit())
                        .creationDate(account.getClient().getCreatedAt().toString())
                        .build())
                .accountNumber(account.getAccountNumber())
                .balance(account.getBalance().doubleValue())
                .build();
    }
}
