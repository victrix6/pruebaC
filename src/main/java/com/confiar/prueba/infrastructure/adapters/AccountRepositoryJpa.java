package com.confiar.prueba.infrastructure.adapters;

import com.confiar.prueba.infrastructure.adapters.entities.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepositoryJpa extends JpaRepository<AccountEntity, Long> {
}
