package com.confiar.prueba.domain.model.movement;

import lombok.Data;

@Data
public class Movement {
    private Long id;
    private String nitClient;
    private String accountNumber;
    private Double amount;
    private String movementType; // movimiento (DB para débito, CR para crédito).
}
