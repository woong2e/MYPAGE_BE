package kr.woong2e.homepage.global.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import kr.woong2e.homepage.global.response.status.BaseStatus;
import lombok.Getter;
import org.springframework.http.ResponseEntity;

@Getter
public class SuccessResponse<T> extends BaseResponse {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final T data;

    protected SuccessResponse(BaseStatus status, T data) {
        super(true, status);
        this.data = data;
    }

    // 성공 응답 - 페이로드 포함
    public static <T> ResponseEntity<SuccessResponse<T>> of(BaseStatus status, T data) {
        SuccessResponse<T> responseBody = new SuccessResponse<>(status, data);
        return ResponseEntity.status(status.getHttpStatus()).body(responseBody);
    }

    // 성공 응답 - 페이로드 없음
    public static ResponseEntity<SuccessResponse<?>> from(BaseStatus status) {
        SuccessResponse<?> responseBody = new SuccessResponse<>(status, null);
        return ResponseEntity.status(status.getHttpStatus()).body(responseBody);
    }
}
