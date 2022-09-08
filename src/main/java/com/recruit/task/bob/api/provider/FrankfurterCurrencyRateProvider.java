package com.recruit.task.bob.api.provider;

import com.recruit.task.bob.api.dto.CurrencyRateDto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component

public class FrankfurterCurrencyRateProvider implements CurrencyRateProvider {

    @Value("${currency.provider.url}")
    private String currencyRateApiUrl;

    private final WebClient client;

    public FrankfurterCurrencyRateProvider() {
        this.client = WebClient.create();
    }

    public CurrencyRateDto getCurrencyRate(String rateDate) {

        WebClient.ResponseSpec responseSpec = this.client.get()
                .uri(this.currencyRateApiUrl + rateDate + "from=EUR&to=USD")
                .retrieve();

        return responseSpec.bodyToMono(CurrencyRateDto.class).block();
    }
}
