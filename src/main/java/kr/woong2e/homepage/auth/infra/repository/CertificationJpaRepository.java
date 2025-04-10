package kr.woong2e.homepage.auth.infra.repository;

import kr.woong2e.homepage.auth.infra.entity.CertificationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CertificationJpaRepository extends JpaRepository<CertificationEntity, String> {

}
