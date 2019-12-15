package com.tennis.domain;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class TennisProducts {
    private String productName;
    private String description;
    private BigDecimal productPrice;
}
