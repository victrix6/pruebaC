package com.confiar.prueba.infrastructure.entryPoints.dto.client;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class ClientRequest {
    private String nit;
    private String name;
}
