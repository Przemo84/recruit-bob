package com.recruit.task.bob.api.service;

import com.recruit.task.bob.api.entity.EurUsdRate;

import java.util.List;

public interface CurrencyService {

    Double searchByRateDate(String rateDate);

    List<EurUsdRate> getHistoricalSearches();
}
