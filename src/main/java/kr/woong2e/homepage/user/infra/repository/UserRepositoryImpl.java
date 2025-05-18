package kr.woong2e.homepage.user.infra.repository;

import kr.woong2e.homepage.user.domain.User;
import kr.woong2e.homepage.user.domain.UserRepository;
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
    public void save(User user) {
        userJpaRepository.save(userMapper.toEntity(user));
    }

    @Override
    public boolean existsByLoginId(String loginId) {
        return userJpaRepository.existsByLoginId(loginId);
    }

    @Override
    public Optional<User> findById(Long userId) {
        return userJpaRepository.findById(userId)
                .map(userMapper::toDomain);
    }

}
