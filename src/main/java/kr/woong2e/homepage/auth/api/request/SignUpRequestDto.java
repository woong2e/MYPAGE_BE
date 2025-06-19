package kr.woong2e.homepage.auth.api.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record SignUpRequestDto(
        @NotBlank(message = "ID를 입력하세요.")
        String loginId,

        @NotBlank(message = "비밀번호는 영문+숫자 8~20자여야 합니다.")
        @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*[0-9])[a-zA-Z0-9]{8,20}$")
        String password,

        @NotBlank(message = "확인 비밀번호를 입력하세요.")
        @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*[0-9])[a-zA-Z0-9]{8,20}$")
        String passwordCheck,

        @NotBlank
        String nickname,

        @Email(message = "유효한 이메일 주소를 입력하세요.")
        @NotBlank
        String email
) {
}
