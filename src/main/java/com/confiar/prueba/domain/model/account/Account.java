package com.confiar.prueba.domain.model.account;

import com.confiar.prueba.domain.model.client.Client;
import com.confiar.prueba.domain.model.movement.Movement;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Account {
    private Long id;
    private Client client;
    private String accountNumber;
    private Double balance;
    private List<Movement> movements;


}
