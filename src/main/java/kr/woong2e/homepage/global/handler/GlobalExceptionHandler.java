package kr.woong2e.homepage.global.handler;

import kr.woong2e.homepage.global.exception.CustomException;
import kr.woong2e.homepage.global.exception.NotFoundException;
import kr.woong2e.homepage.global.response.ErrorResponse;
import kr.woong2e.homepage.global.response.status.ErrorStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ErrorResponse> handleCustomException(CustomException customException) {
        logError(customException.getStatus().getMessage(), customException);
        return ErrorResponse.from(customException.getStatus());
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFoundException(NotFoundException notFoundException) {
        logError(notFoundException.getMessage(), notFoundException);
        return ErrorResponse.from(notFoundException.getStatus());
    }

    @ExceptionHandler({MethodArgumentNotValidException.class, HttpMessageNotReadableException.class})
    public ResponseEntity<ErrorResponse> validationExceptionHandler(Exception exception) {
        logError(exception.getMessage(), exception);
        return ErrorResponse.from(ErrorStatus.VALIDATION_FAIL);
    }

    // 로그 기록 메서드
    private void logError(String message, Object errorDetails) {
        log.error("{}: {}", message, errorDetails);
    }

}
