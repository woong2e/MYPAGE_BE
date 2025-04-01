package kr.woong2e.homepage.user.domain.domain;

import kr.woong2e.homepage.user.domain.value.Role;
import kr.woong2e.homepage.user.domain.value.SocialProvider;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class User {

    private Long id;

    private String loginId;

    private String password;

    private String nickname;

    private String email;

    private String profileImage;

    private Role role;

    private SocialProvider provider;

    private String providerId;

    private LocalDateTime createDate;

    private LocalDateTime modifyDate;

    public static User of(Long userId, String nickname, String email, String profileImage, Role role, LocalDateTime createDate) {
        return new User(userId, null, null, nickname, email, profileImage, role, null, null, createDate, null);

    }
}
