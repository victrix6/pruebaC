package com.confiar.prueba.infrastructure.entryPoints.dto.client;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ClientRequest {
    private String nit;
    private String name;
}
