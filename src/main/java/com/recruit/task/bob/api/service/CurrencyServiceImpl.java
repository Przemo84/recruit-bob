package com.recruit.task.bob.api.service;

import com.recruit.task.bob.api.dto.CurrencyRateDto;
import com.recruit.task.bob.api.entity.EurUsdRate;
import com.recruit.task.bob.api.provider.CurrencyRateProvider;
import com.recruit.task.bob.api.repository.EurUsdRateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
@RequiredArgsConstructor
public class CurrencyServiceImpl implements CurrencyService {

    private final EurUsdRateRepository eurUsdRateRepository;

    private final CurrencyRateProvider currencyRateProvider;

    @Override
    public Double searchByRateDate(String rateDateStr) {

        CurrencyRateDto currencyRate = currencyRateProvider.getCurrencyRate(rateDateStr);
        EurUsdRate eurUsdRate = createEurUsd(currencyRate);

        eurUsdRateRepository.save(eurUsdRate);

        return currencyRate.getRates().getUsd();
    }

    @Override
    public List<EurUsdRate> getHistoricalSearches() {
        return eurUsdRateRepository.findAllByOrderByRateDateAsc();
    }

    private EurUsdRate createEurUsd(CurrencyRateDto currencyRate) {
        return EurUsdRate.builder()
                .rate(currencyRate.getRates().getUsd())
                .rateDate(currencyRate.getDate())
                .searchDate(new Date())
                .build();
    }
}
