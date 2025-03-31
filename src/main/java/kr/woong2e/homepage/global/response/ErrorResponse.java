package kr.woong2e.homepage.global.response;

import kr.woong2e.homepage.global.response.status.BaseStatus;
import lombok.Getter;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Getter
public class ErrorResponse extends BaseResponse {

    private final List<String> reasons;

    protected ErrorResponse(BaseStatus status, List<String> reasons) {
        super(false, status);
        this.reasons = reasons;
    }

    // 실패 응답 - 에러 원인
    public static ResponseEntity<ErrorResponse> of(BaseStatus status, List<String> reasons) {
        ErrorResponse errorResponseBody = new ErrorResponse(status, reasons);
        return ResponseEntity.status(status.getHttpStatus()).body(errorResponseBody);
    }

    // 실패 응답 - 기본 메시지
    public static ResponseEntity<ErrorResponse> from(BaseStatus status) {
        ErrorResponse errorResponseBody = new ErrorResponse(status, null);
        return ResponseEntity.status(status.getHttpStatus()).body(errorResponseBody);
    }
}
