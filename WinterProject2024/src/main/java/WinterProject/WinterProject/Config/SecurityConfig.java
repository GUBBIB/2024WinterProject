package WinterProject.WinterProject.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .csrf(AbstractHttpConfigurer::disable)
                .headers(headers -> headers.frameOptions(frameOptions -> frameOptions.sameOrigin()))
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/BoardManagement/**").hasRole("Admin") // 이 페이지는 ADMIN 만 접속 가능
                        .requestMatchers("/BoardPostPage/**").hasAnyRole("Admin", "User")
                        .requestMatchers("/**").permitAll() // 이 페이지 접속은 모든 사용자 허용
                )
                .formLogin(login -> login
                        .loginPage("/loginPage") // 로그인 페이지
                        .loginProcessingUrl("/login")
                        .failureUrl("/loginPage?error=true")
                        .defaultSuccessUrl("/") // 로그인 성공시 이동할 페이지
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutUrl("/logout") // 로그아웃 기능 페이지
                        .logoutSuccessUrl("/") // 로그아웃 성공시 이동할 페이지
                        .permitAll()
                );

        return http.build();
    }

    @Bean // 사용자 인증 부분 [ 내부적으로 UserSecurityService, PasswordEncoder를 사용한다 ]
    AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean // 비밀번호 암호화
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
