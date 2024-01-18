package com.practice.shoppingmall.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;

public class AuditConfig {

    // JPA Auditing기능을 활성화.
    // 등록자와 수정자를 처리해주는 AuditorAware을 빈으로 등록.
    @Bean
    public AuditorAware<String> auditorProvicer(){
        return new AuditorAwareImpl();
    }
}
