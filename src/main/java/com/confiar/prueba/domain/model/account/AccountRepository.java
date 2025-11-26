package com.confiar.prueba.domain.model.account;

import java.util.Optional;

public interface AccountRepository {
    Account save(Account account);
    Optional<Account> findByAccountNumber(String accountNumber);
}
