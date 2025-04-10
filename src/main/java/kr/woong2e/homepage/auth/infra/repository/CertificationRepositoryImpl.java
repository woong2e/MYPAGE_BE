package kr.woong2e.homepage.auth.infra.repository;

import kr.woong2e.homepage.auth.domain.Certification;
import kr.woong2e.homepage.auth.domain.CertificationRepository;
import kr.woong2e.homepage.auth.infra.entity.CertificationEntity;
import kr.woong2e.homepage.auth.infra.mapper.CertificationMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CertificationRepositoryImpl implements CertificationRepository {

    private final CertificationJpaRepository certificationJpaRepository;
    private final CertificationMapper certificationMapper;

    @Override
    public void save(Certification certification) {
        certificationJpaRepository.save(certificationMapper.toEntity(certification));
    }

    @Override
    public Optional<Certification> findByLoginId(String loginId) {
        return certificationJpaRepository.findById(loginId)
                .map(certificationMapper::toDomain);
    }
}
