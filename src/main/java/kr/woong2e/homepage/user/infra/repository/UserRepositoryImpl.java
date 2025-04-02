package kr.woong2e.homepage.user.infra.repository;

import kr.woong2e.homepage.user.domain.domain.User;
import kr.woong2e.homepage.user.domain.repository.UserRepository;
import kr.woong2e.homepage.user.infra.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final UserJpaRepository userJpaRepository;
    private final UserMapper userMapper;

    @Override
    public boolean existsByLoginId(String loginId) {
        return false;
    }

    @Override
    public Optional<User> findById(Long userId) {
        return userJpaRepository.findById(userId)
                .map(userMapper::toDomain);
    }

}
