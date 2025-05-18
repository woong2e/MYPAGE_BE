package kr.woong2e.homepage.user.domain;

import java.util.Optional;

public interface UserRepository {

    void save(User user);

    boolean existsByLoginId(String loginId);

    Optional<User> findById(Long userId);
}
