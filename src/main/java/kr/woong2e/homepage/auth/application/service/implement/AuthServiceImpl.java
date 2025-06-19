package kr.woong2e.homepage.auth.application.service.implement;

import kr.woong2e.homepage.auth.api.request.CheckCertificationRequestDto;
import kr.woong2e.homepage.auth.api.request.EmailCertificationRequestDto;
import kr.woong2e.homepage.auth.api.request.IdCheckRequestDto;
import kr.woong2e.homepage.auth.api.request.SignUpRequestDto;
import kr.woong2e.homepage.auth.application.response.IdCheckResponseDto;
import kr.woong2e.homepage.auth.application.response.status.AuthErrorStatus;
import kr.woong2e.homepage.auth.application.service.AuthService;
import kr.woong2e.homepage.auth.domain.Certification;
import kr.woong2e.homepage.auth.domain.CertificationRepository;
import kr.woong2e.homepage.global.exception.CustomException;
import kr.woong2e.homepage.global.provider.EmailProvider;
import kr.woong2e.homepage.user.domain.User;
import kr.woong2e.homepage.user.domain.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final CertificationRepository certificationRepository;
    private final EmailProvider emailProvider;
    private final PasswordEncoder encoder;

    @Override
    public IdCheckResponseDto idCheck(IdCheckRequestDto idCheckRequestDto) {
        String loginId = idCheckRequestDto.getLoginId();
        return new IdCheckResponseDto(userRepository.existsByLoginId(loginId));
    }

    @Override
    public void emailCertification(EmailCertificationRequestDto emailCertificationRequestDto) {
        String loginId = emailCertificationRequestDto.getLoginId();
        String email = emailCertificationRequestDto.getEmail();

        boolean isExistsId = userRepository.existsByLoginId(loginId);
        if (isExistsId) {
            throw new CustomException(AuthErrorStatus.DUPLICATED_ID);
        }

        Certification certification = Certification.create(loginId, email);
        String certificationNumber = certification.getCertificationNumber();
        emailProvider.sendCertificationMail(email, certificationNumber);

        certificationRepository.save(certification);
    }

    @Override
    public void checkCertification(CheckCertificationRequestDto checkCertificationRequestDto) {
        String loginId = checkCertificationRequestDto.getLoginId();
        String email = checkCertificationRequestDto.getEmail();
        String certificationNumber = checkCertificationRequestDto.getCertificationNumber();

        Certification certification = certificationRepository.findByLoginId(loginId)
                .orElseThrow(() -> new CustomException(AuthErrorStatus.CERTIFICATION_NOT_EXIST));

        certification.verify(email, certificationNumber);
        certificationRepository.save(certification);
    }

    @Override
    public void signUp(SignUpRequestDto signUpRequestDto) {
        String loginId = signUpRequestDto.loginId();
        boolean isExistId = userRepository.existsByLoginId(loginId);
        if (isExistId) {
            throw new CustomException(AuthErrorStatus.DUPLICATED_ID);
        }

        if (!signUpRequestDto.password().equals(signUpRequestDto.passwordCheck())) {
            throw new CustomException(AuthErrorStatus.NOT_MATCHED_PASSWORD);
        }

        Certification certification = certificationRepository.findByLoginId(loginId)
                .orElseThrow(() -> new CustomException(AuthErrorStatus.CERTIFICATION_NOT_EXIST));

        if (!certification.isVerified()) {
            throw new CustomException(AuthErrorStatus.CERTIFICATION_FAILED);
        }

        String encodedPassword = encoder.encode(signUpRequestDto.password());

        User user = User.create(signUpRequestDto, encodedPassword);

        userRepository.save(user);
        certificationRepository.delete(certification);
    }
}
