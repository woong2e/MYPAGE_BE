package kr.woong2e.homepage.global.handler;

import kr.woong2e.homepage.global.exception.NotFoundException;
import kr.woong2e.homepage.global.response.ErrorResponse;
import kr.woong2e.homepage.global.response.status.ErrorStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ValidationExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFoundException(NotFoundException notFoundException) {
        return ErrorResponse.from(notFoundException.getStatus());
    }

    @ExceptionHandler({MethodArgumentNotValidException.class, HttpMessageNotReadableException.class})
    public ResponseEntity<ErrorResponse> validationExceptionHandler(Exception exception) {
        return ErrorResponse.from(ErrorStatus.VALIDATION_FAIL);
    }



}
