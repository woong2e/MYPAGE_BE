package kr.woong2e.homepage.auth.application.service.implement;

import kr.woong2e.homepage.auth.api.request.IdCheckRequestDto;
import kr.woong2e.homepage.auth.application.response.status.AuthErrorStatus;
import kr.woong2e.homepage.auth.application.service.AuthService;
import kr.woong2e.homepage.global.exception.CustomException;
import kr.woong2e.homepage.user.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    
    @Override
    public void idCheck(IdCheckRequestDto idCheckRequestDto) {

        String loginId = idCheckRequestDto.getLoginId();
        boolean isExistsId = userRepository.existsByLoginId(loginId);

        if (isExistsId) {
            throw new CustomException(AuthErrorStatus.DUPLICATED_ID);
        }

    }
}
