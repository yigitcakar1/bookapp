package com.xupes.bookapp;

import com.xupes.bookapp.core.CoreConfig;
import com.xupes.bookapp.integration.PenguinIntegrationService;
import com.xupes.bookapp.payload.author.AuthorListResponsePayload;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(CoreConfig.class)
public class BookApp {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(BookApp.class);
        PenguinIntegrationService penguinIntegrationService = context.getBean(PenguinIntegrationService.class);
        penguinIntegrationService.getWorksByTitle("Star Wars").getWork().forEach(work->{
            System.out.println(work);
        });
    }
}
