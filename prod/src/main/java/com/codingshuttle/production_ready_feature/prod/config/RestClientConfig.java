package com.codingshuttle.production_ready_feature.prod.config;

import com.codingshuttle.production_ready_feature.prod.exceptions.ResourceNotFoundException;
import jdk.jfr.ContentType;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatusCode;
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
                .baseUrl(BASE_URL)
                .defaultStatusHandler(HttpStatusCode::is4xxClientError,(req,res)->{
                    throw new ResourceNotFoundException("could not able to create the employee");
                })
                .defaultHeader(CONTENT_TYPE, String.valueOf(APPLICATION_JSON))
                .build();

    }

}
