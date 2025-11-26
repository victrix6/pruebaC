package com.confiar.prueba.infrastructure.entryPoints;

import com.confiar.prueba.domain.usecases.AccountUseCase;
import com.confiar.prueba.infrastructure.entryPoints.dto.ApiResponse;
import com.confiar.prueba.infrastructure.entryPoints.dto.account.AccountRequest;
import com.confiar.prueba.infrastructure.entryPoints.dto.account.AccountResponse;
import com.confiar.prueba.infrastructure.entryPoints.dto.mapper.AccountMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AccountController {
    private final AccountUseCase useCase;
    private final AccountMapper mapper;

    @PostMapping("/account")
    public ApiResponse<AccountResponse> createAccount(@RequestBody AccountRequest request){
        var accountDomain = mapper.toDomain(request);

        var saved = useCase.saveAccount(accountDomain);

        return ApiResponse.<AccountResponse>builder()
                .code("00")
                .message("Cuenta creada exitosamente")
                .data(mapper.toResponse(saved))
                .build();
    }
}
