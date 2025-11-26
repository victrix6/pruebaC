package com.confiar.prueba.domain.model.client;

import com.confiar.prueba.domain.model.account.Account;
import lombok.Builder;
import lombok.Data;
import java.util.List;

import java.time.LocalDate;

@Data
@Builder
public class Client {
    private Long id;
    private String nit;
    private String name;
    private LocalDate createdAt;
    private List<Account> account;

}
