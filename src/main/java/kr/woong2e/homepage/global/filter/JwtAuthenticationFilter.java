package kr.woong2e.homepage.global.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.woong2e.homepage.global.exception.NotFoundException;
import kr.woong2e.homepage.global.provider.JwtProvider;
import kr.woong2e.homepage.user.application.response.status.UserErrorStatus;
import kr.woong2e.homepage.user.domain.domain.User;
import kr.woong2e.homepage.user.domain.repository.UserRepository;
import kr.woong2e.homepage.user.domain.value.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private static final String AUTHORIZATION_HEADER = "Authorization";
    private final UserRepository userRepository;
    private final JwtProvider jwtProvider;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            String token = parseBearerToken(request);

            if (token == null) {
                filterChain.doFilter(request, response);
                return;
            }

            String userId = jwtProvider.validate(token);

            if (userId == null) {
                filterChain.doFilter(request, response);
                return;
            }

            User user = userRepository.findById(Long.parseLong(userId))
                    .orElseThrow(() -> new NotFoundException(UserErrorStatus.USER_NOT_EXIST));
            Role role = user.getRole();

            List<GrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority(role.getKey()));

            AbstractAuthenticationToken authenticationToken =
                    new UsernamePasswordAuthenticationToken(userId, null, authorities);
            authenticationToken.setDetails(new WebAuthenticationDetailsSource()
                    .buildDetails(request));

            SecurityContext securityContext = SecurityContextHolder.createEmptyContext();
            securityContext.setAuthentication(authenticationToken);
            SecurityContextHolder.setContext(securityContext);

        } catch (Exception exception) {
            exception.printStackTrace();
        }

        filterChain.doFilter(request, response);

    }

    private String parseBearerToken(HttpServletRequest request) {
        String authorization = request.getHeader(AUTHORIZATION_HEADER);

        boolean hasAuthorization = StringUtils.hasText(authorization);

        if (!hasAuthorization) {
            return null;
        }

        boolean isBearer = authorization.startsWith("Bearer ");
        if (!isBearer) {
            return null;
        }

        String token = authorization.substring(7);
        return token;

    }
}
