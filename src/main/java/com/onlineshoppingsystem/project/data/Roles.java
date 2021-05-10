package com.onlineshoppingsystem.project.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Roles {
    @JsonProperty("ROLE_ADMINISTRATOR")
    ROLE_ADMINISTRATOR,
    @JsonProperty("ROLE_CUSTOMER")
    ROLE_CUSTOMER;
}
