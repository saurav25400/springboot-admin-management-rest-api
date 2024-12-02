package com.codingshuttle.production_ready_feature.prod.config;

import jdk.jfr.ContentType;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

import static org.apache.tomcat.util.http.fileupload.FileUploadBase.CONTENT_TYPE;
import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON;

@Configuration
public class RestClientConfig {

    @Value("${employee.service.base_url}")
    private String BASE_URL;

    @Bean
    @Qualifier("getRestObj")
    RestClient getRestClientObj(){
        return RestClient.builder()
                .defaultHeader(CONTENT_TYPE, String.valueOf(APPLICATION_JSON))
                .build();

    }

}
