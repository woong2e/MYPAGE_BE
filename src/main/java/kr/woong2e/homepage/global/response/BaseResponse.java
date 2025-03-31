package kr.woong2e.homepage.global.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import kr.woong2e.homepage.global.response.status.BaseStatus;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public abstract class BaseResponse {

    @JsonFormat(pattern = "yyyy-MM-dd kk:mm:ss")
    private final LocalDateTime timestamp = LocalDateTime.now();
    private final Boolean isSuccess;
    private final String code;
    private final String message;

    protected BaseResponse(Boolean isSuccess, BaseStatus status) {
        this.isSuccess = isSuccess;
        this.code = status.getCode();
        this.message = status.getMessage();
    }
}
