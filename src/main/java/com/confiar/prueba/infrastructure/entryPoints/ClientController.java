package com.confiar.prueba.infrastructure.entryPoints;


import com.confiar.prueba.domain.model.usecases.ClientUseCase;
import com.confiar.prueba.infrastructure.entryPoints.dto.ApiResponse;
import com.confiar.prueba.infrastructure.entryPoints.dto.client.ClientRequest;
import com.confiar.prueba.infrastructure.entryPoints.dto.client.ClientResponse;
import com.confiar.prueba.infrastructure.entryPoints.dto.mapper.ClientMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ClientController {
    private final ClientUseCase useCase;
    private final ClientMapper mapper;

    public ApiResponse<ClientResponse> createClient(ClientRequest request) {
        var clientDomain = mapper.toDomain(request);

        var saved = useCase.saveClient(clientDomain);

        return ApiResponse.<ClientResponse>builder()
                .code("00")
                .message("Cliente creado exitosamente")
                .data(mapper.toResponse(saved))
                .build();
    }
}
