package kr.woong2e.homepage.global.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import kr.woong2e.homepage.global.response.status.BaseStatus;
import lombok.Getter;
import org.springframework.http.ResponseEntity;

@Getter
public class DataResponse<T> extends BaseResponse {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final T data;

    protected DataResponse(BaseStatus status, T data) {
        super(true, status);
        this.data = data;
    }

    // 성공 응답 - 페이로드 포함
    public static <T> ResponseEntity<DataResponse<T>> of(BaseStatus status, T data) {
        DataResponse<T> responseBody = new DataResponse<>(status, data);
        return ResponseEntity.status(status.getHttpStatus()).body(responseBody);
    }

    // 성공 응답 - 페이로드 없음
    public static ResponseEntity<DataResponse<?>> from(BaseStatus status) {
        DataResponse<?> responseBody = new DataResponse<>(status, null);
        return ResponseEntity.status(status.getHttpStatus()).body(responseBody);
    }
}
