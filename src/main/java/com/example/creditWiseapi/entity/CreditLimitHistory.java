package com.example.creditWiseapi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity
public class CreditLimitHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long clientId;
    private Long userId;
    private Double oldLimit;
    private Double newLimit;
    @CreatedDate
    private LocalDateTime changeDate;

    public CreditLimitHistory(Long clientId,Long userId, Double oldLimit, Double newLimit, LocalDateTime changeDate) {
        this.clientId = clientId;
        this.userId = userId;
        this.oldLimit = oldLimit;
        this.newLimit = newLimit;
        this.changeDate = changeDate;
    }

    public CreditLimitHistory(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Double getOldLimit() {
        return oldLimit;
    }

    public void setOldLimit(Double oldLimit) {
        this.oldLimit = oldLimit;
    }

    public Double getNewLimit() {
        return newLimit;
    }

    public void setNewLimit(Double newLimit) {
        this.newLimit = newLimit;
    }

    public LocalDateTime getChangeDate() {
        return changeDate;
    }

    public void setChangeDate(LocalDateTime changeDate) {
        this.changeDate = changeDate;
    }

    @Override
    public String toString() {
        return "CreditLimitHistory{" +
                "id=" + id +
                ", clientId=" + clientId +
                ", oldLimit=" + oldLimit +
                ", newLimit=" + newLimit +
                ", changeDate=" + changeDate +
                '}';
    }
}