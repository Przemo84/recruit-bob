package com.recruit.task.bob.api.dto;

import lombok.Data;

import javax.persistence.Embedded;
import javax.persistence.Id;

@Data
public class CurrencyRateDto {

    @Id
    private Long id;
    private Double amount;
    private String base;
    private String date;

    @Embedded
    private Rates rates;

}
