package com.xupes.bookapp;

import com.xupes.bookapp.integration.PenguinIntegrationService;
import com.xupes.bookapp.payload.author.AuthorListResponsePayload;
import com.xupes.bookapp.payload.author.AuthorResponsePayload;
import com.xupes.bookapp.payload.work.WorkResponsePayload;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class BookTestApp {

    @Autowired
    private PenguinIntegrationService penguinIntegrationService;

    @Test
    public void workIdNotExist(){
        assertNull(penguinIntegrationService.getWorkById(0L));
    }

    @Test
    public void workIdExist(){
        assertNotNull(penguinIntegrationService.getWorkById(543L));
    }


    @Test
    public void countStartWarsSeries(){
       int count = penguinIntegrationService.getWorksByTitle("Star Wars").getWork().size();
       assertEquals(count,10);
    }

    @Test
    public void controlStarWarsWriter(){
        AuthorListResponsePayload authorListResponsePayload = penguinIntegrationService.getAuthorByNameAndSurname( "ROGER MACBRIDE","ALLEN");
        assertNotEquals(authorListResponsePayload.getAuthor().size(),0);

        AuthorResponsePayload starWarsAuthor = authorListResponsePayload.getAuthor().stream()
                .filter(author->author.getWorks() != null)
                .findFirst()
                .get();

        List<WorkResponsePayload> workList = starWarsAuthor.getWorks().getWorks().stream()
                .map(strWorkId -> penguinIntegrationService.getWorkById(Long.parseLong(strWorkId)))
                .filter(work -> {
                    System.out.println(work.getTitleweb());
                    return work.getTitleweb().contains("Star Wars");
                })
                .collect(Collectors.toList());

        assertNotEquals(workList.size(),0);

    }
}
