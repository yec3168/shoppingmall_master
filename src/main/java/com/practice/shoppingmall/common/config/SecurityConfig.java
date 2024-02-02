package com.practice.shoppingmall.common.config;

import com.practice.shoppingmall.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
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
        http.formLogin(form -> form
                .loginPage("/members/login")
                .defaultSuccessUrl("/") //로그인 성공시
                .usernameParameter("email") // 로그인시 사용할 파라미터 email로 설정.
                .failureUrl("/members/login/error")

        );
        http.logout(form -> form
                .logoutRequestMatcher(new AntPathRequestMatcher("/members/logout"))
                .logoutSuccessUrl("/"));


       http.authorizeHttpRequests(auth -> auth
               // 로그인을 하지 않아도 이용가능하다.
               .requestMatchers("/", "/members/**", "/item/**", "/images/**", "/css/**").permitAll()
               //ADMIN일 경우 접근이 가능하다.
               .requestMatchers("/admin/item/new").hasRole("ADMIN")
               //나머지 경로는 인증을 요구하도록 함.
               .anyRequest().authenticated()
       );

       // 인증되지 않은 사용자가 리소스에 접근시 수행되는 핸들러를 등록합니다.
       http.exceptionHandling(auth-> auth
               .authenticationEntryPoint(new CustomAuthenticationEntryPoint()));

       http.csrf(AbstractHttpConfigurer::disable);

        return http.build();
    }

    AuthenticationManager authenticationManager(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(memberService).passwordEncoder(passwordEncoder());
        return auth.build();
    }


    // 하위 파일은 인증을 무시하도록 설정
    public WebSecurityCustomizer webSecurityCustomizer(){
        return (web)-> web.ignoring().requestMatchers("/css/**", "/js/**", "/img/**");
    }
}
