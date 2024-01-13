package com.practice.shoppingmall.common.config;

import com.practice.shoppingmall.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private MemberService memberService;
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    };

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
//        http
//                .authorizeHttpRequests((auth) -> auth
//                        .anyRequest().authenticated())
//                .httpBasic(Customizer.withDefaults());
        http.formLogin(form -> form
                .loginPage("/member/lgoin")
                .defaultSuccessUrl("/") //로그인 성공시
                .usernameParameter("email") // 로그인시 사용할 파라미터 email로 설정.
                .failureUrl("/member/login/error")
                );
        http.logout(form -> form
                .logoutRequestMatcher(new AntPathRequestMatcher("/member/logout"))
                .logoutSuccessUrl("/"));

        http.csrf(AbstractHttpConfigurer::disable);

        return http.build();
    }

    public WebSecurityCustomizer webSecurityCustomizer(AuthenticationManagerBuilder auth) throws Exception{
        return (web)->{

        };
    }


}
