package kr.woong2e.homepage.auth.domain;

import kr.woong2e.homepage.auth.application.response.status.AuthErrorStatus;
import kr.woong2e.homepage.global.util.AssertUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Certification {

    private String loginId;

    private String email;

    private String certificationNumber;

    private boolean isVerified;

    public static Certification create(String loginId, String email) {
        String certificationNumber = generateCertificationNumber();
        return new Certification(loginId, email, certificationNumber, false);
    }

    private static String generateCertificationNumber() {
        StringBuilder certificationNumber = new StringBuilder();

        for (int i = 0; i < 4; i++) {
            certificationNumber.append((int) (Math.random() * 10));
        }
        return certificationNumber.toString();
    }

    public void verify(String email, String inputCode) {
        AssertUtil.check(this.email.equals(email), AuthErrorStatus.INVALID_EMAIL);
        AssertUtil.check(this.certificationNumber.equals(inputCode), AuthErrorStatus.INVALID_CERTIFICATION_NUMBER);
        this.isVerified = true;
    }

    public static Certification of(String loginId, String email, String certificationNumber, boolean isVerified) {
        return new Certification(loginId, email, certificationNumber, isVerified);
    }

}
