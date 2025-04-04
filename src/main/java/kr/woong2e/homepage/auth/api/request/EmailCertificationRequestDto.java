package kr.woong2e.homepage.auth.api.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EmailCertificationRequestDto {

    @NotBlank
    private String loginId;

    @Email
    @NotBlank
    private String email;
}
