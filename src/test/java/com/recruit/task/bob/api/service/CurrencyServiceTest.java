package com.recruit.task.bob.api.service;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.recruit.task.bob.api.provider.CurrencyRateProvider;
import com.recruit.task.bob.api.repository.EurUsdRateRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.SocketUtils;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(SpringJUnit4ClassRunner.class)
public class CurrencyServiceTest {

    protected static final WireMockServer wireMockServer = new WireMockServer(SocketUtils.findAvailableTcpPort());
    @InjectMocks
    private CurrencyServiceImpl currencyService;
    @Mock
    private CurrencyRateProvider currencyRateProvider;
    @Mock
    private EurUsdRateRepository eurUsdRateRepository;


//    GET stucked
    @Test
    public void shouldSearchByRateDate() {
        //given
        String rateDate = "2019-08-08";

        //when
        currencyService.searchByRateDate(rateDate);

        //then
        verify(currencyRateProvider, times(1)).getCurrencyRate(rateDate);
        verify(eurUsdRateRepository, times(1)).findAllByOrderByRateDateAsc();
    }

}
