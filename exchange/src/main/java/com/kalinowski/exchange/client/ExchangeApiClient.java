package com.kalinowski.exchange.client;

import com.kalinowski.exchange.model.Currencies;
import com.kalinowski.exchange.model.ExchangeApiResponse;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

public interface ExchangeApiClient {
    @RequestLine("GET /symbols")
    @Headers("apiKey: {apiKey}")
    Currencies getCurrencies(@Param("apiKey") String apiKey);

    @RequestLine("GET /convert?to={to}&from={from}&amount={amount}")
    @Headers("apiKey: {apiKey}")
    ExchangeApiResponse convert(
            @Param("apiKey") String apiKey,
            @Param("to") String to,
            @Param("from") String from,
            @Param("amount") int amount
    );


}
