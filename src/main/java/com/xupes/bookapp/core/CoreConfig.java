package com.xupes.bookapp.core;

import com.xupes.bookapp.core.config.autorization.AuthorizationConfigurationProperties;
import com.xupes.bookapp.core.config.resources.ResourcesConfigurationProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Configuration
@EnableConfigurationProperties({AuthorizationConfigurationProperties.class, ResourcesConfigurationProperties.class})
public class CoreConfig {

    @Autowired
    private AuthorizationConfigurationProperties authorizationConfigurationProperties;

    @Bean
    public RestTemplate restTemplate(){
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setMessageConverters(createMessageConverters());
        restTemplate.setInterceptors(createInterceptors());
        return restTemplate;
    }

    private List<HttpMessageConverter<?>> createMessageConverters(){
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.APPLICATION_JSON));
        return Arrays.asList(converter);
    }

    private List<ClientHttpRequestInterceptor> createInterceptors(){
        return Arrays.asList(
                (request, body, execution) -> {
                    request.getHeaders().setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
                    request.getHeaders().setBasicAuth(authorizationConfigurationProperties.getUsername(),authorizationConfigurationProperties.getPassword());
                    return execution.execute(request,body);
                }
        );
    }

}
