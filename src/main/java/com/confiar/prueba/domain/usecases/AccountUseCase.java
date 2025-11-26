package com.confiar.prueba.domain.usecases;

import com.confiar.prueba.domain.model.account.Account;
import com.confiar.prueba.domain.model.account.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountUseCase {
    private final AccountRepository accountRepository;

    if (!clientRepository.existsByNit(account.getClientNit())) {
        throw new BusinessException("Cliente no existe");
    }
    if (accountRepository.existsByNumber(account.getNumber())) {
        throw new BusinessException("Cuenta ya existe");
    }

    public Account saveAccount(Account account) {
        return accountRepository.save(account);
    }
}
