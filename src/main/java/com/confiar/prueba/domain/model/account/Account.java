package com.confiar.prueba.domain.model.account;

import com.confiar.prueba.domain.model.client.Client;
import com.confiar.prueba.domain.model.movement.Movement;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class Account {
    private Long id;
    private Client client;
    private String accountNumber;
    private BigDecimal balance;
    private List<Movement> movements;


}
