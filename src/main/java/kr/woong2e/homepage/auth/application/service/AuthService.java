package kr.woong2e.homepage.auth.application.service;

import kr.woong2e.homepage.auth.api.request.CheckCertificationRequestDto;
import kr.woong2e.homepage.auth.api.request.EmailCertificationRequestDto;
import kr.woong2e.homepage.auth.api.request.IdCheckRequestDto;
import kr.woong2e.homepage.auth.api.request.SignUpRequestDto;

public interface AuthService {

    void idCheck(IdCheckRequestDto idCheckRequestDto);
    void emailCertification(EmailCertificationRequestDto emailCertificationRequestDto);
    void checkCertification(CheckCertificationRequestDto checkCertificationRequestDto);
    void signUp(SignUpRequestDto signUpRequestDto);
}
