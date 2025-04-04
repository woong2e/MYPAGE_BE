package kr.woong2e.homepage.auth.application.response.status;

import kr.woong2e.homepage.global.response.status.BaseStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum AuthErrorStatus implements BaseStatus {

    DUPLICATED_ID(HttpStatus.CONFLICT, "DI", "Duplicated id."),
    MAIL_DELIVERY_FAILED(HttpStatus.INTERNAL_SERVER_ERROR, "ESE", "Failed to Send Email.");

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

}
