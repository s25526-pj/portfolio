package com.kalinowski.exchange.controller;

import com.kalinowski.exchange.model.Currencies;
import com.kalinowski.exchange.model.ExchangeApiResponse;
import com.kalinowski.exchange.model.Query;
import com.kalinowski.exchange.service.ExchangeService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/exchange")
@RequiredArgsConstructor
public class ExchangeController {

    private final ExchangeService exchangeService;

    @GetMapping
    @Secured("ROLE_ADMIN")
    public Currencies getCurr() {
        return exchangeService.getCurrencies();
    }

    @PostMapping
    public ExchangeApiResponse convert(@RequestBody @Valid Query query) {
        return exchangeService.convert(query);
    }

    @PostMapping("/{mail}")
    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    public ExchangeApiResponse convert(@RequestBody @Valid Query request, @PathVariable("mail") String mail) {
        return exchangeService.convertAndSend(request, mail);
    }
}
