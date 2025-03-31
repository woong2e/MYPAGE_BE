package kr.woong2e.homepage.global.response.status;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorStatus implements BaseStatus {

    DATABASE_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "DBE", "Database error."),
    VALIDATION_FAIL(HttpStatus.BAD_REQUEST, "VF", "Validation failed.");

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

}
