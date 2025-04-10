package kr.woong2e.homepage.auth.infra.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "certification")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class CertificationEntity {

    @Id
    private String loginId;

    @Column(name = "email")
    private String email;

    @Column(name = "certification_number")
    private String certificationNumber;

    @Column(name = "is_verified")
    private boolean isVerified;

    public static CertificationEntity of(String loginId, String email, String certificationNumber, boolean isVerified) {
        return new CertificationEntity(loginId, email, certificationNumber, isVerified);

    }
}
