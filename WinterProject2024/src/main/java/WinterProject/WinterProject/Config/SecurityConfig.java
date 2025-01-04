// package WinterProject.WinterProject.Config;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.web.SecurityFilterChain;

// @Configuration
// @EnableWebSecurity
// public class SecurityConfig {

//     @Bean
//     public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

//         http
//                 .csrf().disable()
//                 .authorizeHttpRequests((auth) -> auth
//                         .requestMatchers("/").permitAll()
//                         .requestMatchers("/login", "/register", "/error", "/chk", "/register/saveUser").permitAll()
//                         .requestMatchers("/admin").hasRole("ADMIN")
//                 );

//         return http.build();
//     }
// }
