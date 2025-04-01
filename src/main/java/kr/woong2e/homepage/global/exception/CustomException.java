package kr.woong2e.homepage.global.exception;

import kr.woong2e.homepage.global.response.status.BaseStatus;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CustomException extends RuntimeException {

    private final BaseStatus status;
}
