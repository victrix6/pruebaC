package com.confiar.prueba.infrastructure.adapters.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "cuentas")
public class AccountEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nit_cliente", nullable = false)
    private ClientEntity client;

    @Column(name = "numero_cuenta", unique = true, nullable = false)
    private String accountNumber;

    @Column(name = "monto", nullable = false)
    private Double balance;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<MovementEntity> movements;
}
