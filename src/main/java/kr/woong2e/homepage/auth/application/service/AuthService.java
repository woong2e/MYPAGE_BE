package kr.woong2e.homepage.auth.application.service;

import kr.woong2e.homepage.auth.api.request.IdCheckRequestDto;

public interface AuthService {

    void idCheck(IdCheckRequestDto idCheckRequestDto);
}
