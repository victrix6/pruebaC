package com.confiar.prueba.domain.usecases;

import com.confiar.prueba.domain.model.account.Account;
import com.confiar.prueba.domain.model.account.AccountRepository;
import com.confiar.prueba.domain.model.client.Client;
import com.confiar.prueba.domain.model.client.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountUseCase {
    private final AccountRepository accountRepository;
    private final ClientRepository clientRepository;

    public Account saveAccount(Account account) {
        Client client = clientRepository.findByNit(account.getClient().getNit())
                .orElseThrow(() -> new IllegalStateException("Cliente no existe"));
        if (!accountRepository.findByAccountNumber(account.getAccountNumber()).isEmpty())
        {
            throw new IllegalStateException("Cuenta ya existe");
        }
        account.setClient(client);
        return accountRepository.save(account);
    }

    public Optional<Account> getAccountByNumber(String accountNumber) {
        return accountRepository.findByAccountNumber(accountNumber);
    }
}
