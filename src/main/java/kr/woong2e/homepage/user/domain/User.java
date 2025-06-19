package kr.woong2e.homepage.user.domain;

import kr.woong2e.homepage.auth.api.request.SignUpRequestDto;
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

    public static User of(Long userId, String loginId, String password, String nickname, String email,
                          String profileImage, Role role, SocialProvider provider, String providerId,
                          LocalDateTime createDate, LocalDateTime modifyDate) {
        return new User(
                userId, loginId, password, nickname, email,
                profileImage, role, provider, providerId,
                createDate, modifyDate);

    }

    public static User create(SignUpRequestDto dto, String encodedPassword) {
        return new User(
                null, dto.loginId(), encodedPassword, dto.nickname(), dto.email(),
                null, Role.USER, SocialProvider.LOCAL, null,
                LocalDateTime.now(), LocalDateTime.now()
        );
    }
}
