package com.kalinowski.exchange.configuration;

//import com.kalinowski.exchange.client.ExchangeApiClient;

import com.kalinowski.exchange.client.ExchangeApiClient;
import com.kalinowski.exchange.model.Currencies;
import com.kalinowski.exchange.properties.ExchangeApiProperties;
import feign.Feign;
import feign.Logger;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class ExchangeConfig {

    @Bean
    public ExchangeApiClient exchangeApiClient() {
        return Feign.builder()
                .client(new OkHttpClient())
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .logger(new Slf4jLogger(ExchangeApiClient.class))
                .logLevel(Logger.Level.FULL)
                .target(ExchangeApiClient.class, "https://api.apilayer.com/exchangerates_data");
    }

    @Bean
    public WebClient.Builder webClientBuilder() {
        return WebClient.builder();
    }

    @Bean
    public Currencies currencies(ExchangeApiClient client, ExchangeApiProperties properties) {
        return client.getCurrencies(properties.getApiKey());
    }
}
