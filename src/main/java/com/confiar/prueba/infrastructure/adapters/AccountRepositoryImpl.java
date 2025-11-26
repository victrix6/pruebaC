package com.confiar.prueba.infrastructure.adapters;

import com.confiar.prueba.domain.model.account.Account;
import com.confiar.prueba.domain.model.account.AccountRepository;
import com.confiar.prueba.infrastructure.adapters.entities.AccountEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class AccountRepositoryImpl implements AccountRepository {
    private final AccountRepositoryJpa repo;

    @Override
    public Account save(Account account) {
        return repo.save(AccountEntity);
    }
}
