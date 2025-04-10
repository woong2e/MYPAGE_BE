package kr.woong2e.homepage.global.provider;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import kr.woong2e.homepage.auth.application.response.status.AuthErrorStatus;
import kr.woong2e.homepage.global.exception.CustomException;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmailProvider {

    private final JavaMailSender javaMailSender;
    private final String SUBJECT = "[woong2e] 인증 메일입니다.";

    public void sendCertificationMail(String email, String certificationNumber) {

        try{
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(message, true);

            String htmlContent = getCertificationMessage(certificationNumber);

            mimeMessageHelper.setTo(email);
            mimeMessageHelper.setSubject(SUBJECT);
            mimeMessageHelper.setText(htmlContent, true);

            javaMailSender.send(message);
        } catch (MessagingException messagingException) {
            throw new CustomException(AuthErrorStatus.MAIL_DELIVERY_FAILED);
        }

    }

    private String getCertificationMessage(String certificationNumber) {

        String certificationMessage = "";
        certificationMessage += "<h1 style='text-align: center;'>[woong2e] 인증메일";
        certificationMessage += "<h3 style='text-align: center;'>인증코드 : <strong style='font-size: 32px; letter-spacing: 8px;'>"
                + certificationNumber + "</strong></h3>";

        return certificationMessage;
    }

}
