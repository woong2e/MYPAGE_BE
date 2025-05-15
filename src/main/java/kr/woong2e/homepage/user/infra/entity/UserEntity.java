package kr.woong2e.homepage.user.infra.entity;

import jakarta.persistence.*;
import kr.woong2e.homepage.user.domain.value.Role;
import kr.woong2e.homepage.user.domain.value.SocialProvider;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "login_id", length = 20, unique = true)
    private String loginId;

    @Column(name = "password", length = 30, nullable = false)
    private String password;

    @Column(name = "nickname", nullable = false)
    private String nickname;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "profile_image")
    private String profileImage;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private Role role;

    @Enumerated(EnumType.STRING)
    @Column(name = "provider")
    private SocialProvider provider;

    @Column(name = "provider_id")
    private String providerId;

    @Column(name = "create_date", nullable = false, updatable = false)
    private LocalDateTime createDate;

    @Column(name = "modify_date")
    private LocalDateTime modifyDate;

    public static UserEntity of(Long userId, String loginId, String password, String nickname, String email,
                                String profileImage, Role role, SocialProvider provider, String providerId,
                                LocalDateTime createDate, LocalDateTime modifyDate) {
        return new UserEntity(
                userId, loginId, password, nickname, email,
                profileImage, role, provider, providerId,
                createDate, modifyDate);
    }
}
