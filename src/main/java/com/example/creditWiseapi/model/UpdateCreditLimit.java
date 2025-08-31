package com.example.creditWiseapi.model;

import com.example.creditWiseapi.entity.UserRoles;

public class UpdateCreditLimit {

    private Long clientId;
    private Long userId;
    private Double creditLimit;

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(Double creditLimit) {
        this.creditLimit = creditLimit;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
