package kr.woong2e.homepage.auth.api;

import jakarta.validation.Valid;
import kr.woong2e.homepage.auth.api.request.IdCheckRequestDto;
import kr.woong2e.homepage.auth.application.service.AuthService;
import kr.woong2e.homepage.global.response.SuccessResponse;
import kr.woong2e.homepage.global.response.status.SuccessStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/id-check")
    public ResponseEntity<SuccessResponse<?>> idCheck(
            @RequestBody @Valid IdCheckRequestDto requestBody
    ) {
        authService.idCheck(requestBody);
        return SuccessResponse.from(SuccessStatus.SUCCESS);
    }
}
