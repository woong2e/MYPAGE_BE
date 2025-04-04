package kr.woong2e.homepage.user.domain;

import java.util.Optional;

public interface UserRepository {

    boolean existsByLoginId(String loginId);

    Optional<User> findById(Long userId);
}
