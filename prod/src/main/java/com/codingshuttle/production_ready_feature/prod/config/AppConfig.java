package com.codingshuttle.production_ready_feature.prod.config;

import com.codingshuttle.production_ready_feature.prod.auth.AuditorAwareImpl;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.client.RestTemplate;

@Configuration
@EnableJpaAuditing(auditorAwareRef ="getCurrentAuditor")
public class AppConfig {

    @Bean
    ModelMapper getModelMapper(){
        return new ModelMapper();
    }

    @Bean
    AuditorAware<String> getCurrentAuditor(){
        return new AuditorAwareImpl();
    }

    @Bean
    RestTemplate getRestTemplateObject(){
        return new RestTemplate();
    }


}
