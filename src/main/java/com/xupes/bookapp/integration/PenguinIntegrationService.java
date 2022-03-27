package com.xupes.bookapp.integration;

import com.xupes.bookapp.core.config.resources.ResourcesConfigurationProperties;
import com.xupes.bookapp.payload.author.AuthorListResponsePayload;
import com.xupes.bookapp.payload.author.AuthorResponsePayload;
import com.xupes.bookapp.payload.work.WorkListResponsePayload;
import com.xupes.bookapp.payload.work.WorkResponsePayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PenguinIntegrationService {

    private final RestTemplate restTemplate;
    private final ResourcesConfigurationProperties resourcesConfigurationProperties;

    @Autowired
    public PenguinIntegrationService(RestTemplate restTemplate, ResourcesConfigurationProperties resourcesConfigurationProperties) {
        this.restTemplate = restTemplate;
        this.resourcesConfigurationProperties = resourcesConfigurationProperties;
    }

    public WorkResponsePayload getWorkById(Long id) {
        String url = resourcesConfigurationProperties.getWorks() + "/" + id;
        try{
            ResponseEntity<WorkResponsePayload> forEntity = restTemplate.getForEntity(url, WorkResponsePayload.class);
            return forEntity.getStatusCodeValue() == HttpStatus.OK.value()
                    ? forEntity.getBody()
                    : null;
        }catch (Exception e){
            return null;
        }
       }

    public WorkListResponsePayload getWorksByTitle(String title) {
        String url = resourcesConfigurationProperties.getWorks() + "?search=" + title;
        try{
            ResponseEntity<WorkListResponsePayload> forEntity = this.restTemplate.getForEntity(url, WorkListResponsePayload.class, title);
            return forEntity.getStatusCodeValue() == HttpStatus.OK.value()
                    ? forEntity.getBody()
                    : null;
        }catch (Exception e){
            return null;
        }
    }


    public AuthorListResponsePayload getAuthorByNameAndSurname(String name,String surname){
        String url = resourcesConfigurationProperties.getAuthors() + "?lastName="+surname+"&firstName="+name;
        try{

            ResponseEntity<AuthorListResponsePayload> forEntity = restTemplate.getForEntity(url, AuthorListResponsePayload.class);
            return forEntity.getStatusCodeValue() == HttpStatus.OK.value()
                    ? forEntity.getBody()
                    : null;
        }catch (Exception e){
            return null;
        }
    }

}
