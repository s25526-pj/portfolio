package com.kalinowski.exchange.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "external.api")
@Getter
@Setter
public class ExchangeApiProperties {

    private String apiKey;
}
