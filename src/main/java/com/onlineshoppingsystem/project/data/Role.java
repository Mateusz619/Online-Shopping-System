package com.onlineshoppingsystem.project.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Role {
    @JsonProperty("ROLE_ADMINISTRATOR")
    ROLE_ADMINISTRATOR,
    @JsonProperty("ROLE_CUSTOMER")
    ROLE_CUSTOMER;
}
