package kr.woong2e.homepage.user.infra.mapper;

import kr.woong2e.homepage.user.domain.User;
import kr.woong2e.homepage.user.infra.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserEntity toEntity(User user){
        return UserEntity.of(
                user.getId(),
                user.getLoginId(),
                user.getPassword(),
                user.getNickname(),
                user.getEmail(),
                user.getProfileImage(),
                user.getRole(),
                user.getProvider(),
                user.getProviderId(),
                user.getCreateDate(),
                user.getModifyDate()
        );
    }

    public User toDomain(UserEntity userEntity){
        return User.of(
                userEntity.getId(),
                userEntity.getLoginId(),
                userEntity.getPassword(),
                userEntity.getNickname(),
                userEntity.getEmail(),
                userEntity.getProfileImage(),
                userEntity.getRole(),
                userEntity.getProvider(),
                userEntity.getProviderId(),
                userEntity.getCreateDate(),
                null
        );
    }
}