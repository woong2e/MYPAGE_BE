package kr.woong2e.homepage.user.application.response.status;

import kr.woong2e.homepage.global.response.status.BaseStatus;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum UserErrorStatus implements BaseStatus {

    USER_NOT_EXIST(HttpStatus.NOT_FOUND, "UNE", "존재하지 않은 유저입니다.");

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;
}
