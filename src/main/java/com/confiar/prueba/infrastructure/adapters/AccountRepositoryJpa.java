package com.confiar.prueba.infrastructure.adapters;

import com.confiar.prueba.domain.model.account.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepositoryJpa extends JpaRepository<Account, Long> {
}
