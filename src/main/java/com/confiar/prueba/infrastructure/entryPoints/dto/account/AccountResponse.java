package com.confiar.prueba.infrastructure.entryPoints.dto.account;

import com.confiar.prueba.domain.model.client.Client;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@Builder
public class AccountResponse {

    private Client client;
    private String accountNumber;
    private BigDecimal balance;
}
