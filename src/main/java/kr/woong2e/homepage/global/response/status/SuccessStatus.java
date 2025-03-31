package kr.woong2e.homepage.global.response.status;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum SuccessStatus implements BaseStatus {

    SUCCESS(HttpStatus.OK, "SU", "success.");

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;
}
