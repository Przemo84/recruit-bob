package com.recruit.task.bob.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Rates {

    @JsonProperty("USD")
    private Double usd;

}
