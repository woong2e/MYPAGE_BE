package kr.woong2e.homepage.auth.domain;

import java.util.Optional;

public interface CertificationRepository {

    void save(Certification certification);

    Optional<Certification> findByLoginId(String loginId);
}
