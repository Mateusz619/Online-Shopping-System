package com.onlineshoppingsystem.project.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Payment {
    @JsonProperty("BLIK")
    BLIK,
    @JsonProperty("PAYPAL")
    PAYPAL,
    @JsonProperty("DEBIT_CARD")
    DEBIT_CARD;
}
