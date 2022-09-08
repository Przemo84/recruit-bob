package com.recruit.task.bob.api.controller;

import com.recruit.task.bob.api.entity.EurUsdRate;
import com.recruit.task.bob.api.service.CurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RequestMapping(value = "/api/v1/currency/")
@RequiredArgsConstructor
@RestController
public class CurrencyController {

    private final CurrencyService currencyService;

    @GetMapping(value = "search", params = "rateDate")
    public Double searchByRateDate(@RequestParam String rateDate) {
        return currencyService.searchByRateDate(rateDate);
    }

    @GetMapping("index")
    public List<EurUsdRate> index() {
        return currencyService.getHistoricalSearches();
    }
}
