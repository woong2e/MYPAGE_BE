package kr.woong2e.homepage.auth.infra.mapper;

import kr.woong2e.homepage.auth.domain.Certification;
import kr.woong2e.homepage.auth.infra.entity.CertificationEntity;
import org.springframework.stereotype.Component;

@Component
public class CertificationMapper {

    public Certification toDomain(CertificationEntity certificationEntity) {
        return Certification.of(
                certificationEntity.getLoginId(),
                certificationEntity.getEmail(),
                certificationEntity.getCertificationNumber(),
                certificationEntity.isVerified()
        );
    }

    public CertificationEntity toEntity(Certification certification) {
        return CertificationEntity.of(
                certification.getLoginId(),
                certification.getEmail(),
                certification.getCertificationNumber(),
                certification.isVerified()
        );
    }
}
