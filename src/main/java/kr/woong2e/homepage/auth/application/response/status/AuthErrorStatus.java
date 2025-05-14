package kr.woong2e.homepage.auth.application.response.status;

import kr.woong2e.homepage.global.response.status.BaseStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum AuthErrorStatus implements BaseStatus {

    DUPLICATED_ID(HttpStatus.CONFLICT, "DI", "Duplicated id."),
    MAIL_DELIVERY_FAILED(HttpStatus.INTERNAL_SERVER_ERROR, "ESE", "Failed to Send Email."),
    CERTIFICATION_NOT_EXIST(HttpStatus.NOT_FOUND, "CNE", "존재하지 않는 이메일 인증입니다."),
    INVALID_EMAIL(HttpStatus.NOT_FOUND, "IE", "존재하지 않은 이메일"),
    INVALID_CERTIFICATION_NUMBER(HttpStatus.BAD_REQUEST, "ICN", "유효하지 않은 인증번호"),
    CERTIFICATION_FAILED(HttpStatus.UNAUTHORIZED, "CF", "메일 인증 실패");

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

}
