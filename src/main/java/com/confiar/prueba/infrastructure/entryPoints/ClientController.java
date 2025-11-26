package com.confiar.prueba.infrastructure.entryPoints;


import com.confiar.prueba.domain.usecases.ClientUseCase;
import com.confiar.prueba.infrastructure.entryPoints.dto.ApiResponse;
import com.confiar.prueba.infrastructure.entryPoints.dto.client.ClientRequest;
import com.confiar.prueba.infrastructure.entryPoints.dto.client.ClientResponse;
import com.confiar.prueba.infrastructure.entryPoints.dto.mapper.ClientMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ClientController {
    private final ClientUseCase useCase;
    private final ClientMapper mapper;

    @PostMapping("/client")
    public ApiResponse<ClientResponse> createClient(@RequestBody ClientRequest request) {
        var clientDomain = mapper.toDomain(request);

        var saved = useCase.saveClient(clientDomain);

        return ApiResponse.<ClientResponse>builder()
                .code("00")
                .message("Cliente creado exitosamente")
                .data(mapper.toResponse(saved))
                .build();
    }

    @GetMapping("/client/{id}")
    public ApiResponse<ClientResponse> getClientById(@PathVariable Long id) {
        var clientFound = useCase.getClientById(id);
        if (clientFound.isEmpty()) {
            return ApiResponse.<ClientResponse>builder()
                    .code("01")
                    .message("Cliente no encontrado")
                    .build();
        }
        return ApiResponse.<ClientResponse>builder()
                .code("00")
                .message("Cliente encontrado exitosamente")
                .data(mapper.toResponse(clientFound.get()))
                .build();
    }
}
