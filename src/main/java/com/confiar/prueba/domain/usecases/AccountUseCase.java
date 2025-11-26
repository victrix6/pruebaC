package com.confiar.prueba.domain.usecases;

import com.confiar.prueba.domain.model.account.Account;
import com.confiar.prueba.domain.model.account.AccountRepository;
import com.confiar.prueba.domain.model.client.Client;
import com.confiar.prueba.domain.model.client.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
        System.out.println("clientusecase = " + client);
        System.out.println("accountusecase = " + account);

        return accountRepository.save(account);
    }
}
