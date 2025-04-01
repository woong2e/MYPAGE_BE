package kr.woong2e.homepage.global.exception;

import kr.woong2e.homepage.global.response.status.BaseStatus;

public class NotFoundException extends CustomException {

    public NotFoundException(BaseStatus baseStatus) {
        super(baseStatus);
    }
}
