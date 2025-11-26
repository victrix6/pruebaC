package com.confiar.prueba.infrastructure.adapters.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "clientes")
@Getter
@Setter
public class ClientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nit", unique = true)
    private String nit;

    @Column(name = "nombre")
    private String name;

    @Column(name = "fecha_ingreso")
    private String creationDate;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<AccountEntity> accounts;

}
