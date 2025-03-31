package kr.woong2e.homepage.global.response.status;


import org.springframework.http.HttpStatus;

public interface BaseStatus {

    HttpStatus getHttpStatus();
    String getCode();
    String getMessage();
}
