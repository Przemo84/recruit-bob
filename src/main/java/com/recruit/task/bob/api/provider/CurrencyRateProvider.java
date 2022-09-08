package com.recruit.task.bob.api.provider;

import com.recruit.task.bob.api.dto.CurrencyRateDto;

public interface CurrencyRateProvider {

    CurrencyRateDto getCurrencyRate(String rateDate);
}
