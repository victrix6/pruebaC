package com.confiar.prueba.infrastructure.adapters;

import com.confiar.prueba.domain.model.account.Account;
import com.confiar.prueba.domain.model.account.AccountRepository;
import com.confiar.prueba.infrastructure.adapters.entities.AccountEntity;
import com.confiar.prueba.infrastructure.adapters.entities.ClientEntity;
import com.confiar.prueba.infrastructure.entryPoints.dto.mapper.AccountMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@RequiredArgsConstructor
@Component
public class AccountRepositoryImpl implements AccountRepository {
    private final AccountRepositoryJpa repo;
    private final ClientRepositoryJpa clientRepositoryJpa;
    private final AccountMapper mapper;



    @Override
    public Account save(Account account) {
        ClientEntity clientEntity = clientRepositoryJpa.findByNit(account.getClient().getNit())
                .orElseThrow(() -> new IllegalStateException("Cliente no encontrado"));

        AccountEntity accountEntity = mapper.toEntity(account);

        accountEntity.setClientEntity(clientEntity);

        return mapper.toDomain(repo.save(accountEntity));
    }

    @Override
    public Optional<Account> findByAccountNumber(String accountNumber) {
        return Optional.empty();
    }
}
