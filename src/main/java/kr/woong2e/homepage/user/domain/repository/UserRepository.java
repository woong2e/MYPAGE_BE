package kr.woong2e.homepage.user.domain.repository;

import kr.woong2e.homepage.user.domain.domain.User;

import java.util.Optional;

public interface UserRepository {

    boolean existsByLoginId(String loginId);

    Optional<User> findById(Long userId);
}
