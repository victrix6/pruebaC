package com.confiar.prueba.infrastructure.entryPoints.dto.client;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ClientResponse {
    private String nit;
    private String name;
    private String entryDate;
}
