package org.donate;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class DonateApplication {

    public static void main(String[] args) {
        SpringApplication.run(DonateApplication.class, args);
    }

    @Bean
    @Qualifier("currencyAPI")
    public WebClient currencyWebClient() {
        return WebClient.create("https://currency-converter5.p.rapidapi.com/currency");
    }

    @Bean
    @Qualifier("newsAPI")
    public WebClient newsWebClient() {
        return WebClient.create("https://newsapi.org/v2");
    }


    @Bean
    @Qualifier("weatherAPI")
    public WebClient weatherWebClient() {
        return WebClient.create("http://api.airvisual.com/v2");
    }

}
