package com.kalinowski.exchange.service;

import com.kalinowski.exchange.client.ExchangeApiClient;
import com.kalinowski.exchange.model.Currencies;
import com.kalinowski.exchange.model.ExchangeApiResponse;
import com.kalinowski.exchange.model.Query;
import com.kalinowski.exchange.properties.ExchangeApiProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExchangeService {

    private final ExchangeApiClient exchangeApiClient;
    private final ExchangeApiProperties properties;
    private final EmailSenderService emailSenderService;
    public final Currencies currencies;

    public Currencies getCurrencies() {
        return currencies;
    }

    public ExchangeApiResponse convert(Query query) {
        try {
            return exchangeApiClient.convert(properties.getApiKey(), query.getTo(), query.getFrom(), query.getAmount());
        } catch (Exception e) {
            throw new RuntimeException("Ex");
        }
    }

    public ExchangeApiResponse convertAndSend(Query query, String email) {
        ExchangeApiResponse response = convert(query);
        emailSenderService.sendEmail(email, response);
        return response;
    }
}
