package com.confiar.prueba.infrastructure.adapters.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "movements") // Asume el nombre de la tabla de movimientos
@Data
public class MovementEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id", nullable = false)
    private AccountEntity account;

    @Column(name = "nit_client")
    private String nitClient;

    @Column(name = "account_number")
    private String accountNumber;

    @Column(name = "amount", nullable = false)
    private Double amount;

    @Column(name = "movement_type", nullable = false)
    private String movementType; // DB para débito, CR para crédito.
}
