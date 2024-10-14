package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

/**
 * ClassName: SecurityConfig
 * Package: com.example.demo.config
 * Description: SpringSecurity配置类
 *
 * @Author 毕研政
 * @Create 2024/10/14 22:40
 * @Version 1.0
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // 对/hello请求路径进行拦截，其他的请求放行
        http.authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/hello").authenticated()
                        .anyRequest().permitAll()
                ).formLogin(withDefaults())
                .httpBasic(withDefaults());
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        // 将用户名和密码配置在内存中
        UserDetails user = User.withDefaultPasswordEncoder()
                        .username("test")
                        .password("123456")
                        .roles("USER")
                        .build();
        return new InMemoryUserDetailsManager(user);
    }
}
