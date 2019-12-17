package com.tennis.domain;

import lombok.*;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class TennisProducts {
    private String productName;
    private String description;
    private String productPrice;
}
