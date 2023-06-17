package qlks.java.qlks_javaweb.appconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.CachingUserDetailsService;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import qlks.java.qlks_javaweb.service.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Autowired
    private CustomUserDetailsService detailsService;
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(detailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests(authorize -> authorize

                        .requestMatchers("/home/**", "/login/**", "/logout/**").permitAll()
    //cho co trang chu roi phan quyen cho user  .requestMatchers("/products/**").hasAnyAuthority("ROLE_SALES", "ROLE_USER")
                        .requestMatchers("/admin/**").hasAnyAuthority("ROLE_ADMIN")
                        .requestMatchers("/register/**").permitAll()
                        .anyRequest().authenticated()
                )
                // .formLogin(withDefaults())
                .formLogin(formLogin -> formLogin
                        .loginPage("/login")
                        .loginProcessingUrl("/login")
                       // .defaultSuccessUrl("/home")
                        .failureUrl("/login?error")
                        .permitAll()
                        .successHandler((request, response, authentication) -> {
                            for (GrantedAuthority auth : authentication.getAuthorities()) {
                                if (auth.getAuthority().equals("ROLE_USER")) {
                                    response.sendRedirect("/user");
                                } else if (auth.getAuthority().equals("ROLE_ADMIN")) {
                                    response.sendRedirect("/admin");
                                }
                            }
                        }))


                .logout(
                        logout -> logout
                                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                                .permitAll())

                //.httpBasic(withDefaults())
                .authenticationProvider(authenticationProvider())
                .exceptionHandling(
                        exception -> exception
                                // Xử lý trang truy cập bị từ chối
                                .accessDeniedPage("/home/403"));

        return http.build();
    }
}
