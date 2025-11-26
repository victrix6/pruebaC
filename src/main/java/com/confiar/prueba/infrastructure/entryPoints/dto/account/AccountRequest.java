package com.confiar.prueba.infrastructure.entryPoints.dto.account;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@Builder
public class AccountRequest {

    private String nit;
    private BigDecimal balance;
}
