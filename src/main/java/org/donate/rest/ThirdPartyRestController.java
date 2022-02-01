package org.donate.rest;
import org.donate.entity.other.ConvertRateResponse;
import org.donate.entity.other.CurrencyListResponse;
import org.donate.entity.other.NewsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
@RequestMapping("/other/api")
public class ThirdPartyRestController {


    @Autowired
    @Qualifier("currencyAPI")
    private WebClient currencyWebClient;

    @Autowired
    @Qualifier("newsAPI")
    private WebClient newsWebClient;

    @GetMapping("/currencies/list")
    public CurrencyListResponse getCurrencyList() {
        return currencyWebClient
                .get()
                .uri("/list")
                .header("x-rapidapi-host", "currency-converter5.p.rapidapi.com")
                .header("x-rapidapi-key", "xqHhD8Viw0mshdfXqdmyYwkpirccp1ZMhPejsnT7iBCSqthqK8")
                .header("format", "json")
                .retrieve()
                .bodyToMono(CurrencyListResponse.class)
                .block();
    }

    @GetMapping("/currencies/convert")
    public ConvertRateResponse convertCurrency(@RequestParam String from,@RequestParam String to,@RequestParam String amount) {
        return currencyWebClient
                .get()
                .uri(uriBuilder ->
                        uriBuilder.path("/convert")
                        .queryParam("format","json")
                        .queryParam("from",from)
                        .queryParam("to",to)
                        .queryParam("amount",amount)
                        .build()
                        )
                .header("x-rapidapi-host", "currency-converter5.p.rapidapi.com")
                .header("x-rapidapi-key", "xqHhD8Viw0mshdfXqdmyYwkpirccp1ZMhPejsnT7iBCSqthqK8")
                .header("format", "json")
                .retrieve()
                .bodyToMono(ConvertRateResponse.class)
                .block();
    }


    @GetMapping("/news")
    public NewsResponse convertCurrency(@RequestParam String country) {
        return newsWebClient
                .get()
                .uri(uriBuilder ->
                        uriBuilder
                                .path("/top-headlines")
                                .queryParam("country",country)
                                .queryParam("apiKey","5471b29e9e064a3c9ee60c31a2864391")
                                .build()
                )
                .retrieve()
                .bodyToMono(NewsResponse.class)
                .block();
    }


}
