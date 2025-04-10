package kr.woong2e.homepage.auth.api;

import jakarta.validation.Valid;
import kr.woong2e.homepage.auth.api.request.CheckCertificationRequestDto;
import kr.woong2e.homepage.auth.api.request.EmailCertificationRequestDto;
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

    @PostMapping("email-certification")
    public ResponseEntity<SuccessResponse<?>> emailCertification(
            @RequestBody @Valid EmailCertificationRequestDto requestBody
    ) {
        authService.emailCertification(requestBody);
        return SuccessResponse.from(SuccessStatus.SUCCESS);
    }

    @PostMapping("check-certification")
    public ResponseEntity<SuccessResponse<?>> checkCertification(
            @RequestBody @Valid CheckCertificationRequestDto requestBody
    ) {
        authService.checkCertification(requestBody);
        return SuccessResponse.from(SuccessStatus.SUCCESS);
    }
}

