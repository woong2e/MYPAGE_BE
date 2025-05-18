package kr.woong2e.homepage.user.infra.repository;

import kr.woong2e.homepage.user.infra.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository extends JpaRepository<UserEntity, Long> {

    boolean existsByLoginId(String loginId);
}
