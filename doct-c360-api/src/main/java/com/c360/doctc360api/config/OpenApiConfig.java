package com.albertsons.c360.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

@Configuration
public class  OpenApiConfig {
    private static final String TEAM_URL = "https://albertsons.com";
    private static final String TEAM_EMAIL = "Customer.360.ID.Graph@albertsons.com";
    private static final String TEAM_NAME = "Cash Support Team";
    private static final String APPLICATION_NAME = "doct-c360-api";
    public static final Contact DEFAULT_CONTACT = new Contact();
    private static final String APPLICATION_DESCRIPTION = "The objective of the C360 Profile API is to support business use cases requiring low latency, realtime, responses ";
    @Bean
    public OpenAPI springShopOpenAPI() {
        //       DEFAULT_CONTACT.setEmail(TEAM_EMAIL);
        DEFAULT_CONTACT.setUrl(TEAM_URL);
        DEFAULT_CONTACT.setName(TEAM_NAME);
        return new OpenAPI()
                .info(new Info().title(APPLICATION_NAME)
                        .description(APPLICATION_DESCRIPTION)
                        .version(getCurrentDate())
                        .contact(DEFAULT_CONTACT)
                        .license(new License().name("Apache 2.0").url(TEAM_URL)))
                .externalDocs(new ExternalDocumentation()
                        .url(TEAM_URL));
    }
    private static String getCurrentDate() {
        SimpleDateFormat sdf = new SimpleDateFormat();
        sdf.setTimeZone(TimeZone.getTimeZone("PST"));
        return sdf.format(new Date()) + " PST";
    }

}
