package kr.woong2e.homepage.user.infra.mapper;

import kr.woong2e.homepage.user.domain.User;
import kr.woong2e.homepage.user.infra.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

//    public UserEntity toEntity(User users){
//        return UserEntity.of(
//                users.getEmail(),
//                users.getPassword()
//        );
//    }

    public User toDomain(UserEntity userEntity){
        return User.of(
                userEntity.getId(),
                userEntity.getNickname(),
                userEntity.getEmail(),
                userEntity.getProfileImage(),
                userEntity.getRole(),
                userEntity.getCreateDate()
        );
    }
}