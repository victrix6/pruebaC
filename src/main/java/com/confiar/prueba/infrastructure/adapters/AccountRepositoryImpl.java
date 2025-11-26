package com.confiar.prueba.infrastructure.adapters;

import com.confiar.prueba.domain.model.account.Account;
import com.confiar.prueba.domain.model.account.AccountRepository;
import com.confiar.prueba.infrastructure.adapters.entities.AccountEntity;
import com.confiar.prueba.infrastructure.entryPoints.dto.mapper.AccountMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@RequiredArgsConstructor
@Component
public class AccountRepositoryImpl implements AccountRepository {
    private final AccountRepositoryJpa repo;
    private final AccountMapper mapper;

    @Override
    public Account save(Account account) {
        System.out.println("accountadapter = " + account);
        AccountEntity entity = mapper.toEntity(account);
        System.out.println("entityadapter = " + entity);
        return mapper.toDomain(
                repo.save(
                        mapper.toEntity(account)
                )
        );
    }

    @Override
    public Optional<Account> findByAccountNumber(String accountNumber) {
        return Optional.empty();
    }
}
